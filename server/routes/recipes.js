var express = require('express');
var router = express.Router();
var fetch = require('node-fetch');
var Models = require('../utils/db');
const fs = require('fs');
const apiKey = fs.readFileSync("api_key.txt", "utf8");

let getRecipes = async (req) => {
  //let ingredientList = url.parse(req.url, true).query.ingredients;
  //TODO test if this works
  let user = req.get("email");
  //let user = "test@ubc.ca"
  // Find all ingredients of user
  let allIngredients = await Models.Ingredient.findOne({userId: `${user}`});
  if (allIngredients == null) {
    return [];
  }
  // Push into a list
  let ingredientList = [];
  allIngredients.ingredients.forEach(ingredient => {
    ingredientList.push(ingredient.name);
  });
  //let ingredientList = ["flour","rice","bread","egg"];
  console.log(typeof ingredientList);
  console.log(ingredientList);
  // Get recipes from api endpoint
  let endpoint = `https://api.spoonacular.com/recipes/findByIngredients?apiKey=${apiKey}&ingredients=${ingredientList}&number=5`;
  let recipes;
  try {
    let res = await fetch(endpoint);
    recipes = await res.json();
    console.log(recipes);
    return recipes;
  } catch (error) {
    console.log(error);
    return [];
  }
}

let saveRecipes = async (req) => {
  let userId = req.body.userId;
  let chosenRecipeId = req.body.recipeId;
  let savedRecipe = await Models.Recipe.findOne({
    userId: `${req.body.email}`, 
    recipeId: `${req.body.id}`
  });
  if (savedRecipe !== undefined && savedRecipe.length) {
    savedRecipe.numTimes++;
    await savedRecipe.save();
  }

  let summaryEndpoint = `https://api.spoonacular.com/recipes/${chosenRecipeId}/summary?apiKey=${apiKey}`;
  let summary = "";
  let name = "";
  try {
    let res = await fetch(summaryEndpoint);
    console.log(res);
    let resJson = await res.json();
    console.log(resJson);
    summary = resJson.summary;
    name = resJson.title;
  } catch (error) {
    console.log(error);
  }
  let response = {
    userId,
    recipeId: chosenRecipeId,
    recipeSummary: summary,
    recipeName: name,
    numTimes: 1,
    likes: 0
  }
  savedRecipe = new Models.Recipe(response);
  await savedRecipe.save();
  // Get instructions
  let instrEndpoint = `https://api.spoonacular.com/recipes/${chosenRecipeId}/analyzedInstructions?apiKey=${apiKey}`;
  try {
    let res = await fetch(instrEndpoint);
    console.log(res)
    let resJson = await res.json();
    console.log(resJson);
    response.instructions = resJson;
  } catch (error) {
    console.log(error);
  }
  // Delete ingredients

  //await removeIngredients(userId, ingredientList);
  console.log(response);
  return response;
}

router.get('/', async function(req, res, next) {
  let recipes = await getRecipes(req);
  res.status(200);
  res.send(recipes);
});

router.post('/', async function(req, res, next) {
  let userId = req.body.userId;
  let chosenRecipeId = req.body.recipeId;
  let savedRecipe = await Models.Recipe.findOne({
    userId: `${req.body.email}`, 
    recipeId: `${req.body.id}`
  });
  if (savedRecipe !== undefined && savedRecipe.length) {
    savedRecipe.numTimes++;
    await savedRecipe.save();
    res.status(200);
    res.send(savedRecipe);
  }

  let summaryEndpoint = `https://api.spoonacular.com/recipes/${chosenRecipeId}/summary?apiKey=${apiKey}`;
  let summary = "";
  let name = "";
  try {
    let res = await fetch(summaryEndpoint);
    console.log(res);
    let resJson = await res.json();
    console.log(resJson);
    summary = resJson.summary;
    name = resJson.title;
  } catch (error) {
    console.log(error);
  }
  let response = {
    userId,
    recipeId: chosenRecipeId,
    recipeSummary: summary,
    recipeName: name,
    numTimes: 1,
    likes: 0
  }
  res.status(200);
  res.send(response);
});

module.exports = router;
