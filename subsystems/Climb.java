package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConst;

public class Climb extends SubsystemBase{
    /*
    private final WPI_VictorSPX motorOne = new WPI_VictorSPX(ClimbConst.motorOne);
    private final WPI_VictorSPX motorTwo = new WPI_VictorSPX(ClimbConst.motorTwo);
    private final WPI_VictorSPX motorThree = new WPI_VictorSPX(ClimbConst.motorThree);
    */
    

    private final CANSparkMax motorOne = new CANSparkMax(ClimbConst.motorOne, MotorType.kBrushless);
    private final CANSparkMax motorTwo = new CANSparkMax(ClimbConst.motorTwo, MotorType.kBrushless);
    private final CANSparkMax motorThree = new CANSparkMax(ClimbConst.motorThree, MotorType.kBrushless);

    //maybe limit switches???????

    public Climb(){
        /*
        motorOne.addChild(motorTwo);
        motorOne.addChild(motorThree);
        */
        motorTwo.follow(motorOne);
        motorThree.follow(motorOne);
    }

    public void climb(){
        motorOne.set(1);
    }

    public void retract(){
        motorOne.set(-1);
    }

    public void stop(){
        motorOne.disable();
    }


}