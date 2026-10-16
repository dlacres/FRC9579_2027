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
  //MotorControl m_motor;
  MotorPositionControl m_motor_pos;
  MotorVelocityControl m_motor;
  Joystick m_js;
  double m_motorPosition=0.0;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    m_js = new Joystick(0);
    m_motor_pos = new MotorPositionControl(2);
    m_motor = new MotorVelocityControl(2);
    //m_motor = new MotorControl(2);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Motor_Pos", m_motorPosition);
    SmartDashboard.putNumber("Js", m_js.command());
  }

  @Override
  public void autonomousInit() {
  }
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    m_motor_pos.setEncoderPosition(0.0);
    //m_motor.velocityCommand(m_js.command());
    //m_motor.command(m_js.command());
  }

  @Override
  public void teleopPeriodic() {
    m_motorPosition = m_motor.velocityCommand(m_js.command());
    //m_motorPosition = m_motor.positionCommand(m_js.command()*5);
    //m_motorPosition =  m_motor.command(m_js.command());
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
