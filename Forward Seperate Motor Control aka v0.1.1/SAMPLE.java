package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="Remotely Controlled Spinning v2.0")
public class SAMPLE extends LinearOpMode {
    // Variable creations
    boolean a;
    boolean b;
    boolean x;
    boolean y;
    //Variable Name Declarations
    DcMotor motor1;
    DcMotor motor2;
    @Override

    public void runOpMode() throws InterruptedException {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        waitForStart();
        while (opModeIsActive()) {
            a = gamepad1.a;
            b = gamepad1.b;
            x = gamepad1.x;
            y = gamepad1.y;
            if (a) {
                motor1.setPower(1.00);
            }
            if (b) {
                motor2.setPower(-1.00);
            }
            if (x) {
                motor1.setPower(0.00);
            }
            if (y) {
                motor2.setPower(0.00);
            }
        }
        motor1.setPower(0.00);
        motor2.setPower(0.00);
    }
}