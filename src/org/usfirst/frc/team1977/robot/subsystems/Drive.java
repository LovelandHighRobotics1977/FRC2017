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
		//Define motor controllers for main drive train
		frontLeft = new Victor(RobotMap.DRIVE_FRONT_LEFT_TALON);
    	frontRight = new Victor(RobotMap.DRIVE_FRONT_RIGHT_TALON);
    	backLeft = new Victor(RobotMap.DRIVE_BACK_LEFT_TALON);
    	backRight = new Victor(RobotMap.DRIVE_BACK_RIGHT_TALON);
	}
	
	//Code for controlling the motor controllers last year
	/*public void drive(double hPower, double vPower, double turn) {
        frontLeft.set((vPower - hPower + (turn * turnPowerCoefficient)) * voltageCoefficient);
        frontRight.set((-vPower - hPower + (turn * turnPowerCoefficient)) * voltageCoefficient);
        backLeft.set((vPower + hPower + (turn * turnPowerCoefficient)) * voltageCoefficient);
        backRight.set((-vPower + hPower + (turn * turnPowerCoefficient)) * voltageCoefficient);
    }*/
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
