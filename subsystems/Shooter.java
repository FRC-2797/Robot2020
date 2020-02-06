package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConst;

public class Shooter extends SubsystemBase{ 
    //boolean pressed;
    @Override
    public void periodic(){
    }

    private final WPI_VictorSPX shooterMotor = new WPI_VictorSPX(3);
    //private final WPI_VictorSPX flywheel = new WPI_VictorSPX(2);
    //private final WPI_VictorSPX retractmotor = new WPI_VictorSPX();
    
    //private final CANSparkMax shooterMotor = new CANSparkMax(ShooterConst.SHOOTER, MotorType.kBrushless);
    
    
    public void shoot(boolean activated, double speed){
        shooterMotor.set(speed);
        //.setControlFramePeriod(frame, periodMs)
    }

    public void stop(){
        shooterMotor.disable();
    }


    public void retract(){
        //retractmotor.set(-1);
    }
    /*
    public void windowUp(){
        windowMotor.set(-1);
    }

    public void windowDown(){
        windowMotor.set(1);
    }
    */
    
}