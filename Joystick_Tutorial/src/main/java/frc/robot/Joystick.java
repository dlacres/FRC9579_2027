package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;

public class Joystick {
   XboxController m_xboxController;
   SlewRateLimiter m_rateLimitLtStick;

   public Joystick(int port){
         m_xboxController = new XboxController(port);
         m_rateLimitLtStick = new SlewRateLimiter(6);
   }
   double ltStick() {
      double ltStick = m_rateLimitLtStick.calculate(m_xboxController.getLeftY());
      return(ltStick);
   }
   boolean xButton() {
      return(m_xboxController.getXButton());
   }
   String buttonSelectedString() {
      if (m_xboxController.getXButton()){
         return ("X Button");
      } else if (m_xboxController.getYButton()){
         return ("Y Button");
      } 
      return("No Button");
   }

   String buttonState="state_1";
   String returnString="";

   String buttonStateString(){

      switch (buttonState){
         case "state_1":
            returnString = "X Button State_1";
            if (m_xboxController.getXButtonReleased()){
               buttonState = "state_2";
            }
            break;
         case "state_2":
            returnString = "X Button State_2";
            if (m_xboxController.getXButtonReleased()){
               buttonState = "state_1";
            }
            break;
       }
       return(buttonState);

   }
}
