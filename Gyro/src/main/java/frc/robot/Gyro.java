package frc.robot;

//import com.studica.frc.Navx;
import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;

public class Gyro {

    private final AHRS m_gyro; 

    public Gyro() {
        m_gyro = new AHRS(NavXComType.kMXP_SPI);   
        
        // Zero the gyro heading during initialization
        m_gyro.zeroYaw();
    }

    public void reset() {
        m_gyro.zeroYaw();
    }

    /**
     * Returns the total accumulated angle of the robot.
     * Note: This does not wrap at 360 degrees.
     */
    public double getYawRate() {
        
        return m_gyro.getRate();
    }

    /**
     * Returns the current heading wrapped to [-180, 180] degrees.
     */
    public double getYaw() {
        return m_gyro.getYaw();
    }
}
