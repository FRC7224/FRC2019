package org.usfirst.frc.team7224.robot.subsystems;
import org.usfirst.frc.team7224.robot.RobotMap;
import org.usfirst.frc.team7224.robot.commands.WinchAction;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
*
*/
public class Winch extends Subsystem {


   private final WPI_TalonSRX winchmotor1 = RobotMap.winchTalonSRX9;
   private final WPI_TalonSRX winchmotor2 = RobotMap.winchTalonSRX10;

   public void initDefaultCommand() {
       setDefaultCommand(new WinchAction());
   }

   public void setupWinch() {
       winchmotor1.set(ControlMode.PercentOutput,0);
       winchmotor2.set(ControlMode.PercentOutput,0);
   }

   /**
    * sets the ball motor speed  -1 to +1
    */
   public void setWinchSpeed(double wspeed) {
       winchmotor1.set(wspeed);
       winchmotor2.set(-wspeed);
	   }
}
   
