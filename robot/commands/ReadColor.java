package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.ColorSensor;

public class ReadColor extends RunCommand{
    public ReadColor(ColorSensor colorSensor){
        super(colorSensor::readColor, colorSensor);
    }
}