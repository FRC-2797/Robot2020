package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ColorSensor;

public class WheelSpin extends InstantCommand{
    public WheelSpin(ColorSensor colorsensor){
        super(colorsensor::run);
    }
}