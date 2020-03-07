/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DistanceSpin;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.Intake;
import frc.robot.commands.ShootGroup;
import frc.robot.commands.TurnToAngleProfiled;
import frc.robot.commands.WheelSpin;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  boolean pressed = false;
  public final Climb climb = new Climb();
  public static final Drivetrain drivetrain = new Drivetrain();
  public static XboxController xbx = new XboxController(0);
  public static final Limelight limelight = new Limelight();
  public static final Shooter shooter = new Shooter();
  public static final DriveDistance drivedist = new DriveDistance();
  public static TurnToAngleProfiled profiledTurn;
  public static final ColorSensor colorsensor = new ColorSensor();
  public static final ShootGroup distanceGroup = new ShootGroup(drivetrain, limelight, drivedist,shooter);
  public static final Intake intakeGroup = new Intake(shooter);
  
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  @SuppressWarnings("PMD.ExcessiveImports")
  public RobotContainer(){
    // Configure the button bindings
    configureButtonBindings();
    //shooter.setDefaultCommand(new RunCommand() -> shooter.shoot);
    
    drivetrain.setDefaultCommand(
      new RunCommand(() -> drivetrain.drive(
        (xbx.getPOV() == -1)?0:((xbx.getPOV() == 90 )?0.5:-0.5),
        -(xbx.getY(GenericHID.Hand.kLeft) > 0.3?xbx.getY(GenericHID.Hand.kLeft):xbx.getY(GenericHID.Hand.kLeft)< -0.3?xbx.getY(GenericHID.Hand.kLeft):0),
        xbx.getX(GenericHID.Hand.kRight) > 0.3?xbx.getX(GenericHID.Hand.kRight):xbx.getX(GenericHID.Hand.kRight)<-0.3?xbx.getX(GenericHID.Hand.kRight):0, false),drivetrain));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(xbx, Button.kX.value).whileHeld(() -> colorsensor.distanceSpin()).whenReleased(() -> colorsensor.stop());

    new JoystickButton(xbx, Button.kB.value).whenPressed(() -> drivetrain.calibrate());

    new JoystickButton(xbx, Button.kA.value).whenPressed((new SequentialCommandGroup(new DistanceSpin(colorsensor), new WheelSpin(colorsensor))));
    //new JoystickButton(xbx, Button.kA.value).whenPressed(() -> drivetrain.resetSensor());

    //new JoystickButton(xbx,Button.kBumperLeft.value).whenPressed(() -> testing.talonTesting()).whenReleased(() -> testing.stop());

    //new JoystickButton(xbx, Button.kB.value).whenPressed(() -> climb.go());
    
    //new JoystickButton(xbx, Button.kB.value).whenHeld(new TurnToAngle(drivetrain));

    //new JoystickButton(xbx, Button.kA.value).whenPressed(() -> drivetrain.zeroHeading());
    //144381
    //new JoystickButton(xbx, Button.kX.value).whenPressed(() -> drivedist.driveDistanceFWD(144500, drivetrain)).whenReleased(() -> drivetrain.stop(drivetrain));
    //new JoystickButton(xbx, Button.kY.value).whenPressed(() -> drivetrain.playSong());
    //new JoystickButton(xbx, Button.kY.value).whenPressed(() -> shooter.shoot(1)).whenReleased(() -> shooter.stop());
    
    /*
    new JoystickButton(xbx, 6)
        .whenPressed(() -> drivetrain.setMaxOutput(0.2))
        .whenReleased(() -> drivetrain.setMaxOutput(.5));

    /*
    new JoystickButton(xbx, Button.kX.value).whenPressed(new PIDCommand(
      new PIDController(0.5,0.0, 0.0), 
      drivetrain::getHeading,
      limelight.getX(), 
      output -> drivetrain.drive(0, 0, output, false), //drivetrain.drive(0, Limelight.distance, 0, false),
      drivetrain));
    

    /*
    new JoystickButton(xbx, Button.kY.value).whenHeld(new PIDCommand(
      new PIDController(0.0, 0.0, 0.0), 

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
   */
  public Command getAutonomousCommand() {
    // Logic to determine which auto command to run
  }
  }

}
