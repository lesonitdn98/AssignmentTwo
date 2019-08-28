package me.lesonnnn.assignmenttwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button mBtn1, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8, mBtn9;
    private boolean mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mBtn3 = findViewById(R.id.btn3);
        mBtn4 = findViewById(R.id.btn4);
        mBtn5 = findViewById(R.id.btn5);
        mBtn6 = findViewById(R.id.btn6);
        mBtn7 = findViewById(R.id.btn7);
        mBtn8 = findViewById(R.id.btn8);
        mBtn9 = findViewById(R.id.btn9);
        Button newGame = findViewById(R.id.newGame);

        mPlayer = true;

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
        mBtn6.setOnClickListener(this);
        mBtn7.setOnClickListener(this);
        mBtn8.setOnClickListener(this);
        mBtn9.setOnClickListener(this);
        newGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if (mBtn1.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn1.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn1.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.btn2:
                if (mBtn2.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn2.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn2.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.btn3:
                if (mBtn3.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn3.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn3.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.btn4:
                if (mBtn4.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn4.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn4.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.btn5:
                if (mBtn5.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn5.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn5.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.btn6:
                if (mBtn6.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn6.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn6.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.btn7:
                if (mBtn7.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn7.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn7.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.btn8:
                if (mBtn8.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn8.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn8.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.btn9:
                if (mBtn9.getText().toString().equals("")) {
                    if (mPlayer) {
                        mBtn9.setText("X");
                        mPlayer = false;
                    } else {
                        mBtn9.setText("O");
                        mPlayer = true;
                    }
                }
                break;
            case R.id.newGame:
                mBtn1.setText("");
                mBtn2.setText("");
                mBtn3.setText("");
                mBtn4.setText("");
                mBtn5.setText("");
                mBtn6.setText("");
                mBtn7.setText("");
                mBtn8.setText("");
                mBtn9.setText("");
                mPlayer = true;
                break;
        }
    }
}
