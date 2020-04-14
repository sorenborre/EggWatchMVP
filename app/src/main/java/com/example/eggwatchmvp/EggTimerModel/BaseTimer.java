package com.example.eggwatchmvp.EggTimerModel;

public abstract class BaseTimer extends NotifyOnTimeChanged implements Runnable {
    private long timer;
    private long startTimer;

    private TimerState state = new StopTimerState();

    void startThread() {
        new Thread(this).start();
    }

    void setState(TimerState state) {
        this.state = state;
    }

    TimerState getState() {
        return state;
    }

    void setTimer(long time) {
        timer = time;
    }

    public String getTimer() {
        return formatTime(timer);
    }

    private void setStartTimer() {
        startTimer = System.currentTimeMillis() + timer;
    }

    public String getCurrentTime() {
        if (startTimer <= 0)
            return formatTime(timer);

        return formatTime(startTimer - System.currentTimeMillis());
    }

    void resetTimer() {
        startTimer = 0;
        timer = 0;
    }

    private String formatTime(long time) {
        long second = (time / 1000) % 60;
        long minute = (time / (1000 * 60)) % 60;

        String timeFormatted = String.format("%02d:%02d", minute, second);
        return timeFormatted;
    }

    @Override
    public void run() {
        setStartTimer();

        while (System.currentTimeMillis() < startTimer) {

            try {
                notifyAllObserversCurrentTime();
                Thread.sleep(400);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (startTimer != 0)
            notifyAllObserversAlarm();

        resetTimer();

        getState().stop(this);
    }
}
