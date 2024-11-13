package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class FalconRun extends Command {
    private final Shooter m_falcon;
    private final double m_rpm;

    public FalconRun(double rpm) {
        m_rpm = rpm;

        m_falcon = Shooter.getInstance();
        addRequirements(m_falcon);
    }

    @Override
    public void initialize(){
        m_falcon.setTargetVelocityRPM(m_rpm);
    }
}
