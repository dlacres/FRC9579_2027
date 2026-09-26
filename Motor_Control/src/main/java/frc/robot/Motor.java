package frc.robot;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;

public class Motor {
    SparkMax m_motor;
    RelativeEncoder m_encoder;

    public Motor(int id) {
        m_motor = new SparkMax(id, SparkMax.MotorType.kBrushless);
        m_encoder = m_motor.getEncoder();
    }

    double command(double speed) {
        m_motor.set(speed);

        m_encoder = m_motor.getEncoder();
        return m_encoder.getPosition();
    }
}