package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {
    private static Feeder instance = null;
    private static final double FALCON_500_MAX_SPEED_RPS = 6380/60;

    private TalonFX m_motor;

    private Feeder() {
        m_motor = new TalonFX(20);
    }

    public void setPercentOutput(double percentOutput) {
        m_motor.setControl(new DutyCycleOut(percentOutput));
    }

    public void setTargetVelocityRPM(double rpm) {
        double rps = rpm/60;
    }

    public static Feeder getInstance() {
        if (instance == null) {
            instance = new Feeder();
        }
        return instance;
    }
}
