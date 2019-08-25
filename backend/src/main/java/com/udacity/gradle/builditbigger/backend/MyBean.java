package com.udacity.gradle.builditbigger.backend;

import dev.abhishekkumar.jokelib.JokeClass;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        myData = new JokeClass().getJoke();
        return myData;
    }

}