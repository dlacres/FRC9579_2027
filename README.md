## This is a repo for the 2026 to 2027 season of First Robotics Challange.
## FRC Team 9579 - Tech Devils 9579 🤖🔥

Welcome to the official repository of FRC Team 9579, the Tech Devils! We are a FIRST Robotics Competition team dedicated to fostering innovation, collaboration, and STEM skills through competitive robotics. This repository serves as our central hub for software development and technical documentation.🚀 

## About Tech Devils 9579

The Tech Devils bring together students, mentors, and community members to design, build, and program high-performing robots. Our team operates like a real-world engineering firm, split into specialized sub-teams including mechanical design, software engineering, electrical, and business.💻 

## Robot Programming (Java)

We program our robots using Java alongside the WPILib (WPILibSuite) framework, which is the standard software library for the FIRST Robotics Competition.

Prerequisites & Tools
 * JDK 17 or higher (managed automatically via the WPILib Installer)
 * VS Code (WPILib edition)
 * NI FRC Game Tools (for the Driver Station)
 
## Getting Started with the Code

 # Clone the repository:
 bashgit clone https://github.com
Use code with caution.

 # Open in VS Code: Open the cloned folder using the WPILib-specific version of VS Code.
 # Build the code: Press Ctrl+Shift+P (or Cmd+Shift+P on Mac), type WPILib: Build Robot Code, and hit Enter.
 # Deploy to the RoboRIO: Connect to the robot via Wi-Fi or USB-B, open the WPILib command palette, and select WPILib: Deploy Robot Code.
 
 ## Our Software Architecture
 We follow the Time-Based Programming paradigm. This structural pattern separates robot hardware behavior into two main categories:Subsystems: Represent separate structural components of the robot (e.g., Drivetrain, Intake, Climber). They encapsulate the hardware (motors, sensors) and basic movement methods.Commands: Represent state machines or actions that orchestrate one or more subsystems (e.g., DriveWithJoysticks, IntakeCargo, ScoreGoal).📐 

The time-based paradigm in WPILib Java centers on the TimedRobot class, which serves as the most straightforward, structural design pattern for programming a FIRST Robotics Competition (FRC) robot. Unlike the complex, declarative abstraction of a Command-Based framework, the time-based framework relies on a predictable, imperative loop that runs sequentially.Core Philosophy: The Iterative LoopAt its heart, the time-based paradigm works like a giant while(true) loop managed behind the scenes by the hardware.The 20-Millisecond Tick: By default, the WPILib engine triggers a periodic update exactly every 20 milliseconds (50 Hz).State Interrogation: Every 20ms, your robot checks the current state of sensors and joysticks, runs them through user-defined logic conditional blocks (if/else), and updates motor outputs accordingly.Key Structure of a TimedRobot ProjectWhen using this framework, your code lives primarily inside Robot.java. WPILib breaks the robot's operation down by its match phases. Each phase features an Init method (runs exactly once when transitioning into the phase) and a Periodic method (loops every 20ms):robotInit() & robotPeriodic()robotInit() initializes hardware (e.g., motor controllers, gyro sensors).robotPeriodic() runs consistently across all phases, making it ideal for diagnostics, smart dashboard updates, or sensor logging.autonomousInit() & autonomousPeriodic()Code in autonomousPeriodic() handles the robot's pre-programmed actions during the first 15 seconds of a match.teleopInit() & teleopPeriodic()Loops inside teleopPeriodic() process human operator inputs from joysticks and controllers in real-time.disabledInit() & disabledPeriodic()Code executed while the robot is disabled (often used to reset sensors or choose autonomous paths).Managing Time & Action SequencingBecause everything executes in a flat, iterative manner, performing sequential actions (e.g., “drive forward for 3 seconds, then spin a shooter wheel for 2 seconds”) requires tracking state over time manually. Developers achieve this using two main approaches:1. WPILib Timer ClassTeams instantiate a edu.wpi.first.wpilibj.Timer object. In autonomousInit(), the timer is started (timer.start()). In autonomousPeriodic(), code checks how much time has passed:javaif (timer.get() < 3.0) {
    drivetrain.arcadeDrive(0.5, 00); // Drive forward at 50% speed for 3 seconds
} else if (timer.get() < 5.0) {
    drivetrain.stopMotor();
    shooter.set(0.75); // Turn on shooter for the next 2 seconds
} else {
    shooter.stopMotor();
}
Use code with caution.2. Loop CountingBecause the loop executes precisely every 20ms, teams can count loop iterations to track time. For example, 50 loops equal exactly 1 second of real-world time.3. Custom Frequencies (addPeriodic)If you need specific tasks—like a PID control loop—to run faster than the standard 20ms, the TimedRobot class offers an addPeriodic() method. This executes a custom callback synchronously at a specialized time period (e.g., every 5ms) without risking multithreading issues.



 
## Robot Design & CAD (Onshape)

We design our robots entirely in 3D using Onshape, a cloud-based Computer-Aided Design (CAD) platform. This allows our mechanical team to collaborate simultaneously from any device without worrying about file version conflicts.Our CAD WorkflowTop-Down Design: We start each season with a strategic geometry sketch (or master sketch) to establish robot limits, perimeter constraints, and critical mechanism pivot points.Featurescript: We extensively leverage community FRC Featurescripts (like Julia's FRC Video/Chain Generator, Shaft Generator, and Tube Converter) to accelerate our design workflow.Part Studios & Assemblies: Individual components are modeled inside context-specific Part Studios and later brought together in a main Robot Assembly to check for clearance and fit.How to Access Our ModelsSince Onshape is browser-based, you do not need to download massive files to view our robot designs:Ask a design lead for the shared Onshape Document Link.Create a free Onshape Education Account using your student email.Open the document link to view the live 3D models, export STLs for 3D printing, or create DXF drawings for laser/CNC cutting.🤝 ContributingWe encourage all team members to contribute! Please follow these basic guidelines:Branching: Never push directly to main. Create a descriptive feature branch (e.g., feature/swerve-drive or fix/intake-limit-switch).Pull Requests: Submit a Pull Request (PR) to merge your branch back into main. Ensure your code builds locally and passes all linting tests before requesting a review.Document Your Work: Keep your code well-commented and document your mechanical assemblies inside the design folders.Would you like me to add specific sections to this README, such as a yearly competition history, team roster, or a technical breakdown of your robot's drivetrain?
