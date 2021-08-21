package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="ClawControl w/ Driving")
public class ClawControl extends LinearOpMode {
    //Variables created before loop starts
    // Variable creations
    double x;
    double y;
    double p;
    boolean a;
    //Variable Name Declarations
    DcMotor motor1;
    DcMotor motor2;
    DcMotor arm_motor;
    CRServo servo;
    @Override
    public void runOpMode() throws InterruptedException {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        arm_motor = hardwareMap.dcMotor.get("arm_motor");
        servo = hardwareMap.get(CRServo.class, "servo");
        waitForStart();
        while (opModeIsActive()) {
            // Resetting values constantly
            x = gamepad1.left_stick_y;
            y = gamepad1.left_stick_x;
            p = gamepad2.left_stick_y;
            a = gamepad2.a;
            //Motor1 and 2 are being put at limited values, being reset constantly for analog controls.
            motor1.setPower(Range.clip(-x - (0.5 * y), -1.0, 1.0));
            motor2.setPower(Range.clip(x - (0.5 * y), -1.0, 1.0));
            //Arm motor being clipped just in case
            arm_motor.setPower(Range.clip((p/2), -0.5, 0.5));
            if (a){
                servo.setPower(1.00);
                wait(1);
                servo.setPower(0.00);
            }

        }
        // Making sure they are off
        motor1.setPower(0.00);
        motor2.setPower(0.00);
        arm_motor.setPower(0.00);
        servo.setPower(0.00);
    }
}
