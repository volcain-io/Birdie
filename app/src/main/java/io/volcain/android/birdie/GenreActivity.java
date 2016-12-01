package io.volcain.android.birdie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static android.content.Intent.EXTRA_PROCESS_TEXT_READONLY;

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        // create click listeners
        createClickListeners();
    }

    /**
     * method creates click listeners for each genre
     */
    private void createClickListeners() {
        // Find the View that shows the first genre
        TextView genre_1 = (TextView) findViewById(R.id.genre_1);

        // Set a click listener on that
        genre_1.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the second genre
        TextView genre_2 = (TextView) findViewById(R.id.genre_2);

        // Set a click listener on that
        genre_2.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the third genre
        TextView genre_3 = (TextView) findViewById(R.id.genre_3);

        // Set a click listener on that
        genre_3.setOnClickListener(new View.OnClickListener() {
            // will be executed when the user clicks on the text view.
            @Override
            public void onClick(View view) {
                startSongsActivity(view);
            }
        });

        // Find the View that shows the fourth genre
        TextView genre_4 = (TextView) findViewById(R.id.genre_4);

        // Set a click listener on that
        genre_4.setOnClickListener(new View.OnClickListener() {
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
     * @param view is the actual view (activity_genre)
     */
    private void startSongsActivity(final View view) {
        String genreTag = (String) view.getTag();

        Intent categoryIntent = new Intent(this, SongsActivity.class);
        categoryIntent.putExtra(EXTRA_PROCESS_TEXT_READONLY, genreTag);
        startActivity(categoryIntent);
    }
}
