package com.example.eggwatchmvp.EggTimerModel;

import java.util.ArrayList;
import java.util.List;

public abstract class NotifyOnTimeChanged {

    private List<TimerObserver> observers = new ArrayList<>();

    public void register(TimerObserver observer) {
        observers.add(observer);
    }

    public void unregister(TimerObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void notifyAllObserversStartTime() {
        for (TimerObserver o : observers) {
            o.updateStartTime();
        }
    }
    public void notifyAllObserversAlarm() {
        for (TimerObserver o : observers) {
            o.timerAlarm();
        }
    }

    public void notifyAllObserversCurrentTime() {
        for (TimerObserver o : observers) {
            o.updateCurrentTime();
        }
    }
}
