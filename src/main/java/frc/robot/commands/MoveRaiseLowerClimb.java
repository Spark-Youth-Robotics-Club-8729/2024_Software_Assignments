package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class MoveRaiseLowerClimb extends SequentialCommandGroup{
    //create constructors to give access to the subsystems
    public MoveRaiseLowerClimb(DriveSubsystem m_robotdrive, ClimbSubsystem m_robotclimb) {
        addCommands(
            new ParallelCommandGroup(
                new DriveForward(m_robotdrive, 0.05),
                new SequentialCommandGroup (
                    new ClimberSet(m_robotclimb, 0.05),
                    new WaitCommand(1),
                    new ClimberSet(m_robotclimb, -0.05)
                )
            )
        );
    }
}
