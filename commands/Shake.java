package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drivetrain;

public class Shake extends InstantCommand{
    public Shake(Drivetrain drivetrain){
        super(() -> drivetrain.shake(drivetrain));
    }
}