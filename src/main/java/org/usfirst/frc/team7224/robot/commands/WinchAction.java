

package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 *
 */
public class WinchAction extends Command {


    public WinchAction() {
    	 requires(Robot.winch);

   }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
  		
    	 Robot.winch.winchSetup();
     }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	    

  // Manual adjustment
  double height = Robot.chassis.deadZone(Robot.oi.joystick1.getZ()); // height
  RobotConstants.targetPositionRotations_w =  RobotConstants.targetPositionRotations_w +
          (height * RobotConstants.kwinchManualSensitivity_w); 
  
 

     // Button not pressed - Normal mode     	
  if (RobotConstants.targetPositionRotations_w <= RobotConstants.kwinchMinHt_w) 
     RobotConstants.targetPositionRotations_w = RobotConstants.kwinchMinHt_w;  // Limit to zero height
  if (RobotConstants.targetPositionRotations_w >= RobotConstants.kwinchMaxHt_w )
     RobotConstants.targetPositionRotations_w = RobotConstants.kwinchMaxHt_w;  // Limit to max height
 }
 
  



    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
