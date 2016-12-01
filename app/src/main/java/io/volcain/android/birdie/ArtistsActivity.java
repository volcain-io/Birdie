package io.volcain.android.birdie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.content.Intent.EXTRA_PROCESS_TEXT_READONLY;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        // create click listeners
        createClickListeners();
    }

    /**
     * method creates click listeners for each artists
     */
    private void createClickListeners() {
        // Find the View that shows the first artist
        TextView artist_1 = (TextView) findViewById(R.id.artist_1);

        // Set a click listener on that
        artist_1.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the second artist
        TextView artist_2 = (TextView) findViewById(R.id.artist_2);

        // Set a click listener on that
        artist_2.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the third artist
        TextView artist_3 = (TextView) findViewById(R.id.artist_3);

        // Set a click listener on that
        artist_3.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the fourth artist
        TextView artist_4 = (TextView) findViewById(R.id.artist_4);

        // Set a click listener on that
        artist_4.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });
    }

    /**
     * Create an implicit intent to start songs activity.
     *
     * @param view is the actual view (activity_artists)
     */
    public void startSongsActivity(final View view) {
        String artistTag = (String) view.getTag();

        Intent categoryIntent = new Intent(this, SongsActivity.class);
        categoryIntent.putExtra(EXTRA_PROCESS_TEXT_READONLY, artistTag);
        startActivity(categoryIntent);
    }
}
