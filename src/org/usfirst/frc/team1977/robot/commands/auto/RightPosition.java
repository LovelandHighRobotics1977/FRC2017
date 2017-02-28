package org.usfirst.frc.team1977.robot.commands.auto;

import org.usfirst.frc.team1977.robot.commands.CommandBase;
import org.usfirst.frc.team1977.robot.commands.drive.DriveStop;
import org.usfirst.frc.team1977.robot.commands.drive.DriveTime;
import org.usfirst.frc.team1977.robot.commands.drive.PidController;
import org.usfirst.frc.team1977.robot.commands.drive.TurnTime;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightPosition extends CommandGroup{

	public RightPosition(){
		//Need to adjust driving and turning times
		addSequential( new DriveTime( 0, 0.5, 1000 ) );
		addSequential( new TurnTime( 1000 , 1) );
		addSequential( new PidController());
		PidController.startPID();
	}
	
	protected void end() {
		addSequential( new DriveStop() );
	}
}
