package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Intake;

public class IntakeBall extends Command{
    private final double m_percentOutput;
    private final Intake m_falcon;

    public IntakeBall(double percentOutput) {
        m_percentOutput = -percentOutput;

        m_falcon = Intake.getInstance();
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
