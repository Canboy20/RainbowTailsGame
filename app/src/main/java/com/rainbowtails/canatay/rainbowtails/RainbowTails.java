package com.rainbowtails.canatay.rainbowtails;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.util.Log;

/**
 * Created by Can Atay on 6/4/2015.
 */
public class RainbowTails {




    private float x,y,width,height;
    private float speedX,speedY;
    private boolean isVisible;
    private RectF RainbowTailsRect;
    private RectF comparer;
    boolean speedUp;
    boolean isSlipping;
    private boolean isProtected;
    int freezeCount;
    int numberOfTimesProtected;







    //Used for collision checkings
    double unrotatedCircleX, unrotatedCircleY;
    double closestX, closestY;
    float w ,h,dx,dy;
    float wy,hx;
    float centerXWall;
    float centerYWall;
    float useXWall;
    float useYWall;
    float tangent;


    float radians ;
    int widthOfRect;
    double distance;


    double a,b;





    public RainbowTails(float speedX, float speedY,float x,float y,float width,float height){


        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.speedX=speedX;
        this.speedY=speedY;
        isVisible=true;
        RainbowTailsRect=new RectF(x,y,x+width,y+height);
        comparer=new RectF(0,0,0,0);
        speedUp=false;
        isSlipping=false;
        isProtected=false;
        freezeCount=0;
        numberOfTimesProtected=0;


    }






    public void updateSpeedX(float newSpeedX){


        speedX= newSpeedX;


    }


    public void updateSpeedY(float newSpeedY){



        speedY=newSpeedY;

    }


    public void updatePos(){


        x=x+ speedX;
        y=y+speedY;


        RainbowTailsRect.left=x;
        RainbowTailsRect.top=y;
        RainbowTailsRect.right=x+width;
        RainbowTailsRect.bottom=y+height;
       // RainbowTailsRect=new RectF(x,y,x+width,y+height);


      //  updateRect(x, y);

    }



    public void protectRainTails(){
        isProtected=true;
    }


    public void stopProtectingRainTails(){
        isProtected=false;
    }


    public boolean isRainTailsProtected(){
        return isProtected;
    }




    public float getSpeedX(){
        return speedX;
    }



    public float getSpeedY(){
        return speedY;

    }




    public float getPosX(){
        return x;
    }



    public float getPosY(){
        return y;

    }

    public RectF getRectOfRainbowTails(){


        return RainbowTailsRect;
    }


    public float getCenterXOfRectOfRainTails(){


        return (RainbowTailsRect.right-Assets.dogright1.getWidth()/2);
    }


    public float getCenterYOfRectOfRainTails(){


        return (RainbowTailsRect.bottom-Assets.dogright1.getHeight()/2);
    }




    public void updateRect(float possX,float possY){

        RainbowTailsRect.left=possX;
        RainbowTailsRect.top=possY;
        RainbowTailsRect.right=possX+width;
        RainbowTailsRect.bottom=possX+height;

        Log.i("myAppTag", "RainbowTails x " +  RainbowTailsRect.left);

        Log.i("myAppTag", "RainbowTails y " + RainbowTailsRect.top);

        Log.i("myAppTag", "RainbowTails x2 " +  RainbowTailsRect.right);

        Log.i("myAppTag", "RainbowTails y2 " + RainbowTailsRect.bottom);


    }




    public void letRainbowTailsDisappear(){

        isVisible=false;
    }



    public boolean isRainbowTailsVisible(){


        return isVisible;

    }



    public void startFreezeCount(){

        freezeCount=1;

    }


    public int getFreezeCount(){

        return freezeCount;
    }


    public void increaseFreezeCount(){

        freezeCount++;
    }





