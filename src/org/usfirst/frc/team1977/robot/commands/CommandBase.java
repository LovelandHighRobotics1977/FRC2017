package org.usfirst.frc.team1977.robot.commands;

import org.usfirst.frc.team1977.robot.input.OI;
import org.usfirst.frc.team1977.robot.subsystems.Climber;
import org.usfirst.frc.team1977.robot.subsystems.Drive;
import org.usfirst.frc.team1977.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	/**
	 * Inherited static access to the OI.
	 */
	protected static OI oi;
	protected static Drive drive;
	protected static Shooter shooter;
	protected static Climber climber;
	
	/**
	 * Initialize the CommandBase, in doing so accessing and initializing every
	 * primary subsystem on the robot. Use this during robot initialization to
	 * prevent unnecessary redundancy.
	 */
	
	public static void init() {
		drive = Drive.getInstance();
		shooter = Shooter.getInstance();
		climber = Climber.getInstance();
		oi = OI.getInstance();
	}
}
