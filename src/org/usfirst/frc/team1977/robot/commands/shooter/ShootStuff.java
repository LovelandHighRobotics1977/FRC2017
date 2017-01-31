package org.usfirst.frc.team1977.robot.commands.shooter;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public abstract class ShootStuff extends CommandBase {

	public ShootStuff(){
		requires(shooter);
	}
	
	protected void execute() {
		boolean Power = oi.getDriveJoystick().getRightThumbButtonValue();
		
		if(Power){
			shooter.ShootPower(1);
		} else {
			shooter.ShootPower(0);
		}
		
		
	}
	protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	shooter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	shooter.stop();
    }
}
