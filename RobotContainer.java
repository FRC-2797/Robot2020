/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Ultrasonic;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  boolean pressed = false;
  private final Drivetrain drivetrain = new Drivetrain();
  XboxController xbx = new XboxController(0);
  private final Limelight limelight = new Limelight();
  private final Shooter shooter = new Shooter();
  private final Ultrasonic distanceSensor = new Ultrasonic();
  //private final TurnToAngle angle = new TurnToAngle(drivetrain);
  private final ColorSensor colorsensor = new ColorSensor();
  private final Button rightTrigger = new Button();

  
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  @SuppressWarnings("PMD.ExcessiveImports")
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    /*
    drivetrain.setDefaultCommand(
      new RunCommand(() -> drivetrain.drive(
        xbx.getY(GenericHID.Hand.kLeft) > 0.3?xbx.getY(GenericHID.Hand.kLeft):xbx.getY(GenericHID.Hand.kLeft)< -0.3?xbx.getY(GenericHID.Hand.kLeft):0,
        (xbx.getPOV() == -1)?0:((xbx.getPOV() == 90 )?0.5:-0.5),
        xbx.getX(GenericHID.Hand.kRight) > 0.3?xbx.getX(GenericHID.Hand.kRight):xbx.getX(GenericHID.Hand.kRight)<-0.3?xbx.getX(GenericHID.Hand.kRight):0, false),drivetrain));
    */
    shooter.setDefaultCommand(
      new RunCommand(() -> shooter.shoot(true,xbx.getRawAxis(3)),shooter));

    /*
    drivetrain.setDefaultCommand(
      newRunCommand(() -> drivetrain.arcadeDrive(
        xbx.getY(GenericHID.Hand.kleft) > 0.1?xbx.getY(GenericHID.Hand.kLeft):xbx.getY(GenericHID.Hand.kLeft)<-0.1?xbx.getY(GenericHID.Hand.k)
      ));
    
       */
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //new Button(() -> shooter.shoot(true, 1));
    


    /*
    new RunCommand(() -> shooter.shoot(
        xbx.getTriggerAxis(GenericHID.Hand.kRight) >0.5, 1.0),shooter);
    
    
    new JoystickButton(xbx, Button.kBumperRight.value)
        .whenPressed(() -> drivetrain.setMaxOutput(0.2))
        .whenReleased(() -> drivetrain.setMaxOutput(1));

       
    /*Have to use an encoder, not sure how just yet.
    new JoystickButton(xbx, Button.kA.value).whenHeld(new PIDCommand(
      new PIDController(0.065 ,0.001, 0.0), 
      drivetrain::getHeading,
      limelight.getX(), 
      output -> drivetrain.drive(0, Limelight.x, 0, false), //drivetrain.drive(0, Limelight.distance, 0, false),
      drivetrain));
    


    new JoystickButton(xbx, Button.kY.value).whenHeld(new PIDCommand(
      new PIDController(0.0,/*0.002031250.0,/* 0.0,025 0.00.0 /*0.50.0), 

      drivetrain::getHeading,

      0.0, 

      output -> drivetrain.drive(0, 0, limelight.getX(), false),

      drivetrain
    ));

    //new JoystickButton(xbx, Button.kB.value).whenHeld(new TurnToAngle(drivetrain));
}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}
}
