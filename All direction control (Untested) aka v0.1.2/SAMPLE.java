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
    boolean a;
    boolean b;
    boolean x;
    boolean y;
    boolean motor1On = false;
    boolean motor2On = false;
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
            if (a && motor1On == false) {
                motor1.setPower(1.00);
                motor1On = true;
            }
            if (b && motor2On == false) {
                motor2.setPower(-1.00);
                motor2On = true;
            } // a == right
            if (x && motor1On == false) {
                motor1.setPower(-1.00);
                motor1On = true;
            }
            if (y && motor2On == false) {
                motor2.setPower(1.00);
                motor2On = true;
            }
            if (a && motor1On || x && motor1On) {
                motor1.setPower(0.00);
                motor1On = false;
            }
            if (b && motor2On || y && motor2On) {
                motor2.setPower(0.00);
                motor2On = false;
            }
        }
        motor1.setPower(0.00);
        motor2.setPower(0.00);
    }
}