package io.volcain.android.birdie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_AUDIO_OPEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create click listeners
        createClickListeners();
    }

    /**
     * method creates click listeners for each artists
     */
    private void createClickListeners() {
        // Find the View that shows the albums category
        TextView artist_2 = (TextView) findViewById(R.id.albums);

        // Set a click listener on that
        artist_2.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startActivity(view);
            }
        });

        // Find the View that shows the artist category
        TextView artist_1 = (TextView) findViewById(R.id.artists);

        // Set a click listener on that
        artist_1.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startActivity(view);
            }
        });

        // Find the View that shows the genre category
        TextView artist_3 = (TextView) findViewById(R.id.genre);

        // Set a click listener on that
        artist_3.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startActivity(view);
            }
        });

        // Find the View that shows the songs category
        TextView artist_4 = (TextView) findViewById(R.id.songs);

        // Set a click listener on that
        artist_4.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startActivity(view);
            }
        });
    }

    /**
     * Create an explicit intent to start corresponding activity.
     *
     * @param view is the actual view (activity_main)
     */
    private void startActivity(final View view) {
        String viewTag = (String) view.getTag();

        String categoryAlbums = getString(R.string.category_albums);
        String categoryArtists = getString(R.string.category_artists);
        String categorySongs = getString(R.string.category_songs);
        String categoryTags = getString(R.string.category_genre);

        Intent categoryIntent = null;
        if (viewTag.equalsIgnoreCase(categoryAlbums))
            categoryIntent = new Intent(this, AlbumsActivity.class);
        if (viewTag.equalsIgnoreCase(categoryArtists))
            categoryIntent = new Intent(this, ArtistsActivity.class);
        if (viewTag.equalsIgnoreCase(categorySongs))
            categoryIntent = new Intent(this, SongsActivity.class);
        if (viewTag.equalsIgnoreCase(categoryTags))
            categoryIntent = new Intent(this, GenreActivity.class);
        if (categoryIntent != null)
            startActivity(categoryIntent);
    }
}
