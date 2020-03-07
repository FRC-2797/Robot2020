package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class BallGroup extends SequentialCommandGroup{
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

    public BallGroup(Drivetrain drivetrain, Limelight limelight, DriveDistance drive, Shooter shoot){
        if(starting == 1){
            addCommands(
                new ResetEncoder(drivetrain),
                new Shake(drivetrain),
                new ResetEncoder(drivetrain),
                new ParallelCommandGroup(
                    new Intake(shoot),
                    new DriveDistance(300.25, drivetrain)
                ),
                new ResetEncoder(drivetrain)
            );
        }
        else if(starting ==2){
            addCommands(
                new ResetEncoder(drivetrain),
                new Shake(drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(136, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, -161.625, drivetrain),
                new ResetEncoder(drivetrain),
                new ParallelCommandGroup(
                    new Intake(shoot),
                    new DriveDistance(164.75, drivetrain)
                ),
                new ResetEncoder(drivetrain)
            );

        }
        if(starting ==3){
            addCommands(
                new ResetEncoder(drivetrain),
                new Shake(drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(136, drivetrain),
                new ResetEncoder(drivetrain),
                new DriveDistance(true, -161.625, drivetrain),
                new ResetEncoder(drivetrain),
                new ParallelCommandGroup(
                    new Intake(shoot),
                    new DriveDistance(164.75, drivetrain)
                ),
                new ResetEncoder(drivetrain)

            );
           

        }        
    }
}