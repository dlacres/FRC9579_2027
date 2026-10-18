package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;

public class Joystick {
   XboxController m_xboxController;
   private SlewRateLimiter m_rateLimitForward;
   private SlewRateLimiter m_rateLimitTurn;

   public Joystick(double rateLimit){
      m_xboxController = new XboxController(0);
      m_rateLimitForward = new SlewRateLimiter(rateLimit);
      m_rateLimitTurn = new SlewRateLimiter(rateLimit);
   }
   double forward() {
      double jsCmd = m_xboxController.getLeftY()/2.0;
      double forwardCmd = m_rateLimitForward.calculate(jsCmd);
      return(forwardCmd);
   }
   double turn() {
      double jsCmd = m_xboxController.getLeftX()/2.0;
      double turnCmd = m_rateLimitTurn.calculate(jsCmd);
      return(turnCmd);
   }
}
