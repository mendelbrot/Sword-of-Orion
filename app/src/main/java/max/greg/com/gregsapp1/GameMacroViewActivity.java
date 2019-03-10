package max.greg.com.gregsapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class GameMacroViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_macro_view);

        getSupportActionBar().setTitle(null);

        final Intent intent;

        intent = getIntent();

        Toast.makeText(this, Integer.toString(intent.getIntExtra("players", 0)), Toast.LENGTH_LONG).show();
    }
}
