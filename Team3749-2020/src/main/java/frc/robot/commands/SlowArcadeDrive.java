package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SlowArcadeDrive extends CommandBase {
    private final Drivetrain m_drive;


    public SlowArcadeDrive(Drivetrain drive) {
        m_drive = drive;
    }

    @Override
    public void initialize() {
      m_drive.setMaxOutput(0.5);
    }
  
    @Override
    public void end(boolean interrupted) {
      m_drive.setMaxOutput(1);
    }
}