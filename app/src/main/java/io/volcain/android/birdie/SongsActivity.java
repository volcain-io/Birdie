package io.volcain.android.birdie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import static android.content.Intent.EXTRA_PROCESS_TEXT_READONLY;

public class SongsActivity extends AppCompatActivity {
    // for logging output
    private final String logTag = SongsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        // receive extra from intent
        String selectedCategoryItem = getIntentExtra(savedInstanceState);
        // if intent was started from within in another category, so display the song according to that category
        if (selectedCategoryItem != null)
            displaySongsByCategoryItem(selectedCategoryItem);

        // create click listeners
        createClickListeners();
    }

    /**
     * method creates click listeners for each music control icon (play/pause)
     */
    private void createClickListeners() {
        // Find the View that shows the play icon for the first song
        ImageView song_1 = (ImageView) findViewById(R.id.play_song_1);

        // Set a click listener on that
        song_1.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the image view is clicked on.
            @Override
            public void onClick(View view) {
                playbackControl(view);
            }
        });

        // Find the View that shows the play icon for the second song
        ImageView song_2 = (ImageView) findViewById(R.id.play_song_2);

        // Set a click listener on that
        song_2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the image view is clicked on.
            @Override
            public void onClick(View view) {
                playbackControl(view);
            }
        });

        // Find the View that shows the play icon for the third song
        ImageView song_3 = (ImageView) findViewById(R.id.play_song_3);

        // Set a click listener on that
        song_3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the image view is clicked on.
            @Override
            public void onClick(View view) {
                playbackControl(view);
            }
        });

        // Find the View that shows the play icon for the fourth song
        ImageView song_4 = (ImageView) findViewById(R.id.play_song_4);

        // Set a click listener on that
        song_4.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the image view is clicked on.
            @Override
            public void onClick(View view) {
                playbackControl(view);
            }
        });
    }

    /**
     * Controls the playbacks of a song. Resets also the image resource of the last played song to
     * its initial state (which is represented by the play icon) if needed.
     *
     * @param view is the actual view (activity_songs)
     */
    private void playbackControl(final View view) {
        PlaybackControl playbackControl = new PlaybackControl();
    }

    /**
     * Reads the extra data of the intent.
     *
     * @return a string containing the value of the extra data.
     */
    private String getIntentExtra(final Bundle savedInstanceState) {
        // receive extra from intent
        String selectedCategoryItem;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null)
                selectedCategoryItem = null;
            else {
                selectedCategoryItem = (String) extras.get(EXTRA_PROCESS_TEXT_READONLY);
            }
        } else {
            selectedCategoryItem = (String) savedInstanceState.getSerializable(EXTRA_PROCESS_TEXT_READONLY);
        }
        return selectedCategoryItem;
    }

    /**
     * This method will be used if an explicit intent was started from following activities
     * (categories): {@link AlbumsActivity}, {@link ArtistsActivity}, {@link GenreActivity} It will
     * display the songs according to one of selected categories.
     *
     * @param categoryItem can be an album, a genre, an artist
     */
    private void displaySongsByCategoryItem(final String categoryItem) {
        Log.v(logTag, "displays songs");
        // TODO: to be implemented
    }
}
