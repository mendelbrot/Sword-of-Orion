package max.greg.com.gregsapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    public void startNewGame(final View view) {

        Intent startNewGameIntent = new Intent(this, GameMacroViewActivity.class);
        startNewGameIntent.putExtra("players", 4);
        startActivity(startNewGameIntent);
    }
}
