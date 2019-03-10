package max.greg.com.gregsapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SavedGamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_games);
        getSupportActionBar().setTitle("Saved Games");

        // puts in a back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // back action
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
