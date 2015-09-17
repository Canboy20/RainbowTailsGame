package com.rainbowtails.canatay.rainbowtails;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

/**
 * Created by Can Atay on 6/8/2015.
 */
public class PlayerPaintedWalls {


    private Rect PaintedWallRect[];
    private RectF PaintedWallPaintValues[];
    private String PaintedWallColor[];
    int numberOfWallsPainted;


    public PlayerPaintedWalls() {


        numberOfWallsPainted = 0;
        PaintedWallRect = new Rect[30];
        PaintedWallPaintValues = new RectF[30];
        PaintedWallColor = new String[30];


/*
        for (int i = 0; i < 30; i++) {
            PaintedWallRect[i] = new RectF(0, 0, 0, 0 );

        }


        for (int i = 0; i < 30; i++) {
            PaintedWallColor[i] = new String("");

        }*/

    }


    public void resetAllPaintedWalls() {


        for (int i = 0; i < numberOfWallsPainted; i++) {

            PaintedWallRect[i].left = 0;
            PaintedWallRect[i].top = 0;
            PaintedWallRect[i].right = 0;
            PaintedWallRect[i].bottom = 0;


            PaintedWallPaintValues[i].left = 0;
            PaintedWallPaintValues[i].top = 0;
            PaintedWallPaintValues[i].right = 0;
            PaintedWallPaintValues[i].bottom = 0;

            PaintedWallColor[i] = "empty";


        }
        numberOfWallsPainted = 0;


    }


    public RectF paintWall(int currentWall) {

        return PaintedWallPaintValues[currentWall];
    }


    public Rect rectOfWall(int currentWall) {

        return PaintedWallRect[currentWall];
    }



    public int getNumberOfWallsPainted() {

        return numberOfWallsPainted;

    }


    public void updateNumberOfWallsPainted() {

        numberOfWallsPainted++;

    }
    public void resetNumberOfWallsPainted(){
        numberOfWallsPainted=0;
    }


    public String getColor(int currentWall) {

        return PaintedWallColor[currentWall];
    }


    public void createPlayerPaintedWall(float beginCoordinateX, float beginCoordinateY, float endCoordinateX, float endCoordinateY, String color,RainbowTails rainbowTailsObj) {

        float left = beginCoordinateX;
        float top = beginCoordinateY;
        float right = endCoordinateX;
        float bottom = endCoordinateY;
        float xLeft, yTop, xRight, yBottom;


        if (left == right) {
            xLeft = beginCoordinateX;
            xRight = endCoordinateX;


        } else if (left < right) {
            xLeft = beginCoordinateX;
            xRight = endCoordinateX;

        } else {
            xLeft = endCoordinateX;
            xRight = beginCoordinateX;

        }


        if (top == bottom) {
            yTop = beginCoordinateY;
            yBottom = endCoordinateY;

        } else if (top < bottom) {
            yTop = beginCoordinateY;
            yBottom = endCoordinateY;

        } else {

            yTop = endCoordinateY;
            yBottom = beginCoordinateY;
        }



        String type;
        if ((int) (Math.abs(xRight - xLeft)) >= (int) (Math.abs(yBottom - yTop))) {

            type = "Hori";
            endCoordinateY = beginCoordinateY;
            PaintedWallRect[numberOfWallsPainted] = new Rect((int) xLeft, (int) beginCoordinateY, (int) xRight, (int) beginCoordinateY + (int) (11f * (MainActivity.ScaleHeight)) );


        } else {
            type = "Vert";

            endCoordinateX = beginCoordinateX;
            PaintedWallRect[numberOfWallsPainted] = new Rect((int)beginCoordinateX, (int) yTop, (int) beginCoordinateX + (int) (11f * (MainActivity.ScaleWidth)), (int) yBottom);


        }







/*
        String type;
        if ((int) (Math.abs(xRight - xLeft)) >= (int) (Math.abs(yBottom - yTop))) {

            type = "Hori";
            endCoordinateY = beginCoordinateY;
            PaintedWallRect[numberOfWallsPainted] = new Rect((int) xLeft, (int) yTop, (int) xRight, (int) yTop + (int) (9f * (MainActivity.ScaleHeight)) / 2);


        } else {
            type = "Vert";
            endCoordinateX = beginCoordinateX;
            PaintedWallRect[numberOfWallsPainted] = new Rect((int) xLeft, (int) yTop, (int) xLeft + (int) (9f * (MainActivity.ScaleHeight) / 2), (int) yBottom);


        }*/


        PaintedWallPaintValues[numberOfWallsPainted] = new RectF(beginCoordinateX, beginCoordinateY, endCoordinateX, endCoordinateY);


        //PaintedWallRect[numberOfWallsPainted] = new Rect((int) xLeft, (int) yTop, (int) xRight, (int) yBottom);
        PaintedWallColor[numberOfWallsPainted] = new String(color);


        if(PaintedWallPaintValues[numberOfWallsPainted].intersect(rainbowTailsObj.getRectOfRainbowTails())){


            if(color.equals("yellow")){

                numberOfWallsPainted++;

            }else {
                //No wall is made if painted over our here

            }



        }else {

            numberOfWallsPainted++;

        }

    }



