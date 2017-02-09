package org.usfirst.frc.team1977.robot.subsystems;

import org.usfirst.frc.team1977.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
private static Climber instance;
	
	//private Victor Shoot1;
	private Victor Climb1;
	
	public Climber(){
		Climb1 = new Victor(RobotMap.Climb1MOTOR);
	}
	
	public void initDefaultCommand() {
    }
	
	public void ShootPower(double Power) {
		Climb1.set(Power);
	}
	
	public void stop() {
    	ShootPower(0);
    }

	public static Climber getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
