
/*
 Control the position of a Rev Robotics motor using the Spark Max motor controller.
*/
package frc.robot;

import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.*;

public class MotorPositionControl {
    SparkMax m_motor;
    SparkClosedLoopController m_positionControl;
    RelativeEncoder m_encoder;

    // The PID controller configuration exists in the SparkMaxConfig class
    SparkMaxConfig m_config;

    // The proportional gain for the PID controller. The motor command is the position error * this value.
    private final double kP = 0.1;

    // The integral gain for the PID controller. Give this a value if the position has a force trying to move it away from the position command.
    private final double kI = 0.0;

    // The derivative gain for the PID controller. I do not usually set this value.
    private final double kD = 0.0;

    // The maximum position limit value
    private final double kMaxOutput = 1.0;

    // The minimum position limit value
    private final double kMinOutput = -1.0;

    MotorPositionControl(int deviceId){
        m_motor = new SparkMax(deviceId, SparkMax.MotorType.kBrushless);

        // The PID controller class
        m_positionControl = m_motor.getClosedLoopController();
        m_encoder = m_motor.getEncoder();

        m_config = new SparkMaxConfig();

    //    m_config.encoder.countsPerRevolution(42);
    //    m_config.encoder.positionConversionFactor(kScaleFactor);    // Units
    //    m_config.encoder.velocityConversionFactor(kScaleFactor/60); // Units/second

        m_config.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder);
        m_config.closedLoop.pid(kP,kI,kD);
        m_config.closedLoop.outputRange(kMinOutput, kMaxOutput);
        m_config.smartCurrentLimit(1); // 1 = 1 amp limit
        m_config.idleMode(IdleMode.kBrake);
 
        // This connects the PID configuration to the motor.
        m_motor.configure(m_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
        m_encoder.setPosition(0.0);
  }

    // Set the position to command the motor to move to.
    public void command(double command){
        m_positionControl.setSetpoint(command,ControlType.kPosition);
    }

    // Set the encoder position to a new value.
    public void setEncoderPosition(double position){
        m_encoder.setPosition(position);
    }
    public double getPosition(){
        return(m_encoder.getPosition());
    }
    public double getVelocity(){
        return(m_encoder.getVelocity());
    }
}
 
