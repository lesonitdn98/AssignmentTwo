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
    private boolean endGame = false;

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
                            && game[i][2].equals("X")) || (game[0][0].equals("X")
                    && game[1][1].equals("X")
                    && game[2][2].equals("X")) || (game[0][2].equals("X")
                    && game[1][1].equals("X")
                    && game[2][0].equals("X"))) {
                diem = 1;
                break;
            } else {
                if ((game[0][i].equals("O") && game[1][i].equals("O") && game[2][i].equals("O"))
                        || (game[i][0].equals("O") && game[i][1].equals("O") && game[i][2].equals(
                        "O"))
                        || (game[0][0].equals("O") && game[1][1].equals("O") && game[2][2].equals(
                        "O"))
                        || (game[0][2].equals("O") && game[1][1].equals("O") && game[2][0].equals(
                        "O"))) {
                    diem = -1;
                    break;
                }
            }
        }

        if (diem == 1) {
            Toast.makeText(this, "X Win", Toast.LENGTH_LONG).show();
            mPlayer = false;
            endGame = true;
        } else {
            if (diem == -1) {
                Toast.makeText(this, "O Win", Toast.LENGTH_LONG).show();
                mPlayer = false;
                endGame = true;
            }
        }

        if (dem == 0 && diem == 0) {
            Toast.makeText(this, "Hoà", Toast.LENGTH_SHORT).show();
            endGame = true;
        }
    }

    private void restartGame() {
        diem = 0;
        round = 0;
        mPlayer = true;
        endGame = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mButtons[i][j].setText("");
                play[i][j] = "";
            }
        }
    }

    private void startComputer() {
        boolean myComputer = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!play[i][j].equals(mButtons[i][j].getText().toString())) {
                    play[i][j] = mButtons[i][j].getText().toString();
                    if (round == 0) {
                        if (i == 1 && j == 1) {
                            play[0][0] = "O";
                            mButtons[0][0].setText(play[0][0]);
                            myComputer = false;
                            break;
                        } else {
                            if ((i == 0 && j == 0) || (i == 0 && j == 2) || (i == 2 && j == 0) || (i
                                    == 2 && j == 2)) {
                                play[1][1] = "O";
                                mButtons[1][1].setText(play[1][1]);
                                myComputer = false;
                                break;
                            } else {
                                if (i == 1) {
                                    if (j == 0) {
                                        play[1][2] = "O";
                                        mButtons[1][2].setText(play[1][2]);
                                        myComputer = false;
                                        break;
                                    } else {
                                        play[1][0] = "O";
                                        mButtons[1][0].setText(play[1][0]);
                                        myComputer = false;
                                        break;
                                    }
                                } else {
                                    if (i == 0) {
                                        play[2][1] = "O";
                                        mButtons[2][1].setText(play[2][1]);
                                        myComputer = false;
                                        break;
                                    } else {
                                        play[0][1] = "O";
                                        mButtons[0][1].setText(play[0][1]);
                                        myComputer = false;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {

                        if (play[i][j].equals(play[1][j]) && i != 1) {
                            if (play[2][j].equals("")) {
                                play[2][j] = "O";
                                mButtons[2][j].setText(play[2][j]);
                                myComputer = false;
                                break;
                            } else {
                                if (play[0][j].equals("")) {
                                    play[0][j] = "O";
                                    mButtons[0][j].setText(play[0][j]);
                                    myComputer = false;
                                    break;
                                }
                            }
                        } else {
                            if (play[i][j].equals(play[2][j]) && i != 2) {
                                if (play[1][j].equals("")) {
                                    play[1][j] = "O";
                                    mButtons[1][j].setText(play[1][j]);
                                    myComputer = false;
                                    break;
                                } else {
                                    if (play[0][j].equals("")) {
                                        play[0][j] = "O";
                                        mButtons[0][j].setText(play[0][j]);
                                        myComputer = false;
                                        break;
                                    }
                                }
                            } else {
                                if (play[i][j].equals(play[0][j]) && i != 0) {
                                    if (play[1][j].equals("")) {
                                        play[1][j] = "O";
                                        mButtons[1][j].setText(play[1][j]);
                                        myComputer = false;
                                        break;
                                    } else {
                                        if (play[2][j].equals("")) {
                                            play[2][j] = "O";
                                            mButtons[2][j].setText(play[2][j]);
                                            myComputer = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        if (play[i][j].equals(play[i][1]) && j != 1) {
                            if (play[i][2].equals("")) {
                                play[i][2] = "O";
                                mButtons[i][2].setText(play[i][2]);
                                myComputer = false;
                                break;
                            } else {
                                if (play[i][0].equals("")) {
                                    play[i][0] = "O";
                                    mButtons[i][0].setText(play[i][0]);
                                    myComputer = false;
                                    break;
                                }
                            }
                        } else {
                            if (play[i][j].equals(play[i][2]) && j != 2) {
                                if (play[i][0].equals("")) {
                                    play[i][0] = "O";
                                    mButtons[i][0].setText(play[i][0]);
                                    myComputer = false;
                                    break;
                                } else {
                                    if (play[i][1].equals("")) {
                                        play[i][1] = "O";
                                        mButtons[i][1].setText(play[i][1]);
                                        myComputer = false;
                                        break;
                                    }
                                }
                            } else {
                                if (play[i][j].equals(play[i][0]) && j != 0) {
                                    if (play[i][1].equals("")) {
                                        play[i][1] = "O";
                                        mButtons[i][1].setText(play[i][1]);
                                        myComputer = false;
                                        break;
                                    } else {
                                        if (play[i][2].equals("")) {
                                            play[i][2] = "O";
                                            mButtons[i][2].setText(play[i][2]);
                                            myComputer = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        boolean check = false;

        if (myComputer) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (mButtons[i][j].getText().toString().equals("")) {
                        play[i][j] = "O";
                        mButtons[i][j].setText(play[i][j]);
                        check = true;
                        break;
                    }
                }
                if (check) {
                    break;
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
            }
        } else {
            if (mPlayer) {
                ((Button) v).setText("X");
                mPlayer = false;
                checkStateGame();
                round += 1;
            }

            if (!endGame) {
                startComputer();
                checkStateGame();
            }
        }
    }
}
