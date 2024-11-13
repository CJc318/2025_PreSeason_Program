package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class ShootBall extends Command {
    private final double m_percentOutput;
    private final Shooter m_falcon;

    public ShootBall(double percentOutput) {
        m_percentOutput = percentOutput;

        m_falcon = Shooter.getInstance();
        addRequirements(m_falcon);
    }

    @Override
    public void initialize() {
        m_falcon.setPercentOutput(m_percentOutput);
    }

    public boolean isFinished() {
        return true;
    }
}
