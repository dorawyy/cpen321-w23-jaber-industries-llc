package com.beaker.reciperoulette.IngredientRequest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class IngredientRequest implements Parcelable {
    String requestId;
    String reqDate;
    String expiryDate;
    String ingredientID;
    String ingredientName;
    String requestor;
    String userId; //the requestor's ID

    String image;
    public IngredientRequest(String requestId, String reqDate, String expiryDate, String ingredientID, String ingredientName, String requestor, String userId, String image) {
        this.requestId = requestId;
        this.reqDate = reqDate;
        this.expiryDate = expiryDate;
        this.ingredientID = ingredientID;
        this.ingredientName = ingredientName;
        this.requestor = requestor;
        this.userId = userId;
        this.image = image;
    }

    public IngredientRequest(String ingredientName, String userId)
    {
        this.ingredientName = ingredientName;
        this.userId = userId;
    }

    protected IngredientRequest(Parcel in) {
        requestId = in.readString();
        reqDate = in.readString();
        expiryDate = in.readString();
        ingredientID = in.readString();
        ingredientName = in.readString();
        requestor = in.readString();
        userId = in.readString();
        image = in.readString();
    }

    public static final Creator<IngredientRequest> CREATOR = new Creator<IngredientRequest>() {
        @Override
        public IngredientRequest createFromParcel(Parcel in) {
            return new IngredientRequest(in);
        }

        @Override
        public IngredientRequest[] newArray(int size) {
            return new IngredientRequest[size];
        }
    };

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(String ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

        parcel.writeString(requestId);
        parcel.writeString(reqDate);
        parcel.writeString(expiryDate);
        parcel.writeString(ingredientID);
        parcel.writeString(ingredientName);
        parcel.writeString(requestor);
        parcel.writeString(userId);
        parcel.writeString(image);
    }

}