package org.usfirst.frc.team1977.robot.commands.drive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1977.robot.commands.CommandBase;


public class PidController extends CommandBase{
	
	public PidController() {
		requires(drive);
	}
	
	// distance in inches the robot wants to stay from an object
	private static final double kHoldDistance = 10.0;

	// maximun distance in inches we expect the robot to see
	private static final double kMaxDistance = 24.0;

	// factor to convert sensor values to a distance in inches
	private static final double kValueToInches = 0.125;

	// proportional speed constant
	private static final double kP = 7.0;

	// integral speed constant
	private static final double kI = 0.018;

	// derivative speed constant
	private static final double kD = 1.5;

	//private static final int kLeftMotorPort = 0;
	//private static final int kRightMotorPort = 1;
	private static final int kUltrasonicPort = 0;

	private AnalogInput ultrasonic = new AnalogInput(kUltrasonicPort);
	private PIDController pidController = new PIDController(kP, kI, kD, ultrasonic, new MyPidOutput());
		
	public void pidStart() {
		// Set expected range to 0-24 inches; e.g. at 24 inches from object go
		// full forward, at 0 inches from object go full backward.
		pidController.setInputRange(0, kMaxDistance * kValueToInches);
		// Set setpoint of the pidController
		pidController.setSetpoint(kHoldDistance * kValueToInches);
	}
		
	private static class MyPidOutput implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			drive.drive(output, 0,0);
		}
	}

	public class startPID extends CommandBase {
		public startPID() {
			requires(drive);
		}
		
		protected void initialize() {
			pidController.enable();
	    }
		
		@Override
		protected boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}
	}
	public void stopPID() {
		pidController.disable();

	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
