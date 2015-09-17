package com.rainbowtails.canatay.rainbowtails;

import android.content.res.AssetManager;
import android.graphics.RectF;

/**
 * Created by Can Atay on 6/6/2015.
 */
public class Gem {

    private RectF[] GemRect;
    private int numberOfGemsCollected;


    public Gem(){


        GemRect=new RectF[8];

        GemRect[0]=new RectF(0,0,0,0);
        GemRect[1]=new RectF(0,0,0,0);
        GemRect[2]=new RectF(0,0,0,0);
        GemRect[3]=new RectF(0,0,0,0);
        GemRect[4]=new RectF(0,0,0,0);
        GemRect[5]=new RectF(0,0,0,0);
        GemRect[6]=new RectF(0,0,0,0);
        GemRect[7]=new RectF(0,0,0,0);



        numberOfGemsCollected=0;



    }





    public RectF getRectOfGem(int current){


        return GemRect[current];
    }




    public void initializeGem(int currentLevel){


        if(currentLevel==1){

            GemRect[0].left=(2*MainActivity.ScreenWidth/8)-Assets.gemright.getWidth()/2;
            GemRect[0].top=13*(MainActivity.ScreenHeight/16);
            GemRect[0].right= (2*MainActivity.ScreenWidth/8)-Assets.gemright.getWidth()/2+(Assets.gemright.getWidth());
            GemRect[0].bottom=13*(MainActivity.ScreenHeight/16)+(Assets.gemright.getHeight());


            GemRect[1].left=5*(MainActivity.ScreenWidth/8);
            GemRect[1].top=13*(MainActivity.ScreenHeight/16);
            GemRect[1].right=  (5*(MainActivity.ScreenWidth/8))+(Assets.gemright.getWidth());
            GemRect[1].bottom=13*(MainActivity.ScreenHeight/16)+(Assets.gemright.getHeight());


            GemRect[2].left=(MainActivity.ScreenWidth/2)-Assets.gemright.getWidth()/2;
            GemRect[2].top=3*(MainActivity.ScreenHeight/16);
            GemRect[2].right= (MainActivity.ScreenWidth/2)+(Assets.gemright.getWidth()/2);
            GemRect[2].bottom=3*(MainActivity.ScreenHeight/16)+(Assets.gemright.getHeight());


            GemRect[3].left=-100;
            GemRect[3].top=-100;
            GemRect[3].right= -100;
            GemRect[3].bottom=-100;

            numberOfGemsCollected=0;




        }else if(currentLevel==2){


            GemRect[0].left=(MainActivity.ScreenWidth/4)-Assets.gemright.getWidth();
            GemRect[0].top=6*(MainActivity.ScreenHeight/8);
            GemRect[0].right= (MainActivity.ScreenWidth/4);
            GemRect[0].bottom=(6*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());


            GemRect[1].left=3*(MainActivity.ScreenWidth/4);
            GemRect[1].top=6*(MainActivity.ScreenHeight/8);
            GemRect[1].right=  (3*(MainActivity.ScreenWidth/4))+(Assets.gemright.getWidth());
            GemRect[1].bottom=(6*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());


            GemRect[2].left=MainActivity.ScreenWidth/2;
            GemRect[2].top=2*(MainActivity.ScreenHeight/8);
            GemRect[2].right= (MainActivity.ScreenWidth/2)+(Assets.gemright.getWidth());
            GemRect[2].bottom=(2*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());

            GemRect[3].left=-100;
            GemRect[3].top=-100;
            GemRect[3].right= -100;
            GemRect[3].bottom=-100;

            numberOfGemsCollected=0;


        }else if(currentLevel==3){


            GemRect[0].left=(MainActivity.ScreenWidth/4)-Assets.gemright.getWidth()/2;
            GemRect[0].top=6*(MainActivity.ScreenHeight/9);
            GemRect[0].right= (MainActivity.ScreenWidth/4)-Assets.gemright.getWidth()/2+(Assets.gemright.getWidth());
            GemRect[0].bottom=(6*(MainActivity.ScreenHeight/9))+(Assets.gemright.getHeight());


            GemRect[1].left=3*(MainActivity.ScreenWidth/4);
            GemRect[1].top=6*(MainActivity.ScreenHeight/9);
            GemRect[1].right=  (3*(MainActivity.ScreenWidth/4))+(Assets.gemright.getWidth());
            GemRect[1].bottom=(6*(MainActivity.ScreenHeight/9))+(Assets.gemright.getHeight());


            GemRect[2].left=MainActivity.ScreenWidth/2-Assets.gemright.getWidth()/2;
            GemRect[2].top=3*(MainActivity.ScreenHeight/8);
            GemRect[2].right= (MainActivity.ScreenWidth/2)+(Assets.gemright.getWidth())-Assets.gemright.getWidth()/2;
            GemRect[2].bottom=(3*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());



            numberOfGemsCollected=0;



        }else if(currentLevel==4){


            GemRect[0].left=(MainActivity.ScreenWidth/4)-Assets.gemright.getWidth()/2;
            GemRect[0].top=6*(MainActivity.ScreenHeight/8);
            GemRect[0].right= (MainActivity.ScreenWidth/4)-Assets.gemright.getWidth()/2+(Assets.gemright.getWidth());
            GemRect[0].bottom=(6*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());


            GemRect[1].left=3*(MainActivity.ScreenWidth/4);
            GemRect[1].top=6*(MainActivity.ScreenHeight/8);
            GemRect[1].right=  (3*(MainActivity.ScreenWidth/4))+(Assets.gemright.getWidth());
            GemRect[1].bottom=(6*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());


            GemRect[2].left=MainActivity.ScreenWidth/2-Assets.gemright.getWidth()/2;
            GemRect[2].top=3*(MainActivity.ScreenHeight/8);
            GemRect[2].right= (MainActivity.ScreenWidth/2)+(Assets.gemright.getWidth())-Assets.gemright.getWidth()/2;
            GemRect[2].bottom=(3*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());

            GemRect[3].left=-100;
            GemRect[3].top=-100;
            GemRect[3].right= -100;
            GemRect[3].bottom=-100;

            numberOfGemsCollected=0;


        }else if(currentLevel==6){

            GemRect[0].left=(MainActivity.ScreenWidth/5)-Assets.gemright.getWidth();
            GemRect[0].top=7*(MainActivity.ScreenHeight/9);
            GemRect[0].right= (MainActivity.ScreenWidth/5);
            GemRect[0].bottom=(7*(MainActivity.ScreenHeight/9))+(Assets.gemright.getHeight());


            GemRect[1].left=4*(MainActivity.ScreenWidth/5);
            GemRect[1].top=7*(MainActivity.ScreenHeight/9);
            GemRect[1].right=  (4*(MainActivity.ScreenWidth/5))+(Assets.gemright.getWidth());
            GemRect[1].bottom=(7*(MainActivity.ScreenHeight/9))+(Assets.gemright.getHeight());


            GemRect[2].left=MainActivity.ScreenWidth/2;
            GemRect[2].top=(MainActivity.ScreenHeight/9);
            GemRect[2].right= (MainActivity.ScreenWidth/2)+(Assets.gemright.getWidth());
            GemRect[2].bottom=((MainActivity.ScreenHeight/9))+(Assets.gemright.getHeight());

            GemRect[3].left=-100;
            GemRect[3].top=-100;
            GemRect[3].right= -100;
            GemRect[3].bottom=-100;

            numberOfGemsCollected=0;


        }else if(currentLevel==68) {

            GemRect[0].left = (MainActivity.ScreenWidth / 6);
            GemRect[0].top = (MainActivity.ScreenHeight / 10);
            GemRect[0].right = (MainActivity.ScreenWidth / 6) + (Assets.gemright.getWidth());
            GemRect[0].bottom = ((MainActivity.ScreenHeight / 10)) + (Assets.gemright.getHeight());


            GemRect[1].left = 4 * (MainActivity.ScreenWidth / 6);
            GemRect[1].top = (MainActivity.ScreenHeight / 10);
            GemRect[1].right = (4 * (MainActivity.ScreenWidth / 6)) + (Assets.gemright.getWidth());
            GemRect[1].bottom = ((MainActivity.ScreenHeight / 10)) + (Assets.gemright.getHeight());


            GemRect[2].left = MainActivity.ScreenWidth / 2 - Assets.gemright.getWidth() / 2;
            GemRect[2].top = (MainActivity.ScreenHeight / 2 - 3 * Assets.gemright.getHeight());
            GemRect[2].right = (MainActivity.ScreenWidth / 2) + (Assets.gemright.getWidth() / 2);
            GemRect[2].bottom = (MainActivity.ScreenHeight / 2 - 2 * Assets.gemright.getHeight());

            GemRect[3].left=-100;
            GemRect[3].top=-100;
            GemRect[3].right= -100;
            GemRect[3].bottom=-100;

            numberOfGemsCollected = 0;


        }else if(currentLevel==7){


            GemRect[0].left = (MainActivity.ScreenWidth / 6);
            GemRect[0].top = (MainActivity.ScreenHeight / 10);
            GemRect[0].right = (MainActivity.ScreenWidth / 6) + (Assets.gemright.getWidth());
            GemRect[0].bottom = ((MainActivity.ScreenHeight / 10)) + (Assets.gemright.getHeight());


            GemRect[1].left = 3 * (MainActivity.ScreenWidth / 6);
            GemRect[1].top = MainActivity. ScreenHeight / 3 + Assets.gemright.getHeight();
            GemRect[1].right = (3 * (MainActivity.ScreenWidth / 6)) + (Assets.gemright.getWidth());
            GemRect[1].bottom =  ((MainActivity. ScreenHeight / 3) + Assets.gemright.getHeight() + (Assets.gemright.getHeight()));

            GemRect[2].left = 5 * (MainActivity.ScreenWidth / 6);
            GemRect[2].top = (MainActivity.ScreenHeight / 10);
            GemRect[2].right = (5 * (MainActivity.ScreenWidth / 6)) + (Assets.gemright.getWidth());
            GemRect[2].bottom = ((MainActivity.ScreenHeight / 10)) + (Assets.gemright.getHeight());





            numberOfGemsCollected = 0;


        }else if(currentLevel==8){

            GemRect[0].left=MainActivity.ScreenWidth-Assets.gemright.getWidth();
            GemRect[0].top=8*(MainActivity.ScreenHeight/10);
            GemRect[0].right= MainActivity.ScreenWidth ;
            GemRect[0].bottom=(8*(MainActivity.ScreenHeight/10))+(Assets.gemright.getHeight());


            GemRect[1].left=0;
            GemRect[1].top=8*(MainActivity.ScreenHeight/10);
            GemRect[1].right=  (Assets.gemright.getWidth());
            GemRect[1].bottom=(8*(MainActivity.ScreenHeight/10))+(Assets.gemright.getHeight());


            GemRect[2].left=MainActivity.ScreenWidth/2;
            GemRect[2].top=2*(MainActivity.ScreenHeight/8);
            GemRect[2].right= (MainActivity.ScreenWidth/2)+(Assets.gemright.getWidth());
            GemRect[2].bottom=(2*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());


            GemRect[3].left = (MainActivity.ScreenWidth / 6)-Assets.gemright.getWidth()/2;
            GemRect[3].top = (MainActivity.ScreenHeight / 10);
            GemRect[3].right = (MainActivity.ScreenWidth / 6) + Assets.gemright.getWidth()/2;
            GemRect[3].bottom = ((MainActivity.ScreenHeight / 10)) + (Assets.gemright.getHeight());

            numberOfGemsCollected=0;


        }else if(currentLevel==9){

            GemRect[0].left=(MainActivity.ScreenWidth/4)-Assets.gemright.getWidth()/2;
            GemRect[0].top=6*(MainActivity.ScreenHeight/8);
            GemRect[0].right= (MainActivity.ScreenWidth/4)-Assets.gemright.getWidth()/2+(Assets.gemright.getWidth());
            GemRect[0].bottom=(6*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());


            GemRect[1].left=3*(MainActivity.ScreenWidth/4);
            GemRect[1].top=6*(MainActivity.ScreenHeight/8);
            GemRect[1].right=  (3*(MainActivity.ScreenWidth/4))+(Assets.gemright.getWidth());
            GemRect[1].bottom=(6*(MainActivity.ScreenHeight/8))+(Assets.gemright.getHeight());


            GemRect[2].left=Assets.gemright.getWidth()/2;
            GemRect[2].top=MainActivity.ScreenHeight/3;
            GemRect[2].right= Assets.gemright.getWidth()/2 + (Assets.gemright.getWidth());
            GemRect[2].bottom=MainActivity.ScreenHeight/3 + (Assets.gemright.getHeight());


            GemRect[3].left=MainActivity.ScreenWidth -(Assets.gemright.getWidth()+Assets.gemright.getWidth()/2) ;
            GemRect[3].top=MainActivity.ScreenHeight/3;
            GemRect[3].right= MainActivity.ScreenWidth - Assets.gemright.getWidth()/2;
            GemRect[3].bottom=MainActivity.ScreenHeight/3+ Assets.gemright.getHeight();



            numberOfGemsCollected=0;





        }else if(currentLevel==11){

            GemRect[0].left=(2 * MainActivity.ScreenWidth / 20)-(Assets.gemright.getWidth()/2);
            GemRect[0].top=11 * MainActivity.ScreenHeight / 20 +20f;
            GemRect[0].right= (2 * MainActivity.ScreenWidth / 20)-(Assets.gemright.getWidth()/2)+(Assets.gemright.getWidth());
            GemRect[0].bottom=11 * MainActivity.ScreenHeight / 20 +20f+(Assets.gemright.getHeight());


            GemRect[1].left=(18 * MainActivity.ScreenWidth / 20);
            GemRect[1].top=(11 * MainActivity.ScreenHeight / 20) + 20f;
            GemRect[1].right=  (18 * MainActivity.ScreenWidth / 20)+(Assets.gemright.getWidth());
            GemRect[1].bottom=(11 * MainActivity.ScreenHeight / 20) + 20f+(Assets.gemright.getHeight());


            GemRect[2].left=MainActivity.ScreenWidth/2-Assets.gemright.getWidth()/2;
            GemRect[2].top=6 * MainActivity.ScreenHeight / 20;
            GemRect[2].right= (MainActivity.ScreenWidth/2)+Assets.gemright.getWidth()/2;
            GemRect[2].bottom=6 * MainActivity.ScreenHeight / 20 +(Assets.gemright.getHeight());


            GemRect[3].left=MainActivity.ScreenWidth/2-Assets.gemright.getWidth()/2;
            GemRect[3].top=16 * MainActivity.ScreenHeight / 20;
            GemRect[3].right= (MainActivity.ScreenWidth/2)+Assets.gemright.getWidth()/2;
            GemRect[3].bottom=16 * MainActivity.ScreenHeight / 20 +(Assets.gemright.getHeight());


            numberOfGemsCollected=0;

        }else if(currentLevel==12){


            GemRect[0].set(0,(float)MainActivity.ScreenHeight -2* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2, Assets.gemright.getWidth() , (float)MainActivity.ScreenHeight -2* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2 + Assets.gemright.getHeight());
            GemRect[1].set(0,(float)MainActivity.ScreenHeight -8* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2, Assets.gemright.getWidth() , (float)MainActivity.ScreenHeight -8* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2 + Assets.gemright.getHeight());
            GemRect[2].set(MainActivity.ScreenWidth-Assets.gemright.getWidth(), (float) MainActivity.ScreenHeight - 8 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2, MainActivity.ScreenWidth, (float) MainActivity.ScreenHeight - 8 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2 + Assets.gemright.getHeight());
            GemRect[3].set(MainActivity.ScreenWidth-Assets.gemright.getWidth(), (float) MainActivity.ScreenHeight - 4 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2, MainActivity.ScreenWidth, (float) MainActivity.ScreenHeight - 4 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2 + Assets.gemright.getHeight());

            numberOfGemsCollected=0;


        }else if(currentLevel==13){

            GemRect[0].set(3*MainActivity.ScreenWidth/8,(float)MainActivity.ScreenHeight -1* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2, 3*MainActivity.ScreenWidth/8 + Assets.gemright.getWidth() , (float)MainActivity.ScreenHeight -1* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2 + Assets.gemright.getHeight());
            GemRect[1].set(MainActivity.ScreenWidth/8,(float)MainActivity.ScreenHeight -7* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2, MainActivity.ScreenWidth/8 +Assets.gemright.getWidth() , (float)MainActivity.ScreenHeight -7* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2 + Assets.gemright.getHeight());
            GemRect[2].set(MainActivity.ScreenWidth/2+2*Assets.gemright.getWidth(), (float) MainActivity.ScreenHeight - 8 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2, MainActivity.ScreenWidth/2 + 3*Assets.gemright.getWidth() , (float) MainActivity.ScreenHeight - 8 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2 + Assets.gemright.getHeight());
            GemRect[3].set(MainActivity.ScreenWidth-2*Assets.gemright.getWidth(), (float) MainActivity.ScreenHeight - 3 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2 -2* Assets.gemright.getHeight(), MainActivity.ScreenWidth - Assets.gemright.getWidth(), (float) MainActivity.ScreenHeight - 3 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2 - Assets.gemright.getHeight());

            numberOfGemsCollected=0;

        }else if(currentLevel==16){

            GemRect[0].set(3*MainActivity.ScreenWidth/8,(float)MainActivity.ScreenHeight -1* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2, 3*MainActivity.ScreenWidth/8 + Assets.gemright.getWidth() , (float)MainActivity.ScreenHeight -1* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2 + Assets.gemright.getHeight());
            GemRect[1].set(MainActivity.ScreenWidth/8,(float)MainActivity.ScreenHeight -7* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2, MainActivity.ScreenWidth/8 +Assets.gemright.getWidth() , (float)MainActivity.ScreenHeight -7* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2 + Assets.gemright.getHeight());
            GemRect[2].set(7*MainActivity.ScreenWidth/8, (float) MainActivity.ScreenHeight - 7 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2, 7*MainActivity.ScreenWidth/8 + Assets.gemright.getWidth() , (float) MainActivity.ScreenHeight - 7 * Assets.bluemarker.getHeight() - Assets.bluemarker.getHeight() / 2 + Assets.gemright.getHeight());
            GemRect[3].set(5*MainActivity.ScreenWidth/8,  (float)MainActivity.ScreenHeight -1* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2 ,5*MainActivity.ScreenWidth/8 + Assets.gemright.getWidth(), (float)MainActivity.ScreenHeight -1* Assets.bluemarker.getHeight()-Assets.bluemarker.getHeight()/2 + Assets.gemright.getHeight());


        }else if(currentLevel==17){

            GemRect[0].set((float) 15*MainActivity.ScreenWidth / 20, (float) 2*MainActivity.ScreenHeight / 20, (float)15* MainActivity.ScreenWidth / 20 + Assets.gemright.getWidth() , (float) 2*MainActivity.ScreenHeight / 20 + Assets.gemright.getHeight());
            GemRect[1].set((float) 9.5f*MainActivity.ScreenWidth / 20, (float) 6*MainActivity.ScreenHeight / 20, (float)9.5f* MainActivity.ScreenWidth / 20 + Assets.gemright.getWidth() , (float) 6*MainActivity.ScreenHeight / 20 + Assets.gemright.getHeight());
            GemRect[2].set((float) 9.5f*MainActivity.ScreenWidth / 20, (float) 11*MainActivity.ScreenHeight / 20, (float)9.5f* MainActivity.ScreenWidth / 20 + Assets.gemright.getWidth() , (float) 11*MainActivity.ScreenHeight / 20 + Assets.gemright.getHeight());
            GemRect[3].set((float) 4*MainActivity.ScreenWidth / 20, (float) 14*MainActivity.ScreenHeight / 20, (float)4* MainActivity.ScreenWidth / 20 + Assets.gemright.getWidth() , (float) 14*MainActivity.ScreenHeight / 20 + Assets.gemright.getHeight());
            GemRect[4].set((float) 15*MainActivity.ScreenWidth / 20, (float) 14*MainActivity.ScreenHeight / 20, (float)15* MainActivity.ScreenWidth / 20 + Assets.gemright.getWidth() , (float) 14*MainActivity.ScreenHeight / 20 + Assets.gemright.getHeight());

            numberOfGemsCollected=0;

        }else if(currentLevel==18){


            GemRect[0].set((float) MainActivity.ScreenWidth / 8,  (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.gemright.getHeight()),   (float) MainActivity.ScreenWidth / 8 + Assets.gemright.getWidth()   ,    (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() ));
            GemRect[1].set((float) 7*MainActivity.ScreenWidth / 8,  (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.gemright.getHeight()),   (float)7* MainActivity.ScreenWidth / 8 + Assets.gemright.getWidth()   ,    (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() ));

            GemRect[2].set((float) Assets.gemright.getWidth()/2 ,  (float) MainActivity.ScreenHeight /8,   Assets.gemright.getWidth()/2  + Assets.gemright.getWidth()   ,    (float) MainActivity.ScreenHeight /8 + Assets.gemright.getHeight() );
            GemRect[3].set((float) MainActivity.ScreenWidth-2*Assets.gemright.getWidth() ,  (float) MainActivity.ScreenHeight /8, MainActivity.ScreenWidth- Assets.gemright.getWidth()  ,    (float) MainActivity.ScreenHeight /8 + Assets.gemright.getHeight() );


            GemRect[4].set((float) MainActivity.ScreenWidth / 2 - Assets.gemright.getWidth()/2, (float) 8*MainActivity.ScreenHeight / 20, (float) MainActivity.ScreenWidth / 2 + Assets.gemright.getWidth()/2 , (float) 8*MainActivity.ScreenHeight / 20 + Assets.gemright.getHeight());

            numberOfGemsCollected=0;

        }else if(currentLevel==20){

            GemRect[0].left=(4 * MainActivity.ScreenWidth / 20)-(Assets.gemright.getWidth()/2);
            GemRect[0].top=13 * MainActivity.ScreenHeight / 20 +20f;
            GemRect[0].right= (4 * MainActivity.ScreenWidth / 20)-(Assets.gemright.getWidth()/2)+(Assets.gemright.getWidth());
            GemRect[0].bottom=13 * MainActivity.ScreenHeight / 20 +20f+(Assets.gemright.getHeight());


            GemRect[1].left=(18 * MainActivity.ScreenWidth / 20);
            GemRect[1].top=(12 * MainActivity.ScreenHeight / 20) + 20f;
            GemRect[1].right=  (18 * MainActivity.ScreenWidth / 20)+(Assets.gemright.getWidth());
            GemRect[1].bottom=(12 * MainActivity.ScreenHeight / 20) + 20f+(Assets.gemright.getHeight());


            GemRect[2].left=MainActivity.ScreenWidth/2-Assets.gemright.getWidth();
            GemRect[2].top=6 * MainActivity.ScreenHeight / 20;
            GemRect[2].right= (MainActivity.ScreenWidth/2);
            GemRect[2].bottom=6 * MainActivity.ScreenHeight / 20 +(Assets.gemright.getHeight());

            GemRect[3].left=MainActivity.ScreenWidth/2 - Assets.gemright.getWidth()/2;
            GemRect[3].top=8*(MainActivity.ScreenHeight/10);
            GemRect[3].right= MainActivity.ScreenWidth/2 + Assets.gemright.getWidth()/2;
            GemRect[3].bottom=8*(MainActivity.ScreenHeight/10) + Assets.gemright.getHeight();

            GemRect[4].left=Assets.gemright.getWidth()/2;
            GemRect[4].top=(4*MainActivity.ScreenHeight/10);
            GemRect[4].right= Assets.gemright.getWidth() + Assets.gemright.getWidth()/2;
            GemRect[4].bottom=(4*MainActivity.ScreenHeight/10) + Assets.gemright.getHeight();

            numberOfGemsCollected=0;

        }else if(currentLevel==21){

            GemRect[0].left=( MainActivity.ScreenWidth / 2)-(Assets.gemright.getWidth()/2);
            GemRect[0].top=MainActivity.ScreenHeight/ 8 + 2*Assets.gemright.getHeight();
            GemRect[0].right= ( MainActivity.ScreenWidth / 2)+(Assets.gemright.getWidth()/2);
            GemRect[0].bottom=MainActivity.ScreenHeight / 8 + 3* Assets.gemright.getHeight();


            GemRect[1].left=MainActivity.ScreenWidth/2 + 4*Assets.gemright.getWidth()/2;
            GemRect[1].top=5*(MainActivity.ScreenHeight/14);
            GemRect[1].right= MainActivity.ScreenWidth/2 + 4*Assets.gemright.getWidth()/2 + Assets.gemright.getWidth();
            GemRect[1].bottom=5*(MainActivity.ScreenHeight/14) + Assets.gemright.getHeight();


            GemRect[2].left=MainActivity.ScreenWidth/2 + 4*Assets.gemright.getWidth()/2;
            GemRect[2].top=MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +2* Assets.gemright.getHeight());
            GemRect[2].right= MainActivity.ScreenWidth/2 + 4*Assets.gemright.getWidth()/2 + Assets.gemright.getWidth();
            GemRect[2].bottom=MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +  Assets.gemright.getHeight() );

