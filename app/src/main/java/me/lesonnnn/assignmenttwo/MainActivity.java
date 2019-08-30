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
    private int round = 0;
    private String[][] play = new String[3][3];

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
                play[i][j] = "";
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
                if (!game[i][j].equals("")) {
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
            mPlayer = false;
        } else {
            if (diem == -1) {
                Toast.makeText(this, "O Win", Toast.LENGTH_LONG).show();
                mPlayer = false;
            }
        }

        if (dem == 0 && diem == 0) {
            Toast.makeText(this, "Hoà", Toast.LENGTH_SHORT).show();
        }
    }

    private void restartGame() {
        diem = 0;
        round = 0;
        mPlayer = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mButtons[i][j].setText("");
                play[i][j] = "";
            }
        }
    }

    private void startComputer() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!play[i][j].equals(mButtons[i][j].getText().toString())) {
                    play[i][j] = mButtons[i][j].getText().toString();
                    if (round == 0) {
                        if (i == 1 && j == 1) {
                            play[0][0] = "O";
                            mButtons[0][0].setText(play[0][0]);
                        } else {
                            if ((i == 0 && j == 0) || (i == 0 && j == 2) || (i == 2 && j == 0) || (i
                                    == 2 && j == 2)) {
                                play[1][1] = "O";
                                mButtons[1][1].setText(play[1][1]);
                            } else {
                                if (i == 1) {
                                    if (j == 0) {
                                        play[1][2] = "O";
                                        mButtons[1][2].setText(play[1][2]);
                                    } else {
                                        play[1][0] = "O";
                                        mButtons[1][0].setText(play[1][0]);
                                    }
                                } else {
                                    if (i == 0) {
                                        play[2][1] = "O";
                                        mButtons[2][1].setText(play[2][1]);
                                    } else {
                                        play[0][1] = "O";
                                        mButtons[0][1].setText(play[0][1]);
                                    }
                                }
                            }
                        }
                    } else {

                        if (play[i][j].equals(play[1][j])) {
                            if (play[2][j].equals("")) {
                                play[2][j] = "O";
                                mButtons[2][j].setText(play[2][j]);
                                break;
                            }
                        } else {
                            if (play[i][j].equals(play[2][j])) {
                                if (play[1][j].equals("")) {
                                    play[1][j] = "O";
                                    mButtons[1][j].setText(play[1][j]);
                                    break;
                                }
                            }
                        }
                    }

                    if (play[i][j].equals(play[i][1])) {
                        if (play[i][2].equals("")) {
                            play[i][2] = "O";
                            mButtons[i][2].setText(play[i][2]);
                            break;
                        }
                    } else {
                        if (play[i][j].equals(play[i][2])) {
                            if (play[i][1].equals("")) {
                                play[i][1] = "O";
                                mButtons[i][1].setText(play[i][1]);
                                break;
                            }
                        }
                    }
                }
            }
        }

        mPlayer = true;
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
                startComputer();
                round += 1;
            }
        }
        checkStateGame();
    }
}
