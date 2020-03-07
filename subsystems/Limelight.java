package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{
    
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public static double x,y,area,skew;
    public static boolean validTarget;

    public static double distance, tan;

    @Override 
    public void periodic(){
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");
        NetworkTableEntry ts = table.getEntry("ts");
        NetworkTableEntry tv = table.getEntry("tv");

        x = tx.getDouble(0);       
        //System.out.println("limelight x value " + x);
        y = ty.getDouble(0.0);
        distance = (37.5  -7) / Math.tan(Math.toRadians(15 + y));

        area = ta.getDouble(0.0);
        skew = ts.getDouble(0.0);
        validTarget = tv.getBoolean(false);

        SmartDashboard.putNumber("RobotDistance", distance);
        SmartDashboard.putNumber("Tan", tan);
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightA", area);
        SmartDashboard.putNumber("LimelightSkew", skew); 
        SmartDashboard.putBoolean("LIMELIGHT HAS A TARGET", validTarget);

        
        SmartDashboard.putNumber("Angle Measure From Limelight", x);
    }

    public double getX(){
        return x;
    }
}