    public void initializeRainbowTails(int currentLevel){


        if(currentLevel==1 || currentLevel==17){

           // x = (float) (Math.random() * 400 + 1);
            //y= (float) (Math.random() * 100 + 1);
            x = 0;
            y= 120f* (float) (MainActivity.ScaleHeight);

            speedX = 2f * (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;




        }else if(currentLevel==2 ){


            //Moving images pos and speed
            x = MainActivity.ScreenWidth/8;
            y= 120f* (float) (MainActivity.ScaleHeight);

            speedX = 2f* (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;

        }else if(currentLevel==3 || currentLevel==21){


            x = (float) (MainActivity.ScreenWidth/2) -Assets.dogleft1.getWidth()/2;
            y = 120f* (float) (MainActivity.ScaleHeight);


            speedX = 2f* (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;




        }else if(currentLevel==4){

            x = (float) (MainActivity.ScreenWidth/2) -Assets.dogleft1.getWidth()/2;
            y = 120f* (float) (MainActivity.ScaleHeight);


            speedX = 2f* (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;




        }else if(currentLevel==5 || currentLevel==6){

            x = (float) MainActivity.ScreenWidth/6;
            y = Assets.circlespawn.getHeight();

            speedX = 2f* (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;




        }else if(currentLevel==7 || currentLevel==18 || currentLevel==19){



            x=(float) MainActivity.ScreenWidth/2-(Assets.dogright1.getWidth()/2);
            y =(float)(MainActivity.ScreenHeight-(Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()/2));



            speedX = 2f* (float)MainActivity.ScaleWidth;

            speedY = 2f*(float)MainActivity.ScaleHeight;


        }else if(currentLevel==7 || currentLevel==12 ){

            x=(float) MainActivity.ScreenWidth/2-(Assets.dogright1.getWidth()/2);
            y =(float)(MainActivity.ScreenHeight-(Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()/2));


            speedX = 2f* (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;




        }else if(currentLevel==8 || currentLevel==9 || currentLevel==20 || currentLevel==11) {

            x = (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = 120f* (float) (MainActivity.ScaleHeight);


            speedX = 2f* (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;


        }else if(currentLevel==13){

            x = 0;
            y = (float) MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);

            speedX = 2f* (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;

        }else if(currentLevel==16 ){

            x = MainActivity.ScreenWidth/2 - (Assets.dogright1.getWidth()/2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);

            speedX = 2f* (float)MainActivity.ScaleWidth;
            speedY = 2f*(float)MainActivity.ScaleHeight;

        }else if(currentLevel==15 || currentLevel==14 || currentLevel==10 || currentLevel==22 || currentLevel==23 || currentLevel==24) {

            x = MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);

            speedX = 2f * (float) MainActivity.ScaleWidth;
            speedY = 2f * (float) MainActivity.ScaleHeight;

        }


        isVisible=true;
        RainbowTailsRect.left=x;
        RainbowTailsRect.top=y;
        RainbowTailsRect.right=x+width;
        RainbowTailsRect.bottom=y+height;
    }






    public void respawnPosition(int currentLevel){


        if(currentLevel==1 || currentLevel==17){

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
            y = Assets.circlespawn.getHeight();



        }else if(currentLevel==5 || currentLevel==6){

            x = (float) MainActivity.ScreenWidth/6;
            y = Assets.circlespawn.getHeight();




        }else if(currentLevel==7){



            x=(float) MainActivity.ScreenWidth/2-(Assets.dogright1.getWidth()/2);
            y =(float)(MainActivity.ScreenHeight-(Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()/2));



        }else if(currentLevel==8 ) {

            x = (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = 120f * (float) (MainActivity.ScaleHeight);


        }else if(currentLevel==10){

            x = MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);



        }else if(currentLevel==9 || currentLevel==11) {

            x = (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = 120f* (float) (MainActivity.ScaleHeight);



        }else if(currentLevel==12){

            x =(float) MainActivity.ScreenWidth/2-(Assets.dogright1.getWidth()/2);
            y =(float)(MainActivity.ScreenHeight-2*Assets.dogright1.getHeight());//(float) (Math.random() * (ScreenHeight-100) + ScreenHeight-200);


        }else if(currentLevel==13) {

            x = 0;
            y = (float) MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);


        }else if(currentLevel==14) {


            x = MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);


        }else if(currentLevel==15 || currentLevel==16) {

            x = MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);
            y = MainActivity.ScreenHeight / 2 - (Assets.dogright1.getHeight() / 2);


        }else if(currentLevel==18 || currentLevel==19){

            x=(float) MainActivity.ScreenWidth/2-(Assets.dogright1.getWidth()/2);
            y =(float)(MainActivity.ScreenHeight-(Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight()/2));


        }else if(currentLevel==22 || currentLevel==23){

            x =(float) MainActivity.ScreenWidth/2-(Assets.dogright1.getWidth()/2);
            y =(float)(MainActivity.ScreenHeight/2- (Assets.dogright1.getHeight()/2));//(float) (Math.random() * (ScreenHeight-100) + ScreenHeight-200);

        }

        isVisible=true;
        RainbowTailsRect.left=x;
        RainbowTailsRect.top=y;
        RainbowTailsRect.right=x+width;
        RainbowTailsRect.bottom=y+height;
    }











    public float getRespawnXposition(int currentLevel) {


        if (currentLevel == 1) {

            return (float) (Math.random() * 400 + 1);


        } else if (currentLevel == 2) {


            //Moving images pos and speed
            return (float) (Math.random() * 400 + 1);


        } else if (currentLevel == 3) {


            return (float) (MainActivity.ScreenWidth/2) -Assets.dogleft1.getWidth()/2;



        } else if (currentLevel == 4) {

            return (float) (MainActivity.ScreenWidth/2) -Assets.dogleft1.getWidth()/2;


        } else if (currentLevel == 5) {

            return (float) MainActivity.ScreenWidth/6;



        } else if (currentLevel == 6) {


            return (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);


        } else if (currentLevel == 7) {

            return (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);


        } else if (currentLevel == 8 || currentLevel == 9) {


            return (float) MainActivity.ScreenWidth / 2 - (Assets.dogright1.getWidth() / 2);


        }
        return 0;
    }







    public float getRespawnYPosition (int currentLevel){


        if(currentLevel==1){

             return (float) (Math.random() * 100 + 1);






        }else if(currentLevel==2){


            return (float) (Math.random() * 100 + 1);



        }else if(currentLevel==3){


            return Assets.circlespawn.getHeight();





        }else if(currentLevel==4){

            return Assets.circlespawn.getHeight();





        }else if(currentLevel==5){

            return Assets.circlespawn.getHeight();



        }else if(currentLevel==6 || currentLevel==12){



            return (float)(MainActivity.ScreenHeight-2*Assets.dogright1.getHeight());//(float) (Math.random() * (ScreenHeight-100) + ScreenHeight-200);




        }else if(currentLevel==7 ){



            return (float)(MainActivity.ScreenHeight-2*Assets.dogright1.getHeight());//(float) (Math.random() * (ScreenHeight-100) + ScreenHeight-200);






        }else if(currentLevel==8 || currentLevel==9) {



            return (float) (Assets.dogright1.getHeight());//(float) (Math.random() * (ScreenHeight-100) + ScreenHeight-200);



        }else if(currentLevel==13){



        }

        return 0;
    }







    public void returnToOriginalSpeed() {


        if(isSlipping==false) {
            if (speedX > 0) {
                speedX = 2f * (float) MainActivity.ScaleWidth;

            } else {
                speedX = -2f * (float) MainActivity.ScaleWidth;

            }


            if (speedY > 0) {
                speedY = 2f * (float) MainActivity.ScaleHeight;
            } else {
                speedY = -2f * (float) MainActivity.ScaleHeight;
            }

        }else{

            if (speedX > 0) {
                speedX = 7f * (float) MainActivity.ScaleWidth;

            } else {
                speedX = -7f * (float) MainActivity.ScaleWidth;

            }


            if (speedY > 0) {
                speedY = 7f * (float) MainActivity.ScaleHeight;
            } else {
                speedY = -7f * (float) MainActivity.ScaleHeight;
            }

        }

    }




    public void checkCollisionWithPaintedWalls(RectF PaintedWalls,String PaintedWallsColor,int currentAnalyzedWall,PlayerPaintedWalls ppw){



/*

            comparer.left=(float)PaintedWalls.left;
            comparer.top=(float)PaintedWalls.top;
            comparer.right=(float)PaintedWalls.right;
            comparer.bottom=(float)PaintedWalls.bottom;










            if(comparer.intersect(RainbowTailsRect)) {


                centerXWall=(float)PaintedWalls.left + PaintedWalls.width()/2;
                 centerYWall=(float)PaintedWalls.top + PaintedWalls.height()/2;
                useXWall=(float)PaintedWalls.left;
                useYWall=(float)PaintedWalls.top;
                 tangent=(centerYWall-useYWall)/(centerXWall-useXWall);


                 radians = (float)Math.toRadians(tangent);




                widthOfRect=(int)Math.sqrt((PaintedWalls.bottom - PaintedWalls.top + 10) * (PaintedWalls.bottom - PaintedWalls.top + 10) + (PaintedWalls.right - 10 - PaintedWalls.left) * (PaintedWalls.right - 10 - PaintedWalls.left));

                // Rotate circle's center point back
                 unrotatedCircleX = Math.cos(radians) * ((RainbowTailsRect.left+RainbowTailsRect.width()/2) - centerXWall) -
                        Math.sin(radians) * ((RainbowTailsRect.top+RainbowTailsRect.height()/2) - centerYWall) + centerXWall;
                 unrotatedCircleY  = Math.sin(radians) * ((RainbowTailsRect.left+RainbowTailsRect.width()/2) - centerXWall) +
                        Math.cos(radians) * ((RainbowTailsRect.top+RainbowTailsRect.height()/2) - centerYWall) + centerYWall;

// Closest point in the rectangle to the center of circle rotated backwards(unrotated)


// Find the unrotated closest x point from center of unrotated circle
                if (unrotatedCircleX  < centerXWall-widthOfRect/2)
                    closestX = centerXWall-widthOfRect/2;
                else if (unrotatedCircleX  > centerXWall+widthOfRect/2)
                    closestX = centerXWall+widthOfRect/2;
                else
                    closestX = unrotatedCircleX ;

// Find the unrotated closest y point from center of unrotated circle
                if (unrotatedCircleY < centerYWall-10)
                    closestY = centerYWall-10;
                else if (unrotatedCircleY > centerYWall+10)
                    closestY = centerYWall+10;
                else
                    closestY = unrotatedCircleY;

// Determine collision

                distance = findDistance(unrotatedCircleX , unrotatedCircleY, closestX, closestY);
                if (distance < RainbowTailsRect.width()/2) {
*/

                    w = (float) (0.5 * (PaintedWalls.width() + RainbowTailsRect.width()));
                     h = (float) (0.5 * (PaintedWalls.height() + RainbowTailsRect.height()));
                    dx = PaintedWalls.centerX() - RainbowTailsRect.centerX();
                     dy = PaintedWalls.centerY() - RainbowTailsRect.centerY();

                    if (Math.abs(dx) <= w && Math.abs(dy) <= h) {


                       wy = w * dy;
                         hx = h * dx;

                        if (wy > hx) {
                            if (wy > -hx) {

                                speedY=(-Math.abs(speedY));

                                // collision at the top
                            } else {


                                speedX=(Math.abs(speedX));


                                // on the left
                            }


                        } else {
                            if (wy > -hx) {

                                speedX=( -Math.abs(speedX));
                                // on the right
                            } else {
                                speedY=( Math.abs(speedY));
                                // at the bottom

                            }
                        }


                        if(PaintedWallsColor.equals("yellow")) {


                            Assets.playSound(Assets.warpID);
                            ppw.deleteYellowWall(currentAnalyzedWall);
                            respawnPosition(GameView.currentLevel);


                        }else if(PaintedWallsColor.equals("blue")){

                            ppw.deleteBumpedWall(currentAnalyzedWall);


                        }else if(PaintedWallsColor.equals("green")){

                            GameView.speedUpNow=true;
                            ppw.deleteBumpedWall(currentAnalyzedWall);






                        }


                    }



/*
                } else {



                }


            }






*/




    }




public void bumpMusicPipe(RectF PaintedWalls){

    w = (float) (0.5 * (PaintedWalls.width() + RainbowTailsRect.width()));
    h = (float) (0.5 * (PaintedWalls.height() + RainbowTailsRect.height()));
    dx = PaintedWalls.centerX() - RainbowTailsRect.centerX();
    dy = PaintedWalls.centerY() - RainbowTailsRect.centerY();

    if (Math.abs(dx) <= w && Math.abs(dy) <= h) {


        wy = w * dy;
        hx = h * dx;

        if (wy > hx) {
            if (wy > -hx) {

                speedY = (-Math.abs(speedY));

                // collision at the top
            } else {


                speedX = (Math.abs(speedX));


                // on the left
            }


        } else {
            if (wy > -hx) {

                speedX = (-Math.abs(speedX));
                // on the right
            } else {
                speedY = (Math.abs(speedY));
                // at the bottom

            }
        }
    }



    }




    public double findDistance(double fromX, double fromY, double toX, double toY){
         a = Math.abs(fromX - toX);
        b = Math.abs(fromY - toY);

        return Math.sqrt((a * a) + (b * b));
    }





    public boolean isRainTailsSlipping(){
        return isSlipping;
    }


    public void letRainTailsSlip(){
        isSlipping=true;

    }



    public void setRainTailsSlipSpeed(){

        if(speedX>0){
            speedX=7f* (float) MainActivity.ScaleWidth;
        }else{
            speedX=-7f* (float) MainActivity.ScaleWidth;
        }

        if(speedY>0){
            speedY=7* (float) MainActivity.ScaleHeight;
        }else{
            speedY=-7f* (float) MainActivity.ScaleHeight;
        }


    }


    public int getNumberOfTimesProtected(){

        return numberOfTimesProtected;
    }


    public void increaseNumberOfTimesProtected(){

        numberOfTimesProtected++;
    }



    public void setOriginalSpeedBack(){


        if(isSlipping==false) {

            if(speedX>0) {
                speedX = 2f * (float) MainActivity.ScaleWidth;
            }else{
                speedX = -2f * (float) MainActivity.ScaleWidth;

            }


            if(speedY>0) {
                speedY = 2f * (float) MainActivity.ScaleHeight;
            }else{
                speedY = -2f * (float) MainActivity.ScaleHeight;

            }


        }else{

            if(speedX>0) {
                speedX = 7f * (float) MainActivity.ScaleWidth;
            }else{
                speedX = -7f * (float) MainActivity.ScaleWidth;

            }


            if(speedY>0) {
                speedY = 7f * (float) MainActivity.ScaleHeight;
            }else{
                speedY = -7f * (float) MainActivity.ScaleHeight;

            }

        }

    }
}
