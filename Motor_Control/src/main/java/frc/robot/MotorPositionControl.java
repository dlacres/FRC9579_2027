
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
    SparkMaxConfig m_config;
    private final double kP = 0.1;
    private final double kI = 0.0;
    private final double kD = 0.0;
    private final double kMaxOutput = 1.0;
    private final double kMinOutput = -1.0;

    MotorPositionControl(int deviceId){
        m_motor = new SparkMax(deviceId, SparkMax.MotorType.kBrushless);
        m_positionControl = m_motor.getClosedLoopController();
        m_encoder = m_motor.getEncoder();

        m_config = new SparkMaxConfig();

    //    m_config.encoder.countsPerRevolution(42);
    //    m_config.encoder.positionConversionFactor(kScaleFactor);    // Units
    //    m_config.encoder.velocityConversionFactor(kScaleFactor/60); // Units/second

        m_config.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder);
        m_config.closedLoop.p(kP);
        m_config.closedLoop.i(kI);
        m_config.closedLoop.d(kD);
        m_config.closedLoop.outputRange(kMinOutput, kMaxOutput);
        m_config.smartCurrentLimit(1); // 1 = 1 amp limit
        m_config.idleMode(IdleMode.kBrake);
 
        m_motor.configure(m_config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
        m_encoder.setPosition(0.0);
  }

    public double positionCommand(double command){
        m_positionControl.setSetpoint(command,ControlType.kPosition);

        return(m_encoder.getPosition());
    }
    public void setEncoderPosition(double position){
        m_encoder.setPosition(position);
    }
}
 
