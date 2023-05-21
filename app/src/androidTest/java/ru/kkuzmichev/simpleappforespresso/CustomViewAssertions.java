package ru.kkuzmichev.simpleappforespresso;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;

public class CustomViewAssertions {

    public static ViewAssertion isRecycleView() {
        return new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                try {
                    RecyclerView recyclerView = (RecyclerView) view;  // Для проверки элемента, мы пытаемся привести view к типу RecyclerView

                }
                catch (ClassCastException cce) {    // кидаем исключения если не вышло.
                    throw new IllegalStateException("This is not a RecycleView");
                }
            }
        };
    }

}
