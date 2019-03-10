package max.greg.com.gregsapp1;

import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button newGameButton;
    private Button savedGamesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); //hide the title bar

        newGameButton = findViewById(R.id.newGameButton);
        savedGamesButton = findViewById(R.id.savedGamesButton);

        // set button click effect
        // https://stackoverflow.com/questions/35398499/set-button-click-effect-in-android
        View.OnTouchListener buttonTouchListener = new View.OnTouchListener() {
            public boolean onTouch (View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFF800080));
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.getBackground().setColorFilter(null);
                }
                return true;
            }
        };
        newGameButton.setOnTouchListener(buttonTouchListener);
        savedGamesButton.setOnTouchListener(buttonTouchListener);

    }


}
