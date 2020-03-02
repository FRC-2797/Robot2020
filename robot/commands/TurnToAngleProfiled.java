package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import frc.robot.subsystems.Drivetrain;

public class TurnToAngleProfiled{
    /*
    
    public TurnToAngleProfiled(double targetDegrees, Drivetrain drive){
        super(new ProfiledPIDController(0.0, 0.0, 0.0, new TrapezoidProfile.Constraints(0.0, 0.0)), 
            drive::getHeading, 
            targetDegrees, 
            (output, setpoint) -> drive.drive(0.0, 0.0, output, false), 
            drive);
        
        getController().enableContinuousInput(-180, 180);
        getController().setTolerance(2,2);
    }

    @Override
    public boolean isFinished(){
        return getController().atGoal();
    }
    */
}
