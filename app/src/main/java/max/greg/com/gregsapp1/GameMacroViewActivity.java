package max.greg.com.gregsapp1;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.GridView;

public class GameMacroViewActivity extends AppCompatActivity {

    GridView macroGameGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_macro_view);

        getSupportActionBar().setTitle(null);

        //final Intent intent = getIntent();
        //Toast.makeText(this, Integer.toString(intent.getIntExtra("players", 0)), Toast.LENGTH_LONG).show();

        GridView macroGameGrid = findViewById(R.id.gridView);
        macroGameGrid.setNumColumns(4);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;
        double widthDenominator = 4.2;
        macroGameGrid.setColumnWidth((int)(screenWidth/widthDenominator));
        ImageAdapter macroGridAdapter = new ImageAdapter(getApplicationContext(), macroGridSquares, widthDenominator);
        macroGameGrid.setAdapter(macroGridAdapter);
    }

    //fake data for grid squares
    int a = R.drawable.alphacentauri;
    int macroGridSquares[] = {
        a, a, a, a,
        a, a, a, a,
        a, a, a, a,
        a, a, a, a,
        a, a, a, a,
        a, a, a, a
    };




}
