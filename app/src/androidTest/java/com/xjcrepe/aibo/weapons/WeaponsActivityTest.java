package com.xjcrepe.aibo.weapons;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.xjcrepe.aibo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class WeaponsActivityTest {

    @Rule
    public IntentsTestRule<WeaponsActivity> mActivityRule = new IntentsTestRule<>(
            WeaponsActivity.class);

    @Test
    public void displaysWeaponsTest() {
        onView(withId(R.id.tvWeapons)).check(matches(withText("Hello World!")));
    }
}
