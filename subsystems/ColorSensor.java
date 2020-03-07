package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
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
    
    private final WPI_VictorSPX arm = new WPI_VictorSPX(0);

    
    
    String gameData;

    double data;

    ColorSensorV3 colorsensor = new ColorSensorV3(i2cPort);

    Color detectedColor;

    RawColor rawColor;

    String color;

    double IR;

    int proximity;

    boolean red, blue, green, yellow = false;

    double distance;

    String goalPos;

    Object [][] colorwheel = new Object[8][4];

    String initPos;

    //double  redCount, blueCount, yellowCount, greenCount, redCount2, blueCount2, yellowCount2, greenCount2, redCount3, blueCount3, yellowCount3, greenCount3, redCount4, blueCount4, yellowCount4, greenCount4;


    boolean started;

    boolean off;

    String initColor;

    boolean isEnabled;

    //Trigger trigger = new Trigger(colorsensor::getEnabled);

    @Override
    public void periodic(){

        readColor();

        detectedColor = colorsensor.getColor();
 
        colorsensor.getRawColor();
        
        IR = colorsensor.getIR();

        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);

        
        SmartDashboard.putNumber("IR", IR);

        proximity = colorsensor.getProximity();

        SmartDashboard.putNumber("Proximity", proximity);

        gameData = DriverStation.getInstance().getGameSpecificMessage();

        gameData = "B";
        
        }

    public void run(){
        System.out.println("Runninig");
        gameData = "B";
        if(gameData.length()> 0){
            switch (gameData.charAt(0)){
                case 'B':
                    System.out.println("In B");
                    blue = true;
                    goalPos = "blue";
                    SmartDashboard.putBoolean("Blue", blue);
                    readColor();
                    if(color.equals("red")){
                        //goalPos = 24;
                        colorSpin();
                    }
                    else if(color.equals("green")){
                        //goalPos = 37.5;
                        colorSpin();
                    }
                    else if(color.equals("yellow")){
                        //goalPos = 12.5;
                        colorSpin();
                    }
                    else{
                        stop();
                    }
                    break;
                case 'G':
                    goalPos = "green";
                    green = true;
                    SmartDashboard.putBoolean("Green", green);
                    readColor();
                    if(color.equals("red")){
                        //goalPos = 37.5;
                        colorSpin();
                    }
                    else if(color.equals("blue")){
                        //goalPos = 12.5;
                        colorSpin();
                    }
                    else if(color.equals("yellow")){
                        //goalPos = 24;
                        colorSpin();
                    }
                    else{
                        stop();
                    }
                    break;
                case 'R':
                    red = true;
                    goalPos = "red";
                    SmartDashboard.putBoolean("Red", red);
                    readColor();
                    if(color.equals("blue")){
                        //goalPos = 24;
                        colorSpin();
                    }
                    else if(color.equals("green")){
                        //goalPos = 12.5;
                        colorSpin();
                    }
                    else if(color.equals("yellow")){
                        //goalPos = 37.5;
                        colorSpin();
                    }
                    else{
                        stop();
                    }

                    break;
                case 'Y':
                    yellow = true;
                    goalPos = "yellow";
                    SmartDashboard.putBoolean("Yellow", yellow);
                    readColor();
                    if(color.equals("red")){
                        //goalPos = 12.5;
                        colorSpin();
                    }
                    else if(color.equals("blue")){
                        //goalPos = 37.5;
                        colorSpin();
                    }
                    else if(color.equals("green")){
                        //goalPos = 24;
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

    public void distanceSpin(){
        readColor();
        String target = color;
        
        int colorCount = 0;
        boolean onTarget = true;
        boolean offTarget = false;
        do{
            readColor();
            //System.out.println(target + " " + onTarget);
            spin();
            if(color.equals(target) && onTarget){
                System.out.println(target);
                //System.out.println("If target color" + target);
                colorCount++; 
                System.out.println(colorCount);
                onTarget = false;
                offTarget = true;
            }
            else if(!color.equals(target) && offTarget){
                System.out.println("In Else");
                onTarget = true;
                offTarget = false;
            }
        }while(colorCount < 8);
            //isEnabled = false;
            colorCount = 0;
            System.out.println("Hello i am under the water please help me");
            stop();
        }
       



    public void readColor(){
        detectedColor = colorsensor.getColor();
         //need to read the values and then do something with them after
        if(detectedColor.red > .4 && detectedColor.blue < .16 && detectedColor.green < .37){
            //System.out.println("Red");
            color = "red";
            //isEnabled = true;
        }
        else if(detectedColor.green > .5 && detectedColor.red < .2 && detectedColor.blue < .27){
            //System.out.println("Green");
            color = "green";
            //isEnabled = true;
        }
        else if(detectedColor.blue > .4 && detectedColor.green > .4){
            //System.out.println("blue");
            color = "blue";
            //isEnabled = true;
        }
        else{
            //System.out.println("yellow");
            color = "yellow";
            //isEnabled = true;
         }
    }
    

    public void colorSpin(){
        while(!(color.equals(goalPos))){
            readColor();
            if(!(color.equals(goalPos))){
                spin();
            }
            else{
                stop();
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
