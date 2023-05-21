package ru.kkuzmichev.simpleappforespresso;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class CustomViewMatcher {

    public static Matcher<View> recyclerViewSizeMatcher(final int matcherSize) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            String result;

            @Override
            public void describeTo(Description description) { // Доп. описание ошибки
                description.appendText("List size" + matcherSize);
                description.appendText(result);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) { // Проверка
                int items = recyclerView.getAdapter().getItemCount(); // фактическое кол-во элементов
                return matcherSize == items;
            }
        };
    }
}
