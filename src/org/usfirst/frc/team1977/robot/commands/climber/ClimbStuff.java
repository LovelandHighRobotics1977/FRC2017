package org.usfirst.frc.team1977.robot.commands.climber;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

public class ClimbStuff extends CommandBase{
	
	int Power;
	
	public ClimbStuff(){
		requires(climber);
	}
	
	protected void execute() {
		//Commented out for testing
		/*if(oi.getDriveJoystick().getRightThumbButtonValue()) Power = -1;
		else if(oi.getDriveJoystick().getRightShoulderValue()) Power = 1;
		
		climber.ShootPower(Power);*/
		
	}
	protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	climber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climber.stop();
    }
}
