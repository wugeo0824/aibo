package com.xjcrepe.aibo.dashboard;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.xjcrepe.aibo.R;
import com.xjcrepe.aibo.weapons.WeaponsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
            MainActivity.class);

    @Test
    public void launchWeaponsActivityOnButtonClick() {
        onView(withId(R.id.btnWeapons)).perform(click());

        intended(hasComponent(WeaponsActivity.class.getName()));
    }

    @Test
    public void displaysWeaponsTest() {
        onView(withId(R.id.tvWeapons)).check(matches(withText("Hello World!")));
    }
}
