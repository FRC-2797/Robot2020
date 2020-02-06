package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class TurnToAngle{
    /*
    static Limelight limelight = new Limelight();
    public TurnToAngle(Drivetrain drivetrain) {
        super(new PIDController(.001, 0  , 0),

                drivetrain::getHeading,

                limelight.getX() ,

                output -> drivetrain.drive(0, 0, limelight.getX(), false),

            drivetrain);
        
        System.out.println(getController().calculate(limelight.getX()));
    

        getController().enableContinuousInput(-180, 180);

        //max turn rate degrees per second
        //max turn acceleration degrees pre second squared
        getController().setTolerance(2, 0);
    }

    @Override
    public boolean isFinished() {
        return getController().atSetpoint();
    }
*/
}