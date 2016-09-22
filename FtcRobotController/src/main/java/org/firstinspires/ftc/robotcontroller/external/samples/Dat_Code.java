package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.RobotLog;

/**
 * Created by Braden on 9/19/2016.
 */
@TeleOp(name="Dat_Code", group="Pushbot")
@Disabled


public class Dat_Code extends LinearOpMode {

    hardware_epic robot           = new hardware_epic();
    @Override


    public void runOpMode() throws InterruptedException {
        double FrontLeft;
        double FrontRight;
        double BackLeft;
        double BackRight;
        double max;
        double limit;

        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            FrontLeft = ((gamepad1.left_stick_y/4) - (gamepad1.left_stick_x/4)) - (gamepad1.right_stick_x/4);
            FrontRight = ((gamepad1.left_stick_y/4) + (gamepad1.left_stick_x/4)) + (gamepad1.right_stick_x/4);
            BackLeft = ((gamepad1.left_stick_y/4) + (gamepad1.left_stick_x/4)) - (gamepad1.right_stick_x/4);
            BackRight = ((gamepad1.left_stick_y/4) - (gamepad1.left_stick_x/4)) + (gamepad1.right_stick_x/4);

            if (gamepad1.right_stick_x < 15) {
                FrontLeft = FrontLeft * 2;
                FrontRight = FrontRight * 2;
                BackLeft = BackLeft * 2;
                BackRight = BackRight * 2;
            }

            if (gamepad1.left_stick_x >.999) {
                gamepad1.left_stick_x = 1;
            }

            if (gamepad1.left_stick_y >.999) {
                gamepad1.left_stick_y = 1;
            }

            if (gamepad1.right_stick_x >.999) {
                gamepad1.right_stick_x = 1;
            }
            ;
            //Normalize the values so neither exceed +/- 1.0
            /*max = Math.max(Math.abs(FrontLeft), Math.abs(FrontRight));
            limit = Math.limit(Math.abs(BackLeft), Math.abs(BackRight));

            if (max > 1.0) {
                FrontLeft /= max;
                FrontRight /= max;
            }

            if (limit > 1.0){
                BackLeft /= max;
                BackRight /= max;
            }
            */

            if(gamepad1.y)
                robot.RightBackMotor.setPower(1);

            if(gamepad1.x)
                robot.RightFrontMotor.setPower(1);

            if(gamepad1.a)
                robot.LeftBackMotor.setPower(1);

            if(gamepad1.b)
                robot.LeftFrontMotor.setPower(1);


            robot.LeftFrontMotor.setPower(-FrontLeft);
            robot.LeftBackMotor.setPower(-BackLeft);
            robot.RightBackMotor.setPower(BackRight);
            robot.RightFrontMotor.setPower(FrontRight);



        }
        }

    }

