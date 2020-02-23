/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class TargetAdjustment extends CommandBase {
    private final Drivetrain m_drive;
    private final Vision m_vision

    /**
     * @param subsystem
     */
    public TargetAdjustment(Drivetrain subsystem1, Vision subsystem2) {
           m_drive = subsystem1;
           m_vision = subsystem2;
    }

    //Gets the current x value from the Pixy2 table
   public double getx() {
       return m_vision.getx();
    }

    //Gets the current distance value from the Pixy2 table
    public double getdistance() {
        return m_vision.getdistance();
     }

     // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
       double error = getx()-1;
       while(getx() != -1) {
           m_drive.arcadeDrive(0, 0.3 * error);
        }
        while (getdistance() >= 10) {
            m_drive.arcadeDrive(0.3, 0);
        }
    }

}