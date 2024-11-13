package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;

public class SetFeederPercentoutput extends Command{
    private final Feeder m_feeder;
    private double m_percentOutput;

    public SetFeederPercentoutput(double percentOutput) {
        m_feeder = Feeder.getInstance();
            addRequirements(m_feeder);

        m_percentOutput = percentOutput;
    }

    @Override
    public void initialize() {
        m_feeder.setPercentOutput(m_percentOutput);
    }

    public boolean isFinished() {
        return true;
    }
}
