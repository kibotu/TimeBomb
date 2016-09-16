package net.kibotu.timebomb.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.kibotu.timebomb.BuildConfig;
import net.kibotu.timebomb.TimeBomb;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeBomb.bombAfterDays(this, Long.parseLong(BuildConfig.BUILD_DATE), 14);
    }
}
