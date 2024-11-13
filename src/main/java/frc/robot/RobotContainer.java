// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FalconRun;
import frc.robot.commands.ShootBall;
import frc.robot.commands.Falconv3;
import frc.robot.commands.IntakeBall;
import frc.robot.subsystems.ExampleSubsystem;
import io.github.oblarg.oblog.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final CommandXboxController m_controller = new CommandXboxController(1);


  public RobotContainer() {
    Logger.configureLoggingAndConfig(this, false);

    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // m_controller.a().onTrue(new FalconRun(600.00));
    // m_controller.a().onFalse(new FalconRun(0.0));

    m_controller.b().onTrue(new ShootBall(50.0));
    m_controller.b().onFalse(new ShootBall(0.0));

    // m_controller.x().onTrue(new ShootBall(80.0));
    // m_controller.x().onFalse(new ShootBall(0.0));

    // m_controller.a().onTrue(new ShootBall(30.0));
    // m_controller.a().onFalse(new ShootBall(0.0));

    // // m_controller.x().onTrue(new Falconv3());

    m_controller.a().onTrue(new IntakeBall(10.0).andThen(new ShootBall(10.0)));
    m_controller.a().onFalse(new IntakeBall(0.0).andThen(new ShootBall(0.0)));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *[\]
   [\]

   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
