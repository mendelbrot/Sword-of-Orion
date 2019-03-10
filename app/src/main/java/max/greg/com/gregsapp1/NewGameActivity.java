package max.greg.com.gregsapp1;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class NewGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        getSupportActionBar().setTitle("New Game");

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
