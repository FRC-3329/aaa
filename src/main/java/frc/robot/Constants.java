package frc.robot;

public final class Constants {
    // TODO
    public static final class DriveConstants {
        public static final int leftFrontCanId = 0;
        public static final int leftRearCanId = 0;

        public static final int rightFrontCanId = 0;
        public static final int rightRearCanId = 0;

        public static final boolean leftInverted = false;
        public static final boolean rightInverted = true;

        public static final double deadband = 0.08;
        public static final double maxOutput = 0.25;

        private DriveConstants() {
        }
    }

    public static final class OperatorConstants {
        public static final int driverControllerPort = 0;
    }

    private Constants() {
    }
}
