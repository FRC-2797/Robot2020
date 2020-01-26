package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConst;

public class Shooter extends SubsystemBase{

    @Override
    public void periodic(){
    }

    //private final WPI_VictorSPX shooterMotor = new WPI_VictorSPX(4);
    private final CANSparkMax shooterMotor = new CANSparkMax(ShooterConst.SHOOTER, MotorType.kBrushless);
    //private final  SimpleMotorFeedforward shooterFeedForward = new SimpleMotorFeedforward(ShooterConst.volts, ShooterConst.voltsSecondsPerRotation);

    public void shoot(double speed){
        shooterMotor.set(speed);
    }

    public void stop(){
        shooterMotor.disable();
    }

    public void retract(double speed){
        shooterMotor.set(speed);
    }
}