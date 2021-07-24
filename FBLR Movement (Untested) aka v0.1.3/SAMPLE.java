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
            // Defines value of variables
            a = gamepad1.a;
            b = gamepad1.b;
            x = gamepad1.y;
            y = gamepad1.x;
            // A is to go backwards, so checks to see if off first before putting motors in reverse
            if (a && motor1On == false && motor2On == false) {
                motor1.setPower(-1.00);
                motor2.setPower(1.00);
                motor1On = true;
                motor2On = true;
            }
            // B is to go right, so checks to see if off first before putting one motor on
            else if (b && motor2On == false) {
                motor2.setPower(-1.00);
                motor2On = true;
            } 
            // X is to go forwards, so checks to see if off first before putting motors on
            else if (x && motor1On == false && motor2On == false) {
                motor1.setPower(1.00);
                motor2.setPower(-1.00);
                motor2On = true;
                motor1On = true;
            }
            // Y is left, turns a motor on
            else if (y && motor1On == false) {
                motor1.setPower(1.00);
                motor1On = true;
            }
            else if (a && motor1On || x && motor1On) {
                motor1.setPower(0.00);
                motor2.setPower(0.00);
                motor1On = false;
                motor2On = false;
            }
            else if (b && motor2On) {
                motor2.setPower(0.00);
                motor2On = false;
            }
            else if (y && motor1On){
                motor1.setPower(0.00);
                motor1On = false;
            }
        }
        motor1.setPower(0.00);
        motor2.setPower(0.00);
    }
}
