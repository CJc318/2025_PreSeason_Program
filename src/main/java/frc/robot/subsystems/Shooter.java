package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private static Shooter instance = null;
    private static final double FALCON_500_MAX_SPEED_RPS = 6380/60;

    private final TalonFX m_motor;

    // private static final CurrentLimitsConfigs CURRENT_LIMITS_CONFIGS = new CurrentLimitsConfigs()
    //     .withSupplyCurrentLimit(60)
    //     .withSupplyTimeThreshold(0.5)
    //     .withSupplyCurrentThreshold(40)
    //     .withStatorCurrentLimit(80);

    // private static final Slot0Configs PID_GAINS = new Slot0Configs()
    //     .withKV(0.0)
    //     .withKP(0.0);

    private Shooter() {
        m_motor = new TalonFX(20);

        // setUpMotor(m_motor, InvertedValue.Clockwise_Positive);
    }

    // private void setUpMotor(TalonFX motor, InvertedValue invert) {
    //     motor.getConfigurator().apply(new TalonFXConfiguration());

    //     motor.getConfigurator().apply(CURRENT_LIMITS_CONFIGS);

    // }

    // private static final MotionMagicConfigs MOTION_MAGIC_CONFIGS = new MotionMagicConfigs()
    //     .withMotionMagicCruiseVelocity(FALCON_500_MAX_SPEED_RPS)
    //     .withMotionMagicAcceleration(FALCON_500_MAX_SPEED_RPS * 2.0);

    
    public void setPercentOutput(double percentOutput) {
        m_motor.setControl(new DutyCycleOut(percentOutput));
    }

    public void setTargetVelocityRPM(double rpm) {
        double rps = rpm/60;
        m_motor.setControl(new MotionMagicVelocityVoltage(rps));
    }

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }


}



