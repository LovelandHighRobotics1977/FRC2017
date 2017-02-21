package org.usfirst.frc.team1977.robot.commands.shooter;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public abstract class ShootStuff extends CommandBase {

	int Power;
	
	public ShootStuff(){
		requires(shooter);
	}
	
	protected void execute() {
		//Commenting out for now
		/*if(oi.getDriveJoystick().getLeftThumbButtonValue()) Power = -1;
		else if(oi.getDriveJoystick().getLeftShoulderValue()) Power = 1;

		shooter.ShootPower(Power);	*/	
		
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
