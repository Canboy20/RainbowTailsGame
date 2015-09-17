package com.rainbowtails.canatay.rainbowtails;

import android.graphics.RectF;

/**
 * Created by Can Atay on 8/27/2015.
 */
public class MusicPipes {


    float x[];
    float y[];
    float xChange[];
    float yChange[];
    RectF musicPipeRect[];
    int musicNoteSituation[];
    char typeOfPipe[];
    int numberOfPipes;



    public MusicPipes(){

        x=new float[20];
        y=new float[20];
        xChange=new float[20];
        yChange=new float[20];
        musicNoteSituation=new int[20];
        typeOfPipe=new char[20];
        numberOfPipes=0;


        musicPipeRect=new RectF[20];

        for(int i=0;i<20;i++){

            musicPipeRect[i]=new RectF(0,0,0,0);
            x[i]=0;
            y[i]=0;
            xChange[i]=0;
            yChange[i]=0;
            musicNoteSituation[i]=(i*8);
            typeOfPipe[i]='n';


        }




    }




    public void initializeMusicPipes(int currentlevel){



        if(currentlevel==3) {

            numberOfPipes=10;
            /*
            x[0] = MainActivity.ScreenWidth - Assets.pipeleft.getWidth() / 4;
            y[0] = MainActivity.ScreenHeight / 2 + 2 * Assets.pipeleft.getHeight();

            x[1] = MainActivity.ScreenWidth - Assets.pipeleft.getWidth() / 2;
            y[1] = MainActivity.ScreenHeight / 2 + 3 * Assets.pipeleft.getHeight();


            x[2] = MainActivity.ScreenWidth - Assets.pipeleft.getWidth() / 4;
            y[2] = MainActivity.ScreenHeight / 2 + 4 * Assets.pipeleft.getHeight();

            x[3] = MainActivity.ScreenWidth - Assets.pipeleft.getWidth();
            y[3] = MainActivity.ScreenHeight / 2 + 5 * Assets.pipeleft.getHeight();

            x[4] = MainActivity.ScreenWidth - Assets.pipeleft.getWidth() / 2;
            y[4] = MainActivity.ScreenHeight / 2 + 6 * Assets.pipeleft.getHeight();


            x[5] = -Assets.pipeleft.getWidth() / 4;
            y[5] = MainActivity.ScreenHeight / 2 + 2 * Assets.pipeleft.getHeight();

            x[6] = -Assets.pipeleft.getWidth();
            y[6] = MainActivity.ScreenHeight / 2 + 3 * Assets.pipeleft.getHeight();

            x[7] = -Assets.pipeleft.getWidth() / 2;
            y[7] = MainActivity.ScreenHeight / 2 + 4 * Assets.pipeleft.getHeight();

            x[8] = -Assets.pipeleft.getWidth() / 3;
            y[8] = MainActivity.ScreenHeight / 2 + 5 * Assets.pipeleft.getHeight();


            x[9] = -Assets.pipeleft.getWidth();
            y[9] = MainActivity.ScreenHeight / 2 + 6 * Assets.pipeleft.getHeight();



                x[10] =  MainActivity.ScreenWidth / 2 - 3*Assets.pipebottom.getWidth();
            x[11] =  MainActivity.ScreenWidth / 2 - 4*Assets.pipebottom.getWidth();
            x[12] =  MainActivity.ScreenWidth / 2 - 5*Assets.pipebottom.getWidth();
            x[13] =  MainActivity.ScreenWidth / 2 - 6*Assets.pipebottom.getWidth();
            x[14] =  MainActivity.ScreenWidth / 2 - 7*Assets.pipebottom.getWidth();

            x[15] =  MainActivity.ScreenWidth / 2 + 3*Assets.pipebottom.getWidth() ;
            x[16] =  MainActivity.ScreenWidth / 2 + 4*Assets.pipebottom.getWidth();
            x[17] =  MainActivity.ScreenWidth / 2 + 5*Assets.pipebottom.getWidth();
            x[18] =  MainActivity.ScreenWidth / 2 + 6*Assets.pipebottom.getWidth();
            x[19] =  MainActivity.ScreenWidth / 2 + 7*Assets.pipebottom.getWidth();



            y[10] = MainActivity.ScreenHeight - 2 * Assets.bluemarker.getHeight() / 8;
            y[11] = MainActivity.ScreenHeight ;
            y[12] = MainActivity.ScreenHeight - 7 * Assets.bluemarker.getHeight() / 8;
            y[13] = MainActivity.ScreenHeight - 5 * Assets.bluemarker.getHeight() / 8;
            y[14] = MainActivity.ScreenHeight - 10 * Assets.bluemarker.getHeight() / 8;
            y[15] = MainActivity.ScreenHeight - 3 * Assets.bluemarker.getHeight() / 8;
            y[16] = MainActivity.ScreenHeight;
            y[17] = MainActivity.ScreenHeight - 8 * Assets.bluemarker.getHeight() / 8;
            y[18] = MainActivity.ScreenHeight + 1 * Assets.bluemarker.getHeight() / 8;
            y[19] = MainActivity.ScreenHeight - 4 * Assets.bluemarker.getHeight() / 8;


            for (int i = 0; i < 10; i++) {

                musicPipeRect[i].set(x[i], y[i], x[i] + Assets.pipeleft.getWidth(), y[i] + Assets.pipeleft.getHeight());
                xChange[i] = 1f;
                yChange[i] = 0f;

            }


            for (int i = 10; i < 20; i++) {

                musicPipeRect[i].set(x[i], y[i], x[i] + Assets.pipeleft.getWidth(), y[i] + Assets.pipeleft.getHeight());
                xChange[i] = 0f;
                yChange[i] = 2f;

            }




            x[0] =  MainActivity.ScreenWidth / 2 - 3*Assets.pipebottom.getWidth();
            x[1] =  MainActivity.ScreenWidth / 2 - 4*Assets.pipebottom.getWidth();
            x[2] =  MainActivity.ScreenWidth / 2 - 5*Assets.pipebottom.getWidth();
            x[3] =  MainActivity.ScreenWidth / 2 - 6*Assets.pipebottom.getWidth();
            x[4] =  MainActivity.ScreenWidth / 2 - 7*Assets.pipebottom.getWidth();

            x[5] =  MainActivity.ScreenWidth / 2 + 3*Assets.pipebottom.getWidth() ;
            x[6] =  MainActivity.ScreenWidth / 2 + 4*Assets.pipebottom.getWidth();
            x[7] =  MainActivity.ScreenWidth / 2 + 5*Assets.pipebottom.getWidth();
            x[8] =  MainActivity.ScreenWidth / 2 + 6*Assets.pipebottom.getWidth();
            x[9] =  MainActivity.ScreenWidth / 2 + 7*Assets.pipebottom.getWidth();


            y[0] = MainActivity.ScreenHeight - 2 * Assets.bluemarker.getHeight() / 8;
            y[1] = MainActivity.ScreenHeight ;
            y[2] = MainActivity.ScreenHeight - 7 * Assets.bluemarker.getHeight() / 8;
            y[3] = MainActivity.ScreenHeight - 5 * Assets.bluemarker.getHeight() / 8;
            y[4] = MainActivity.ScreenHeight - 10 * Assets.bluemarker.getHeight() / 8;
            y[5] = MainActivity.ScreenHeight - 3 * Assets.bluemarker.getHeight() / 8;
            y[6] = MainActivity.ScreenHeight;
            y[7] = MainActivity.ScreenHeight - 8 * Assets.bluemarker.getHeight() / 8;
            y[8] = MainActivity.ScreenHeight + 1 * Assets.bluemarker.getHeight() / 8;
            y[9] = MainActivity.ScreenHeight - 4 * Assets.bluemarker.getHeight() / 8;
*/


            x[0] =  MainActivity.ScreenWidth / 4 - 2*Assets.pipebottom.getWidth();
            x[1] =  MainActivity.ScreenWidth / 4 - 1*Assets.pipebottom.getWidth();
            x[2] =  MainActivity.ScreenWidth / 4 - 0*Assets.pipebottom.getWidth();
            x[3] =  MainActivity.ScreenWidth / 4 + 1*Assets.pipebottom.getWidth();
            x[4] =  MainActivity.ScreenWidth / 4 + 2*Assets.pipebottom.getWidth();

            x[5] =  3*MainActivity.ScreenWidth / 4 -2*Assets.pipebottom.getWidth() ;
            x[6] =  3*MainActivity.ScreenWidth / 4 -1*Assets.pipebottom.getWidth();
            x[7] =  3*MainActivity.ScreenWidth / 4 + 0*Assets.pipebottom.getWidth();
            x[8] =  3*MainActivity.ScreenWidth / 4 + 1*Assets.pipebottom.getWidth();
            x[9] =  3*MainActivity.ScreenWidth / 4 + 2*Assets.pipebottom.getWidth();


            y[0] = MainActivity.ScreenHeight - 5*Assets.pipebottom.getHeight()/8;
            y[1] = MainActivity.ScreenHeight  - 6*Assets.pipebottom.getHeight()/8;
            y[2] = MainActivity.ScreenHeight -  7*Assets.pipebottom.getHeight()/8 ;
            y[3] = MainActivity.ScreenHeight - 6*Assets.pipebottom.getHeight()/8;
            y[4] = MainActivity.ScreenHeight - 5*Assets.pipebottom.getHeight()/8;

            y[5] = MainActivity.ScreenHeight - 5*Assets.pipebottom.getHeight()/8;
            y[6] = MainActivity.ScreenHeight  - 6*Assets.pipebottom.getHeight()/8;
            y[7] = MainActivity.ScreenHeight -  7*Assets.pipebottom.getHeight()/8 ;
            y[8] = MainActivity.ScreenHeight - 6*Assets.pipebottom.getHeight()/8;
            y[9] = MainActivity.ScreenHeight - 5*Assets.pipebottom.getHeight()/8;




            for (int i = 0; i < numberOfPipes; i++) {

                musicPipeRect[i].set(x[i], y[i], x[i] + Assets.pipebottom.getWidth(), y[i] + Assets.pipebottom.getHeight());
                xChange[i] = 0f;
                yChange[i] = 0f;

            }


        }
    }



