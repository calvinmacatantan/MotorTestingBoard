package frc.robot.subsystems;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;

public class ColorSensor extends SubsystemBase{
    public final ColorSensorV3 testSensor = new ColorSensorV3(I2C.Port.kOnboard);

    public void colorOutput() {
        double totalNumber = testSensor.getRed() + testSensor.getBlue() + testSensor.getGreen();
        SmartDashboard.putNumber("Red", testSensor.getRed()*255 / totalNumber);
        SmartDashboard.putNumber("Blue", testSensor.getBlue()*255 / totalNumber);
        SmartDashboard.putNumber("Green", testSensor.getGreen()*255 / totalNumber);
        SmartDashboard.putString("Color", testSensor.getColor().toString());
        SmartDashboard.putNumber("Proximity", testSensor.getProximity());
    }

    @Override
    public void periodic() {
        colorOutput();
        SmartDashboard.updateValues();
    }
}