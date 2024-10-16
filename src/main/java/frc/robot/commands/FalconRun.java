package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Falcon;

public class FalconRun extends InstantCommand {
    private final Falcon m_falcon;
    private final double m_rpm;

    public FalconRun(double rpm) {
        m_rpm = rpm;

        m_falcon = Falcon.getInstance();
        addRequirements(m_falcon);
    }

    @Override
    public void initialize(){
        m_falcon.setTargetVelocityRPM(m_rpm);
    }
}
