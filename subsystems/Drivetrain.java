package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConst;

public class Drivetrain extends SubsystemBase{
    
    private static final AHRS gyro = new AHRS();

    double initPosition;
    
    
    private final WPI_TalonFX frontright = new WPI_TalonFX(DriveConst.FRONTRIGHT);
    private final WPI_TalonFX frontleft = new WPI_TalonFX(DriveConst.FRONTLEFT);
    private final WPI_TalonFX backright = new WPI_TalonFX(DriveConst.BACKRIGHT);
    private final WPI_TalonFX backleft = new WPI_TalonFX(DriveConst.BACKLEFT);

    public static double distance;
    
    
    
    public final MecanumDrive drivetrain = new MecanumDrive(frontleft, backleft, frontright, backright);

    double velocity;
    

    public void calibrate(){
        gyro.calibrate();
    }
    
    public double getEncoder(){
        return frontleft.getSelectedSensorPosition();
    }

    
    public boolean driveDistanceFWD(double goalPosition, Drivetrain drivetrain){
        while(drivetrain.getEncoder() <= goalPosition){
            drivetrain.drive(0.2,0.0,0.0,false);
        } 
        return true;
    }

    public boolean driveDistanceSide(double goalPosition, Drivetrain drivetrain){
        if(goalPosition > 0){
            while(drivetrain.getEncoder()<= goalPosition){
                drivetrain.drive(0.0,0.2,0.0,false);
            }
            return true;
        }
        else{
            while(drivetrain.getEncoder() >= goalPosition){
                drivetrain.drive(0.0,0.2,0.0,false);
            }
            return true;
        }
        
    }

    public boolean shake(Drivetrain drivetrain){
        driveDistanceFWD(3, drivetrain);
        while(drivetrain.getEncoder() >= -3){
            drivetrain.drive(-.2, 0.0, 0.0, false);
        }
        return true;
    }
    
    public boolean resetSensor(){
        frontleft.setSelectedSensorPosition(0);
        return true;
    }

    public Rotation2d getAngle(){
        return Rotation2d.fromDegrees(gyro.getAngle() * (DriveConst.gyroReversed ? 1.0: -1.0));
    }

    public void drive(double yspeed, double xspeed, double rot, boolean fieldRelative){
        if(fieldRelative){
            drivetrain.driveCartesian(yspeed, xspeed, rot, -gyro.getAngle());
        } else{
            drivetrain.driveCartesian(yspeed, xspeed, rot);
            //System.out.println(rot);
        }
    }


    public boolean stop(Drivetrain drivetrain){
        drivetrain.drive(0, 0, 0, false);
        return true;
    }

    public void setMaxOutput(double maxOutput){
        drivetrain.setMaxOutput(maxOutput);
    }

    public void zeroHeading(){
        gyro.reset();
    }

    public double getHeading(){
        return Math.IEEEremainder(gyro.getAngle(), 360) * (DriveConst.gyroReversed ? -1.0 : 1.0);
    }

    public double getTurnRate(){
        return gyro.getRate() * (DriveConst.gyroReversed ? -1.0: 1.0);
    }
    
    public static boolean isFinished(){
        return true;
    }
}