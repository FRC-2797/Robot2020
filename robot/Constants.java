/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConst{
    //usually 3 changed it 
    public static final int FRONTRIGHT = 4;//4
    public static final int FRONTLEFT = 2;//1
    public static final int BACKRIGHT = 3; //2
    public static final int BACKLEFT = 1;//3 
    public static final boolean gyroReversed = false;
    public static final double wheelCircumference = 18.84 ;
    }

    public static final class LimelightConstants{
        public static final double tapeheight = 38;//20
        public static final double robotheight = 9;
        public static final double angleoflimelight = 15;
        //edit a2
        /*
        
        */
    }

    public static final class DistanceConst{
        public static final int sensorChannel = 1;
        public static final double volts_to_dist= 1.0;
        public static final double toInches = 0.125;
    }

    public static final class ShooterConst{
        //should be reverted
        public static final int SHOOTER = 5;
        public static final double volts = 0.05;
        public static final double voltsSecondsPerRotation = 12.0;
    }

    public static final class ColorSensorConst{
        public static final int COLORMOTOR = 0;
        public static final double FORWARDSPEED = 1.0;
        public static final double BACKSPEED = 1.0;
    }

    public static final class ClimbConst{
        public static final int motorOne = 0;
        public static final int motorTwo = 1;
        public static final int motorThree = 8;
    }
    
}
