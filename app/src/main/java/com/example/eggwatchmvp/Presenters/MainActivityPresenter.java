package com.example.eggwatchmvp.Presenters;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eggwatchmvp.EggTimerModel.EggTimer;
import com.example.eggwatchmvp.EggTimerModel.TimerObserver;


public class MainActivityPresenter extends AppCompatActivity implements TimerObserver {
    private EggTimerView mainView;
    private EggTimer eggTimer;

    public MainActivityPresenter(EggTimerView view) {
        eggTimer = new EggTimer();
        eggTimer.register(this);
        mainView = view;
    }

    public void start() {
        eggTimer.start();
    }

    public void stop() {
        eggTimer.stop();
    }

    public void timerSetup(String prepEgg) {
        eggTimer.selectBoilingTime(prepEgg);
        eggTimer.setup();
    }



    @Override
    public void updateCurrentTime() {
        mainView.setTimerText(eggTimer.getCurrentTime());
    }

    @Override
    public void updateStartTime() {
        mainView.setTimerText(eggTimer.getTimer());
    }

    @Override
    public void timerAlarm() {
        mainView.alarm();
    }

}