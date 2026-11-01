package frc.robot;

public class Lime_light {

    public Lime_light() {
    }

    public static boolean hasTarget() {
        boolean tv = LimelightHelpers.getTV("");
        return tv;
    }

    public static double getX() {
        double tx = LimelightHelpers.getTX("");
        return tx;
    }

    public static double getY() {
        double ty = LimelightHelpers.getTY("");
        return ty;
    }

    public static double getArea() {
        double ta = LimelightHelpers.getTA("");
        return ta;
    }
}