   public void deleteYellowWall(int yellowWallDeleted){


        for(int i=yellowWallDeleted;i<numberOfWallsPainted;i++){

            PaintedWallRect[i]=PaintedWallRect[i+1];
            PaintedWallPaintValues[i]=PaintedWallPaintValues[i+1];
            PaintedWallColor[i]=PaintedWallColor[i+1];

        }

        numberOfWallsPainted--;

    }




    public void deleteBumpedWall(int WallBumped){


        for(int i=WallBumped;i<numberOfWallsPainted;i++){

            if(numberOfWallsPainted!=30) {
                PaintedWallRect[i] = PaintedWallRect[i + 1];
                PaintedWallPaintValues[i] = PaintedWallPaintValues[i + 1];
                PaintedWallColor[i] = PaintedWallColor[i + 1];
            }else{

            }

        }

        numberOfWallsPainted--;
    }


/*
    public void checkCollisionFireBallWithPlayerPaintedWalls(FireBall fireBallObj) {


        for (int i = 0; i < numberOfWallsPainted; i++) {
            for (int k = 0; k < fireBallObj.getNumberOfFireballs(); k++) {


                float w = (float) (0.5 * (rectOfWall(i).width() + fireBallObj.getRectOfFireBall(k).width()));
                float h = (float) (0.5 * (rectOfWall(i).height() + fireBallObj.getRectOfFireBall(k).height()));
                float dx = rectOfWall(i).centerX() - fireBallObj.getRectOfFireBall(k).centerX();
                float dy = rectOfWall(i).centerY() - fireBallObj.getRectOfFireBall(k).centerY();

                if (Math.abs(dx) <= w && Math.abs(dy) <= h) {
                    float wy = w * dy;
                    float hx = h * dx;

                    if (wy > hx) {
                        if (wy > -hx) {

                            fireBallObj.updateSpeedY(-Math.abs(fireBallObj.getSpeedY(k)), k);




                        } else {
                            fireBallObj.updateSpeedX(Math.abs(fireBallObj.getSpeedX(k)), k);


                        }


                    } else {
                        if (wy > -hx) {

                            fireBallObj.updateSpeedX(-Math.abs(fireBallObj.getSpeedX(k)), k);

                        } else {
                            fireBallObj.updateSpeedY(Math.abs(fireBallObj.getSpeedY(k)), k);


                        }
                    }





                    if (getColor(i).equals("yellow")) {


                        //fireBallObj.respawnPosition(GameView.currentLevel, k);
                        //Assets.playSound(Assets.warpID);

                    }
                }


            }


        }
    }
*/


    public void checkCollisionFireBallWithPlayerPaintedWallls(FireBall fireBallObj) {


        for (int i = 0; i <getNumberOfWallsPainted(); i++) {
            for (int k = 0; k < fireBallObj.getNumberOfFireballs(); k++) {


                float w = (float) (0.5 * (rectOfWall(i).width() + fireBallObj.getRectOfFireBall(k).width()));
                float h = (float) (0.5 * (rectOfWall(i).height() + fireBallObj.getRectOfFireBall(k).height()));
                float dx = rectOfWall(i).centerX() - fireBallObj.getRectOfFireBall(k).centerX();
                float dy = rectOfWall(i).centerY() - fireBallObj.getRectOfFireBall(k).centerY();

                if (Math.abs(dx) <= w && Math.abs(dy) <= h) {
                    float wy = w * dy;
                    float hx = h * dx;

                    if (wy > hx) {
                        if (wy > -hx) {

                            fireBallObj.updateSpeedY(-Math.abs(fireBallObj.getSpeedY(k)), k);




                        } else {
                            fireBallObj.updateSpeedX(Math.abs(fireBallObj.getSpeedX(k)), k);


                        }




                    } else {
                        if (wy > -hx) {

                            fireBallObj.updateSpeedX(-Math.abs(fireBallObj.getSpeedX(k)), k);

                        } else {
                            fireBallObj.updateSpeedY(Math.abs(fireBallObj.getSpeedY(k)), k);


                        }
                    }





                    if (getColor(i).equals("yellow")) {


                        //fireBallObj.respawnPosition(GameView.currentLevel, k);
                        //Assets.playSound(Assets.warpID);

                    }else if(getColor(i).equals("blue")){

                        deleteBumpedWall(i);
                        k=fireBallObj.getNumberOfFireballs();

                    }
                }


            }


        }
    }


}