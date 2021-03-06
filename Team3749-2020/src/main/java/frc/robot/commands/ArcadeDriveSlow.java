package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeDriveSlow extends CommandBase {
    private final Drivetrain m_drive;

    /**
     * 
     * @param drive
     */
    public ArcadeDriveSlow(Drivetrain drive) {
        m_drive = drive;
    }

    @Override
    public void initialize() {
      m_drive.setMaxOutput(Robot.getConstants().kSlowDriveSpeed);
    }
  
    @Override
    public void end(boolean interrupted) {
      m_drive.setMaxOutput(1);
    }
}