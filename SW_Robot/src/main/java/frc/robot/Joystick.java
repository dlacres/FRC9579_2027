package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class Joystick {
     XboxController m_xboxController;

     public Joystick(){
          m_xboxController = new XboxController(0);
     }
     double forward() {
        return(m_xboxController.getLeftY()/2.0);
     }
     double turn() {
        return(-m_xboxController.getLeftX()/2.0);
     }
}
