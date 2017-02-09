package org.usfirst.frc.team1977.robot.commands.climber;

import org.usfirst.frc.team1977.robot.commands.CommandBase;

public class ClimbStuff extends CommandBase{
	public ClimbStuff(){
		requires(climber);
	}
	
	protected void execute() {
		boolean Power = oi.getDriveJoystick().getLeftThumbButtonValue();
		
		if(Power){
			climber.ShootPower(1);
		} else {
			climber.ShootPower(0);
		}
		
		
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
