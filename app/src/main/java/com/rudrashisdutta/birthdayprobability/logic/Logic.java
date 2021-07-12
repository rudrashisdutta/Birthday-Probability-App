package com.rudrashisdutta.birthdayprobability.logic;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.rudrashisdutta.birthdayprobability.ui.OutputInterface;

public class Logic implements LogicInterface {
    public static final String TAG = Logic.class.getName();
    OutputInterface mOut;

    public Logic(OutputInterface out){
        mOut = out;
    }

    @SuppressLint("DefaultLocale")
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }
        if (simulationCount <= 0) {
            mOut.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage");
        mOut.println("of times that two people share the same birthday is");
        mOut.println(String.format("%.2f%% of the time.", percent));

    }
    public double calculate(int size, int count) {
        double percentage;
        int trueCondition=0;
        for(int i=0;i<count;i++){
            List<Integer> People = new ArrayList<>(365);
            for(int k=0;k<365;k++){
                People.add(null);
            }
            Random rand =new Random(i+1);
            Random r=new Random(i-22209);
            for(int j=0;j<size;j++){
                int birthDay=(int)(r.nextDouble()*365);
                if(People.get(birthDay)!=null){
                    trueCondition++;
                    break;
                }
                else{
                    People.add(birthDay,rand.nextInt());
                }
            }
        }
        percentage=calculatePercentage(trueCondition,count);
        return percentage;
    }
    public static double calculatePercentage(int trueCondition,int simulationCount){
        double percentage;
        percentage=((double)trueCondition/(double)simulationCount)*100.0;
        return percentage;
    }
}
