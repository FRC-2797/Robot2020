package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class ShootGroup extends SequentialCommandGroup{
    private static int starting;
    private static Alliance team;

    public int setStarting(){
        starting = DriverStation.getInstance().getLocation();
        return starting;
    }

    public Alliance getTeam(){
        team = DriverStation.getInstance().getAlliance();
        return team;
    }


    public ShootGroup(Drivetrain drivetrain, Limelight limelight, DriveDistance drive, Shooter shoot){
        if(team == Alliance.Red){
        }
        if(team == Alliance.Blue){
        }
        //written for top right now
        if(starting == 1){
            addCommands(
                new ResetEncoder(drivetrain),
                new DriveDistance(123.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, 66.44, drivetrain),
                new ResetEncoder(drivetrain),
                new TurnToAngleProfiled(180.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(90.0, drivetrain),
                new Shoot(shoot, 1)
            );
        }
        //middle
        else if(starting ==2){
            addCommands(
                new ResetEncoder(drivetrain),
                new DriveDistance(150.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, -66.44, drivetrain),
                new ResetEncoder(drivetrain),
                new TurnToAngleProfiled(180.0, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(90.0, drivetrain),
                new Shoot(shoot, 1)
            );
        }
        //bottom
        else if(starting == 3){
            addCommands(
                new ResetEncoder(drivetrain),
                new DriveDistance(136, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, -179.32, drivetrain),
                new ResetEncoder(drivetrain),
                new TurnToAngleProfiled(180, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(90.0, drivetrain)
            );
        }
    }
}