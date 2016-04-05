package com.example.testing.testingexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.KeyEvent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;


/**
 * MainActivity 自动化测试
 * Created by Even on 1/4/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
    private static final String STRING_TO_BE_TYPED = "Peter";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void sayHello() {
        //如果输入法不是实时输入字符,需要按Enter输入的话,需要添加点击Enter事件
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED), pressKey(KeyEvent.KEYCODE_ENTER),
                closeSoftKeyboard());

        onView(withText("Say hello!")).perform(click());

        String expectedText = "Hello," + STRING_TO_BE_TYPED + "!";

        onView(withId(R.id.textView)).check(matches(withText(expectedText)));
    }

    @Test
    public void testHamcrest() {
        //为提升test的性能,尽可能使用最少的条件筛选.除非一个ID匹配到多个 view,才使用条件筛选.
        onView(allOf(withId(R.id.editText), not(withText("editText")))).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard
                ());
    }
}
