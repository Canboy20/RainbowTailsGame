package com.rainbowtails.canatay.rainbowtails;

import android.graphics.RectF;

/**
 * Created by Can Atay on 6/6/2015.
 */



public class Freezor {


    private RectF[] FreezorRect;
    boolean pressed;


    public Freezor() {


        FreezorRect = new RectF[3];
        FreezorRect[0]=new RectF(0,0,0,0);
        FreezorRect[1]=new RectF(0,0,0,0);
        FreezorRect[2]=new RectF(0,0,0,0);

        pressed=false;

    }


    public void initializeFreezor(int currentLevel) {

        if(currentLevel==7){

            FreezorRect[0].left=MainActivity.ScreenWidth/4+Assets.freezeButton.getWidth();
            FreezorRect[0].top=3* MainActivity.ScreenHeight/4+Assets.freezeButton.getHeight();
            FreezorRect[0].right=MainActivity.ScreenWidth/4 +2*Assets.freezeButton.getWidth();
            FreezorRect[0].bottom=3* (MainActivity.ScreenHeight/4)+2*Assets.freezeButton.getHeight();


            FreezorRect[1].left=3*(MainActivity.ScreenWidth/4)-2*Assets.freezeButton.getWidth();
            FreezorRect[1].top=3*MainActivity. ScreenHeight/4+Assets.freezeButton.getHeight();
            FreezorRect[1].right= 3*(MainActivity.ScreenWidth/4)- Assets.freezeButton.getWidth();
            FreezorRect[1].bottom=3* (MainActivity.ScreenHeight/4)+2*Assets.freezeButton.getHeight();

            FreezorRect[2].left=(MainActivity.ScreenWidth/2)-Assets.freezeButton.getWidth()/2 ;
            FreezorRect[2].top=3*MainActivity. ScreenHeight/4;
            FreezorRect[2].right= (MainActivity.ScreenWidth/2) + Assets.freezeButton.getWidth()/2;
            FreezorRect[2].bottom=3* (MainActivity.ScreenHeight/4) + Assets.freezeButton.getHeight();



        }else if(currentLevel==8) {


            FreezorRect[0].left = (3 * (MainActivity.ScreenWidth / 4))- Assets.freezeButton.getWidth();
            FreezorRect[0].top = 3*MainActivity.ScreenHeight / 22;
            FreezorRect[0].right = 3 * (MainActivity.ScreenWidth / 4);
            FreezorRect[0].bottom = (3*MainActivity.ScreenHeight / 22) + Assets.freezeButton.getHeight();





        }else if(currentLevel==20){

            FreezorRect[0].left = 2*MainActivity.ScreenWidth / 20 ;
            FreezorRect[0].top = 6 * MainActivity.ScreenHeight / 20;
            FreezorRect[0].right = 2*MainActivity.ScreenWidth / 20 + Assets.freezeButton.getWidth();
            FreezorRect[0].bottom = 6 * MainActivity.ScreenHeight / 20 + Assets.freezeButton.getHeight();

            FreezorRect[1].left = 3 * (MainActivity.ScreenWidth / 4);
            FreezorRect[1].top = 6*MainActivity.ScreenHeight / 20;
            FreezorRect[1].right = 3 * (MainActivity.ScreenWidth / 4) + Assets.freezeButton.getWidth();
            FreezorRect[1].bottom = (6*MainActivity.ScreenHeight / 20) + Assets.freezeButton.getHeight();

        }else if(currentLevel==13){

            FreezorRect[0].left = 5*MainActivity.ScreenWidth / 20 ;
            FreezorRect[0].top =  MainActivity.ScreenHeight / 2-Assets.freezeButton.getHeight()/2;
            FreezorRect[0].right = 5*MainActivity.ScreenWidth / 20 + Assets.freezeButton.getWidth();
            FreezorRect[0].bottom =  MainActivity.ScreenHeight / 2 +Assets.freezeButton.getHeight()/2;

            FreezorRect[1].left = 5*MainActivity.ScreenWidth / 20 ;
            FreezorRect[1].top =  MainActivity.ScreenHeight / 2 -Assets.freezeButton.getHeight()/2;
            FreezorRect[1].right = 5*MainActivity.ScreenWidth / 20 + Assets.freezeButton.getWidth();
            FreezorRect[1].bottom =  MainActivity.ScreenHeight / 2 + Assets.freezeButton.getHeight()/2;


        }else if(currentLevel==18) {

            FreezorRect[0].left =MainActivity.ScreenWidth / 2 - Assets.freezeButton.getWidth()/2 ;
            FreezorRect[0].top = (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight() + Assets.freezeButton.getHeight()));
            FreezorRect[0].right = MainActivity.ScreenWidth / 2 + Assets.freezeButton.getWidth()/2;
            FreezorRect[0].bottom = (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()));

