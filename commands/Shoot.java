package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class Shoot extends InstantCommand{
    public Shoot(Shooter shooter, double speed){
        super(() -> shooter.shoot(speed));
    }
}