            GemRect[3].left=MainActivity.ScreenWidth/2 - 5*Assets.gemright.getWidth()/2;
            GemRect[3].top=9*(MainActivity.ScreenHeight/14);
            GemRect[3].right= MainActivity.ScreenWidth/2 - 5*Assets.gemright.getWidth()/2 + Assets.gemright.getWidth();
            GemRect[3].bottom=9*(MainActivity.ScreenHeight/14) + Assets.gemright.getHeight();

            GemRect[4].left=Assets.gemright.getWidth();
            GemRect[4].top=(5*MainActivity.ScreenHeight/14);
            GemRect[4].right= Assets.gemright.getWidth() + Assets.gemright.getWidth();
            GemRect[4].bottom=(5*MainActivity.ScreenHeight/14) + Assets.gemright.getHeight();

            numberOfGemsCollected=0;



        }else if(currentLevel==22){

            GemRect[0].left=5*( MainActivity.ScreenWidth / 8)-(Assets.gemright.getWidth()/2);
            GemRect[0].top=MainActivity.ScreenHeight/ 8;
            GemRect[0].right= 5*( MainActivity.ScreenWidth / 8)+(Assets.gemright.getWidth()/2);
            GemRect[0].bottom=MainActivity.ScreenHeight / 8 +  Assets.gemright.getHeight();


            GemRect[1].left=7*MainActivity.ScreenWidth/8 - Assets.gemright.getWidth()/2;
            GemRect[1].top=6*(MainActivity.ScreenHeight/14);
            GemRect[1].right= 7*MainActivity.ScreenWidth/8 - Assets.gemright.getWidth()/2 + Assets.gemright.getWidth();
            GemRect[1].bottom=6*(MainActivity.ScreenHeight/14) + Assets.gemright.getHeight();


            GemRect[2].left=7*MainActivity.ScreenWidth/8 - Assets.gemright.getWidth()/2 ;
            GemRect[2].top=MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +2* Assets.gemright.getHeight());
            GemRect[2].right= 7*MainActivity.ScreenWidth/8  - Assets.gemright.getWidth()/2 +  Assets.gemright.getWidth();
            GemRect[2].bottom=MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +  Assets.gemright.getHeight() );

            GemRect[3].left=5*MainActivity.ScreenWidth/8 - Assets.gemright.getWidth()/2;
            GemRect[3].top=MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +2* Assets.gemright.getHeight());
            GemRect[3].right= 5*MainActivity.ScreenWidth/8 - Assets.gemright.getWidth()/2 + Assets.gemright.getWidth();
            GemRect[3].bottom= MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.gemright.getHeight());

            GemRect[4].left=Assets.gemright.getWidth();
            GemRect[4].top=(8*MainActivity.ScreenHeight/14);
            GemRect[4].right= Assets.gemright.getWidth() + Assets.gemright.getWidth();
            GemRect[4].bottom=(8*MainActivity.ScreenHeight/14) + Assets.gemright.getHeight();

            numberOfGemsCollected=0;


        }else if(currentLevel==23){


            GemRect[0].left=( MainActivity.ScreenWidth / 8)-(Assets.gemright.getWidth()/2);
            GemRect[0].top=MainActivity.ScreenHeight/ 8 ;
            GemRect[0].right= ( MainActivity.ScreenWidth / 8)+(Assets.gemright.getWidth()/2);
            GemRect[0].bottom=MainActivity.ScreenHeight / 8 + Assets.gemright.getHeight();


            GemRect[1].left=7*MainActivity.ScreenWidth/8 - Assets.gemright.getWidth()/2;
            GemRect[1].top=5*(MainActivity.ScreenHeight/14);
            GemRect[1].right= 7*MainActivity.ScreenWidth/8 + Assets.gemright.getWidth()/2;
            GemRect[1].bottom=5*(MainActivity.ScreenHeight/14) + Assets.gemright.getHeight();


            GemRect[2].left=MainActivity.ScreenWidth/2 + 4*Assets.gemright.getWidth()/2;
            GemRect[2].top=MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +2* Assets.gemright.getHeight());
            GemRect[2].right= MainActivity.ScreenWidth/2 + 4*Assets.gemright.getWidth()/2 + Assets.gemright.getWidth();
            GemRect[2].bottom=MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +  Assets.gemright.getHeight() );

            GemRect[3].left=(5* MainActivity.ScreenWidth / 8)-(Assets.gemright.getWidth()/2);
            GemRect[3].top=MainActivity.ScreenHeight/ 8 ;
            GemRect[3].right= (5* MainActivity.ScreenWidth / 8)+(Assets.gemright.getWidth()/2);
            GemRect[3].bottom=MainActivity.ScreenHeight / 8 + Assets.gemright.getHeight();

            GemRect[4].left=Assets.gemright.getWidth();
            GemRect[4].top=(5*MainActivity.ScreenHeight/14);
            GemRect[4].right= Assets.gemright.getWidth() + Assets.gemright.getWidth();
            GemRect[4].bottom=(5*MainActivity.ScreenHeight/14) + Assets.gemright.getHeight();

            GemRect[5].left=(7* MainActivity.ScreenWidth / 8)-(Assets.gemright.getWidth()/2);
            GemRect[5].top=MainActivity.ScreenHeight/ 8 ;
            GemRect[5].right= (7* MainActivity.ScreenWidth / 8)+(Assets.gemright.getWidth()/2);
            GemRect[5].bottom=MainActivity.ScreenHeight / 8 + Assets.gemright.getHeight();

            GemRect[6].left=( MainActivity.ScreenWidth / 8)-(Assets.gemright.getWidth()/2);
            GemRect[6].top =MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +2* Assets.gemright.getHeight());
            GemRect[6].right= ( MainActivity.ScreenWidth / 8)+(Assets.gemright.getWidth()/2);
            GemRect[6].bottom=MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() +1* Assets.gemright.getHeight());


            numberOfGemsCollected=0;



        }
    }




    public void increaseCollectedGems(){

        numberOfGemsCollected++;
    }




    public int getNumberOfGemsCollected(){

        return numberOfGemsCollected;
    }






    public boolean checkCollisionOfRainTailsWithGem(RainbowTails rainbowTails,Star star,int currentlevel){


        for(int i=0;i<8;i++) {
            if (rainbowTails.getRectOfRainbowTails().intersect(GemRect[i])) {

                GemRect[i].left = -100;
                GemRect[i].top = -100;
                GemRect[i].right = -100;
                GemRect[i].bottom = -100;

                numberOfGemsCollected++;

                //If all 3 collected, then good for you! Now go get that star
                if (currentlevel<8 && numberOfGemsCollected == 3) {
                    star.makeStarVisible();

                }else if(currentlevel<17 && numberOfGemsCollected==4){

                    star.makeStarVisible();

                }else if(currentlevel<=22 && numberOfGemsCollected==5){
                    star.makeStarVisible();


                }else if(currentlevel<25 && numberOfGemsCollected==7){

                    star.makeStarVisible();


                }
                return true;
            }
        }
        return false;


    }

}
