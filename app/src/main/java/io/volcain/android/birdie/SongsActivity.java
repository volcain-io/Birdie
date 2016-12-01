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
    // flag to handle music control
    private boolean isPlaying = false;
    // id of the current playing song
    private int currentSongId = -1;

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
        // for the first playback of a song
        if (currentSongId == -1) {
            startPlaying(view.getId());
        } else {
            // if the user clicks on the currently playing song we will pause the playback
            if (currentSongId == view.getId()) {
                // is already playing?
                if (isPlaying)
                    pausePlaying(currentSongId);
                else
                    startPlaying(currentSongId);
            } else {
                // stop current song
                stopPlaying(currentSongId);
                // play selected song
                startPlaying(view.getId());
            }
        }
        // get id of the current song
        currentSongId = view.getId();
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
     * This method will be used if an implicit intent was started from following activities
     * (categories): {@link AlbumsActivity}, {@link ArtistsActivity}, {@link GenreActivity} It will
     * display the songs according to one of selected categories.
     *
     * @param categoryItem can be an album, a genre, an artist
     */
    private void displaySongsByCategoryItem(final String categoryItem) {
        // TODO: to be implemented
        Log.v(logTag, "displays songs");
    }

    /**
     * Start playing a song.
     *
     * @param currentSongId is the id of the song which should be played
     */
    private void startPlaying(final int currentSongId) {
        isPlaying = true;
        // set the image to the pause icon to indicate that the song is currently played
        ImageView imageView = (ImageView) findViewById(currentSongId);
        imageView.setImageResource(R.drawable.ic_pause_circle_outline_black_48dp);
        Log.v(logTag, "start playing song...");
        // TODO: logic to be implemented
    }

    /**
     * Stops playing a song.
     *
     * @param currentSongId is the id of the song which should be stopped
     */
    private void stopPlaying(final int currentSongId) {
        isPlaying = false;
        // set the image to the play icon to indicate that the song is currently paused
        ImageView imageView = (ImageView) findViewById(currentSongId);
        imageView.setImageResource(R.drawable.ic_play_circle_outline_black_48dp);
        Log.v(logTag, "stop playing song...");
        // TODO: logic to be implemented
    }

    /**
     * Pauses the current playing song.
     *
     * @param currentSongId is the id of the song which should be paused
     */
    private void pausePlaying(final int currentSongId) {
        isPlaying = false;
        // set the image to the play icon to indicate that the song is currently paused
        ImageView imageView = (ImageView) findViewById(currentSongId);
        imageView.setImageResource(R.drawable.ic_play_circle_outline_black_48dp);
        Log.v(logTag, "pause playing song...");
        // TODO: logic to be implemented
    }

    /**
     * Sets the image resource of the given view to play icon (ic_play_circle_outline_black_48dp).
     *
     * @param imageView is the image view of which we change the image resource
     */
    private void resetImageResource(final ImageView imageView) {
        imageView.setImageResource(R.drawable.ic_play_circle_outline_black_48dp);
    }
}
