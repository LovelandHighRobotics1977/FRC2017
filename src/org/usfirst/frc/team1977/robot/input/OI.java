package org.usfirst.frc.team1977.robot.input;

import org.usfirst.frc.team1977.robot.commands.drive.SpeedToggle;
import org.usfirst.frc.team1977.robot.commands.drive.TurnTime;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static OI instance;
	// XBox Controller references
	private XBoxController driveJoystick;
	//Other joystick will be put here as well
	
	public OI() {
		driveJoystick = new XBoxController(0);
		//Set other controller here once we know if it is used 
		//manipulatorJoystick = new XBoxController(1);
	}
	
	public void init() {
		//Put things here when you want buttons to trigger
		//Speed toggle
		driveJoystick.leftThumbWhenPressed(new SpeedToggle());
		//Turn functions for shoulders
		driveJoystick.rightWhileHeld(new TurnTime(100,-1));
		driveJoystick.leftWhileHeld(new TurnTime(100,1));
		//180 turn function
		driveJoystick.rightThumbWhenPressed(new TurnTime(500,1)); //THIS NEEDS TO BE Adjusted
	}
	
	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}
		return instance;
	}
	
	public XBoxController getDriveJoystick() {
		return driveJoystick;
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
