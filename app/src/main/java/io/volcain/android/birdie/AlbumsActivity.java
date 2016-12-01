package io.volcain.android.birdie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static android.content.Intent.EXTRA_PROCESS_TEXT_READONLY;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        // create click listeners
        createClickListeners();
    }

    /**
     * method creates click listeners for each album
     */
    private void createClickListeners() {
        // Find the View that shows the first album
        TextView album_1 = (TextView) findViewById(R.id.album_1);

        // Set a click listener on that
        album_1.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the second album
        TextView album_2 = (TextView) findViewById(R.id.album_2);

        // Set a click listener on that
        album_2.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the third song
        TextView album_3 = (TextView) findViewById(R.id.album_3);

        // Set a click listener on that
        album_3.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the fourth song
        TextView album_4 = (TextView) findViewById(R.id.album_4);

        // Set a click listener on that
        album_4.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });
    }

    /**
     * Create an explicit intent to start songs activity.
     *
     * @param view is the actual view (activity_albums)
     */
    private void startSongsActivity(final View view) {
        String albumTag = (String) view.getTag();

        Intent categoryIntent = new Intent(this, SongsActivity.class);
        categoryIntent.putExtra(EXTRA_PROCESS_TEXT_READONLY, albumTag);
        startActivity(categoryIntent);
    }

}
