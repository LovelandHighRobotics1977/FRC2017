package org.usfirst.frc.team1977.robot.commands.drive;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Joystick;

public class UserDrive extends CommandBase {
	//Time for 180 degree turn
	
	public UserDrive() {
		requires(drive);
	}
	
	protected void execute() {
		double hPower = oi.getDriveJoystick().getLeftX();
		double vPower = oi.getDriveJoystick().getLeftY();
		double turn = (oi.getDriveJoystick().getLeftTriggerAxis() * 0.7)
				- (oi.getDriveJoystick().getRightTriggerAxis() * 0.7);
		
		if (Math.abs(hPower) < .2) {
			hPower = 0;
		}

		if (Math.abs(vPower) < .2) {
			vPower = 0;
		}

		if (Math.abs(turn) < .2) {
			turn = 0;
		}
		drive.drive(-hPower, -vPower, -turn);
		
	}
	
	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drive.stop();
    }
}
