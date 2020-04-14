package com.example.eggwatchmvp.EggTimerModel;

public interface TimerState {
    void start(BaseTimer timer);
    void pause(BaseTimer timer);
    void stop(BaseTimer timer);
    void setup(BaseTimer timer);
}
