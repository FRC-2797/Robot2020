package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends InstantCommand{
    //navx distance not encoder 
    //private double wheelCircumference = 18.85;
    public DriveDistance(){
    }

    public DriveDistance(boolean forward, double goalPosition, Drivetrain drivetrain){
        super(() -> drivetrain.driveDistanceSide(goalPosition, drivetrain));

    }

   public DriveDistance(double goalPosition, Drivetrain drivetrain){
        super(() -> drivetrain.driveDistanceFWD(goalPosition, drivetrain));
   }
}