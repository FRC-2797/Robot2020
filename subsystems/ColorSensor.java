package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorSensorV3.RawColor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ColorSensorConst;


public class ColorSensor extends SubsystemBase{
    
    private final I2C.Port i2cPort = I2C.Port.kOnboard;

    
    //private final WPI_VictorSPX arm = new WPI_VictorSPX(ColorSensorConst.COLORMOTOR);
    
    

    private final CANSparkMax arm = new CANSparkMax(ColorSensorConst.COLORMOTOR, MotorType.kBrushless);

    private final CANEncoder wheelEncoder = new CANEncoder(arm);

    String gameData;

    double data;

    ColorSensorV3 colorsensor = new ColorSensorV3(i2cPort);

    Color detectedColor;

    RawColor rawColor;

    String color;

    double IR;

    int proximity;

    boolean red, blue, green, yellow = false;

    double circle = 12;

    double distance;

    double initPos;

    double goalPos;
    
    @Override
    public void periodic(){
        

        detectedColor = colorsensor.getColor();


        colorsensor.getRawColor();

        IR = colorsensor.getIR();

        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Raw Color blue", rawColor.blue);
        SmartDashboard.putNumber("Raw Color red", rawColor.red);
        SmartDashboard.putNumber("Raw Color green", rawColor.green);
        
        SmartDashboard.putNumber("IR", IR);

        proximity = colorsensor.getProximity();

        SmartDashboard.putNumber("Proximity", proximity);

        gameData = DriverStation.getInstance().getGameSpecificMessage();
        

        gameData = "B";
        if(gameData.length()> 0){
            switch (gameData.charAt(0)){
                case 'B':
                    blue = true;
                    SmartDashboard.putBoolean("Blue", blue);
                    readColor();
                    if(color.equals("Red")){
                        goalPos = 24;
                        colorSpin();
                    }
                    else if(color.equals("Green")){
                        goalPos = 37.5;
                        colorSpin();
                    }
                    else if(color.equals("Yellow")){
                        goalPos = 12.5;
                        colorSpin();
                    }
                    else{
                        stop();
                    }
                    break;
                case 'G':
                    green = true;
                    SmartDashboard.putBoolean("Green", green);
                    readColor();
                    if(color.equals("Red")){
                        goalPos = 37.5;
                        colorSpin();
                    }
                    else if(color.equals("Blue")){
                        goalPos = 12.5;
                        colorSpin();
                    }
                    else if(color.equals("Yellow")){
                        goalPos = 24;
                        colorSpin();
                    }
                    else{
                        stop();
                    }
                    break;
                case 'R':
                    red = true;
                    SmartDashboard.putBoolean("Red", red);
                    readColor();
                    if(color.equals("Blue")){
                        goalPos = 24;
                        colorSpin();
                    }
                    else if(color.equals("Green")){
                        goalPos = 12.5;
                        colorSpin();
                    }
                    else if(color.equals("Yellow")){
                        goalPos = 37.5;
                        colorSpin();
                    }
                    else{
                        stop();
                    }

                    break;
                case 'Y':
                    yellow = true;
                    SmartDashboard.putBoolean("Yellow", yellow);
                    readColor();
                    if(color.equals("Red")){
                        goalPos = 12.5;
                        colorSpin();
                    }
                    else if(color.equals("Blue")){
                        goalPos = 37.5;
                        colorSpin();
                    }
                    else if(color.equals("Green")){
                        goalPos = 24;
                        colorSpin();
                    }
                    else{
                        stop();
                    }
                    break;
                default:
                    break;

            }
        }

    }

    public double readColor(){
        detectedColor = colorsensor.getColor();
         //need to read the values and then do something with them after 

         if(detectedColor.red > .4 && detectedColor.blue < .16 && detectedColor.green < .37){
             System.out.println("Red");
             color = "red";
             return detectedColor.red;
         }
         else if(detectedColor.green > .5 && detectedColor.red < .2 && detectedColor.blue < .27){
             System.out.println("Green");
             color = "green";
             return detectedColor.green;
         }
         else if(detectedColor.blue > .4 && detectedColor.green > .4){
             System.out.println("blue");
             color = "blue";
             return detectedColor.blue;
         }
         else{
             System.out.print("yellow");
             color = "yellow";
             return 0.0;
         }


    }
    
    public void colorSpin(){
        //fix the init pos thing
        initPos = wheelEncoder.getPosition();
        while(initPos <= goalPos){
            spin();
        }
        stop();
    }

    public void spin(){
        arm.set(ColorSensorConst.FORWARDSPEED);
    } 

    public void stop(){
        arm.disable();
    }
}
