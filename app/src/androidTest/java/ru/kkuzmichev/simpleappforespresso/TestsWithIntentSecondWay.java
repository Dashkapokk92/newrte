package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.ViewInteraction;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.allOf;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;

import android.content.Intent;
import androidx.appcompat.widget.ActionMenuView;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(AndroidJUnit4.class)
public class TestsWithIntentSecondWay {

    @Rule  // меняем “правило” для тестов и проверяем срабатывание Intent с помощью метода intended().
    public IntentsTestRule intentsTestRule =
            new IntentsTestRule(MainActivity.class);

    @Test
    public void checkIntent2() {
        ViewInteraction navigationToSettings = onView(withParent(isAssignableFrom(ActionMenuView.class)));
        ViewInteraction settings = onView(allOf(withId(R.id.title), withText("Settings")));
        navigationToSettings.check(matches(isDisplayed()));
        navigationToSettings.perform(click());
        settings.check(matches(isDisplayed()));
        settings.perform(click());
        intended(allOf(
                hasData("https://google.com"),
                hasAction(Intent.ACTION_VIEW)
        ));
    }
}

