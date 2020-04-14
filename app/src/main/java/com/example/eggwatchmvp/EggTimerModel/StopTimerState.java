package com.example.eggwatchmvp.EggTimerModel;

public class StopTimerState implements TimerState {


    public StopTimerState(){

        System.out.println("resetState");
    }
    @Override
    public void start(BaseTimer timer) {
        timer.setState(new RunTimerState());
        timer.startThread();
    }

    @Override
    public void pause(BaseTimer timer) {
//nothing
    }

    @Override
    public void stop(BaseTimer timer) {
//nothing
    }

    @Override
    public void setup(BaseTimer timer) {
        timer.notifyAllObserversStartTime();
    }
}

