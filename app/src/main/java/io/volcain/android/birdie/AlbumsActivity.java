package io.volcain.android.birdie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.content.Intent.EXTRA_PROCESS_TEXT_READONLY;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
    }

    /**
     * Create an implicit intent to start corresponding activity.
     *
     * @param view is the actual view (activity_albums)
     */
    public void startActivity(final View view) {
        String albumTag = (String) view.getTag();

        Intent categoryIntent = new Intent(this, SongsActivity.class);
        categoryIntent.putExtra(EXTRA_PROCESS_TEXT_READONLY, albumTag);
        startActivity(categoryIntent);
    }

}
