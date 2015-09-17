package com.rainbowtails.canatay.rainbowtails;

/**
 * Created by Can Atay on 6/6/2015.
 */

import android.graphics.RectF;
import android.util.Log;



public class Star {




    private RectF StarRect;
    private boolean isVisible;


    public Star(){


        StarRect=new RectF(0,0,0,0);
        isVisible=false;


    }





    public RectF getRectOStar(){


        return StarRect;
    }


    public float getPosX(){
        return StarRect.left;
    }

    public float getPosY(){
        return StarRect.top;

    }


    public void initializeStar(int currentLevel){




        if (currentLevel == 1) {

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
            StarRect.top=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2);
            StarRect.right=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2)+ Assets.star.getWidth();;
            StarRect.bottom=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2) + Assets.star.getHeight();


        } else if (currentLevel == 2) {
            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
            StarRect.top=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2);
            StarRect.right=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2)+ Assets.star.getWidth();;
            StarRect.bottom=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2) + Assets.star.getHeight();



        } else if (currentLevel == 3) {


            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
            StarRect.top=(MainActivity.ScreenHeight -Assets.bluemarker.getHeight()) - 2*(Assets.star.getHeight());
            StarRect.right=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2)+ Assets.star.getWidth();;
            StarRect.bottom=(MainActivity.ScreenHeight -Assets.bluemarker.getHeight())-(Assets.star.getHeight()) ;


        } else if (currentLevel == 4) {

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
            StarRect.top=MainActivity.ScreenHeight / 2 + (Assets.star.getHeight());
            StarRect.right=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2)+ Assets.star.getWidth();;
            StarRect.bottom=MainActivity.ScreenHeight / 2 + 2*Assets.star.getHeight();

        } else if (currentLevel == 6) {

            StarRect.left=(7*MainActivity.ScreenWidth / 9) ;
            StarRect.top=MainActivity.ScreenHeight / 9 ;
            StarRect.right=(7*MainActivity.ScreenWidth / 9)+ Assets.star.getWidth();
            StarRect.bottom=MainActivity.ScreenHeight / 9 + Assets.star.getHeight();

        } else if (currentLevel == 7) {

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
            StarRect.top=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2);
            StarRect.right=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2)+ Assets.star.getWidth();;
            StarRect.bottom=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2) + Assets.star.getHeight();
/*
        }else if (currentLevel == 8) {

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
            StarRect.top=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2);
            StarRect.right=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2)+ Assets.star.getWidth();;
            StarRect.bottom=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2) + Assets.star.getHeight();
*/
        }else if (currentLevel == 8) {

            StarRect.left = MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
            StarRect.top = MainActivity.ScreenHeight / 2 + Assets.star.getHeight();
            StarRect.right = MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2) + Assets.star.getWidth();
            StarRect.bottom = MainActivity.ScreenHeight / 2 + 2 * Assets.star.getHeight();


        }  else if (currentLevel == 9) {

                StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
                StarRect.top=MainActivity.ScreenHeight / 2 + Assets.star.getHeight();
                StarRect.right=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2)+ Assets.star.getWidth();
                StarRect.bottom=MainActivity.ScreenHeight / 2 +2* Assets.star.getHeight();

        }else if(currentLevel == 11){

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth()/2);
            StarRect.top=10*MainActivity.ScreenHeight / 20;
            StarRect.right=MainActivity.ScreenWidth / 2 + (Assets.star.getWidth()/2);
            StarRect.bottom=10*MainActivity.ScreenHeight / 20 + Assets.star.getHeight();


        }else if (currentLevel == 20) {

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2);
            StarRect.top=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2);
            StarRect.right=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth() / 2)+ Assets.star.getWidth();;
            StarRect.bottom=MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2) + Assets.star.getHeight();

        }else if(currentLevel == 12){

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth()/2);
            StarRect.top=MainActivity.ScreenHeight / 2;
            StarRect.right=MainActivity.ScreenWidth / 2 + (Assets.star.getWidth()/2);
            StarRect.bottom=MainActivity.ScreenHeight / 2 + Assets.star.getHeight();
/*
        }else if(currentLevel == 12){

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth());
            StarRect.top=6*MainActivity.ScreenHeight / 20;
            StarRect.right=MainActivity.ScreenWidth / 2 ;
            StarRect.bottom=6*MainActivity.ScreenHeight / 20 + Assets.star.getHeight();
*/


        }else if(currentLevel == 13){

            StarRect.left=MainActivity.ScreenWidth  -3* (Assets.star.getWidth());
            StarRect.top=3*MainActivity.ScreenHeight / 4;
            StarRect.right=MainActivity.ScreenWidth - 2* (Assets.star.getWidth()) ;
            StarRect.bottom=3*MainActivity.ScreenHeight / 4 + Assets.star.getHeight();

        }else if(currentLevel==16){

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth()/2);
            StarRect.top=MainActivity.ScreenHeight / 2 - 3*Assets.star.getHeight();
            StarRect.right=MainActivity.ScreenWidth / 2 + (Assets.star.getWidth()/2) ;
            StarRect.bottom=MainActivity.ScreenHeight / 2 -2* Assets.star.getHeight();


        }else if(currentLevel==17){



            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth());
            StarRect.top=(float) 16 * MainActivity.ScreenHeight / 20;
            StarRect.right=MainActivity.ScreenWidth / 2 ;
            StarRect.bottom=(float) 16 * MainActivity.ScreenHeight / 20 + Assets.star.getHeight();

        }else if(currentLevel==18){

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth()/2);
            StarRect.top=MainActivity.ScreenHeight / 2 - 2*Assets.star.getHeight();
            StarRect.right=MainActivity.ScreenWidth / 2  + (Assets.star.getWidth()/2) ;
            StarRect.bottom=MainActivity.ScreenHeight / 2 - Assets.star.getHeight();


        }else if(currentLevel==21){


            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth()/2);
            StarRect.top=9*(MainActivity.ScreenHeight/14);
            StarRect.right=MainActivity.ScreenWidth / 2  + (Assets.star.getWidth()/2) ;
            StarRect.bottom=9*(MainActivity.ScreenHeight/14) + Assets.star.getHeight();

        }else if(currentLevel==22){

            StarRect.left=MainActivity.ScreenWidth / 2 - (Assets.star.getWidth()/2);
            StarRect.top=9*(MainActivity.ScreenHeight/15);
            StarRect.right=MainActivity.ScreenWidth / 2  + (Assets.star.getWidth()/2) ;
            StarRect.bottom=9*(MainActivity.ScreenHeight/15) + Assets.star.getHeight();

        }else if(currentLevel==23){

            StarRect.left=MainActivity.ScreenWidth / 2;
            StarRect.top=MainActivity.ScreenHeight/2 -Assets.star.getWidth()/2;
            StarRect.right=MainActivity.ScreenWidth / 2  + (Assets.star.getWidth()) ;
            StarRect.bottom=MainActivity.ScreenHeight/2 + Assets.star.getWidth()/2;



        }
    }




    public void makeStarVisible(){

        isVisible=true;

    }


    public boolean isStarVisible(){

       return isVisible;

    }




    public boolean checkCollision(RectF raintails){
       


        if(raintails.intersect(StarRect)){

            return true;
        }

        return false;

    }


}


