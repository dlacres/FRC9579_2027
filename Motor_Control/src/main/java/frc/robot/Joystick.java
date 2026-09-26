package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class Joystick {
     XboxController m_xboxController;

     public Joystick(int port){
          m_xboxController = new XboxController(port);
     }
     double command() {
        return(m_xboxController.getLeftY()/2.0);
     }
}
