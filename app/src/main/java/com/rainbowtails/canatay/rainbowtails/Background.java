package com.rainbowtails.canatay.rainbowtails;

import android.graphics.Canvas;

/**
 * Created by Can Atay on 8/13/2015.
 */
public class Background {

    int freezeCount;
    int thundeCount;


    public Background(){

        freezeCount=0;
        thundeCount=0;

    }


//Background images may change
    public void displayBackground(Canvas mCanvas,String superPowerUsed,RainbowTails rainTails){


        freezeCount=rainTails.getFreezeCount();

        //Will change to dark background when blue gem is pressed.Else draw bright background
            if (superPowerUsed == "blue") {
                thundeCount++;

                if (rainTails.isRainTailsSlipping() == true) {
                    mCanvas.drawBitmap(Assets.musicbackgroundfrozen4dark, 0, 0, null);


                } else {
                    mCanvas.drawBitmap(Assets.musicbackgrounddark, 0, 0, null);

                    if(thundeCount%45==1 || thundeCount%45==2 || thundeCount%45==3     ){
                        mCanvas.drawBitmap(Assets.thunder, 0, 0, null);

                    }else if(thundeCount%45==25 || thundeCount%45==26 || thundeCount%45==27 ){
                       // mCanvas.drawBitmap(Assets.thundertwo, 0, 0, null);
                    }

                    mCanvas.drawBitmap(Assets.blur, 0, 0, null);




                }



            } else {
                thundeCount=0;

                if (rainTails.getFreezeCount() == 0) {

                    mCanvas.drawBitmap(Assets.musicbackground, 0, 0, null);

                } else if (rainTails.getFreezeCount() == 1 || rainTails.getFreezeCount() == 2 || rainTails.getFreezeCount() == 3 || rainTails.getFreezeCount() == 4) {
                    mCanvas.drawBitmap(Assets.musicbackgroundfrozen1, 0, 0, null);
                    rainTails.increaseFreezeCount();

                } else if (rainTails.getFreezeCount()== 5 || rainTails.getFreezeCount() == 6 || rainTails.getFreezeCount() == 7 || rainTails.getFreezeCount() == 8) {
                    mCanvas.drawBitmap(Assets.musicbackgroundfrozen2, 0, 0, null);
                    rainTails.increaseFreezeCount();

                } else if (rainTails.getFreezeCount() == 9 || rainTails.getFreezeCount() == 10 || rainTails.getFreezeCount()== 11 || rainTails.getFreezeCount() == 12) {

                    mCanvas.drawBitmap(Assets.musicbackgroundfrozen3, 0, 0, null);
                    rainTails.increaseFreezeCount();


                } else if (rainTails.getFreezeCount() == 13 || rainTails.getFreezeCount() == 14 || rainTails.getFreezeCount() == 15 || rainTails.getFreezeCount() == 16 || rainTails.getFreezeCount() == 17) {
                    mCanvas.drawBitmap(Assets.musicbackgroundfrozen4, 0, 0, null);

                    if (rainTails.getFreezeCount() == 17) {

                    } else {
                        rainTails.increaseFreezeCount();
                    }
                }
            }



    }


}
