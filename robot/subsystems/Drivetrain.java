package frc.robot.subsystems;


import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConst;

public class Drivetrain extends SubsystemBase{
    
    private static final AHRS gyro = new AHRS();
    /*
    double timer;

    double initPosition;


    //MecanumDriveOdometry odometry = new MecanumDriveOdometry(, getAngle());
    
    
    private final WPI_TalonFX frontright = new WPI_TalonFX(DriveConst.FRONTRIGHT);
    private final WPI_TalonFX frontleft = new WPI_TalonFX(DriveConst.FRONTLEFT);
    private final WPI_TalonFX backright = new WPI_TalonFX(DriveConst.BACKRIGHT);
    private final WPI_TalonFX backleft = new WPI_TalonFX(DriveConst.BACKLEFT);

    WPI_TalonFX [] talons = {frontleft, frontright, backleft, backright};

    Sound orchestra;
    
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
    public static double distance;
    
    /*
    private final CANEncoder frontLeftENC = new CANEncoder(frontleft);
    private final CANEncoder frontRightENC = new CANEncoder(frontright);
    private final CANEncoder backRightENC = new CANEncoder(backright);
    private final CANEncoder backLeftENC = new CANEncoder(backleft);
    */
    
    /*
    public final MecanumDrive drivetrain = new MecanumDrive(frontleft, backleft, frontright, backright);

    double velocity;
    */

    public void calibrate(){
        gyro.calibrate();
    }
    @Override 
    public void periodic(){
        
        distance = gyro.getDisplacementX();
        double distancey = gyro.getDisplacementY();
        double distancez = gyro.getDisplacementZ();
        double quaternion = gyro.getQuaternionX();
        gyro.getQuaternionZ();
        gyro.getRawMagX();
        //velocity = frontleft.getSelectedSensorPosition();
        //distance = frontleft.getSelectedSensorPosition();
        System.out.println("Distance: "+ distance);


        SmartDashboard.putNumber("Quaternion", quaternion);
        SmartDashboard.putNumber("Distance", distance);
    }
    /*
    
    public double getEncoder(){
        return frontleft.getSelectedSensorPosition();
    }

    public void resetSensor(){
        frontleft.setSelectedSensorPosition(0);
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


    public void stop(Drivetrain drivetrain){
        drivetrain.drive(0, 0, 0, false);
    }

    public void driveDistance(double yspeed, double xpseed, double rot, boolean fieldRelative){
    }

    /*
    public void arcadeDrive(double fwd, double rot){
        drivetrainD.arcadeDrive(fwd, rot);
    }
    
    
    public void setMaxOutput(double maxOutput){
        drivetrain.setMaxOutput(maxOutput);
    }

    public void zeroHeading(){
        gyro.reset();
    }

    public void resetCoder(){
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

    public void addInstruments(){
        ArrayList<WPI_TalonFX> instruments = new ArrayList<WPI_TalonFX>();
        System.out.println("Adding instrument");
        instruments.add(frontright);
        instruments.add(frontleft);
        instruments.add(backright);
        instruments.add(backleft);

        orchestra = new Sound(instruments, "StarWars.chrp");
        System.out.println("Added bro");
    }

    public void playSong(){
        orchestra.loadMusic("test.chrp");
        addInstruments();
        orchestra.play();
    }
    */
}