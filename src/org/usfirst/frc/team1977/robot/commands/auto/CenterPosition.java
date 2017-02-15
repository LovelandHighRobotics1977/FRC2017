package org.usfirst.frc.team1977.robot.commands.auto;


import org.usfirst.frc.team1977.robot.commands.CommandBase;
import org.usfirst.frc.team1977.robot.commands.drive.DriveStop;
import org.usfirst.frc.team1977.robot.commands.drive.DriveTime;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.StartCommand;

import org.usfirst.frc.team1977.robot.commands.drive.PidController;


public class CenterPosition extends CommandGroup {
	
	public CenterPosition() {
		
		//Need to adjust time and speed
		//Currently drives at half speed for 1 second
		//addSequential( new DriveTime( 0, 0.5, 1000) );
		addSequential( new startPID());
	}
	
	protected void end() {
		addSequential( new DriveStop() );
	}
	
	
	
	//Another way of autonomous working
	/*protected void initialize() {
		//How long this will run for
    	setTimeout(15);
    }
	
	 protected void execute() {
		 //Need to check on time and speed
		 //Currently half speed for 1 second
    	 addSequential( new DriveTime( 0, 0.5, 1000) );
    }
	
	 // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }*/
}

