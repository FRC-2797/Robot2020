package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants.ShooterConst;

public class Shooter extends SubsystemBase{
    Double gameData;
    //boolean pressed;
    

    private final WPI_VictorSPX flywheel = new WPI_VictorSPX(2);
    private final WPI_VictorSPX windowMotor = new WPI_VictorSPX(3);
    private final WPI_VictorSPX intake = new WPI_VictorSPX(4);
    
    private final CANSparkMax shooterMotor = new CANSparkMax(3 , MotorType.kBrushless);
    
    
    public void shoot(double speed){
        flywheel.set(speed);
        shooterMotor.set(speed);
    }

    public void stop(){
        flywheel.disable();
        shooterMotor.disable();
    }

    public void retract(double speed){
        shooterMotor.set(speed);
    }

    public void intake(double speed){
        intake.set(speed);
    }
    
    public void windowUp(double speed){
        windowMotor.set(speed);
    }

}