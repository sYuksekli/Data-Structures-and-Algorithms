package com.company;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
/*
 *
 *******************
 *******************
 *   CSE 222 HW2   *
 * Sıla Bengisu Yüksekli *
 *******************
 *******************

 * @author Sıla Bengisu Yüksekli

 * @since 2019

 * @version HW2

 */


public class Experiment {

    private String setup;
    private int day;
    private String time;
    private boolean completed;
    private float accuracy;



    /**
     * Experiment constructor that initialize the instance variables.
     * @param Setup explains the experimental setup
     * @param Day represents the day of start
     * @param Completed indicates whether it is completed or not
     * @param Accuracy represents the output
     */
    public Experiment(String Setup, int Day, boolean Completed, float Accuracy){

        setup=Setup;
        day=Day;
        completed=Completed;
        accuracy= Accuracy;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        time=dateFormat.format(date);
    }

    /**
     * Experiment constructor that initialize the instance variables.
     * @param Setup explains the experimental setup
     * @param Time represents the time of start
     * @param Day represents the day of start
     * @param Completed indicates whether it is completed or not
     * @param Accuracy epresents the output
     */
    public Experiment(String Setup,String Time, boolean Completed, int Day, float Accuracy){

        setup=Setup;
        day=Day;
        completed=Completed;
        accuracy= Accuracy;
        time=Time;
    }

    /**
     * It sets the setup.
     * @param setup which is need to explain experiment.
     */
    public void setSetup(String setup) {
        this.setup = setup;
    }

    /**
     * It sets the completed
     * @param completed , to set if the experiment is completed.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * It sets the time.
     * @param time, to set the time of start
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * It sets the accuracy.
     * @param accuracy, to know the output
     */
    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * It sets the day.
     * @param day, to set the day of the start
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * It returns accuracy.
     * @return accuracy, which represents the output
     */
    public float getAccuracy() {
        return accuracy;
    }

    /**
     * It returns the day.
     * @return day, it indicates the day of start
     */
    public int getDay() {
        return day;
    }

    /**
     *It returns the setup.
     * @return setup, it explains the experiment
     */
    public String getSetup() {
        return setup;
    }

    /**
     * It returns the time.
     * @return time, it indicates the the time of start
     */
    public String getTime() {
        return time;
    }

    /**
     * It returns the completed variable
     * @return If the experiment is completed, return 1, else 0.
     */
    public boolean getCompleted(){
        return completed;
    }

    /**
     * It returns a string that "textually represents" this object.
     * @return a string representation of the object
     */
    @Override
    public String toString(){
        return setup+" "+day+" "+time+" "+completed+" "+accuracy;
    }



}
