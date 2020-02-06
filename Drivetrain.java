package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConst;

public class Drivetrain extends SubsystemBase{
    private final AHRS gyro = new AHRS();

    //MecanumDriveOdometry odometry = new MecanumDriveOdometry(, getAngle());

    
    private final TalonFX frontright = new TalonFX(0);
    private final TalonFX frontleft = new TalonFX(1);
    private final TalonFX backright = new TalonFX(2);
    private final TalonFX backleft = new TalonFX(3);

    /*
    private final CANSparkMax frontright = new CANSparkMax(DriveConst.FRONTRIGHT, MotorType.kBrushless);
    private final CANSparkMax frontleft = new CANSparkMax(DriveConst.FRONTLEFT, MotorType.kBrushless);
    private final CANSparkMax backleft = new CANSparkMax(DriveConst.BACKLEFT, MotorType.kBrushless);
    private final CANSparkMax backright = new CANSparkMax(DriveConst.BACKRIGHT, MotorType.kBrushless);
    */



    /*
    private final WPI_VictorSPX frontright = new WPI_VictorSPX(DriveConst.FRONTRIGHT);
    private final WPI_VictorSPX frontleft = new WPI_VictorSPX(DriveConst.FRONTLEFT);
    private final WPI_VictorSPX backright = new WPI_VictorSPX(DriveConst.BACKRIGHT);
    private final WPI_VictorSPX backleft = new WPI_VictorSPX(DriveConst.BACKLEFT);
    

    private final SpeedControllerGroup leftSC = new SpeedControllerGroup(frontrightV, backrightV);
    private final SpeedControllerGroup rightSC = new SpeedControllerGroup(frontleftV, backleftV);

    public final DifferentialDrive drivetrainD = new DifferentialDrive(leftSC, rightSC);
    */

    private final CANCoder frontleftEncoder = new CANCoder(0);

    /*
    private final CANEncoder frontLeftENC = new CANEncoder(frontleft);
    private final CANEncoder frontRightENC = new CANEncoder(frontright);
    private final CANEncoder backRightENC = new CANEncoder(backright);
    private final CANEncoder backLeftENC = new CANEncoder(backleft);
    */
    

    public final MecanumDrive drivetrain = new MecanumDrive(frontleft, backleft, frontright, backright);


    public Rotation2d getAngle(){
        return Rotation2d.fromDegrees(gyro.getAngle() * (DriveConst.gyroReversed ? 1.0: -1.0));
    }

    public void drive(double xspeed, double yspeed, double rot, boolean fieldRelative){
        if(fieldRelative){
            drivetrain.driveCartesian(yspeed, xspeed, rot, -gyro.getAngle());
        } else{
            drivetrain.driveCartesian(yspeed, xspeed, rot);
        }
    }

    /*
    public void arcadeDrive(double fwd, double rot){
        drivetrainD.arcadeDrive(fwd, rot);
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

    
    public CANSparkMax getFrontRight(){
        return frontright;
    }
    public CANSparkMax getFrontLeft(){
        return frontleft;
    }
    public  CANSparkMax getBackLeft(){
        return backleft;
    }
    public CANSparkMax getBackRight(){
        return backright;
    }
    */
}