package me.lesonnnn.assignmenttwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button[][] mButtons = new Button[3][3];
    private boolean mPlayer;
    private int diem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "btn" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                mButtons[i][j] = findViewById(resID);
                mButtons[i][j].setOnClickListener(this);
            }
        }
        Button newGame = findViewById(R.id.newGame);

        mPlayer = true;

        newGame.setOnClickListener(this);
    }

    private void checkStateGame() {
        String[][] game = new String[3][3];
        int dem = 9;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game[i][j] = mButtons[i][j].getText().toString();
                if (!game[i][j].equals("")){
                    dem -= 1;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if ((game[0][i].equals("X") && game[1][i].equals("X") && game[2][i].equals("X")) || (
                    game[i][0].equals("X")
                            && game[i][1].equals("X")
                            && game[i][2].equals("X"))) {
                diem = 1;
            } else {
                if ((game[0][i].equals("O") && game[1][i].equals("O") && game[2][i].equals("O"))
                        || (game[i][0].equals("O") && game[i][1].equals("O") && game[i][2].equals(
                        "O"))) {
                    diem = -1;
                }
            }
        }

        if (diem == 1) {
            Toast.makeText(this, "X Win", Toast.LENGTH_LONG).show();
            restartGame();
        } else {
            if (diem == -1) {
                Toast.makeText(this, "O Win", Toast.LENGTH_LONG).show();
                restartGame();
            }
        }

        if (dem == 0 && diem == 0){
            Toast.makeText(this, "Hoà", Toast.LENGTH_SHORT).show();
        }
    }

    private void restartGame() {
        diem = 0;
        mPlayer = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mButtons[i][j].setText("");
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            if (((Button) v).getText().toString().equals("New Game")) {
                restartGame();
            } else {
                return;
            }
        } else {

            if (mPlayer) {
                ((Button) v).setText("X");
                mPlayer = false;
            } else {
                ((Button) v).setText("O");
                mPlayer = true;
            }
        }
        checkStateGame();
    }
}