    public void updateSpeed(int currenlevel) {


        if (currenlevel == 3){

/*
            for (int i = 0; i < 5; i++) {

                musicNoteSituation[i]++;
                if (musicNoteSituation[i] > 100) {
                    musicNoteSituation[i] = 0;
                }


                musicPipeRect[i].set(x[i], y[i], x[i] + Assets.pipeleft.getWidth(), y[i] + Assets.pipeleft.getHeight());


                x[i] = x[i] + xChange[i];
                y[i] = y[i] + yChange[i];


                if (x[i]  > MainActivity.ScreenWidth) {

                    xChange[i] = -1f;

                } else if (x[i] < MainActivity.ScreenWidth -3 * Assets.pipeleft.getWidth() / 4) {
                    xChange[i] = 1f;

                }


            }





            for (int i = 5; i < 10; i++) {

                musicNoteSituation[i]++;
                if (musicNoteSituation[i] > 100) {
                    musicNoteSituation[i] = 0;
                }


                musicPipeRect[i].set(x[i], y[i], x[i] + Assets.pipeleft.getWidth(), y[i] + Assets.pipeleft.getHeight());


                x[i] = x[i] + xChange[i];
                y[i] = y[i] + yChange[i];


                if (x[i] + Assets.pipeleft.getWidth() > 3 * Assets.pipeleft.getWidth() / 4) {

                    xChange[i] = -1f;

                } else if (x[i] < -3 * Assets.pipeleft.getWidth() / 4) {
                    xChange[i] = 1f;

                }


            }



            for (int i = 10; i < 20; i++) {

                musicNoteSituation[i]++;
                if (musicNoteSituation[i] > 100) {
                    musicNoteSituation[i] = 0;
                }


                musicPipeRect[i].set(x[i], y[i], x[i] + Assets.pipebottom.getWidth(), y[i] + Assets.pipebottom.getHeight());


                x[i] = x[i] + xChange[i];
                y[i] = y[i] + yChange[i];


                if (y[i]< MainActivity.ScreenHeight-Assets.pipebottom.getHeight()) {

                    yChange[i] = 2f;

                } else if (y[i] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()/2) {
                    yChange[i] = -2f;

                }


            }


*/


            for (int i = 0; i < numberOfPipes; i++) {

                musicNoteSituation[i]++;
                if (musicNoteSituation[i] > 100) {
                    musicNoteSituation[i] = 0;
                }


                musicPipeRect[i].set(x[i], y[i], x[i] + Assets.pipebottom.getWidth(), y[i] + Assets.pipebottom.getHeight());


                x[i] = x[i] + xChange[i];
                y[i] = y[i] + yChange[i];


                if (y[i]< MainActivity.ScreenHeight-Assets.pipebottom.getHeight()) {

                    yChange[i] = 2f;

                } else if (y[i] > MainActivity.ScreenHeight - Assets.bluemarker.getHeight()/2) {
                    yChange[i] = -2f;

                }


            }
    }
    }


    public RectF getPipeRect(int current){

        return musicPipeRect[current];
    }



    public char showMusicNoteOfPipe(int current){

        if( musicNoteSituation[current]>50 && musicNoteSituation[current]<55){
            return 'y';

        }

        return 'n';
    }



    public int getNumberOfPipes(){
        return numberOfPipes;
    }


}
