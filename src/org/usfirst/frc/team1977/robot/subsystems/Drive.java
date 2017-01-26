package org.usfirst.frc.team1977.robot.subsystems;

import org.usfirst.frc.team1977.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	 private Victor frontLeft;
	 private Victor frontRight;
	 private Victor backLeft;
	 private Victor backRight;
	
	public Drive(){
		frontLeft = new Victor(RobotMap.DRIVE_FRONT_LEFT_TALON);
    	frontRight = new Victor(RobotMap.DRIVE_FRONT_RIGHT_TALON);
    	backLeft = new Victor(RobotMap.DRIVE_BACK_LEFT_TALON);
    	backRight = new Victor(RobotMap.DRIVE_BACK_RIGHT_TALON);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
