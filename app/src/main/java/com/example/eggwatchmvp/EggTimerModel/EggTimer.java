package com.example.eggwatchmvp.EggTimerModel;

public class EggTimer extends BaseTimer {

    public void start() {
        getState().start(this);
    }

    public void stop() {
        getState().stop(this);
    }

    public void setup() {
        getState().setup(this);
    }

    public void selectBoilingTime(String selectTimer) {
        switch (selectTimer) {

            case "soft":
                setTimer(270000);
                setTimer(1000);

                break;

            case "medium":
                setTimer(390000);
                break;

            case "hard":
                setTimer(570000);
                break;
        }
    }
}
