package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="Driving in all directions")
public class SAMPLE extends LinearOpMode {
    // Variable creations
    double x;
    double y;
    //Variable Name Declarations
    DcMotor motor1;
    DcMotor motor2;
    @Override

    public void runOpMode() throws InterruptedException {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        waitForStart();
        while (opModeIsActive()) {
            x = gamepad1.left_stick_y;
            y = gamepad1.right_stick_x;
            motor1.setPower(x - (0.5 * y));
            motor2.setPower(-x - (0.5 * y));

        }
        motor1.setPower(0.00);
        motor2.setPower(0.00);
    }
}