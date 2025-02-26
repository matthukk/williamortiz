package frc.robot.subsystems;


import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import static frc.robot.Constants.DriveConstants.*;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.config.SparkMaxConfig;


public class Drive extends SubsystemBase {


	private final static Drive INSTANCE = new Drive();

	DifferentialDrive drivetrain;

	@SuppressWarnings("WeakerAccess")
	public static Drive getInstance() {
		return INSTANCE;
	}

	/**
	 * Creates a new instance of this Drive. This constructor
	 * is private since this class is a Singleton. Code should use
	 * the {@link #getInstance()} method to get the singleton instance.
	 */
	private Drive() {
		SparkMax leftFront = new SparkMax(leftForwardMotorChannel, brushedType);



	}
}

