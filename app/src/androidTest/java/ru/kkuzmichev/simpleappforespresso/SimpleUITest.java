package ru.kkuzmichev.simpleappforespresso;


import androidx.test.espresso.ViewInteraction;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SimpleUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkMainText() {
        ViewInteraction mainText = onView(withId(R.id.text_home));
        mainText.check(matches(isDisplayed()));
        mainText.check(matches(withText("This is home fragment")));
    }

    //открыть меню и проверить наличие всех пунктов
    @Test
    public void checkAllMenuItems() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.nav_home)).check(matches(isDisplayed()));
        onView(withId(R.id.nav_gallery)).check(matches(isDisplayed()));
        onView(withId(R.id.nav_slideshow)).check(matches(isDisplayed()));
    }

    //Переключиться на следующий пункт меню и проверить отображение текста
    //“This is slideshow fragment”
    @Test
    public void checkTextInSlideshow() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.nav_slideshow)).perform(click());
        onView(withId(R.id.text_slideshow)).check(matches(withText("This is slideshow fragment")));
    }
}
