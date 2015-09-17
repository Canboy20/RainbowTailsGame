package com.rainbowtails.canatay.rainbowtails;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;

/**
 * Created by Can Atay on 6/9/2015.
 */
public class Painter {

    private Paint paintedWallsPaint;
    private Paint transparentTopRowPaint;
    private Paint transparentTopRowPaint2;
    private Paint levelWallsPaint;
    private Paint whiteWallsPaint;
    private Paint trailCirclePaint;
    private Paint trailCirclePaint2;
    private Paint lockableWallsPaint;
    private Paint whiteTilePaint;




    private Paint breakablelevelWallsPaint;
    private Paint worldInfoPaint;
    private Paint inkLeftPaint;
    private Paint bottomCirclePaint;
    private Context context;
    int color,color2;
    int lightbluecolor;
    int orangecolor;
    Resources res;






    public Painter(Context context){

        paintedWallsPaint=new Paint();
        transparentTopRowPaint=new Paint();
        whiteWallsPaint=new Paint();
        transparentTopRowPaint2=new Paint();
        levelWallsPaint=new Paint();
        breakablelevelWallsPaint=new Paint();
        worldInfoPaint=new Paint();
        inkLeftPaint=new Paint();
        bottomCirclePaint=new Paint();
        trailCirclePaint=new Paint();
        trailCirclePaint2=new Paint();
        lockableWallsPaint=new Paint();
        whiteTilePaint=new Paint();


        this.context=context;
        res = context.getResources();
        color = res.getColor(R.color.pink);
        lightbluecolor= res.getColor(R.color.lightblue);
        //orangecolor= res.getColor(R.color.orange);
        orangecolor= res.getColor(R.color.cottoncandy);
        color2=res.getColor(R.color.tinyline);




    }


    public Paint getTrailCirclePaint(){
        return trailCirclePaint;
    }

    public Paint getWhiteTilePaint(){
        return whiteTilePaint;
    }

    public Paint getTrailCirclePaint2(){
        return trailCirclePaint2;
    }


    public Paint getWhiteWallsPaint(){
        return whiteWallsPaint;
    }

    public Paint getPaintedWallsPaint(){

        return paintedWallsPaint;


    }


    public Paint getTransparentTopRowPaint(){

        return transparentTopRowPaint;


    }

    public Paint getLockableWallsPaint(){

        return lockableWallsPaint;


    }

    public Paint getTransparentTopRowPaint2(){

        return transparentTopRowPaint2;


    }


    public Paint getLevelWallsPaint(){

        return levelWallsPaint;


    }


    public Paint getBreakablelevelWallsPaint(){

        return breakablelevelWallsPaint;

    }




    public Paint getWorldInfoPaint(){

        return worldInfoPaint;

    }


    public Paint getInkLeftPaint(String color){


            if (color.equals("blue")) {

                inkLeftPaint.setColor(lightbluecolor);
                return inkLeftPaint;

            } else if (color.equals("green")){

                inkLeftPaint.setColor(Color.GREEN);
                return inkLeftPaint;



            }else if (color.equals("red")) {

                inkLeftPaint.setColor(Color.RED);
                return inkLeftPaint;



            }else  {

                inkLeftPaint.setColor(Color.YELLOW);
                return inkLeftPaint;


            }


    }



    public Paint getBottomCirclePaint(){

        return bottomCirclePaint;

    }


    public void updatePaintedWallsPaint(String color){




        if (color.equals("blue")) {

            paintedWallsPaint.setColor(lightbluecolor);

        } else if (color.equals("green")){

            paintedWallsPaint.setColor(Color.GREEN);


        }else if (color.equals("red")) {

            paintedWallsPaint.setColor(Color.RED);


        }else if (color.equals("yellow")) {

            paintedWallsPaint.setColor(Color.YELLOW);

        }

    }

    public void setTileAlpha(int amount){

        whiteTilePaint.setAlpha(amount);


    }




