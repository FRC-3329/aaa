package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
    private final Drivetrain drivetrain = new Drivetrain();
    private final CommandXboxController controller = new CommandXboxController(OperatorConstants.driverControllerPort);

    public RobotContainer() {
        drivetrain.setDefaultCommand(drivetrain.run(this::driveFromController));
    }

    private void driveFromController() {
        if (DriverStation.isTeleopEnabled()) {
            drivetrain.tankDrive(-controller.getLeftY(), -controller.getRightY());
        } else {
            drivetrain.tankDrive(0.0, 0.0);
        }
    }

    public Command getAutonomousCommand() {
        return Commands.none();
    }
}
