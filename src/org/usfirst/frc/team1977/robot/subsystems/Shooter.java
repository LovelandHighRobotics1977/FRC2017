package org.usfirst.frc.team1977.robot.subsystems;

import org.usfirst.frc.team1977.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static Shooter instance;
	
	//private Victor Shoot1;
	private Victor Shoot1;
	
	public Shooter(){
		Shoot1 = new Victor(RobotMap.SHOOT1MOTOR);
	}
	
	public void initDefaultCommand() {
    }
	
	public void ShootPower(double Power) {
		Shoot1.set(Power);
	}
	
	public void stop() {
    	ShootPower(0);
    }

	public static Shooter getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}

