package com.example.eggwatchmvp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.eggwatchmvp.Presenters.EggTimerView;
import com.example.eggwatchmvp.Presenters.MainActivityPresenter;
import com.example.eggwatchmvp.R;

public class MainActivity extends AppCompatActivity implements EggTimerView, View.OnClickListener {

    private MainActivityPresenter presenter;
    private Ringtone r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);

        Button mButtonStartPause = findViewById(R.id.start_timer);
        Button ButtonReset = findViewById(R.id.reset);
        ImageButton ButtonSoft = findViewById(R.id.soft_boiled);
        ImageButton ButtonMedium = findViewById(R.id.medium_boiled);
        ImageButton ButtonHard = findViewById(R.id.hardboiled);

        mButtonStartPause.setOnClickListener(this);
        ButtonReset.setOnClickListener(this);
        ButtonSoft.setOnClickListener(this);
        ButtonMedium.setOnClickListener(this);
        ButtonHard.setOnClickListener(this);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        r = RingtoneManager.getRingtone(getApplicationContext(), notification);
    }

    @Override
    public void onClick(View v) {
        if (r.isPlaying()){
            r.stop();

        }

        if (v.getId() == R.id.soft_boiled) {
            presenter.timerSetup("soft");
        }
        else if (v.getId() == R.id.medium_boiled){
            presenter.timerSetup("medium");
        }
        else if (v.getId() == R.id.hardboiled){
            presenter.timerSetup("hard");
        }
        else if (v.getId() == R.id.start_timer) {
            presenter.start();
        }
        else if (v.getId() == R.id.reset) {
            presenter.stop();
        }
    }

    @Override
    public void setTimerText(String timer) {
       TextView t = findViewById(R.id.textView4);
        t.setText(timer);
    }

    @Override
    public void alarm() {
        r.play();
    }
}
