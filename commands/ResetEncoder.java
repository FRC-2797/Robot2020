package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drivetrain;

public class ResetEncoder extends InstantCommand{
    public ResetEncoder(Drivetrain drivetrain){
        super(drivetrain::resetSensor);
    }
}