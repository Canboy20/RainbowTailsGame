package com.rainbowtails.canatay.rainbowtails;

import android.graphics.RectF;

/**
 * Created by Can Atay on 8/16/2015.
 */
public class SpikyWalls {

    private float x[], y[];
    private float speedX[], speedY[];
    private RectF spikyWallRect[];
    int numberOfSpikyWallsInLevel;
    char bumpable[];
    char typeOfSpikyWall[];
    float w,h,dx,dy,wy,hx;


    public SpikyWalls() {


        x = new float[30];
        y = new float[30];

        spikyWallRect = new RectF[30];
        speedX = new float[30];
        speedY = new float[30];

        bumpable=new char[30];
        typeOfSpikyWall=new char[30];

        for (int i = 0; i < 30; i++) {
            spikyWallRect[i] = new RectF(0, 0, 0 , 0 );
            bumpable[i]='n';
            typeOfSpikyWall[i]='n';


        }

        numberOfSpikyWallsInLevel = 0;

    }


    public void initializeSpikyDoubleWalls(int currentLevel) {


        if (currentLevel == 1) {

            numberOfSpikyWallsInLevel = 0;



        }else if(currentLevel==2) {

            x[0] = 0f;
            x[1] = (float) (MainActivity.ScreenWidth / 5);
            x[2] = (float) 4 * (MainActivity.ScreenWidth / 5);

            y[0] = (float) (MainActivity.ScreenHeight / 4 + Assets.spikyVert.getHeight());
            y[1] = (float) (MainActivity.ScreenHeight / 2) + Assets.spikyVert.getHeight();
            y[2] = (float) (MainActivity.ScreenHeight / 2) + Assets.spikyVert.getHeight();

            speedX[0] = 2f * (float) MainActivity.ScaleWidth;
            speedX[1] = 0f;
            speedX[2] = 0f;

            speedY[0] = 0f;
            speedY[1] = 5f * (float) MainActivity.ScaleHeight;
            speedY[2] = 5f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[0] = 'v';
            typeOfSpikyWall[1] = 'v';
            typeOfSpikyWall[2] = 'v';


            numberOfSpikyWallsInLevel = 3;


        }else if(currentLevel==3) {


            //Spikkes pos and speed
            x[0] = 0f;
            y[0] = (float) (MainActivity.ScreenHeight / 4) - (Assets.spikyVert.getHeight() / 3);

            speedX[0] = 3.0f * (float) MainActivity.ScaleWidth;
            speedY[0] = 2.0f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[0] = 'v';


            x[1] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            x[2] = 0f;

            y[1] = (float) (MainActivity.ScreenHeight / 2) + Assets.spikyVert.getHeight();
            y[2] = (float) (MainActivity.ScreenHeight / 2) + Assets.spikyVert.getHeight();

            speedX[1] = -3.0f * (float) MainActivity.ScaleWidth;
            speedX[2] = -3.0f * (float) MainActivity.ScaleWidth;

            speedY[1] = 3.5f * (float) MainActivity.ScaleHeight;
            speedY[2] = 3.5f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[1] = 'h';
            typeOfSpikyWall[2] = 'h';


            numberOfSpikyWallsInLevel = 3;



        }else if(currentLevel==4) {

            //Spikkes pos and speed
            x[0] = (float) (MainActivity.ScreenWidth / 4);
            x[1] = (float) 3 * (MainActivity.ScreenWidth / 4);

            y[0] = (float) (MainActivity.ScreenHeight / 4);
            y[1] = (float) (MainActivity.ScreenHeight / 4);

            speedX[0] = 0f;
            speedX[1] = 0f;

            speedY[0] = 4f * (float) MainActivity.ScaleHeight;
            speedY[1] = 4f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[0] = 'v';
            typeOfSpikyWall[1] = 'v';


            x[2] = 0f;
            x[3] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            x[4] = 0f;

            y[2] = (float) 2 * (MainActivity.ScreenHeight / 8);
            y[3] = (float) 4 * (MainActivity.ScreenHeight / 8);
            y[4] = (float) 6 * (MainActivity.ScreenHeight / 8);

            speedX[2] = 3.5f * (float) MainActivity.ScaleWidth;
            speedX[3] = -3.5f * (float) MainActivity.ScaleWidth;
            speedX[4] = 3.5f * (float) MainActivity.ScaleWidth;

            speedY[2] = 0f;
            speedY[3] = 0f;
            speedY[4] = 0f;
            typeOfSpikyWall[2] = 'h';
            typeOfSpikyWall[3] = 'h';
            typeOfSpikyWall[4] = 'h';


            numberOfSpikyWallsInLevel = 5;





        }else if(currentLevel==5) {


            //Spikkes pos and speed
            x[0] = 0f;
            y[0] = (float) (MainActivity.ScreenHeight / 2) + Assets.spikyHori.getHeight() / 2;

            speedX[0] = 2.8f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;

            typeOfSpikyWall[0] = 'h';

            numberOfSpikyWallsInLevel = 1;



        }else if(currentLevel==6) {


            //Spikkes pos and speed
            x[0] = 0f;
            y[0] = (float) (MainActivity.ScreenHeight / 2) + Assets.spikyHori.getHeight() / 2;


            speedX[0] = 4 * (float) MainActivity.ScaleWidth* (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;


            typeOfSpikyWall[0] = 'h';




            //Spikkes pos and speed
            x[1] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[1] = (float) (4*MainActivity.ScreenHeight / 5) + Assets.spikyHori.getHeight() / 2;


            speedX[1] = -5 * (float) MainActivity.ScaleWidth* (float) MainActivity.ScaleWidth;
            speedY[1] = 0f;


            typeOfSpikyWall[1] = 'h';


            x[2] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[2] = (float) (2*MainActivity.ScreenHeight / 5);


            speedX[2] = -4 * (float) MainActivity.ScaleWidth* (float) MainActivity.ScaleWidth;
            speedY[2] = 0f;


            typeOfSpikyWall[2] = 'v';


            numberOfSpikyWallsInLevel = 3;





        }else if(currentLevel==7) {


            //Spikkes pos and speed
            x[0] = 0f;


            y[0] = (float) (MainActivity.ScreenHeight / 3) + Assets.spikyHori.getHeight();


            speedX[0] = 6f * (float) MainActivity.ScaleWidth;


            speedY[0] = 0f;


            x[1] = MainActivity.ScreenWidth * 1f;


            y[1] = (float) (MainActivity.ScreenHeight / 4);


            speedX[1] = -6f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0f;

            typeOfSpikyWall[0] = 'h';
            typeOfSpikyWall[1] = 'h';

            numberOfSpikyWallsInLevel = 2;


        }else if(currentLevel==8) {


            x[0] = (float) MainActivity.ScreenWidth / 2 - Assets.spikyVert.getWidth() / 2;
            y[0] = (float) MainActivity.ScreenHeight;
            speedX[0] = 0f;
            speedY[0] = -4f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[0] = 'v';


            x[1] = 0f;
            y[1] = (float) (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2;
            speedX[1] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0f;


            x[2] = MainActivity.ScreenWidth * 1f;
            y[2] = (float) (2 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[2] = -2.5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0f;


            x[3] = 0f;
            y[3] = (float) (3 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[3] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0f;


            x[4] = MainActivity.ScreenWidth * 1f;
            y[4] = (float) (4 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[4] = -2.5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0f;

            typeOfSpikyWall[1] = 'h';
            typeOfSpikyWall[2] = 'h';
            typeOfSpikyWall[3] = 'h';
            typeOfSpikyWall[4] = 'h';


            numberOfSpikyWallsInLevel = 5;





        }else if(currentLevel==9) {


            x[0] = (float) MainActivity.ScreenWidth / 2 - Assets.spikyVert.getWidth();
            y[0] = (float) (MainActivity.ScreenHeight / 2);
            speedX[0] = -4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 5f * (float) MainActivity.ScaleHeight;


            x[1] = (float) MainActivity.ScreenWidth / 2;
            y[1] = (float) (MainActivity.ScreenHeight / 2);
            speedX[1] = 4f * (float) MainActivity.ScaleWidth;
            speedY[1] = 5f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[0] = 'v';
            typeOfSpikyWall[1] = 'v';


            x[2] = 0;
            y[2] = (float) (MainActivity.ScreenHeight / 10);
            speedX[2] = 5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 4f * (float) MainActivity.ScaleHeight;

            x[3] = (float) MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[3] = (float) (MainActivity.ScreenHeight / 10);
            speedX[3] = -5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 4f * (float) MainActivity.ScaleHeight;

            x[4] = 0;
            y[4] = (float) 2 * (MainActivity.ScreenHeight / 5);
            speedX[4] = 5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0f;


            typeOfSpikyWall[2] = 'h';
            typeOfSpikyWall[3] = 'h';
            typeOfSpikyWall[4] = 'h';


            numberOfSpikyWallsInLevel = 5;







        }else if(currentLevel==10) {


            x[0] = 20f;
            y[0] = (float) (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2;
            speedX[0] = 4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 5f * (float) MainActivity.ScaleHeight;


            x[1] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[1] = (float) (2 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[1] = -4f * (float) MainActivity.ScaleWidth;
            speedY[1] = -5f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[0] = 'v';
            typeOfSpikyWall[1] = 'v';


            numberOfSpikyWallsInLevel = 2;







        }else if(currentLevel==11) {


            x[0] = 20f;
            y[0] = (float) (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2;
            speedX[0] = 4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 4f * (float) MainActivity.ScaleHeight;


            x[1] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[1] = (float) (2 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[1] = -4f * (float) MainActivity.ScaleWidth;
            speedY[1] = -4f * (float) MainActivity.ScaleHeight;


            x[2] = 40f;
            y[2] = (float) (3 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = -4f * (float) MainActivity.ScaleHeight;


            x[3] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[3] = (float) (4 * (MainActivity.ScreenHeight / 5) +  - Assets.spikyHori.getHeight() / 2);
            speedX[3] = -4f * (float) MainActivity.ScaleWidth;
            speedY[3] = 4f * (float) MainActivity.ScaleHeight;


            typeOfSpikyWall[0] = 'h';
            typeOfSpikyWall[1] = 'h';
            typeOfSpikyWall[2] = 'h';
            typeOfSpikyWall[3] = 'h';


            numberOfSpikyWallsInLevel = 4;


        }else if(currentLevel==12) {


            //Spikkes pos and speed
            x[0] = 0;
            x[1] = (float) (MainActivity.ScreenWidth) - Assets.spikyVert.getWidth();
            x[2] = (float) (MainActivity.ScreenWidth) - Assets.spikyVert.getWidth();


            y[0] = (float) MainActivity.ScreenHeight - (6 * Assets.bluemarker.getHeight());
            y[1] = (float) MainActivity.ScreenHeight - (7 * Assets.bluemarker.getHeight());
            y[2] = (float) MainActivity.ScreenHeight - (8 * Assets.bluemarker.getHeight());


            speedX[0] = 3f * (float) MainActivity.ScaleWidth;
            speedX[1] = 3f * (float) MainActivity.ScaleWidth;
            speedX[2] = 4.5f * (float) MainActivity.ScaleWidth;


            speedY[0] = 0f;
            speedY[1] = 0f;
            speedY[2] = 0f;


            typeOfSpikyWall[0] = 'v';
            typeOfSpikyWall[1] = 'v';
            typeOfSpikyWall[2] = 'v';


            x[3] = 0;
            y[3] = (float) MainActivity.ScreenHeight - 2 * Assets.bluemarker.getHeight();
            speedX[3] = 4f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0;

            x[4] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[4] = (float) MainActivity.ScreenHeight - (3 * Assets.bluemarker.getHeight());
            speedX[4] = -5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;

            x[5] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[5] = (float) MainActivity.ScreenHeight - (4 * Assets.bluemarker.getHeight());
            speedX[5] = 6f * (float) MainActivity.ScaleWidth;
            speedY[5] = 0;

            x[6] = 0;
            y[6] = (float) MainActivity.ScreenHeight - (5 * Assets.bluemarker.getHeight());
            speedX[6] = 6f * (float) MainActivity.ScaleWidth;
            speedY[6] = 0;


            typeOfSpikyWall[3] = 'h';
            typeOfSpikyWall[4] = 'h';
            typeOfSpikyWall[5] = 'h';
            typeOfSpikyWall[6] = 'h';


            numberOfSpikyWallsInLevel = 7;





        }else if(currentLevel==13) {


            x[0] = 0;
            y[0] = (float) MainActivity.ScreenHeight - 2 * Assets.bluemarker.getHeight();
            speedX[0] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0;

            x[1] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[1] = (float) MainActivity.ScreenHeight - (3 * Assets.bluemarker.getHeight());
            speedX[1] = -3.5f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0;

            x[2] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[2] = (float) MainActivity.ScreenHeight - (4 * Assets.bluemarker.getHeight());
            speedX[2] = 3.5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0;

            x[3] = 0;
            y[3] = (float) MainActivity.ScreenHeight - (6 * Assets.bluemarker.getHeight());
            speedX[3] = -2.5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0;

            x[4] = 0;
            y[4] = (float) MainActivity.ScreenHeight - (7 * Assets.bluemarker.getHeight());
            speedX[4] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;

            typeOfSpikyWall[0] = 'h';
            typeOfSpikyWall[1] = 'h';
            typeOfSpikyWall[2] = 'h';
            typeOfSpikyWall[3] = 'h';
            typeOfSpikyWall[4] = 'h';


            numberOfSpikyWallsInLevel = 5;






        }else if(currentLevel==14) {


            x[0] = (float) (MainActivity.ScreenWidth / 2) - Assets.spikyVert.getWidth() / 2;
            y[0] = 0;

            speedX[0] = 3f * (float) MainActivity.ScaleWidth;
            speedY[0] = 2f;

            x[1] = (float) (MainActivity.ScreenWidth / 2) - Assets.spikyVert.getWidth() / 2;
            y[1] = (float) (MainActivity.ScreenHeight) - Assets.spikyVert.getHeight();

            speedX[1] = -3f * (float) MainActivity.ScaleWidth;
            speedY[1] = -2f;


            typeOfSpikyWall[0] = 'v';
            typeOfSpikyWall[1] = 'v';


            x[2] = 0;
            y[2] = 2 * (float) MainActivity.ScreenHeight / 5;
            speedX[2] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0;

            x[3] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[3] = (float) MainActivity.ScreenHeight / 5;
            speedX[3] = -3.5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0;

            x[4] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[4] = ((float) 3 * MainActivity.ScreenHeight / 5) + 5 * Assets.spikyHori.getHeight();
            speedX[4] = 1.5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;

            x[5] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[5] = (4 * MainActivity.ScreenHeight / 5) + 2 * Assets.spikyHori.getHeight();
            speedX[5] = 3.5f * (float) MainActivity.ScaleWidth;
            speedY[5] = 0;

            x[6] = MainActivity.ScreenWidth / 2 - Assets.spikyHori.getWidth() / 2;
            y[6] = 0;
            speedX[6] = -3.5f * (float) MainActivity.ScaleWidth;
            speedY[6] = 3.5f * (float) MainActivity.ScaleHeight;


            typeOfSpikyWall[2] = 'h';
            typeOfSpikyWall[3] = 'h';
            typeOfSpikyWall[4] = 'h';
            typeOfSpikyWall[5] = 'h';
            typeOfSpikyWall[6] = 'h';


            numberOfSpikyWallsInLevel = 7;





        }else if(currentLevel==15) {


            x[0] = 20f;
            y[0] = (float) (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2;
            speedX[0] = 4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 4f * (float) MainActivity.ScaleHeight;


            x[1] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[1] = (float) (2 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[1] = -4f * (float) MainActivity.ScaleWidth;
            speedY[1] = -4f * (float) MainActivity.ScaleHeight;


            x[2] = 40f;
            y[2] = (float) (3 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = -4f * (float) MainActivity.ScaleHeight;


            x[3] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[3] = (float) (4 * (MainActivity.ScreenHeight / 5));
            speedX[3] = -4f * (float) MainActivity.ScaleWidth;
            speedY[3] = 4f * (float) MainActivity.ScaleHeight;


            typeOfSpikyWall[0] = 'h';
            typeOfSpikyWall[1] = 'h';
            typeOfSpikyWall[2] = 'h';
            typeOfSpikyWall[3] = 'h';

            numberOfSpikyWallsInLevel = 4;




        }else if(currentLevel==16) {


            //Spikkes pos and speed
            x[0] = (float) (MainActivity.ScreenWidth / 4);
            x[1] = (float) 3 * (MainActivity.ScreenWidth / 4);

            y[0] = (float) (MainActivity.ScreenHeight / 4);
            y[1] = (float) (MainActivity.ScreenHeight / 4);

            speedX[0] = 0f;
            speedX[1] = 0f;

            speedY[0] = 4f * (float) MainActivity.ScaleHeight;
            speedY[1] = 4f * (float) MainActivity.ScaleHeight;


            typeOfSpikyWall[0] = 'v';
            typeOfSpikyWall[1] = 'v';


            x[2] = 20f;
            y[2] = (float) (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2;
            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = 4f * (float) MainActivity.ScaleHeight;


            x[3] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[3] = (float) (2 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[3] = -4f * (float) MainActivity.ScaleWidth;
            speedY[3] = -4f * (float) MainActivity.ScaleHeight;


            x[4] = 40f;
            y[4] = (float) (3 * (MainActivity.ScreenHeight / 5) + ((MainActivity.ScreenHeight / 5) / 2) - Assets.spikyHori.getHeight() / 2);
            speedX[4] = 4f * (float) MainActivity.ScaleWidth;
            speedY[4] = -4f * (float) MainActivity.ScaleHeight;


            x[5] = MainActivity.ScreenWidth - Assets.spikyHori.getWidth();
            y[5] = (float) (4 * (MainActivity.ScreenHeight / 5));
            speedX[5] = -4f * (float) MainActivity.ScaleWidth;
            speedY[5] = 4f * (float) MainActivity.ScaleHeight;


            typeOfSpikyWall[2] = 'h';
            typeOfSpikyWall[3] = 'h';
            typeOfSpikyWall[4] = 'h';
            typeOfSpikyWall[5] = 'h';


            numberOfSpikyWallsInLevel = 6;


        }else if(currentLevel==17){

            x[0] = 6.5f*MainActivity.ScreenWidth / 20;
            x[1] = 13.5f*MainActivity.ScreenWidth / 20;
            x[2] = 2f*MainActivity.ScreenWidth / 20;
            x[3] = 18f*MainActivity.ScreenWidth / 20;


            y[0] = (float)MainActivity.ScreenHeight - (Assets.spikyVert.getHeight());
            y[1] = Assets.spikyVert.getHeight();
            y[2] = (float)MainActivity.ScreenHeight/2;
            y[3] = (float)MainActivity.ScreenHeight/2;

            speedX[0] = 0;
            speedX[1] = 0;
            speedX[2] = 0;
            speedX[3] = 0;


            speedY[0] = -5f*(float)MainActivity.ScaleWidth;
            speedY[1] = 5f*(float)MainActivity.ScaleWidth;
            speedY[2] = 3f*(float)MainActivity.ScaleWidth;
            speedY[3] = -3f*(float)MainActivity.ScaleWidth;




            x[4] = 0;
            y[4] = (float) 6*MainActivity.ScreenHeight / 20;
            speedX[4] = 2.5f*(float)MainActivity.ScaleWidth;
            speedY[4] = 0;

            x[5] = MainActivity.ScreenWidth-Assets.spikyHori.getWidth();
            y[5] = (float) 10*MainActivity.ScreenHeight / 20;
            speedX[5] = -3.5f*(float)MainActivity.ScaleWidth;
            speedY[5] = 0;

            x[6] = 0;
            y[6] = ((float) 14*MainActivity.ScreenHeight / 20);
            speedX[6] = 3.5f*(float)MainActivity.ScaleWidth;
            speedY[6] = 0;

            x[7] = MainActivity.ScreenWidth-Assets.spikyHori.getWidth();
            y[7] = (float) 16*MainActivity.ScreenHeight / 20;
            speedX[7] = -2.5f*(float)MainActivity.ScaleWidth;
            speedY[7] = 0;

            x[8] = MainActivity.ScreenWidth-Assets.spikyHori.getWidth();
            y[8] = 2.5f*MainActivity.ScreenHeight / 20;
            speedX[8] = -1.5f*(float)MainActivity.ScaleWidth;
            speedY[8] = 0;



            typeOfSpikyWall[0] = 'v';
            typeOfSpikyWall[1] = 'v';
            typeOfSpikyWall[2] = 'v';
            typeOfSpikyWall[3] = 'v';

            typeOfSpikyWall[4] = 'h';
            typeOfSpikyWall[5] = 'h';
            typeOfSpikyWall[6] = 'h';
            typeOfSpikyWall[7] = 'h';
            typeOfSpikyWall[8] = 'h';




            numberOfSpikyWallsInLevel=9;






        } else if (currentLevel == 18) {


            x[0] = 0f;
            y[0] = (float) (MainActivity.ScreenHeight / 2);

            speedX[0] = 6f*(float)MainActivity.ScaleWidth;
            speedY[0] = 0f;

            x[1] = (float) (MainActivity.ScreenWidth / 2 );
            y[1] = (float) (MainActivity.ScreenHeight / 4);

            speedX[1] = -5f*(float)MainActivity.ScaleWidth;
            speedY[1] = 0f;

            typeOfSpikyWall[0] = 'd';
            typeOfSpikyWall[1] = 'd';



            numberOfSpikyWallsInLevel = 2;


        }else if(currentLevel==19) {

            x[0] = 0f;
            y[0] = (float) (MainActivity.ScreenHeight / 2);

            speedX[0] = 6f * (float) MainActivity.ScaleWidth;
            speedY[0] = -4f * (float) MainActivity.ScaleHeight;


            x[1] = MainActivity.ScreenWidth - Assets.spikyDouble.getWidth();
            y[1] = (float) (MainActivity.ScreenHeight / 2);

            speedX[1] = 6f * (float) MainActivity.ScaleWidth;
            speedY[1] = -4f * (float) MainActivity.ScaleHeight;


            x[2] = (float) (MainActivity.ScreenWidth / 2);
            y[2] = (float) (MainActivity.ScreenHeight / 2 - Assets.spikyDouble.getHeight());

            speedX[2] = -5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0f;

            x[3] = (float) (MainActivity.ScreenWidth / 2);
            y[3] = (float) (MainActivity.ScreenHeight / 4);

            speedX[3] = 5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0f;

            x[4] = (float) (MainActivity.ScreenWidth / 2);
            y[4] = (float) (3 * MainActivity.ScreenHeight / 4);

            speedX[4] = 5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0f;

            x[5] = (float) (MainActivity.ScreenWidth / 2);
            y[5] = (float) (MainActivity.ScreenHeight / 2 - Assets.spikyDouble.getHeight());

            speedX[5] = -2f * (float) MainActivity.ScaleWidth;
            speedY[5] = -2f * (float) MainActivity.ScaleHeight;

            x[6] = (float) (MainActivity.ScreenWidth / 2);
            y[6] = (float) (MainActivity.ScreenHeight / 2 - Assets.spikyDouble.getHeight());

            speedX[6] = 2f * (float) MainActivity.ScaleWidth;
            speedY[6] = 2f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[0] = 'd';
            typeOfSpikyWall[1] = 'd';
            typeOfSpikyWall[2] = 'd';
            typeOfSpikyWall[3] = 'd';
            typeOfSpikyWall[4] = 'd';
            typeOfSpikyWall[5] = 'd';
            typeOfSpikyWall[6] = 'd';

            numberOfSpikyWallsInLevel = 7;


        }else if(currentLevel==20){

            x[0] = 0f;
            y[0] = (float) (MainActivity.ScreenHeight / 2) + Assets.spikyHori.getHeight() / 2;

            speedX[0] = 7f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;

            typeOfSpikyWall[0] = 'h';

            numberOfSpikyWallsInLevel = 1;



        }else if(currentLevel==21){

            x[0] = MainActivity.ScreenWidth - Assets.spikyDouble.getWidth();
            y[0] = MainActivity.ScreenHeight / 3 - 4*Assets.spikyDouble.getHeight();

            speedX[0] = -4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;


            x[1] = 0f;
            y[1] = MainActivity.ScreenHeight / 3 - 2*Assets.spikyDouble.getHeight();

            speedX[1] = 6f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0f;

            x[2] = 80f;
            y[2] = 3*(MainActivity.ScreenHeight / 5) ;

            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = 4f * (float) MainActivity.ScaleHeight;

            x[3] = MainActivity.ScreenWidth - Assets.spikyDouble.getWidth();
            y[3] = 3*(MainActivity.ScreenHeight / 5) ;

            speedX[3] = -4f * (float) MainActivity.ScaleWidth;
            speedY[3] = 4f * (float) MainActivity.ScaleHeight;

            typeOfSpikyWall[0] = 'd';
            typeOfSpikyWall[1] = 'd';
            typeOfSpikyWall[2] = 'd';
            typeOfSpikyWall[3] = 'd';


            numberOfSpikyWallsInLevel = 4;


        }else if(currentLevel==22) {

            x[0] = MainActivity.ScreenWidth - 2 * Assets.spikyDouble.getWidth();
            y[0] = MainActivity.ScreenHeight - 2 * Assets.spikyDouble.getHeight();

            speedX[0] = -4f * (float) MainActivity.ScaleWidth;
            speedY[0] = -4f * (float) MainActivity.ScaleHeight;

            x[1] = 0;
            y[1] = 0;

            speedX[1] = 4f * (float) MainActivity.ScaleWidth;
            speedY[1] = 4f * (float) MainActivity.ScaleHeight;


            x[2] = MainActivity.ScreenWidth / 2;
            y[2] = 0;

            speedX[2] = 2f * (float) MainActivity.ScaleWidth;
            speedY[2] = 2f * (float) MainActivity.ScaleHeight;


            x[3] = 0;
            y[3] = MainActivity.ScreenHeight / 4;

            speedX[3] = 2f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0f;


            x[4] = MainActivity.ScreenWidth / 2 - 2 * Assets.spikyDouble.getWidth();
            y[4] = MainActivity.ScreenHeight / 4;

            speedX[4] = 0;
            speedY[4] = -2f * (float) MainActivity.ScaleWidth;


            x[5] =MainActivity.ScreenWidth / 2;
            y[5] = 7*MainActivity.ScreenHeight / 8;

            speedX[5] =  2f * (float) MainActivity.ScaleWidth;
            speedY[5] = -2f * (float) MainActivity.ScaleWidth;
            bumpable[5]='y';


            typeOfSpikyWall[0] = 'd';
            typeOfSpikyWall[1] = 'd';
            typeOfSpikyWall[2] = 'd';
            typeOfSpikyWall[3] = 'd';
            typeOfSpikyWall[4] = 'd';
            typeOfSpikyWall[5] = 'd';



            numberOfSpikyWallsInLevel = 6;

        }else if(currentLevel==23){
            numberOfSpikyWallsInLevel = 6;


            for(int i=0;i< numberOfSpikyWallsInLevel;i++){
                bumpable[i]='y';
            }


            x[0] = MainActivity.ScreenWidth/8 - Assets.spikyDouble.getWidth()/2;
            y[0] = 3*MainActivity.ScreenHeight/8 - Assets.spikyDouble.getHeight()/2;

            speedX[0] = 4f * (float) MainActivity.ScaleWidth;
            speedY[0] = -4f * (float) MainActivity.ScaleHeight;

            x[1] =7* MainActivity.ScreenWidth/8 - Assets.spikyDouble.getWidth()/2;
            y[1] = 5*MainActivity.ScreenHeight/8 - Assets.spikyDouble.getHeight()/2;

            speedX[1] = -4f * (float) MainActivity.ScaleWidth;
            speedY[1] = 4f * (float) MainActivity.ScaleHeight;

            x[2] =7* MainActivity.ScreenWidth/8 - Assets.spikyDouble.getWidth()/2;
            y[2] = 1*MainActivity.ScreenHeight/8 - Assets.spikyDouble.getHeight()/2;

            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = 4f * (float) MainActivity.ScaleHeight;

            x[3] =3* MainActivity.ScreenWidth/8 - Assets.spikyDouble.getWidth()/2;
            y[3] = 7*MainActivity.ScreenHeight/8 - Assets.spikyDouble.getHeight()/2;

            speedX[3] = 4f * (float) MainActivity.ScaleWidth;
            speedY[3] = -4f * (float) MainActivity.ScaleHeight;

            x[4] =1* MainActivity.ScreenWidth/8 - Assets.spikyDouble.getWidth()/2;
            y[4] = 1*MainActivity.ScreenHeight/8 - Assets.spikyDouble.getHeight()/2;

            speedX[4] = -4f * (float) MainActivity.ScaleWidth;
            speedY[4] = -4f * (float) MainActivity.ScaleHeight;

            x[5] =1* MainActivity.ScreenWidth/8 - Assets.spikyDouble.getWidth()/2;
            y[5] = 5*MainActivity.ScreenHeight/8 - Assets.spikyDouble.getHeight()/2;

            speedX[5] = 4f * (float) MainActivity.ScaleWidth;
            speedY[5] = -4f * (float) MainActivity.ScaleHeight;



            typeOfSpikyWall[0] = 'd';
            typeOfSpikyWall[1] = 'd';
            typeOfSpikyWall[2] = 'd';
            typeOfSpikyWall[3] = 'd';
            typeOfSpikyWall[4] = 'd';
            typeOfSpikyWall[5] = 'd';









        }else if(currentLevel==24){

            x[0] = MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;
            y[0] = MainActivity.ScreenHeight/4;

            speedX[0] =- 5f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0;

            x[1] = MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;
            y[1] = MainActivity.ScreenHeight/4 +2* Assets.spikyDouble.getHeight();

            speedX[1] = 5f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0;

            x[2] = MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;
            y[2] = MainActivity.ScreenHeight/4 +4* Assets.spikyDouble.getHeight();

            speedX[2] = -5f * (float) MainActivity.ScaleWidth;
            speedY[2] =0;


            x[3] = MainActivity.ScreenWidth/4 - Assets.spikyDouble.getWidth()/2;
            y[3] = MainActivity.ScreenHeight/2+2* Assets.spikyDouble.getHeight();

            speedX[3] =- 5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0;

            x[4] =3* MainActivity.ScreenWidth/4 - Assets.spikyDouble.getWidth()/2;
            y[4] =MainActivity.ScreenHeight/2 +4* Assets.spikyDouble.getHeight();

            speedX[4] = 5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;

            x[5] = MainActivity.ScreenWidth/4 - Assets.spikyDouble.getWidth()/2;
            y[5] = MainActivity.ScreenHeight/2 +6* Assets.spikyDouble.getHeight();

            speedX[5] = -5f * (float) MainActivity.ScaleWidth;
            speedY[5] =0;


            x[6] = MainActivity.ScreenWidth - Assets.spikyDouble.getWidth();
            y[6] = MainActivity.ScreenHeight/2 - Assets.spikyDouble.getHeight()/2;

            speedX[6] = -2f * (float) MainActivity.ScaleWidth;
            speedY[6] =0;


            x[7] = MainActivity.ScreenWidth - Assets.spikyDouble.getWidth();
            y[7] = 3*MainActivity.ScreenHeight/4 + Assets.spikyDouble.getHeight()/2;

            speedX[7] = -7f * (float) MainActivity.ScaleWidth;
            speedY[7] =0;

            x[8] = 0;
            y[8] = MainActivity.ScreenHeight/4 - 5*Assets.spikyDouble.getHeight() ;

            speedX[8] = 7f * (float) MainActivity.ScaleWidth;
            speedY[8] =0;


            typeOfSpikyWall[0] = 'd';
            typeOfSpikyWall[1] = 'd';
            typeOfSpikyWall[2] = 'd';
            typeOfSpikyWall[3] = 'd';
            typeOfSpikyWall[4] = 'd';
            typeOfSpikyWall[5] = 'd';
            typeOfSpikyWall[6] = 'd';
            typeOfSpikyWall[7] = 'd';
            typeOfSpikyWall[8] = 'd';



            numberOfSpikyWallsInLevel = 9;







        }
    }















    public void updateSpeed(int currentLevel,LevelWalls levelwalls,SpikyWalls spikyDouble) {



        if(currentLevel==2) {

            if (x[0] + Assets.spikyVert.getWidth() > MainActivity.ScreenWidth) {

                speedX[0] = -Math.abs(speedX[0]);

            } else if (x[0] < 0) {

                speedX[0] = Math.abs(speedX[0]);
            }


            if (y[1] + Assets.spikyVert.getHeight() > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                speedY[1] = -Math.abs(speedY[1]);
                speedY[2] = -Math.abs(speedY[2]);

            } else if (y[1] < MainActivity.ScreenHeight / 4 ) {

                speedY[1] = Math.abs(speedY[1]);
                speedY[2] = Math.abs(speedY[2]);
            }



        }else if(currentLevel==3) {


            if (x[0] + Assets.spikyVert.getWidth() > MainActivity.ScreenWidth) {

                speedX[0] = -Math.abs(speedX[0]);
                speedY[0] = -Math.abs(speedY[0]);


            } else if (x[0] < 0) {

                speedX[0] = Math.abs(speedX[0]);
                speedY[0] = Math.abs(speedY[0]);
            }


            if (y[1] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                speedX[1] = Math.abs(speedX[1]);
                speedY[1] = -Math.abs(speedY[1]);


            } else if (x[1] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[1] = -Math.abs(speedX[1]);
                speedY[1] = Math.abs(speedY[1]);
            }


            if (y[2] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                speedX[2] = -1 * speedX[2];
                speedY[2] = -1 * speedY[2];


            } else if (x[2] < 0) {

                speedX[2] = Math.abs(speedX[2]);
                speedY[2] = Math.abs(speedY[2]);
            }






        }else if(currentLevel==4) {


            if (y[0] + Assets.spikyVert.getHeight() > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                speedY[0] = -Math.abs(speedY[0]);
                speedY[1] = -Math.abs(speedY[1]);

            } else if (y[1] < MainActivity.ScreenHeight / 4) {

                speedY[0] = Math.abs(speedY[0]);
                speedY[1] = Math.abs(speedY[1]);
            }


            if (x[2] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[2] = -Math.abs(speedX[2]);
                speedY[2] = Math.abs(speedY[2]);


            } else if (x[2] < 0) {

                speedX[2] = Math.abs(speedX[2]);
                speedY[2] = -Math.abs(speedY[2]);
            }


            if (x[3] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[3] = -Math.abs(speedX[3]);
                speedY[3] = Math.abs(speedY[3]);


            } else if (x[3] < 0) {

                speedX[3] = Math.abs(speedX[3]);
                speedY[3] = -Math.abs(speedY[3]);
            }


            if (x[4] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[4] = -Math.abs(speedX[4]);
                speedY[4] = Math.abs(speedY[4]);


            } else if (x[4] < 0) {

                speedX[4] = Math.abs(speedX[4]);
                speedY[4] = -Math.abs(speedY[4]);
            }






        }else if(currentLevel==5) {


            for (int i = 0; i < 1; i++) {

                if (x[i] < 0) {

                    speedX[i] = Math.abs(speedX[i]);

                } else if (x[i] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                    speedX[i] = -Math.abs(speedX[i]);

                }

            }


        }else if(currentLevel==6) {


            if (x[0] < 0) {

                speedX[0] = Math.abs(speedX[0]);


            } else if (x[0] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[0] = -Math.abs(speedX[0]);

            }


            if (x[1] < 0) {

                speedX[1] = Math.abs(speedX[1]);


            } else if (x[1] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[1] = -Math.abs(speedX[1]);

            }


            if (x[2] < 0) {

                speedX[2] = Math.abs(speedX[2]);


            } else if (x[2] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[2] = -Math.abs(speedX[2]);

            }



        }else if(currentLevel==7) {


            for (int i = 0; i < 2; i++) {
                if (x[i] < 0) {

                    speedX[i] = Math.abs(speedX[i]);


                } else if (x[i] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                    speedX[i] = -Math.abs(speedX[i]);

                }
            }


        }else if(currentLevel==8) {


            if (y[0] + Assets.spikyVert.getHeight() > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                speedY[0] = -Math.abs(speedY[0]);
                speedY[0] = -Math.abs(speedY[0]);

            } else if (y[0] < MainActivity.ScreenHeight / 4) {

                speedY[0] = Math.abs(speedY[0]);
                speedY[0] = Math.abs(speedY[0]);
            }


            for (int i = 1; i < 5; i++) {
                if (x[i] < 0) {

                    speedX[i] = Math.abs(speedX[i]);


                } else if (x[i] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                    speedX[i] = -Math.abs(speedX[i]);

                }
            }






        }else if(currentLevel==9) {


            if (x[0] + Assets.spikyVert.getWidth() > MainActivity.ScreenWidth) {

                speedX[0] = -Math.abs(speedX[0]);
                speedY[0] = Math.abs(speedY[0]);

            } else if (x[0] < 0) {

                speedX[0] = Math.abs(speedX[0]);
                speedY[0] = -Math.abs(speedY[0]);
            }


            if (x[1] + Assets.spikyVert.getWidth() > MainActivity.ScreenWidth) {

                speedX[1] = -Math.abs(speedX[1]);
                speedY[1] = -Math.abs(speedY[1]);


            } else if (x[1] < 0) {

                speedX[1] = Math.abs(speedX[1]);
                speedY[1] = Math.abs(speedY[1]);
            }


            if (x[2] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[2] = -Math.abs(speedX[2]);
                speedY[2] = -Math.abs(speedY[2]);


            } else if (x[2] < 0) {

                speedX[2] = Math.abs(speedX[2]);
                speedY[2] = Math.abs(speedY[2]);
            }


            if (x[3] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[3] = -Math.abs(speedX[3]);
                speedY[3] = Math.abs(speedY[3]);


            } else if (x[3] < 0) {

                speedX[3] = Math.abs(speedX[3]);
                speedY[3] = -Math.abs(speedY[3]);
            }


            if (x[4] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                speedX[4] = -Math.abs(speedX[4]);

            } else if (x[4] < 0) {

                speedX[4] = Math.abs(speedX[4]);
            }




        }else if(currentLevel==10) {


            for (int i = 0; i < 2; i++) {

                if (x[i] < 0) {
                    speedX[i] = -1 * speedX[i];

                } else if (x[i] + Assets.spikyVert.getWidth() / 2 > MainActivity.ScreenWidth) {

                    speedX[i] = -1 * speedX[i];

                } else {


                }


                if (y[i] < 110f * (float) (MainActivity.ScaleHeight)) {
                    speedY[i] = -1 * speedY[i];

                } else if (y[i] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                    speedY[i] = -1 * speedY[i];

                } else {


                }

            }


        }else if(currentLevel==11) {


            for (int i = 0; i < 4; i++) {

                if (x[i] < 0) {
                    speedX[i] = -1 * speedX[i];

                } else if (x[i] + Assets.spikyHori.getWidth() / 2 > MainActivity.ScreenWidth) {

                    speedX[i] = -1 * speedX[i];

                } else {


                }


                if (y[i] < 110f * (float) (MainActivity.ScaleHeight)) {
                    speedY[i] = -1 * speedY[i];

                } else if (y[i] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                    speedY[i] = -1 * speedY[i];

                } else {


                }

            }


        }else if(currentLevel==12) {


            for (int i = 0; i < 3; i++) {
                if (x[i] + Assets.spikyVert.getWidth() > MainActivity.ScreenWidth) {

                    speedX[i] = -Math.abs(speedX[i]);


                } else if (x[i] < 0) {

                    speedX[i] = Math.abs(speedX[i]);
                }
            }


            for (int i = 3; i < 7; i++) {

                if (x[i] < 0) {
                    speedX[i] = -1 * speedX[i];

                } else if (x[i] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                    speedX[i] = -1 * speedX[i];

                } else {

                }

            }


        }else if(currentLevel==13) {


            for (int i = 0; i < 5; i++) {

                if (x[i] < 0) {
                    speedX[i] = -1 * speedX[i];

                } else if (x[i] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {

                    speedX[i] = -1 * speedX[i];

                } else {

                }

            }


        }else if(currentLevel==14) {


            for (int h = 0; h < 2; h++) {
                if (x[h] + Assets.spikyVert.getWidth() > MainActivity.ScreenWidth) {

                    speedX[h] = -Math.abs(speedX[h]);

                } else if (x[h] < 0) {

                    speedX[h] = Math.abs(speedX[h]);
                }

                if (y[h] + Assets.spikyVert.getHeight() > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                    speedY[h] = -Math.abs(speedY[h]);


                } else if (y[h] < 110f * (float) (MainActivity.ScaleHeight)) {

                    speedY[h] = Math.abs(speedY[h]);

                }
            }


            for (int i = 2; i < 6; i++) {

                if (x[i] < 0) {
                    speedX[i] = -1 * speedX[i];

                } else if (x[i] + Assets.spikyHori.getWidth() / 2 > MainActivity.ScreenWidth) {

                    speedX[i] = -1 * speedX[i];

                } else {

                }


                if (y[i] < 110f * (float) (MainActivity.ScaleHeight)) {
                    speedY[i] = -1 * speedY[i];

                } else if (y[i] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                    speedY[i] = -1 * speedY[i];

                } else {

                }

            }


            if (x[6] + Assets.spikyVert.getWidth() > MainActivity.ScreenWidth) {

                speedX[6] = -Math.abs(speedX[6]);

            } else if (x[6] < 0) {

                speedX[6] = Math.abs(speedX[6]);
            }


            if (y[6] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                speedY[6] = -Math.abs(speedY[6]);


            } else if (y[6] < 110f * (float) (MainActivity.ScaleHeight)) {

                speedY[6] = Math.abs(speedY[6]);

            }


        }else if(currentLevel==15) {


            for (int i = 0; i < 4; i++) {

                if (x[i] < 0) {
                    speedX[i] = -1 * speedX[i];

                } else if (x[i] + Assets.spikyHori.getWidth() / 2 > MainActivity.ScreenWidth) {

                    speedX[i] = -1 * speedX[i];

                } else {


                }


                if (y[i] < 110f * (float) (MainActivity.ScaleHeight)) {
                    speedY[i] = -1 * speedY[i];

                } else if (y[i] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                    speedY[i] = -1 * speedY[i];

                } else {


                }

            }


        }else if(currentLevel==16) {


            if (y[0] + Assets.spikyVert.getHeight() > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                speedY[0] = -Math.abs(speedY[0]);
                speedY[1] = -Math.abs(speedY[1]);

            } else if (y[1] < MainActivity.ScreenHeight / 4) {

                speedY[0] = Math.abs(speedY[0]);
                speedY[1] = Math.abs(speedY[1]);
            }


            for (int i = 2; i < 6; i++) {

                if (x[i] < 0) {
                    speedX[i] = -1 * speedX[i];

                } else if (x[i] + Assets.spikyHori.getWidth() / 2 > MainActivity.ScreenWidth) {

                    speedX[i] = -1 * speedX[i];

                } else {


                }


                if (y[i] < 110f * (float) (MainActivity.ScaleHeight)) {
                    speedY[i] = -1 * speedY[i];

                } else if (y[i] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                    speedY[i] = -1 * speedY[i];

                } else {


                }

            }




        }else if(currentLevel==17){


            for(int h=0;h<4;h++) {
                if (x[h] + Assets.spikyVert.getWidth() > MainActivity.ScreenWidth) {

                    speedX[h] = -Math.abs(speedX[h]);

                } else if (x[h] < 0) {

                    speedX[h] = Math.abs(speedX[h]);
                }

                if (y[h] + Assets.spikyVert.getHeight() > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                    speedY[h] = -Math.abs(speedY[h]);


                } else if (y[h] < 110f* (float) (MainActivity.ScaleHeight)) {

                    speedY[h] = Math.abs(speedY[h]);

                }
            }




            for(int i=4;i<9;i++){

                if(x[i]<0){
                    speedX[i]=-1*speedX[i];

                }else if(x[i] + Assets.spikyHori.getWidth()/2 > MainActivity.ScreenWidth){

                    speedX[i]=-1*speedX[i];

                }else{


                }



                if(y[i]<110f* (float) (MainActivity.ScaleHeight)){
                    speedY[i]=-1*speedY[i];

                }else if(y[i]  > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()){

                    speedY[i]=-1*speedY[i];

                }else{


                }

            }





        } else if(currentLevel==18) {


            if (x[0] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {
                x[0]=0;
            }


            if(x[1]<0){
                x[1]=(float) (MainActivity.ScreenWidth / 2);
            }



        }else if(currentLevel==19) {

            for (int i = 0; i < numberOfSpikyWallsInLevel; i++) {

                if (x[i] < 0) {
                    speedX[i] = Math.abs(speedX[i]);

                } else if (x[i] + Assets.spikyDouble.getWidth() > MainActivity.ScreenWidth) {

                    speedX[i] = -1 * speedX[i];
                }


                if (y[i] < 110f * (float) (MainActivity.ScaleHeight)) {
                    speedY[i] = Math.abs(speedY[i]);

                } else if (y[i] + Assets.spikyDouble.getHeight() > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()) {

                    speedY[i] = -1 * speedY[i];
                }

            }



        }else if(currentLevel==20){




            if(x[0]+Assets.spikyHori.getWidth()>MainActivity.ScreenWidth){

                speedX[0]=-Math.abs(speedX[0]);
                speedY[0]=Math.abs(speedY[0]);


            }else if(x[0]<0){

                speedX[0]=Math.abs(speedX[0]);
                speedY[0]=-Math.abs(speedY[0]);
            }





        }else if(currentLevel==21){

            if (x[1] + Assets.spikyHori.getWidth() > MainActivity.ScreenWidth) {
                x[1]=0;
            }


            if(x[0]<0){
                x[0]=(float) (MainActivity.ScreenWidth );
            }


            if(y[2]>MainActivity.ScreenHeight - Assets.gemright.getHeight()){
                speedY[2]=-speedY[2];
                speedX[2]=-speedX[2];

            }else if(x[2]<0){

                speedY[2]=Math.abs(speedY[2]);
                speedX[2]=Math.abs(speedX[2]);

            }


            if(y[3]>MainActivity.ScreenHeight - Assets.gemright.getHeight()){
                speedY[3]=-speedY[3];
                speedX[3]=Math.abs(speedX[3]);

            }else if(x[3] + Assets.gemright.getWidth()>MainActivity.ScreenWidth){

                speedY[3]=Math.abs(speedY[3]);
                speedX[3]=-Math.abs(speedX[3]);

            }


        }else if(currentLevel==22) {

            for (int i = 0; i < 2; i++) {

                if (x[i] + Assets.spikyDouble.getWidth() > MainActivity.ScreenWidth) {
                    speedX[i] = -Math.abs(speedX[i]);

                } else if (x[i] < 0) {
                    speedX[i] = Math.abs(speedX[i]);
                }


                if (y[i] > MainActivity.ScreenHeight - Assets.spikyDouble.getHeight()) {
                    speedY[i] = -Math.abs(speedY[i]);
                    //speedX[i]=-speedX[i];

                } else if (y[i] < 110f* (float) (MainActivity.ScaleHeight)) {

                    speedY[i] = Math.abs(speedY[i]);
                    // speedX[2]=Math.abs(speedX[2]);

                }
            }


            if (x[2] > MainActivity.ScreenWidth - Assets.spikyDouble.getWidth()) {

                speedX[2] = -Math.abs(speedX[2]);
                speedY[2] = -Math.abs(speedY[2]);

            } else if (x[2] < MainActivity.ScreenWidth / 2) {
                speedX[2] = Math.abs(speedX[2]);
                speedY[2] = Math.abs(speedY[2]);


            }


            if (x[3] > MainActivity.ScreenWidth / 2 - 2 * Assets.spikyDouble.getWidth()) {
                x[3] = 0;
            }


            if (y[4] < 110f* (float) (MainActivity.ScaleHeight)) {
                y[4] = MainActivity.ScreenHeight / 4;
            }


            levelwalls.checkCollisionSpikyDoubleWallsWithLevelWalls(spikyDouble,5);
            checkSpikyDoubleWallCollisionWithScreen(5);



        }else if(currentLevel==23){


            for(int i=0;i< numberOfSpikyWallsInLevel;i++) {
                levelwalls.checkCollisionSpikyDoubleWallsWithLevelWalls(spikyDouble,i);
                checkSpikyDoubleWallCollisionWithScreen(i);
            }




        }else if(currentLevel==24){


            if(x[0]<0 ){
                x[0]= MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;

            }


            if(x[2]<0 ){
                x[2]= MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;

            }

            if(x[1]>MainActivity.ScreenWidth - Assets.spikyDouble.getWidth() ){
                x[1]= MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;

            }


            if(x[3]<0 ){
                x[3]= MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;

            }


            if(x[5]<0 ){
                x[5]= MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;

            }

            if(x[4]>MainActivity.ScreenWidth - Assets.spikyDouble.getWidth() ){
                x[4]= MainActivity.ScreenWidth/2 - Assets.spikyDouble.getWidth()/2;

            }


            if(x[6]>MainActivity.ScreenWidth - Assets.spikyDouble.getWidth() ){
                speedX[6]= -Math.abs(speedX[6]);

            }else if(x[6]<0){
                speedX[6]= Math.abs(speedX[6]);

            }


            if(x[7]<0 ){
                x[7]= MainActivity.ScreenWidth- Assets.spikyDouble.getWidth();

            }

            if(x[8]>MainActivity.ScreenWidth-Assets.spikyDouble.getWidth() ){
                x[8]= 0;

            }



        }
    }



    public char getTypeOfSpikyWall(int current){

        return typeOfSpikyWall[current];

    }



    public RectF getRectOfSpikyDouble(int current) {


        return spikyWallRect[current];
    }




    public boolean checkCollisionsRainTailsWithSpikyDoubleWalls(RainbowTails rainTails){


        for(int i=0;i< numberOfSpikyWallsInLevel;i++) {
            w = (float) (0.5 * (spikyWallRect[i].width() -spikyWallRect[i].width()/8+ rainTails.getRectOfRainbowTails().width()));
            h = (float) (0.5 * (spikyWallRect[i].height()-spikyWallRect[i].height()/8 + rainTails.getRectOfRainbowTails().height()));
            dx = spikyWallRect[i].centerX() - rainTails.getRectOfRainbowTails().centerX();
            dy = spikyWallRect[i].centerY() - rainTails.getRectOfRainbowTails().centerY();

            if (Math.abs(dx) <= w && Math.abs(dy) <= h) {


                wy = w * dy;
                hx = h * dx;

                if (wy > hx) {
                    if (wy > -hx) {

return true;
                        // collision at the top
                    } else {

return true;


                        // on the left
                    }


                } else {
                    if (wy > -hx) {
return true;
                        // on the right
                    } else {
                        return true;
                        // at the bottom

                    }
                }
            }
        }

        return false;
        /*
        for(int i=0;i<numberOfSpikyWallsInLevel;i++){

            if(rainTails.getRectOfRainbowTails().intersect(spikyWallRect[i]) && rainTails.isRainTailsProtected()==false){
                return true;
            }

        }

        return false;*/
    }





    public int getNumberOfDoubleSpikyWalls(){
        return numberOfSpikyWallsInLevel;
    }


    public void updatePos(){



        for(int i=0;i<numberOfSpikyWallsInLevel;i++) {
            x[i]=x[i]+speedX[i];
            y[i]=y[i]+speedY[i];


            if(typeOfSpikyWall[i]=='v') {

               spikyWallRect[i].set(x[i] , y[i] , x[i] + Assets.spikyVert.getWidth() , y[i] + Assets.spikyVert.getHeight());


            }else if(typeOfSpikyWall[i]=='h'){

                spikyWallRect[i].set(x[i] , y[i] , x[i] + Assets.spikyHori.getWidth() , y[i] + Assets.spikyHori.getHeight());

            }else if(typeOfSpikyWall[i]=='d'){

                spikyWallRect[i].set(x[i] , y[i] , x[i] + Assets.spikyDouble.getWidth() , y[i] + Assets.spikyDouble.getHeight());

            }

        }

    }



    public void updateSpeedX(float newSpeedX,int current){

        speedX[current]= newSpeedX;

    }



    public void updateSpeedY(float newSpeedY,int current){

        speedY[current]=newSpeedY;

    }

    public float getSpeedX(int current){
        return speedX[current];
    }



    public float getSpeedY(int current){
        return speedY[current];

    }



    public void checkSpikyDoubleWallCollisionWithScreen(int i){


            if(x[i]<0){
                speedX[i]=Math.abs(speedX[i]);
            }else if(x[i]+Assets.spikyDouble.getWidth()>MainActivity.ScreenWidth){
                speedX[i]=-Math.abs(speedX[i]);
            }


            if(y[i]<110f* (float) (MainActivity.ScaleHeight)){
                speedY[i]=Math.abs(speedY[i]);
            } else if(y[i]+Assets.spikyDouble.getHeight()>MainActivity.ScreenHeight - Assets.bluemarker.getHeight()){
                speedY[i]=-Math.abs(speedY[i]);
            }




    }



    public char isItBumpable(int current){
        return bumpable[current];

    }



    public void slowDownSpikyWallsFromRain(){


        for(int i=0;i<numberOfSpikyWallsInLevel;i++){


            speedX[i]=speedX[i]/4;
            speedY[i]=speedY[i]/4;

        }
    }



    public void restoreNormalSpeedAfterRain(int currentLevel) {


        if (currentLevel == 2) {


            speedX[0] = 2f * (float) MainActivity.ScaleWidth;
            speedX[1] = 0f;
            speedX[2] = 0f;

            speedY[0] = 0f;
            speedY[1] = 5f * (float) MainActivity.ScaleHeight;
            speedY[2] = 5f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 3) {


            speedX[0] = 3.0f * (float) MainActivity.ScaleWidth;
            speedY[0] = 2.0f * (float) MainActivity.ScaleHeight;


            speedX[1] = -3.0f * (float) MainActivity.ScaleWidth;
            speedX[2] = -3.0f * (float) MainActivity.ScaleWidth;

            speedY[1] = 3.5f * (float) MainActivity.ScaleHeight;
            speedY[2] = 3.5f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 4) {


            speedX[0] = 0f;
            speedX[1] = 0f;

            speedY[0] = 4f * (float) MainActivity.ScaleHeight;
            speedY[1] = 4f * (float) MainActivity.ScaleHeight;


            speedX[2] = 3.5f * (float) MainActivity.ScaleWidth;
            speedX[3] = -3.5f * (float) MainActivity.ScaleWidth;
            speedX[4] = 3.5f * (float) MainActivity.ScaleWidth;

            speedY[2] = 0f;
            speedY[3] = 0f;
            speedY[4] = 0f;


        } else if (currentLevel == 5) {


            speedX[0] = 2.8f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;


        } else if (currentLevel == 6) {


            speedX[0] = 4 * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;


        } else if (currentLevel == 7) {


            speedX[0] = 6f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;


            speedX[1] = -6f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0f;


        } else if (currentLevel == 8) {


            speedX[0] = 0f;
            speedY[0] = -4f * (float) MainActivity.ScaleHeight;

            speedX[1] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0f;


            speedX[2] = -2.5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0f;


            speedX[3] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0f;


            speedX[4] = -2.5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0f;


        } else if (currentLevel == 9) {


            speedX[0] = -4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 5f * (float) MainActivity.ScaleHeight;


            speedX[1] = 4f * (float) MainActivity.ScaleWidth;
            speedY[1] = 5f * (float) MainActivity.ScaleHeight;


            speedX[2] = 5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 4f * (float) MainActivity.ScaleHeight;


            speedX[3] = -5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 4f * (float) MainActivity.ScaleHeight;


            speedX[4] = 5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0f;


        } else if (currentLevel == 10) {


            speedX[0] = 4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 5f * (float) MainActivity.ScaleHeight;


            speedX[1] = -4f * (float) MainActivity.ScaleWidth;
            speedY[1] = -5f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 11) {


            speedX[0] = 4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 4f * (float) MainActivity.ScaleHeight;


            speedX[1] = -4f * (float) MainActivity.ScaleWidth;
            speedY[1] = -4f * (float) MainActivity.ScaleHeight;


            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = -4f * (float) MainActivity.ScaleHeight;


            speedX[3] = -4f * (float) MainActivity.ScaleWidth;
            speedY[3] = 4f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 12) {


            speedX[0] = 3f * (float) MainActivity.ScaleWidth;
            speedX[1] = 3f * (float) MainActivity.ScaleWidth;
            speedX[2] = 4.5f * (float) MainActivity.ScaleWidth;


            speedY[0] = 0f;
            speedY[1] = 0f;
            speedY[2] = 0f;


            speedX[3] = 4f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0;


            speedX[4] = -5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;


            speedX[5] = 6f * (float) MainActivity.ScaleWidth;
            speedY[5] = 0;


            speedX[6] = 6f * (float) MainActivity.ScaleWidth;
            speedY[6] = 0;


        } else if (currentLevel == 13) {


            speedX[0] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0;


            speedX[1] = -3.5f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0;


            speedX[2] = 3.5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0;


            speedX[3] = -2.5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0;


            speedX[4] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;


        } else if (currentLevel == 14) {


            speedX[0] = 3f * (float) MainActivity.ScaleWidth;
            speedY[0] = 2f;

            speedX[1] = -3f * (float) MainActivity.ScaleWidth;
            speedY[1] = -2f;


            speedX[2] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0;


            speedX[3] = -3.5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0;

            speedX[4] = 1.5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;


            speedX[5] = 3.5f * (float) MainActivity.ScaleWidth;
            speedY[5] = 0;


            speedX[6] = -3.5f * (float) MainActivity.ScaleWidth;
            speedY[6] = 3.5f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 15) {

            speedX[0] = 4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 4f * (float) MainActivity.ScaleHeight;


            speedX[1] = -4f * (float) MainActivity.ScaleWidth;
            speedY[1] = -4f * (float) MainActivity.ScaleHeight;


            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = -4f * (float) MainActivity.ScaleHeight;


            speedX[3] = -4f * (float) MainActivity.ScaleWidth;
            speedY[3] = 4f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 16) {


            speedX[0] = 0f;
            speedX[1] = 0f;

            speedY[0] = 4f * (float) MainActivity.ScaleHeight;
            speedY[1] = 4f * (float) MainActivity.ScaleHeight;


            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = 4f * (float) MainActivity.ScaleHeight;


            speedX[3] = -4f * (float) MainActivity.ScaleWidth;
            speedY[3] = -4f * (float) MainActivity.ScaleHeight;


            speedX[4] = 4f * (float) MainActivity.ScaleWidth;
            speedY[4] = -4f * (float) MainActivity.ScaleHeight;


            speedX[5] = -4f * (float) MainActivity.ScaleWidth;
            speedY[5] = 4f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 17) {


            speedX[0] = 0;
            speedX[1] = 0;
            speedX[2] = 0;
            speedX[3] = 0;


            speedY[0] = -5f * (float) MainActivity.ScaleWidth;
            speedY[1] = 5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 3f * (float) MainActivity.ScaleWidth;
            speedY[3] = -3f * (float) MainActivity.ScaleWidth;


            speedX[4] = 2.5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;


            speedX[5] = -3.5f * (float) MainActivity.ScaleWidth;
            speedY[5] = 0;


            speedX[6] = 3.5f * (float) MainActivity.ScaleWidth;
            speedY[6] = 0;


            speedX[7] = -2.5f * (float) MainActivity.ScaleWidth;
            speedY[7] = 0;


            speedX[8] = -1.5f * (float) MainActivity.ScaleWidth;
            speedY[8] = 0;


        } else if (currentLevel == 18) {


            speedX[0] = 6f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;

            speedX[1] = -5f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0f;


        } else if (currentLevel == 19) {


            speedX[0] = 6f * (float) MainActivity.ScaleWidth;
            speedY[0] = -4f * (float) MainActivity.ScaleHeight;


            speedX[1] = 6f * (float) MainActivity.ScaleWidth;
            speedY[1] = -4f * (float) MainActivity.ScaleHeight;


            speedX[2] = -5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0f;


            speedX[3] = 5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0f;


            speedX[4] = 5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0f;


            speedX[5] = -2f * (float) MainActivity.ScaleWidth;
            speedY[5] = -2f * (float) MainActivity.ScaleHeight;


            speedX[6] = 2f * (float) MainActivity.ScaleWidth;
            speedY[6] = 2f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 20) {


            speedX[0] = 7f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;


        } else if (currentLevel == 21) {


            speedX[0] = -4f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0f;


            speedX[1] = 6f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0f;


            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = 4f * (float) MainActivity.ScaleHeight;

            speedX[3] = -4f * (float) MainActivity.ScaleWidth;
            speedY[3] = 4f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 22) {


            speedX[0] = -4f * (float) MainActivity.ScaleWidth;
            speedY[0] = -4f * (float) MainActivity.ScaleHeight;


            speedX[1] = 4f * (float) MainActivity.ScaleWidth;
            speedY[1] = 4f * (float) MainActivity.ScaleHeight;


            speedX[2] = 2f * (float) MainActivity.ScaleWidth;
            speedY[2] = 2f * (float) MainActivity.ScaleHeight;


            speedX[3] = 2f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0f;

            speedX[4] = 0;
            speedY[4] = -2f * (float) MainActivity.ScaleWidth;


            speedX[5] = 2f * (float) MainActivity.ScaleWidth;
            speedY[5] = -2f * (float) MainActivity.ScaleWidth;


        } else if (currentLevel == 23) {


            speedX[0] = 4f * (float) MainActivity.ScaleWidth;
            speedY[0] = -4f * (float) MainActivity.ScaleHeight;


            speedX[1] = -4f * (float) MainActivity.ScaleWidth;
            speedY[1] = 4f * (float) MainActivity.ScaleHeight;


            speedX[2] = 4f * (float) MainActivity.ScaleWidth;
            speedY[2] = 4f * (float) MainActivity.ScaleHeight;


            speedX[3] = 4f * (float) MainActivity.ScaleWidth;
            speedY[3] = -4f * (float) MainActivity.ScaleHeight;


            speedX[4] = -4f * (float) MainActivity.ScaleWidth;
            speedY[4] = -4f * (float) MainActivity.ScaleHeight;


            speedX[5] = 4f * (float) MainActivity.ScaleWidth;
            speedY[5] = -4f * (float) MainActivity.ScaleHeight;


        } else if (currentLevel == 24) {


            speedX[0] = -5f * (float) MainActivity.ScaleWidth;
            speedY[0] = 0;


            speedX[1] = 5f * (float) MainActivity.ScaleWidth;
            speedY[1] = 0;


            speedX[2] = -5f * (float) MainActivity.ScaleWidth;
            speedY[2] = 0;


            speedX[3] = -5f * (float) MainActivity.ScaleWidth;
            speedY[3] = 0;


            speedX[4] = 5f * (float) MainActivity.ScaleWidth;
            speedY[4] = 0;


            speedX[5] = -5f * (float) MainActivity.ScaleWidth;
            speedY[5] = 0;


            speedX[6] = -2f * (float) MainActivity.ScaleWidth;
            speedY[6] = 0;


            speedX[7] = -7f * (float) MainActivity.ScaleWidth;
            speedY[7] = 0;


            speedX[8] = 7f * (float) MainActivity.ScaleWidth;
            speedY[8] = 0;


        }

    }



}
