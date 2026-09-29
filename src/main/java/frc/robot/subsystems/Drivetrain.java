package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
    private final WPI_VictorSPX leftFront = new WPI_VictorSPX(DriveConstants.leftFrontCanId);
    private final VictorSPX leftRear = new VictorSPX(DriveConstants.leftRearCanId);

    private final WPI_VictorSPX rightFront = new WPI_VictorSPX(DriveConstants.rightFrontCanId);
    private final VictorSPX rightRear = new VictorSPX(DriveConstants.rightRearCanId);

    private final DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);

    public Drivetrain() {
        leftFront.setInverted(DriveConstants.leftInverted);
        rightFront.setInverted(DriveConstants.rightInverted);

        leftRear.follow(leftFront);
        rightRear.follow(rightFront);

        leftRear.setInverted(InvertType.FollowMaster);
        rightRear.setInverted(InvertType.FollowMaster);

        drive.setDeadband(DriveConstants.deadband);
        drive.setMaxOutput(DriveConstants.maxOutput);

        drive.setSafetyEnabled(true);
        drive.stopMotor();
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void arcadeDrive(double forwardSpeed, double rotation) {
        drive.arcadeDrive(forwardSpeed, rotation);
    }
}
