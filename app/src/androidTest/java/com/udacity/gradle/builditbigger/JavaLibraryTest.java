package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class JavaLibraryTest extends AndroidTestCase {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void testJokeIsNotEmpty() throws Exception {
        String joke=null;
        EndpointAsyncTask endpointAsyncTask =  new EndpointAsyncTask();
        endpointAsyncTask.execute();//InstrumentationRegistry.getContext()
        try {
            joke = endpointAsyncTask.get();
            Log.d("NonEmptyStringTest",joke);
        }
        catch (Exception e){
            e.printStackTrace();
            Log.d("NonEmptyStringTest","Failed");
        }
        assertNotNull(joke);
    }


}