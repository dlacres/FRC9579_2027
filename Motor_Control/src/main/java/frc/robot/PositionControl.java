
/*
 Control the position of a Rev Robotics motor using the Spark Max motor controller.
*/
package frc.robot;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class PositionControl {
    SparkMax m_motor;
    SparkClosedLoopController m_positionControl;
    RelativeEncoder m_encoder;
    SparkMaxConfig m_config;
    private final double kP = 0.1;
    private final double kI = 0.0;
    private final double kD = 0.0;
    private final double kMaxOutput = 1.0;
    private final double kMinOutput = -1.0;

    PositionControl(int deviceId){
        m_motor = new SparkMax(deviceId, SparkMax.MotorType.kBrushless);
        m_encoder = m_motor.getEncoder();
        m_positionControl = m_motor.getClosedLoopController();

        m_config = new SparkMaxConfig();

        m_config.closedLoop.p(kP);
        m_config.closedLoop.i(kI);
        m_config.closedLoop.d(kD);
        m_config.closedLoop.outputRange(kMinOutput, kMaxOutput);

        m_motor.configure(m_config,com.revrobotics.ResetMode.kResetSafeParameters,com.revrobotics.PersistMode.kPersistParameters);
        m_motor.configure(m_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        m_encoder.setPosition(0.0);
    }

    public double positionCommand(double command){
        m_positionControl.setSetpoint(command,ControlType.kMAXMotionPositionControl);

        return(m_encoder.getPosition());
    }
}
 
