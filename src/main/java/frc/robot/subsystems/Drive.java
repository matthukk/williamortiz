package frc.robot.subsystems;


import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;

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
	public Drive() {
		SparkMax leftFront = new SparkMax(leftForwardMotorChannel, brushedType);
		SparkMax leftRear = new SparkMax(leftRearMotorChannel, brushedType);
		SparkMax rightFront = new SparkMax(rightForwardMotorChannel, brushedType);
		SparkMax rightRear = new SparkMax(rightRearMotorChannel, brushedType);

		SparkMaxConfig leftFrontConfig = new SparkMaxConfig();
		SparkMaxConfig leftRearConfig = new SparkMaxConfig();
		SparkMaxConfig rightFrontConfig = new SparkMaxConfig();
		SparkMaxConfig rightRearConfig = new SparkMaxConfig();

		leftFrontConfig
				.smartCurrentLimit(maxCurrent);

		leftRearConfig
				.smartCurrentLimit(maxCurrent)
				.follow(leftFront);

		rightFrontConfig
				.smartCurrentLimit(maxCurrent)
				.inverted(true);

		rightFrontConfig
				.smartCurrentLimit(maxCurrent)
				.follow(rightFront);

		leftFront.configure(leftFrontConfig, noReset, persist);
		leftRear.configure(leftRearConfig, noReset, persist);
		rightFront.configure(rightFrontConfig, noReset, persist);
		rightRear.configure(rightRearConfig, noReset, persist);

		drivetrain = new DifferentialDrive(leftFront, rightFront);

	}

	public void arcadeDrive(double speed, double rotation) {
		drivetrain.arcadeDrive(speed, rotation);
	}

	@Override
	public void periodic(){

	}
}

