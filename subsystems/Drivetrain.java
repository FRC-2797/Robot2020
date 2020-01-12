package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveMotorVoltages;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConst;

public class Drivetrain extends SubsystemBase{

    /** 
    private final PWMVictorSPX frontleft = new PWMVictorSPX(DriveConst.FRONTLEFT);
    private final PWMVictorSPX backright = new PWMVictorSPX(DriveConst.BACKRIGHT);
    private final PWMVictorSPX backleft = new PWMVictorSPX(DriveConst.BACKLEFT);
    private final PWMVictorSPX frontright = new PWMVictorSPX(DriveConst.FRONTRIGHT);
    */
    
    private final Gyro gyro = new ADXRS450_Gyro();

    //MecanumDriveOdometry odometry = new MecanumDriveOdometry(, getAngle());



    //frontRightSC = new SpeedController(frontright);
    //frontLeftSC = new SpeedController(backright);
    //backRightSC = new SpeedController(backleft);
    //backLeftSC = new SpeedController(frontright);
    

    /**
    private final CANSparkMax frontright = new CANSparkMax(DriveConst.FRONTRIGHT, MotorType.kBrushless);
    private final CANSparkMax frontleft = new CANSparkMax(DriveConst.FRONTLEFT, MotorType.kBrushless);
    private final CANSparkMax backleft = new CANSparkMax(DriveConst.BACKLEFT, MotorType.kBrushless);
    private final CANSparkMax backright = new CANSparkMax(DriveConst.BACKRIGHT, MotorType.kBrushless);
    */


    private final WPI_VictorSPX frontright = new WPI_VictorSPX(DriveConst.FRONTRIGHT);
    private final WPI_VictorSPX frontleft = new WPI_VictorSPX(DriveConst.FRONTLEFT);
    private final WPI_VictorSPX backright = new WPI_VictorSPX(DriveConst.BACKRIGHT);
    private final WPI_VictorSPX backleft = new WPI_VictorSPX(DriveConst.BACKLEFT);

    /** 
    SpeedController frontRightSC = new SpeedController(frontright);
    SpeedController frontLeftSC = new SpeedController(backright);
    SpeedController backRightSC = new SpeedController(backleft);
    SpeedController backLeftSC = new SpeedController(frontright);
    */

    public final MecanumDrive drivetrain = new MecanumDrive(frontleft, backleft, frontright, backright);

    public Rotation2d getAngle(){
        return Rotation2d.fromDegrees(gyro.getAngle() * (DriveConst.gyroReversed ? 1.0: -1.0));
    }

    public void drive(double xspeed, double yspeed, double rot, boolean fieldRelative){
        if(fieldRelative){
            drivetrain.driveCartesian(yspeed, xspeed, rot, -gyro.getAngle());
        } else{
            drivetrain.driveCartesian(xspeed, yspeed, rot);
        }
    }

    public void setMaxOutput(double maxOutput){
        drivetrain.setMaxOutput(maxOutput);
    }

    public void setDriveSpeedControllersVolts(MecanumDriveMotorVoltages volts){
        frontleft.setVoltage(volts.frontLeftVoltage);
        backleft.setVoltage(volts.rearLeftVoltage);
        frontright.setVoltage(volts.frontRightVoltage);
        backright.setVoltage(volts.rearRightVoltage);
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
}