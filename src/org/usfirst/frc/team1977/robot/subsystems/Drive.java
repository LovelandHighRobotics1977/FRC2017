package org.usfirst.frc.team1977.robot.subsystems;

import org.usfirst.frc.team1977.robot.RobotMap;
import org.usfirst.frc.team1977.robot.commands.drive.UserDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private static Drive instance;
	//used for getInstance
	
	private boolean speedToggle = false;
	//for speedToggle function to halve speed
	
	private Victor frontLeft;
	private Victor frontRight;
	private Victor backLeft;
	private Victor backRight;
	
	
	/*private CANTalon frontLeft;
	private CANTalon frontRight;
	private CANTalon backLeft;
	private CANTalon backRight;*/
	
	
	private UserDrive userDrive;
	
	//May use if this we need to
	//robotDrive.setInvertedMotor(MotorType.frontLeft, true);
	
	private double voltageCoefficient = 1;
	private double turnPowerCoefficient = 1;

	
	public Drive(){
		//Define motor controllers for drive train on test chassis
		frontLeft = new Victor(RobotMap.DRIVE_FRONT_LEFT_VICTOR);
    	frontRight = new Victor(RobotMap.DRIVE_FRONT_RIGHT_VICTOR);
    	backLeft = new Victor(RobotMap.DRIVE_BACK_LEFT_VICTOR);
    	backRight = new Victor(RobotMap.DRIVE_BACK_RIGHT_VICTOR);
    	
    	/* Define motor controllers for drive train on main chassis
    	 * Need this because FIRST only has Victor plugins and they have no idea what its like trying to find and install plugins from third party sites that look fairly sketchy and don't really install right and why can't just add the commonly used motor controllers that they have in their FIRST Choice Program
    	 * http://www.ctr-electronics.com/downloads/pdf/CTRE%20Toolsuite%20Installation%20Guide.pdf*/
    /*	frontLeft = new CANTalon(RobotMap.DRIVE_FRONT_LEFT_TALON);
    	frontRight = new CANTalon(RobotMap.DRIVE_FRONT_RIGHT_TALON);
    	backLeft = new CANTalon(RobotMap.DRIVE_BACK_LEFT_TALON);
    	backRight = new CANTalon(RobotMap.DRIVE_BACK_RIGHT_TALON);*/
    	
	}
	
	public void initDefaultCommand() {
	       userDrive = new UserDrive();
	       setDefaultCommand(userDrive);
	    }
	
	public static Drive getInstance() {
    	if (instance == null) {
    		instance = new Drive();
    	}
    	return instance;
    }
	
	/**
     * Set the four drive victors based upon the specified power values 
     * multiplied by the drivetrain voltage coefficient.
     * @param hPower Horizontal (strafing) power.  Pulled from the X axis of the
     * left stick. Positive goes right!
     * @param vPower Vertical (forward) power.  Pulled from the Y axis of the 
     * left stick. Positive goes forward!
     * @param turn Turning power.  Pulled from the left and right triggers.
     */
	
	public void drive(double hPower, double vPower, double turn) {
        frontLeft.set((vPower - hPower + (turn * turnPowerCoefficient)) * voltageCoefficient);
        frontRight.set((-vPower - hPower + (turn * turnPowerCoefficient)) * voltageCoefficient);
         backLeft.set((vPower + hPower + (turn * turnPowerCoefficient)) * voltageCoefficient);
        backRight.set((-vPower + hPower + (turn * turnPowerCoefficient)) * voltageCoefficient);
    }
	
	public void stop() {
    	drive(0, 0, 0);
    }
	
	public boolean isSpeedToggle() {
    	return speedToggle;
    }
    
    public void setSpeedToggle(boolean speedToggle) {
    	this.speedToggle = speedToggle;
    	if (speedToggle) {
    		voltageCoefficient = 0.5;
    	} else {
    		voltageCoefficient = 1.0;
    	}
    }
}
