package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.MedianFilter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DistanceConst;

public class Ultrasonic extends SubsystemBase{
    
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

        double currentDistance = (filter.calculate(distanceSensor.getValue()) * DistanceConst.toInches) -22; 

        SmartDashboard.putNumber("Distance", currentDistance);
    }
    
}