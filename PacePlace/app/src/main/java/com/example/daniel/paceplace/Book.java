package com.example.daniel.paceplace;

/**
 * Created by Daniel on 5/8/2018.
 */

public class Book {

    private String mTitle;
    private String mAuthor;


    public Book(String mTitle, String mAuthor){
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;

    }


    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
