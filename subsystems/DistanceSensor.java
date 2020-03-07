package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.MedianFilter;
//import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DistanceConst;

public class DistanceSensor extends SubsystemBase{
    
    //private final Ultrasonic test = new Ultrasonic();

    private static final AnalogInput distanceSensor = new AnalogInput(DistanceConst.sensorChannel);

    private final MedianFilter filter = new MedianFilter(35);

    public static double getVoltage(){
        return distanceSensor.getVoltage();
    }

    public static double getDistance(){
        return getVoltage() * DistanceConst.volts_to_dist;
    }

    @Override 
    public void periodic(){

        //test.getDistance();

        double distance = (filter.calculate(distanceSensor.getValue()) * DistanceConst.toInches); 

        double currentDistance = getDistance();

        SmartDashboard.putNumber("getValue", distanceSensor.getValue());
        SmartDashboard.putNumber("dist", distance);
        SmartDashboard.putNumber("volt", getVoltage());
        SmartDashboard.putNumber(" Analog Distance", currentDistance);
    }
    
}