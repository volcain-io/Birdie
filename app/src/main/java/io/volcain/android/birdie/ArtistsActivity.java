package io.volcain.android.birdie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.content.Intent.EXTRA_PROCESS_TEXT_READONLY;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
    }

    /**
     * Create an implicit intent to start corresponding activity.
     *
     * @param view is the actual view (activity_artists)
     */
    public void startActivity(final View view) {
        String artistTag = (String) view.getTag();

        Intent categoryIntent = new Intent(this, SongsActivity.class);
        categoryIntent.putExtra(EXTRA_PROCESS_TEXT_READONLY, artistTag);
        startActivity(categoryIntent);
    }
}
