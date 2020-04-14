package com.example.eggwatchmvp.EggTimerModel;

public interface TimerObserver {
    void updateCurrentTime();
    void updateStartTime();
    void timerAlarm();

}
