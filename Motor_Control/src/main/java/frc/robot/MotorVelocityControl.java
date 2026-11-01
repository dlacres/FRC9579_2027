/*
 Control the velocity (speed) of a Rev Robotics motor using the Spark Max motor controller.
*/
package frc.robot;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.*;

public class MotorVelocityControl {
    SparkMax m_motor;
    SparkClosedLoopController m_velocityControl;
    RelativeEncoder m_encoder;
    SparkMaxConfig m_config;
    private final double kP = 0.01;
    private final double kI = 0.0;
    private final double kD = 0.0;

    public MotorVelocityControl(int deviceId){
        m_motor = new SparkMax(deviceId, SparkMax.MotorType.kBrushless);

        m_encoder = m_motor.getEncoder();
        m_encoder.setPosition(0.0);

        //m_velocityControl = m_motor.getClosedLoopController();

        /*m_config = new SparkMaxConfig();
        m_config.closedLoop.pid(kP, kI, kD); // Set P, I, D gains
        m_config.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder);
        m_motor.configure(m_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);*/
    }

    public void command(double vCmd){
        double cmd = (vCmd - m_encoder.getVelocity()/3000.0) * kP;
        m_motor.set(cmd);
        SmartDashboard.putNumber("Cmd", cmd);
        //m_velocityControl.setSetpoint(command, ControlType.kVelocity);
    }
    public double getPosition(){
        return(m_encoder.getPosition());
    }
    public double getVelocity(){
        return(m_encoder.getVelocity());
    }
    public void setEncoderPosition(double position){
        m_encoder.setPosition(position);
    }
}
 
