package com.rainbowtails.canatay.rainbowtails;

import android.graphics.RectF;

/**
 * Created by Can Atay on 6/4/2015.
 */
public class LevelSelectTiles {

    private RectF tilePosition[];


    public LevelSelectTiles(){


        tilePosition=new RectF[24];
    }




    public RectF getRectOfTile(int current){

        return tilePosition[current];

    }



    public void initializeLevelSelectTiles(){


        tilePosition[0]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 1*Assets.levellocked.getWidth()/4 + Assets.levellocked.getWidth()/4 ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , Assets.levellocked.getWidth()/4  +Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[1]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  1*Assets.levellocked.getWidth()/4 + Assets.levellocked.getWidth()/4 , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2, Assets.levellocked.getWidth()/4  +Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[2]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 1*Assets.levellocked.getWidth()/4 + Assets.levellocked.getWidth()/4, 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   ,Assets.levellocked.getWidth()/4  +Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[3]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 1*Assets.levellocked.getWidth()/4 + Assets.levellocked.getWidth()/4 , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , Assets.levellocked.getWidth()/4  +Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);

        tilePosition[4]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4 ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() +Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[5]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4, 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2, 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() +Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[6]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4, 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   ,2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() +Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[7]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4, 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() +Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);


        tilePosition[8]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,3*Assets.levellocked.getWidth()/4 + 2*Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4 ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , 3*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[9]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  3*Assets.levellocked.getWidth()/4 + 2*Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4 , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2, 3*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[10]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 3*Assets.levellocked.getWidth()/4 + 2*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4 , 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   ,3*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[11]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 3*Assets.levellocked.getWidth()/4 + 2*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4  , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , 3*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);

        tilePosition[12]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  4*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4 ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 ,  4*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[13]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,   4*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4 , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2,  4*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[14]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  4*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4 , 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   , 4*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[15]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  4*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4  , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 ,  4*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);


        tilePosition[16]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  5*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4  ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 ,  5*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[17]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2 ,   5*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4 , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2,  5*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[18]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  5*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4 , 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   , 5*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[19]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  5*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4  , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 ,  5*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);


        tilePosition[20]=new RectF(  4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2 ,   6*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4 , 4*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2,  6*Assets.levellocked.getWidth()/4 + 6*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[21]=new RectF( 12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  6*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4, 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   , 6*Assets.levellocked.getWidth()/4 + 6*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[22]=new RectF(  20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2 ,   6*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4  , 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2,  6*Assets.levellocked.getWidth()/4 + 6*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);
        tilePosition[23]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  6*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight() + Assets.levellocked.getWidth()/4, 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   , 6*Assets.levellocked.getWidth()/4 + 6*Assets.levellocked.getHeight()+ Assets.levellocked.getWidth()/4);



        /*
        tilePosition[0]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() +Assets.levellocked.getHeight());
        tilePosition[1]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2, 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() +Assets.levellocked.getHeight());
        tilePosition[2]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight(), 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   ,2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() +Assets.levellocked.getHeight());
        tilePosition[3]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , 2*Assets.levellocked.getWidth()/4 + Assets.levellocked.getHeight() +Assets.levellocked.getHeight());



        tilePosition[4]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,3*Assets.levellocked.getWidth()/4 + 2*Assets.levellocked.getHeight()  ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , 3*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight());
        tilePosition[5]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  3*Assets.levellocked.getWidth()/4 + 2*Assets.levellocked.getHeight()  , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2, 3*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight());
        tilePosition[6]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 3*Assets.levellocked.getWidth()/4 + 2*Assets.levellocked.getHeight() , 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   ,3*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight());
        tilePosition[7]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  , 3*Assets.levellocked.getWidth()/4 + 2*Assets.levellocked.getHeight()  , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 , 3*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight());

        tilePosition[8]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  4*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()  ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 ,  4*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight());
        tilePosition[9]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,   4*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()  , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2,  4*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight());
        tilePosition[10]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  4*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight() , 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   , 4*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight());
        tilePosition[11]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  4*Assets.levellocked.getWidth()/4 + 3*Assets.levellocked.getHeight()  , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 ,  4*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight());


        tilePosition[12]=new RectF( 4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  5*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()  ,4* MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 ,  5*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight());
        tilePosition[13]=new RectF(  12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2 ,   5*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()  , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2,  5*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight());
        tilePosition[14]=new RectF( 20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  5*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight() , 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   , 5*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight());
        tilePosition[15]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  5*Assets.levellocked.getWidth()/4 + 4*Assets.levellocked.getHeight()  , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2 ,  5*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight());


        tilePosition[16]=new RectF(  4*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2 ,   6*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight()  , 4*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2,  6*Assets.levellocked.getWidth()/4 + 6*Assets.levellocked.getHeight());
        tilePosition[17]=new RectF( 12*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  6*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight() , 12*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   , 6*Assets.levellocked.getWidth()/4 + 6*Assets.levellocked.getHeight());
        tilePosition[18]=new RectF(  20*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2 ,   6*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight()  , 20*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2,  6*Assets.levellocked.getWidth()/4 + 6*Assets.levellocked.getHeight());
        tilePosition[19]=new RectF( 28*MainActivity.ScreenWidth/32 - Assets.levellocked.getWidth()/2  ,  6*Assets.levellocked.getWidth()/4 + 5*Assets.levellocked.getHeight() , 28*MainActivity.ScreenWidth/32 + Assets.levellocked.getWidth()/2   , 6*Assets.levellocked.getWidth()/4 + 6*Assets.levellocked.getHeight());
*/









    }
















}
