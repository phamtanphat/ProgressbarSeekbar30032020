package com.example.progressbarseekbar30032020;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTvPercent;
    ProgressBar mProgressbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvPercent = findViewById(R.id.textviewPercent);
        mProgressbar = findViewById(R.id.progressbar);

        // Handler : Tao ra 1 cong viec se duoc thuc thi trong tuong lai
        // CountDownTimer : Sau khoang thoi gian se thuc thi cong viec
//        1s = 1000ms
//        5000 -
//        1000 - 1
        // Task 1 : Random gia tri khi duoc them vao progressbar
        // Task 2 : Khi dat nguong 100% thi dung lai
         CountDownTimer countDownTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mProgressbar.setProgress(
                        mProgressbar.getProgress() + getRandom(10));
                mTvPercent.setText(mProgressbar.getProgress() + " %");
            }
            @Override
            public void onFinish() {
                if (mProgressbar.getProgress() >= 100){
                    Toast.makeText(MainActivity.this, "Ket thuc", Toast.LENGTH_SHORT).show();
                    return;
                }
                this.start();
            }
        };
        countDownTimer.start();
    }
    private int getRandom(int bound){
        return new Random().nextInt(bound);
    }
}
