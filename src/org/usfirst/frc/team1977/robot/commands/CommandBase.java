package org.usfirst.frc.team1977.robot.commands;

import org.usfirst.frc.team1977.robot.input.OI;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	/**
	 * Inherited static access to the OI.
	 */
	protected static OI oi;
}
