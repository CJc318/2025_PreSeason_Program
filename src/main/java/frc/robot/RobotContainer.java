// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SetFeederPercentoutput;
import frc.robot.commands.SetShooterPercentoutput;
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

  private final CommandXboxController m_controller = 
    new CommandXboxController(1);

  public RobotContainer() {
    Logger.configureLoggingAndConfig(this, false);

    configureBindings();
  }


  private void configureBindings() {
    m_controller.a().onTrue(new SetFeederPercentoutput(10.0).andThen(new SetShooterPercentoutput(10.0)));
    m_controller.a().onFalse(new SetFeederPercentoutput(0.0).andThen(new SetShooterPercentoutput(0.0)));
  }


  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonom
  // }
}
