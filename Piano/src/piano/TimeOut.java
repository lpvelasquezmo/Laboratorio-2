/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARIAJOSE
 */
public class TimeOut {
 private int hour;
    private int minute;
    private int second;
    private Timer timer;
    private boolean isTimerRunning;
    private Display display;
 
    public TimeOut() {
        timer = new Timer();
        display = new Display();
        this.hour = 0;
        this.minute = 0;
        this.second= 15;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
 
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            isTimerRunning = true;
            if(second > 0) {
                second--;
            } else {
                second = 59;
                if(minute > 0) minute--;
                else {
                    minute = 59;
                    if(hour > 0) hour--;
                    // si segundo = 0, minuto = 0 y hora = 0,
                    // cancelamos el timer
                    else {
                        isTimerRunning = false;
                        timer.cancel();
                        
                        timer.purge();
                    }
                }
            }
            if(isTimerRunning){
                display.printTime(hour, minute, second);
        } else {
                System.out.println("Se acabo el tiempo");
        
    }}
    }; // fin timertask
 
    public void start(int timeout, int interval) {
        timer.schedule(task, timeout, interval);
        if (this.second == 0){
            timer.cancel();
            this.second = 15;
        }
    }
    public void stop(){
        timer.purge();
        this.second = 15;
        
    }
}     

