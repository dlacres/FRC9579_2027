// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
<<<<<<< HEAD
  //MotorControl m_motor;
  MotorPositionControl m_motor_pos;
  MotorVelocityControl m_motor;
=======
  public static final int VOLTAGE=1;
  public static final int POSITION=2;
  public static final int VELOCITY=3;
  
  int controlType = VOLTAGE;
  
  // A variable to hold the the handle t the MotorControl. (undefined until "new" is called)
  MotorControl m_motorControl;
  MotorPositionControl m_motorPositionControl;
  MotorVelocityControl m_motorVelocityControl;

  // A variable to hold the handle to the Joystick. (undefined until "new" is called)
>>>>>>> f8eeb47 (Add Arcade Drive. Update Motor Control with option to select the type of control.)
  Joystick m_js;

  // A variable to hold the position of the motor of double type
  double m_motorPosition=0.0;
  double m_motorVelocity=0.0;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   * 
   * Note: public is an access modifier that controls who can see the class. 
   * Robot is the name of the class. This is called when when "new" is used to create a handle for the class (new instance)
   * extends - extends keyword indicates class inheritance, allowing a subclass (child) 
   *   to inherit the fields and methods of a superclass (parent). In the software the @Override is used to modify the inherited methods.
   */
  public Robot() {

    // A handle for the MotorControl. The value of 2 is the ID of the motor controller. Change this value to control a different motor.
    m_motorControl = new MotorControl(2);
    m_motorPositionControl = new MotorPositionControl(2);
    m_motorVelocityControl = new MotorVelocityControl(2);

    // A handle for the Joystick
    m_js = new Joystick(0);
<<<<<<< HEAD
    m_motor_pos = new MotorPositionControl(2);
    m_motor = new MotorVelocityControl(2);
    //m_motor = new MotorControl(2);
=======

    //m_motor = new MotorPositionControl(2);
    //m_motor = new MotorVelocityControl(2);
>>>>>>> f8eeb47 (Add Arcade Drive. Update Motor Control with option to select the type of control.)
  }

  /**
   * This method is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * This runs after the mode specific periodic methods, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    // Send the current value of m_motorPosition for display in the SmartDashboard app
    SmartDashboard.putNumber("Motor_Pos", m_motorPosition);

    // Send the current value of m_js.command() for display in the SmartDashboard app
    SmartDashboard.putNumber("Js", m_js.command());
  }

  @Override
  public void autonomousInit() {
  }
  @Override
  public void autonomousPeriodic() {
  }

  /*
   * This method is called one time when transitioning from Disabled, Autonomous, or Test mode into Teleop.
   */
  @Override
  public void teleopInit() {
<<<<<<< HEAD
    m_motor_pos.setEncoderPosition(0.0);
    //m_motor.velocityCommand(m_js.command());
    //m_motor.command(m_js.command());
=======
    m_motorControl.setEncoderPosition(0.0);
>>>>>>> f8eeb47 (Add Arcade Drive. Update Motor Control with option to select the type of control.)
  }

  /*
   * This method is called when the teleop is enabled in the Drivers Station
   */
  @Override
  public void teleopPeriodic() {
<<<<<<< HEAD
    m_motorPosition = m_motor.velocityCommand(m_js.command());
    //m_motorPosition = m_motor.positionCommand(m_js.command()*5);
    //m_motorPosition =  m_motor.command(m_js.command());
=======

    // Command the motor to move with a voltage set by the left joystick up/down movement. 1 is full voltage, 0 is no voltage.
    if (controlType==VOLTAGE) {
      m_motorControl.command(m_js.command());
      m_motorVelocity = m_motorControl.getVelocity();
      m_motorPosition = m_motorControl.getPosition();
    } else if (controlType == POSITION) {
      m_motorPositionControl.command(m_js.command());
      m_motorVelocity = m_motorControl.getVelocity();
      m_motorPosition = m_motorControl.getPosition();
    } else if (controlType == POSITION) {
      m_motorVelocityControl.command(m_js.command());
      m_motorVelocity = m_motorControl.getVelocity();
      m_motorPosition = m_motorControl.getPosition();
    }
>>>>>>> f8eeb47 (Add Arcade Drive. Update Motor Control with option to select the type of control.)
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
