package net.kibotu.timebomb.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.kibotu.timebomb.TimeBomb;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeBomb.enableLogging(BuildConfig.DEBUG);
        long timeLeft = TimeBomb.bombAfterDays(this, BuildConfig.BUILD_DATE, 14);

        ((TextView) findViewById(R.id.label)).setText(timeLeft + " days left until bombing.");
    }
}
