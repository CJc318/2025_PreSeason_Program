package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class SetShooterPercentoutput extends Command {
    private final Shooter m_shooter;
    private double m_percentOutput;

    public SetShooterPercentoutput(double percentOutput) {
        m_shooter = Shooter.getInstance();
            addRequirements(m_shooter);

        m_percentOutput = percentOutput;
    }

    @Override
    public void initialize() {
        m_shooter.setPercentOutput(m_percentOutput);
    }

    public boolean isFinished() {
        return true;
    }
}
