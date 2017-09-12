import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.JokeAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertFalse;

/**
 * BuildItBigger
 * Created by Guilherme Ziolle on 11/09/2017.
 * gziolle@gmail.com
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private CountDownLatch mLatch;

    @Before
    public void setup(){
        mLatch = new CountDownLatch(1);
    }

    @Test
    public void testAsyncTask() throws InterruptedException{
        JokeAsyncTask task = new JokeAsyncTask(new JokeAsyncTask.AsyncResponse() {
            @Override
            public void updateJoke(String joke) {
                assertFalse(TextUtils.isEmpty(joke));
                mLatch.countDown();
            }
        });
        task.execute();
        mLatch.await();
    }
}
