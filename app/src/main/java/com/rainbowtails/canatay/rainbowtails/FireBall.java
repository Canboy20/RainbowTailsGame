package com.rainbowtails.canatay.rainbowtails;

import android.graphics.RectF;
import android.util.Log;

import java.util.Random;

/**
 * Created by Can Atay on 6/4/2015.
 */
public class FireBall {


    private float[] x,y;
    private float[] speedX,speedY;
    private RectF[] fireBallRect;
    private int numberOfFireballs;
    private int randomer;



    public FireBall(){

        x=new float[15];
        y=new float[15];
        speedX=new float[15];
        speedY=new float[15];

        fireBallRect=new RectF[15];
        for(int i=0;i<15;i++){

            fireBallRect[i]=new RectF(0,0,Assets.fireball.getWidth(),Assets.fireball.getHeight());
        }
        numberOfFireballs=0;

    }




    public void updateSpeedX(float newSpeedX,int current){

        speedX[current]= newSpeedX;

    }



    public void updateSpeedY(float newSpeedY,int current){

        speedY[current]=newSpeedY;

    }



    public void updatePos(int currentlevel){

        for(int i=0;i<numberOfFireballs;i++) {
            x[i] = x[i] + speedX[i];
            y[i] = y[i] + speedY[i];

           /* if(currentlevel==1 || currentlevel==2 || currentlevel==3){

                if(y[1]>MainActivity.ScreenHeight -( 2*Assets.bluemarker.getHeight())) {
                    x[1]=Assets.fireball.getWidth()/2 - Assets.fireball.getWidth();
                    y[1]= MainActivity.ScreenHeight/3 - Assets.purplegem.getHeight()/2 + 2*Assets.fireball.getHeight();

                }

                if(y[2]>MainActivity.ScreenHeight -( 2*Assets.bluemarker.getHeight())) {
                    x[2]=MainActivity.ScreenWidth - (Assets.fireball.getWidth()/2 - Assets.fireball.getWidth());
                    y[2]= MainActivity.ScreenHeight/3 - Assets.purplegem.getHeight()/2 + 2*Assets.fireball.getHeight();

                }


            }else if(currentlevel==6){

                if(x[0]<2*Assets.fireball.getWidth()){

                    x[0]=MainActivity.ScreenWidth/2-Assets.fireball.getWidth()/2;
                    y[0]=MainActivity.ScreenHeight/2 - Assets.fireball.getHeight();

                    x[3]=MainActivity.ScreenWidth/2-Assets.fireball.getWidth()/2;
                    y[3]=MainActivity.ScreenHeight/2 - Assets.fireball.getHeight();
                }

                if(x[2]+Assets.fireball.getWidth()>MainActivity.ScreenWidth - 2*Assets.fireball.getWidth()){
                    x[2]=MainActivity.ScreenWidth/2-Assets.fireball.getWidth()/2;
                    y[2]=MainActivity.ScreenHeight/2 - Assets.fireball.getHeight();

                    x[4]=MainActivity.ScreenWidth/2-Assets.fireball.getWidth()/2;
                    y[4]=MainActivity.ScreenHeight/2 - Assets.fireball.getHeight();

                }


                if(y[1]<2*Assets.fireball.getHeight()){

                    x[1]=MainActivity.ScreenWidth/2-Assets.fireball.getWidth()/2;
                    y[1]=MainActivity.ScreenHeight/2 - Assets.fireball.getHeight();


                }


            }*/





            fireBallRect[i].left = x[i];
            fireBallRect[i].top = y[i];
            fireBallRect[i].right = x[i] + Assets.fireball.getWidth();
            fireBallRect[i].bottom = y[i] + Assets.fireball.getWidth();
        }

    }




    public float getSpeedX(int current){
        return speedX[current];
    }



    public float getSpeedY(int current){
        return speedY[current];

    }




    public float getPosX(int current){
        return x[current];
    }



    public float getPosY(int current){
        return y[current];

    }

    public RectF getRectOfFireBall(int current){


        return fireBallRect[current];
    }





    public void updateRect(float possX,float possY,int k){

        fireBallRect[k].left=possX;
        fireBallRect[k].top=possY;
        fireBallRect[k].right=possX+Assets.fireball.getWidth();
        fireBallRect[k].bottom=possX+Assets.fireball.getHeight();




    }




