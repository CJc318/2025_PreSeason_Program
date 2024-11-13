// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// import frc.robot.commands.FalconRun;
// import frc.robot.commands.FalconRunPercentOutput;
// import frc.robot.commands.Falconv3;
// import frc.robot.commands.ShootBall;

// public class Controls extends SubsystemBase {
//     private static Controls instance = null;

//     private static final int CONTROLLER_PORT = 1;
//     private final CommandXboxController m_Controller;

//     public static Controls getInstance() {
//         if (instance == null) {
//             instance = new Controls();
//         }
//         return instance;
//     }

//     private Controls() {
//         m_Controller = new CommandXboxController(CONTROLLER_PORT);
//         configControllerBindings();
//     }

//     private void configControllerBindings() {
//         m_Controller.b().onTrue(new FalconRun(4000.00));
//         m_Controller.b().onFalse(new FalconRun(0.00));

//         m_Controller.x().onTrue(new FalconRunPercentOutput(60));
//         m_Controller.x().onFalse(new FalconRunPercentOutput(0.0));

//         m_Controller.a().onTrue(new ShootBall());

//         m_Controller.y().onTrue(new Falconv3());

        


//     }


// }