    public void initializePaint(){



        transparentTopRowPaint.setAntiAlias(true);
        transparentTopRowPaint.setColor(Color.WHITE);
        transparentTopRowPaint.setStyle(Paint.Style.STROKE);
        transparentTopRowPaint.setStrokeJoin(Paint.Join.ROUND);
        //transparentTopRowPaint.setAlpha(150);
        transparentTopRowPaint.setStrokeWidth(200f * (float) (MainActivity.ScaleHeight));

        transparentTopRowPaint2.setAntiAlias(true);
        transparentTopRowPaint2.setColor(color2);
        transparentTopRowPaint2.setStyle(Paint.Style.STROKE);
        transparentTopRowPaint2.setStrokeJoin(Paint.Join.ROUND);
        //transparentTopRowPaint.setAlpha(150);
        transparentTopRowPaint2.setStrokeWidth(205f * (float) (MainActivity.ScaleHeight));





        worldInfoPaint.setAntiAlias(true);
        worldInfoPaint.setColor(Color.RED);
        worldInfoPaint.setStyle(Paint.Style.FILL);
        worldInfoPaint.setTextSize(40 * (float) (MainActivity.ScaleHeight));




        bottomCirclePaint.setAntiAlias(true);
        transparentTopRowPaint.setStyle(Paint.Style.STROKE);
        transparentTopRowPaint.setStrokeJoin(Paint.Join.ROUND);
        bottomCirclePaint.setColor(Color.WHITE);
        transparentTopRowPaint.setAlpha(230);


        trailCirclePaint.setAntiAlias(true);
        trailCirclePaint.setColor(Color.WHITE);

        trailCirclePaint.setAlpha(160);


        trailCirclePaint2.setAntiAlias(true);
        trailCirclePaint2.setColor(Color.BLACK);

       // trailCirclePaint2.setAlpha(110);




        levelWallsPaint.setAntiAlias(true);
       // levelWallsPaint.setColor(Color.MAGENTA);
        levelWallsPaint.setColor(color);

        levelWallsPaint.setStyle(Paint.Style.STROKE);
        levelWallsPaint.setStrokeJoin(Paint.Join.ROUND);
        levelWallsPaint.setStrokeWidth(11f * (float) (MainActivity.ScaleHeight));
        levelWallsPaint.setAlpha(230);


        whiteTilePaint.setAntiAlias(true);
        // levelWallsPaint.setColor(Color.MAGENTA);
        whiteTilePaint.setColor(Color.WHITE);

        whiteTilePaint.setStyle(Paint.Style.STROKE);
        whiteTilePaint.setStrokeJoin(Paint.Join.ROUND);
        whiteTilePaint.setStrokeWidth(500f * (float) (MainActivity.ScaleHeight));
        whiteTilePaint.setAlpha(120);



        whiteWallsPaint.setAntiAlias(true);
        // levelWallsPaint.setColor(Color.MAGENTA);
        whiteWallsPaint.setColor(Color.WHITE);

        whiteWallsPaint.setStyle(Paint.Style.STROKE);
        whiteWallsPaint.setStrokeJoin(Paint.Join.ROUND);
        whiteWallsPaint.setStrokeWidth(11f * (float) (MainActivity.ScaleHeight));
        whiteWallsPaint.setAlpha(90);



        breakablelevelWallsPaint.setAntiAlias(true);
        breakablelevelWallsPaint.setColor(orangecolor);
        breakablelevelWallsPaint.setStyle(Paint.Style.STROKE);
        breakablelevelWallsPaint.setStrokeJoin(Paint.Join.ROUND);
        breakablelevelWallsPaint.setStrokeWidth(11f*(float)(MainActivity.ScaleHeight));
        breakablelevelWallsPaint.setAlpha(240);


        lockableWallsPaint.setAntiAlias(true);
        lockableWallsPaint.setColor(Color.GRAY);
        lockableWallsPaint.setStyle(Paint.Style.STROKE);
        lockableWallsPaint.setStrokeJoin(Paint.Join.ROUND);
        lockableWallsPaint.setStrokeWidth(11f*(float)(MainActivity.ScaleHeight));
        lockableWallsPaint.setAlpha(240);




        inkLeftPaint.setAntiAlias(true);
        inkLeftPaint.setColor(lightbluecolor);
        inkLeftPaint.setStyle(Paint.Style.STROKE);
        inkLeftPaint.setStrokeJoin(Paint.Join.ROUND);
        inkLeftPaint.setStrokeWidth(30f * (float) (MainActivity.ScaleHeight));
        inkLeftPaint.setAlpha(230);




        paintedWallsPaint.setAntiAlias(true);
        paintedWallsPaint.setColor(Color.YELLOW);
        paintedWallsPaint.setStyle(Paint.Style.STROKE);
        paintedWallsPaint.setStrokeJoin(Paint.Join.ROUND);
        paintedWallsPaint.setStrokeWidth(11f*(float)(MainActivity.ScaleHeight));
        paintedWallsPaint.setAlpha(230);


    }




}