            FreezorRect[1].left =MainActivity.ScreenWidth / 2 - Assets.freezeButton.getWidth()/2 ;
            FreezorRect[1].top = (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight() + Assets.freezeButton.getHeight()));
            FreezorRect[1].right = MainActivity.ScreenWidth / 2 + Assets.freezeButton.getWidth()/2;
            FreezorRect[1].bottom = (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()));



        }else if(currentLevel==19){


            FreezorRect[0].left =MainActivity.ScreenWidth / 2 - Assets.freezeButton.getWidth()/2 ;
            FreezorRect[0].top = (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight() + Assets.freezeButton.getHeight()));
            FreezorRect[0].right = MainActivity.ScreenWidth / 2 + Assets.freezeButton.getWidth()/2;
            FreezorRect[0].bottom = (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()));

            FreezorRect[1].left=MainActivity.ScreenWidth/4+Assets.freezeButton.getWidth();
            FreezorRect[1].top=3* MainActivity.ScreenHeight/4+Assets.freezeButton.getHeight();
            FreezorRect[1].right=MainActivity.ScreenWidth/4 +2*Assets.freezeButton.getWidth();
            FreezorRect[1].bottom=3* (MainActivity.ScreenHeight/4)+2*Assets.freezeButton.getHeight();


            FreezorRect[2].left=3*(MainActivity.ScreenWidth/4)-2*Assets.freezeButton.getWidth();
            FreezorRect[2].top=3*MainActivity. ScreenHeight/4+Assets.freezeButton.getHeight();
            FreezorRect[2].right= 3*(MainActivity.ScreenWidth/4)- Assets.freezeButton.getWidth();
            FreezorRect[2].bottom=3* (MainActivity.ScreenHeight/4)+2*Assets.freezeButton.getHeight();




        }else if(currentLevel==24){



            FreezorRect[0].left =MainActivity.ScreenWidth / 2 - Assets.freezeButton.getWidth()/2 ;
            FreezorRect[0].top = MainActivity.ScreenHeight/2 - Assets.freezeButton.getWidth()/2;
            FreezorRect[0].right = MainActivity.ScreenWidth / 2 + Assets.freezeButton.getWidth()/2;
            FreezorRect[0].bottom = MainActivity.ScreenHeight/2 + Assets.freezeButton.getWidth()/2;

            FreezorRect[1].left =MainActivity.ScreenWidth / 2 + Assets.freezeButton.getWidth()/2 ;
            FreezorRect[1].top = MainActivity.ScreenHeight/2 - Assets.freezeButton.getWidth()/2;
            FreezorRect[1].right = MainActivity.ScreenWidth / 2 + 3*Assets.freezeButton.getWidth()/2;
            FreezorRect[1].bottom = MainActivity.ScreenHeight/2 + Assets.freezeButton.getWidth()/2;


        }

        }



    public RectF getFreezorRect(int i) {

    return FreezorRect[i];

    }


    public void pressFreezor(){


        pressed=true;

    }

    public boolean checkIfFreezorIsPressed(){

        return pressed;

    }

    }