    public void initializeFireBall(int currentLevel){


        if(currentLevel==1 || currentLevel==2 || currentLevel==3){
            numberOfFireballs = 3;



            for(int i=0;i<numberOfFireballs;i++) {


                x[i] = (float) (Math.random() * MainActivity.ScreenWidth-2*Assets.fireball.getWidth() + 2*Assets.fireball.getWidth());
                y[i] = (float) (Math.random() * 400 + 600);


               randomer =(int)Math.random()*2;

                if(randomer%2==0){
                    speedX[i] = - 3.0f * (float) MainActivity.ScaleWidth;
                    speedY[i] = -3.0f * (float) MainActivity.ScaleHeight;

                }else{

                    speedX[i] =  3.0f * (float) MainActivity.ScaleWidth;
                    speedY[i] =  3.0f * (float) MainActivity.ScaleHeight;

                }

            }







        }else if(currentLevel==2){

            numberOfFireballs = 2;

            for(int i=0;i<numberOfFireballs;i++) {

                //Fire pos and speed
                x[i] = (float) (Math.random() * 400 + 1);
                y[i] = (float) (Math.random() * 700 + 400);

                speedX[i] = 2f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2f * (float) MainActivity.ScaleHeight;
            }




        }else if(currentLevel==3){

            numberOfFireballs=3;

            for(int i=0;i<numberOfFireballs;i++) {

                int p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    x[i] = (float) (Math.random() * 200) + 1;
                    y[i] = (float) (Math.random() * 400) + 500;

                } else {
                    x[i] = (float) (Math.random() * (MainActivity.ScreenWidth/2))+ MainActivity.ScreenWidth/2;
                    y[i] = (float) (Math.random() * 400) + 500;

                }


                //Fire pos and speed
                p = (int) (Math.random() * 10);
                if (p % 2 == 0) {
                    speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;
                } else {
                    speedX[i] = -2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = -2.5f * (float) MainActivity.ScaleHeight;

                }
            }


        }else if(currentLevel==4){

            numberOfFireballs = 0;

            for(int i=0;i<numberOfFireballs;i++) {

                int p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    x[i] = (float) (Math.random() * 200 + 1);
                    y[i] = (float) (Math.random() * 400 + 300);

                } else {
                    x[i] = (float) (Math.random() * (MainActivity.ScreenWidth) + (MainActivity.ScreenWidth - 200));
                    y[i] = (float) (Math.random() * 400 + 300);
                }


                //Fire pos and speed
                p = (int) (Math.random() * 10);
                if (p % 2 == 0) {
                    speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;
                } else {
                    speedX[i] = -2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = -2.5f * (float) MainActivity.ScaleHeight;

                }
            }




        }else if(currentLevel==5){

            numberOfFireballs = 14;

            for(int i=0;i<numberOfFireballs;i++) {

                //Fire pos and speed
                x[i] = (float) (Math.random() * (7 * (MainActivity.ScreenWidth / 8))) ;

                y[i] = (float) (Math.random() * (6 * (MainActivity.ScreenHeight / 8)) + ((3*MainActivity.ScreenHeight / 8)));

                int p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    speedX[i] = 3f * (float) MainActivity.ScaleWidth;
                } else {
                    speedX[i] = -3f * (float) MainActivity.ScaleWidth;

                }

                p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    speedY[i] = 3f * (float) MainActivity.ScaleHeight;
                } else {
                    speedY[i] = -3f * (float) MainActivity.ScaleHeight;

                }
            }




        }else if(currentLevel==6 || currentLevel==21){


            numberOfFireballs=3;

            for(int i=0;i<numberOfFireballs;i++) {

                int p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    x[i] = (float) (Math.random() * 200) + 1;
                    y[i] = (float) (Math.random() * 400) + 500;

                } else {
                    x[i] = (float) (Math.random() * (MainActivity.ScreenWidth/2))+ MainActivity.ScreenWidth/2;
                    y[i] = (float) (Math.random() * 400) + 500;

                }


                //Fire pos and speed
                p = (int) (Math.random() * 10);
                if (p % 2 == 0) {
                    speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;
                } else {
                    speedX[i] = -2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = -2.5f * (float) MainActivity.ScaleHeight;

                }
            }

         /*   numberOfFireballs = 5;
            for(int i=0;i<numberOfFireballs;i++) {


                x[i]=MainActivity.ScreenWidth/2-Assets.fireball.getWidth()/2;
                y[i]=MainActivity.ScreenHeight/2 - Assets.fireball.getHeight()/2;


            }

            speedX[0]=-2f;
            speedY[0]=-1f;

            speedX[1]=0f;
            speedY[1]=-1f;

            speedX[2]=2f;
            speedY[2]=-1f;

            speedX[3]=-1f;
            speedY[3]=1f;

            speedX[4]=1f;
            speedY[4]=1f;*/




        }else if(currentLevel==67 || currentLevel==7 || currentLevel==8 || currentLevel==9 ){


            for(int i=0;i<8;i++) {

                //Fire pos and speed
                x[i] = (float) (Math.random() * 400 + 1);

                y[i] = (float) (Math.random() * 300 + 500);


                int p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                } else {
                    speedX[i] = -2.5f * (float) MainActivity.ScaleWidth;

                }


                p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;
                } else {
                    speedY[i] = -2.5f * (float) MainActivity.ScaleHeight;

                }
            }
            if(currentLevel==6) {
                numberOfFireballs = 6;
            }else{
                numberOfFireballs = 3;

            }




        }else if(currentLevel==20 || currentLevel==11 || currentLevel==14 ){
            for(int i=0;i<8;i++) {

                //Fire pos and speed
                x[i] = (float) (Math.random() * 400 + 1);

                y[i] = (float) (Math.random() * 300 + 500);


                int p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    speedX[i] = 3.5f  * (float) MainActivity.ScaleWidth;
                } else {
                    speedX[i] = -3.5f  * (float) MainActivity.ScaleWidth;

                }


                p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    speedY[i] = 3.5f  * (float) MainActivity.ScaleHeight;
                } else {
                    speedY[i] = -3.5f * (float) MainActivity.ScaleHeight;

                }
            }
            numberOfFireballs = 5;

        } else if(currentLevel==15) {


            for (int i = 0; i < 8; i++) {

                int p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    x[i] = (float) (Math.random() * 200) + 1;
                    y[i] = (float) (Math.random() * 400) + 500;

                } else {
                    x[i] = (float) (Math.random() * (MainActivity.ScreenWidth / 2)) + MainActivity.ScreenWidth / 2;
                    y[i] = (float) (Math.random() * 400) + 500;


                }


                //Fire pos and speed
                p = (int) (Math.random() * 10);
                if (p % 2 == 0) {
                    speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;
                } else {
                    speedX[i] = -2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = -2.5f * (float) MainActivity.ScaleHeight;

                }
            }

            numberOfFireballs = 7;


        }else if(currentLevel==10 || currentLevel==18) {


            for (int i = 0; i < 8; i++) {

                int p = (int) (Math.random() * 10);

                if (p % 2 == 0) {
                    x[i] = (float) (Math.random() * 200) + 1;
                    y[i] = (float) (Math.random() * 400) + 500;

                } else {
                    x[i] = (float) (Math.random() * (MainActivity.ScreenWidth / 2)) + MainActivity.ScreenWidth / 2;
                    y[i] = (float) (Math.random() * 400) + 500;


                }


                //Fire pos and speed
                p = (int) (Math.random() * 10);
                if (p % 2 == 0) {
                    speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;
                } else {
                    speedX[i] = -2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = -2.5f * (float) MainActivity.ScaleHeight;

                }
            }

            if(currentLevel==17) {
                numberOfFireballs = 4;
            }else{
                numberOfFireballs=7;
            }

        }else if(currentLevel==22){


            numberOfFireballs = 5;

            for (int i = 0; i < numberOfFireballs; i++) {


                Random generator = new Random();
                int p = generator.nextInt(10) + 1;

                    x[i] =generator.nextInt(((MainActivity.ScreenWidth ) -3*MainActivity.ScreenWidth/4) + 1) + 3*MainActivity.ScreenWidth/4; //(float)(Math.random()* (MainActivity.ScreenWidth )) + 3*MainActivity.ScreenWidth/4 ;
                    y[i] =generator.nextInt(((MainActivity.ScreenHeight ) - 2*MainActivity.ScreenHeight/3 ) + 1) +  2*MainActivity.ScreenHeight/3 ; //(float)(Math.random()* (MainActivity.ScreenHeight )) +  2*MainActivity.ScreenHeight/3 ;






                //Fire pos and speed
                p = (int) (Math.random() * 10);
                if (p % 2 == 0) {
                    speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;
                } else {
                    speedX[i] = -2.5f * (float) MainActivity.ScaleWidth;
                    speedY[i] = -2.5f * (float) MainActivity.ScaleHeight;

                }
            }




        }



        for(int i=0;i<8;i++) {

            updateRect(x[i], y[i],i);
        }
    }








    public int getNumberOfFireballs(){
        return numberOfFireballs;
    }




    public void decreaseNumberOfFireballs(){

        numberOfFireballs--;
    }







    public void respawnPosition(int currentLevel,int i){


        if(currentLevel==1){

                //Fire pos and speed
                x[i] = (float) (Math.random() * 400 + 1);
                y[i] = (float) (Math.random() * 400 + 600);



        }else if(currentLevel==2){


                //Fire pos and speed
                x[i] = (float) (Math.random() * 400 + 1);
                y[i] = (float) (Math.random() * 700 + 400);




        }else if(currentLevel==3){

                //Fire pos and speed
                x[i] = (float) (Math.random() * 400 + 1);
                y[i] = (float) (Math.random() * 400 + 300);





        }else if(currentLevel==4){

            //Fire pos and speed

                x[i] = (float) (Math.random() * 400 + 1);
                y[i] = (float) (Math.random() * 400 + 500);







        }else if(currentLevel==5){

                //Fire pos and speed
                x[i] = (float) (Math.random() * 400 + 1);

                y[i] = (float) (Math.random() * 300 + 500);









        }else if(currentLevel==6 || currentLevel==7 || currentLevel==8 || currentLevel==9){


                //Fire pos and speed
                x[i] = (float) (Math.random() * 400 + 1);

                y[i] = (float) (Math.random() * 300 + 500);






        }else if(currentLevel==20){

            x[i] = (float) (Math.random() * 400 + 1);

            y[i] = (float) (Math.random() * 300 + 500);



        }


            updateRect(x[i], y[i],i);

    }



    public void slowDownMusicalNotesFromRain(){


        for(int i=0;i<numberOfFireballs;i++) {


            speedX[i]=speedX[i]/2;
            speedY[i]=speedY[i]/2;

        }

    }




    public void restoreSpeedFromRain(int currentLevel) {


        if (currentLevel == 1) {

            for (int i = 0; i < numberOfFireballs; i++) {

                speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 2) {


            for (int i = 0; i < numberOfFireballs; i++) {

                speedX[i] = 2f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2f * (float) MainActivity.ScaleHeight;
            }


        } else if (currentLevel == 3) {


            for (int i = 0; i < numberOfFireballs; i++) {


                speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 4) {


            for (int i = 0; i < numberOfFireballs; i++) {

                speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 5) {


            for (int i = 0; i < numberOfFireballs; i++) {


                speedX[i] = 3f * (float) MainActivity.ScaleWidth;
                speedY[i] = 3f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 6 || currentLevel == 21) {


            for (int i = 0; i < numberOfFireballs; i++) {


                speedX[i] = 2.8f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2.8f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 67 || currentLevel == 7 || currentLevel == 8 || currentLevel == 9) {


            for (int i = 0; i < numberOfFireballs; i++) {


                speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;


                speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 20 || currentLevel == 11 || currentLevel == 14) {


            for (int i = 0; i < numberOfFireballs; i++) {


                speedX[i] = 3.5f * (float) MainActivity.ScaleWidth;
                speedY[i] = 3.5f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 15) {


            for (int i = 0; i < numberOfFireballs; i++) {


                speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 10 || currentLevel == 18) {


            for (int i = 0; i < numberOfFireballs; i++) {

                int p = (int) (Math.random() * 10);


                speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;

            }


        } else if (currentLevel == 22) {


            for (int i = 0; i < numberOfFireballs; i++) {


                speedX[i] = 2.5f * (float) MainActivity.ScaleWidth;
                speedY[i] = 2.5f * (float) MainActivity.ScaleHeight;

            }


        }
    }








    public boolean checkCollisionsRainTailsWithFireball(RainbowTails rainTails){


        for(int i=0;i<numberOfFireballs;i++){

            if(rainTails.getRectOfRainbowTails().intersect(fireBallRect[i]) && rainTails.isRainTailsProtected()==false){
                return true;
            }

        }

        return false;
    }















}
