package frc.robot.subsystems;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;

public class Sound extends Orchestra{
    public Sound(ArrayList<WPI_TalonFX> instruments, String filePath){
        System.out.println("going into loop");
        for(TalonFX instrument : instruments) {
            addInstrument(instrument);
            System.out.println("In loop");
        }
        
        loadMusic(filePath);
    }
}