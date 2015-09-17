package com.rainbowtails.canatay.rainbowtails;

import android.graphics.RectF;

/**
 * Created by Can Atay on 8/11/2015.
 */
public class CircleSpawnSpot {

    float x, y;
    private RectF CircleRect;



    public CircleSpawnSpot() {

        x = 0;
        y = 0;
        CircleRect=new RectF(x,y,x+Assets.circlespawn.getWidth(),y+Assets.circlespawn.getHeight());

    }



    public void initializeCircleSpawnSpot(int currentLevel){


        if(currentLevel==1){

            x = 0;
            y= 120f* (float) (MainActivity.ScaleHeight);


        }else if(currentLevel==2){

            x = MainActivity.ScreenWidth/8;
            y= 120f* (float) (MainActivity.ScaleHeight);


        }else if(currentLevel==3 || currentLevel==20 || currentLevel==21){

            x = (float) (MainActivity.ScreenWidth/2) -Assets.dogleft1.getWidth()/2;
            y = 120f* (float) (MainActivity.ScaleHeight);


        }else if(currentLevel==4){

            x = (float) (MainActivity.ScreenWidth/2) -Assets.dogleft1.getWidth()/2;
            y = 120f* (float) (MainActivity.ScaleHeight);


        }else if(currentLevel==5 || currentLevel==6){

            x = (float) MainActivity.ScreenWidth/6;
            y = Assets.circlespawn.getHeight();

        }else if(currentLevel==7) {

            x = (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight() / 2));


        }else if(currentLevel==8) {

            x = (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = 120f * (float) (MainActivity.ScaleHeight);


        }else if(currentLevel==10){

            x = MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);

        }else if( currentLevel==12 ){

            x=(float) MainActivity.ScreenWidth/2-(Assets.dogright1.getWidth()/2);
            y =(float)(MainActivity.ScreenHeight-(Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()/2));


        }else if(currentLevel==9 ||  currentLevel==11 ) {

            x = (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = 120f* (float) (MainActivity.ScaleHeight);



        }else if(currentLevel==13){

            x = 0;
            y = (float) MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);


        }else if(currentLevel==14){

            x = MainActivity.ScreenWidth/2 - (Assets.dogright1.getWidth()/2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);


        }else if(currentLevel==15 || currentLevel==16){

            x = MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);

        }else if(currentLevel==17){

            x = 0;
            y= 120f* (float) (MainActivity.ScaleHeight);

        }else if(currentLevel==18 || currentLevel==19){

            x=(float) MainActivity.ScreenWidth/2-(Assets.dogright1.getWidth()/2);
            y =(float)(MainActivity.ScreenHeight-(Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()/2));

        }else if(currentLevel==22 || currentLevel==23){
            x = MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);

        }

        CircleRect.set(x, y, x + Assets.circlespawn.getWidth(), y + Assets.circlespawn.getHeight());



    }


    public RectF getCircleRect(){

        return CircleRect;

    }

}
