package com.example.cardgame.cardgame;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.cardgame.cardgame.ui.activity.MainPageActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class MainPageActivityTest1 {
    @Rule
    public ActivityTestRule<MainPageActivity> activityRule = new ActivityTestRule(MainPageActivity.class);
    @Test
    //Given the user has logged in and they are at the appointment page
    //attention: because we are given user has loggin in, you need to login inorder to test
    //username: tester1  password: 123456
    public void initialState(){
        onView(withId(R.id.title)).check(matches(withText("Reserved Events")));
        onView(withId(R.id.app_name)).check(matches(withText("Study Buddies")));
        onView(withId(R.id.create_appt)).check(matches(allOf(isEnabled(), isClickable(), isDisplayed())));
        onView(withId(R.id.create_appt)).check(matches(allOf(isEnabled(), isClickable(), isDisplayed())));

    }

    //When he/she clicked the logout button
    // Then a dialog will show up to ask user to confirm
    @Test
    public void checkLogout() {

        // toggle logout button
        onView(withId(R.id.logout)).perform(click());

        // new state - logout prompt
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withText("Are you sure you want to log out?")).check(matches(isDisplayed()));

    }

}