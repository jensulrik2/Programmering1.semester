package model;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");


        TrainingPlan trainingPlan1 = new TrainingPlan('A',16,10);
        TrainingPlan trainingPlan2 = new TrainingPlan('B',10,6);

        trainingPlan1.addSwimmer(s1);
        trainingPlan1.addSwimmer(s2);
        trainingPlan2.addSwimmer(s3);

        System.out.println(trainingPlan1.getSwimmers().toString());


    }
    
}
