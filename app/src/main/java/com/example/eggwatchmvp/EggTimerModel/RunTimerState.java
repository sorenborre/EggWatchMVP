package com.example.eggwatchmvp.EggTimerModel;

public class RunTimerState implements TimerState {

    public RunTimerState(){

        System.out.println("StartState");
    }

    @Override
    public void start(BaseTimer timer) {
        //nothing
    }

    @Override
    public void pause(BaseTimer timer) {

    }

    @Override
    public void stop(BaseTimer timer) {
        timer.setState(new StopTimerState());
        timer.resetTimer();
        timer.notifyAllObserversCurrentTime();
    }

    @Override
    public void setup(BaseTimer timer) {

    }
}
