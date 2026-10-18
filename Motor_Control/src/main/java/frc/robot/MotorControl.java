/*
 * The package statement declares that the current Java file belongs to the main frc.robot namespace and is stored 
 * inside the src/main/java/frc/robot/ folder path of an FIRST Robotics Competition (FRC) project. 
 */
package frc.robot;

/* 
 * Import acts as a shorthand that allows you to refer to classes by their simple names instead of their fully qualified names.
 */
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;

public class MotorControl {


    //SparkMax declare a variable called m_motor of type SparkMax. In this case SparkMax is a class the is imported above.
    SparkMax m_motor;

    // Declare a variable called m_encoder of type RelativeEncoder. This will be used later to get the motor position.
    // Note: Relative Encoder is a class that was created by Rev Robotics
    RelativeEncoder m_encoder;

    /* 
     * This is a constructor that is called when a class is instantiated. We will do this in the Robot.java next.
     * Int id is passed into the MotorControl class when it is instantiated. The variable "id" is the motor controller number
    */
    public MotorControl(int id) {

        /*
         * Create a new instance of SparkMax and store it in the variable m_motor. The creator for SparkMax
         * needs to know the id and the type of motor.
         */
        m_motor = new SparkMax(id, SparkMax.MotorType.kBrushless);

        // Call SparkMax's getEncoder method to get a handle to the encoder for use in calling encoder methods.
        m_encoder = m_motor.getEncoder();
    }
    /*
     * a method that reads in the desired motor speed and sets the motor speed. The command method also returns the motor position as a double type.
     */
    void command(double speed) {
        // Set the speed of the motor
        m_motor.set(speed);
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