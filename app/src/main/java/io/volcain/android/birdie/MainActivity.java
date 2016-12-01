package io.volcain.android.birdie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_AUDIO_OPEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Create an implicit intent to start corresponding activity.
     *
     * @param view is the actual view (activity_main)
     */
    public void startActivity(final View view) {
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

    /**
     * Add songs to the library.
     *
     * @param view is the actual view (activity_main)
     */
    public void addSongs(final View view) {
        Intent addSongsIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        addSongsIntent.setType("audio/*");
        addSongsIntent.addCategory(Intent.CATEGORY_OPENABLE);
        // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
        startActivityForResult(addSongsIntent, REQUEST_AUDIO_OPEN);
    }
}
