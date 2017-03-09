package org.usfirst.frc.team1977.robot.commands.auto;

import org.usfirst.frc.team1977.robot.commands.CommandBase;
import org.usfirst.frc.team1977.robot.commands.drive.DriveStop;
import org.usfirst.frc.team1977.robot.commands.drive.DriveTime;
import org.usfirst.frc.team1977.robot.commands.drive.PidController;
import org.usfirst.frc.team1977.robot.commands.drive.TurnTime;
import org.usfirst.frc.team1977.robot.input.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPosition extends CommandGroup{
	public static LeftPosition instance;
	public LeftPosition(){
		//Need to adjust driving and turning times
		addSequential( new DriveTime( 0, 1, 1620 ) );//3240
		addSequential( new TurnTime( 300 , -1) );
		//addSequential( new DriveTime( 0, 0.5, 675) );//1350
		//addSequential( new PidController());
		//PidController.startPID();
	}
	
	protected void end() {
		addSequential( new DriveStop() );
	
	}
	public static LeftPosition getInstance() {
		if (instance == null) {
			instance = new LeftPosition();
		}
		return instance;
	}
}
