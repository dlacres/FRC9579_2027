package frc.robot;

import com.revrobotics.spark.SparkMax;
/*
 * Drive a robot with two drive motors, one for the left wheel and one for the right wheel
 */
public class ArcadeDrive{

  private SparkMax m_driveLeft;
  private SparkMax m_driveRight;
  double m_distLeft;
  double m_distRight;
  double m_turnAngle;


  ArcadeDrive() {
    m_driveLeft = new SparkMax(3, SparkMax.MotorType.kBrushless);
    m_driveRight = new SparkMax(7, SparkMax.MotorType.kBrushless);
  }

  // Command movement of the robot
  public void command(double forwardCommand, double turnCommand){
    m_driveLeft.set(forwardCommand+turnCommand);
    m_driveRight.set(-forwardCommand+turnCommand);
  }

  public double distance(){
    return(1.0);
  }
  public double turnAngle(){
   return(1.0);
  }
}