package com.beaker.recipeRoulette;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Review implements Parcelable {
    int id;
    int rating;
    String author;
    String title;
    String review;
    String stringDate;
    String publishDate;
    String image;

    public Review(int id, int rating, String author, String title, String review, String publishDate, String image) {
        this.id = id;
        this.rating = rating;
        this.author = author;
        this.title = title;
        this.review = review;
        this.publishDate = publishDate;
        this.image = image;
    }

    protected Review(Parcel in) {
        id = in.readInt();
        rating = in.readInt();
        author = in.readString();
        title = in.readString();
        review = in.readString();
        stringDate = in.readString();
        publishDate = in.readString();
        image = in.readString();
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };

    public String getImage() {
        return image;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getStringDate() {
        return stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(rating);
        parcel.writeString(author);
        parcel.writeString(title);
        parcel.writeString(review);
        parcel.writeString(stringDate);
        parcel.writeString(publishDate);
        parcel.writeString(image);
    }
}
