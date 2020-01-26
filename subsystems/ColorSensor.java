package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ColorSensorConst;
import edu.wpi.first.wpilibj.DriverStation;


public class ColorSensor extends SubsystemBase{
    
    private final I2C.Port i2cPort = I2C.Port.kOnboard;

    /*
    private final WPI_VictorSPX arm = new WPI_VictorSPX(ColorSensorConst.COLORMOTOR);
    */

    private final CANSparkMax arm = new CANSparkMax(ColorSensorConst.COLORMOTOR, MotorType.kBrushless);

    String gameData;

    ColorSensorV3 colorsensor = new ColorSensorV3(i2cPort);

    Color detectedColor;

    double IR;

    int proximity;

    boolean red, blue, green, yellow = false;
    
    @Override
    public void periodic(){

        detectedColor = colorsensor.getColor();

        IR = colorsensor.getIR();

        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("IR", IR);


        proximity = colorsensor.getProximity();

        SmartDashboard.putNumber("Proximity", proximity);

        gameData = DriverStation.getInstance().getGameSpecificMessage();

        if(gameData.length()> 0){
            switch (gameData.charAt(0)){
                case 'B':
                    blue = true;
                    SmartDashboard.putBoolean("Blue", blue);
                    break;
                case 'G':
                    green = true;
                    SmartDashboard.putBoolean("Green", green);
                    break;
                case 'R':
                    red = true;
                    SmartDashboard.putBoolean("Red", red);
                    break;
                case 'Y':
                    yellow = true;
                    SmartDashboard.putBoolean("Yellow", yellow);
                    break;
                default:
                    break;

            }
        }

    }

    public void spin(){
        arm.set(ColorSensorConst.FORWARDSPEED);
    } 

    public void stop(){
        arm.disable();
    }
}