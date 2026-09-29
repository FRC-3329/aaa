package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
    private static final String arcadeDriveKey = "Arcade Drive";

    private final Drivetrain drivetrain = new Drivetrain();
    private final CommandXboxController controller = new CommandXboxController(OperatorConstants.driverControllerPort);

    public RobotContainer() {
        SmartDashboard.setDefaultBoolean(arcadeDriveKey, false);
        drivetrain.setDefaultCommand(drivetrain.run(this::driveFromController));
    }

    private void driveFromController() {
        if (DriverStation.isTeleopEnabled()) {
            if (SmartDashboard.getBoolean(arcadeDriveKey, false)) {
                drivetrain.arcadeDrive(-controller.getLeftY(), -controller.getRightX());
            } else {
                drivetrain.tankDrive(-controller.getLeftY(), -controller.getRightY());
            }
        } else {
            drivetrain.tankDrive(0.0, 0.0);
        }
    }

    public Command getAutonomousCommand() {
        return Commands.none();
    }
}
