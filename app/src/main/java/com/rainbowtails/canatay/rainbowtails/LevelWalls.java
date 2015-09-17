package com.rainbowtails.canatay.rainbowtails;

import android.graphics.RectF;

/**
 * Created by Can Atay on 6/13/2015.
 */
public class LevelWalls {

    RectF levelWalls[];
    String typeOfLevelWall[];
    int numberOfLevelWalls;
    char breakableWall[];
    char broken[];
    int responsibleFor[];
    char locked[];



    public LevelWalls(){

        levelWalls=new RectF[30];

        for(int i=0;i<30;i++){
            levelWalls[i]=new RectF(0,0,0,0);
        }


        typeOfLevelWall=new String[30];
        for(int i=0;i<30;i++){
            typeOfLevelWall[i]=new String("none");
        }

        breakableWall=new char[30];
        for(int i=0;i<30;i++){
            breakableWall[i]='n';
        }


        broken=new char[30];
        for(int i=0;i<30;i++){
            broken[i]='n';
        }


        responsibleFor=new int[30];
        for(int i=0;i<30;i++){
            responsibleFor[i]=-1;
        }


        locked=new char[30];
        for(int i=0;i<30;i++){
            locked[i]='y';
        }




        numberOfLevelWalls=0;


    }



    public void initializeLevelWalls(int currentLevel){


        if(currentLevel==1) {


            levelWalls[0].left= 4*MainActivity.ScreenWidth /10;
            levelWalls[0].top= 3*MainActivity.ScreenHeight / 8;
            levelWalls[0].right =6*MainActivity.ScreenWidth / 10;
            levelWalls[0].bottom= 3*MainActivity.ScreenHeight / 8 + 11f*(float)(MainActivity.ScaleHeight);
            typeOfLevelWall[0]="hori";


            levelWalls[1].left=4*MainActivity.ScreenWidth /10;
            levelWalls[1].top= 5*MainActivity.ScreenHeight / 8;
            levelWalls[1].right =6*MainActivity.ScreenWidth / 10;
            levelWalls[1].bottom= 5*MainActivity.ScreenHeight / 8 +  11f*(float)(MainActivity.ScaleHeight);
            typeOfLevelWall[1]="hori";

            numberOfLevelWalls=2;



        }else if(currentLevel==2){


            levelWalls[0].left= 4*MainActivity.ScreenWidth /10;
            levelWalls[0].top= 3*MainActivity.ScreenHeight / 8;
            levelWalls[0].right =6*MainActivity.ScreenWidth / 10;
            levelWalls[0].bottom= 3*MainActivity.ScreenHeight / 8 + 11f*(float)(MainActivity.ScaleHeight);
            typeOfLevelWall[0]="hori";


            levelWalls[1].left=4*MainActivity.ScreenWidth /10;
            levelWalls[1].top= 5*MainActivity.ScreenHeight / 8;
            levelWalls[1].right =6*MainActivity.ScreenWidth / 10;
            levelWalls[1].bottom= 5*MainActivity.ScreenHeight / 8 +  11f*(float)(MainActivity.ScaleHeight);
            typeOfLevelWall[1]="hori";


            numberOfLevelWalls=2;



        }else if(currentLevel==3) {

            levelWalls[0].left = MainActivity.ScreenWidth / 2;
            levelWalls[0].top = 5 * MainActivity.ScreenHeight / 8;
            levelWalls[0].right = MainActivity.ScreenWidth / 2 + 11f * (float) (MainActivity.ScaleWidth);
            levelWalls[0].bottom = 6 * MainActivity.ScreenHeight / 8;
            typeOfLevelWall[0] = "vert";

            numberOfLevelWalls = 1;


        }else if(currentLevel==4){

            levelWalls[0].set((MainActivity.ScreenWidth / 2) , (2*MainActivity.ScreenHeight / 3) ,   (MainActivity.ScreenWidth / 2) +  11f * (float) (MainActivity.ScaleWidth) , (MainActivity.ScreenHeight ));
            typeOfLevelWall[0]="vert";

            levelWalls[1].set(0 , (5*MainActivity.ScreenHeight / 8) ,   (1*MainActivity.ScreenWidth / 8)  , (5*MainActivity.ScreenHeight / 8) +  11f * (float) (MainActivity.ScaleHeight) );
            typeOfLevelWall[1]="hori";


            levelWalls[2].set((7 * MainActivity.ScreenWidth / 8), (5 * MainActivity.ScreenHeight / 8),  MainActivity.ScreenWidth , (5 * MainActivity.ScreenHeight / 8) + 11f * (float) (MainActivity.ScaleHeight));
            typeOfLevelWall[2]="hori";


            numberOfLevelWalls = 3;



        }else if(currentLevel==5){


            numberOfLevelWalls = 1;

            levelWalls[0].set((MainActivity.ScreenWidth / 2) , (MainActivity.ScreenHeight / 4) ,   (MainActivity.ScreenWidth / 2) +10f , 3*(MainActivity.ScreenHeight / 4));
            typeOfLevelWall[0]="vert";




        }else if(currentLevel==6){




            int currentWall=0;

            for(int y=3;y<6;y++){

                for(int x=0;x<4;x++){

                    levelWalls[currentWall].set((x*MainActivity.ScreenWidth / 4) , y*(MainActivity.ScreenHeight / 7) ,  (x+1)*(MainActivity.ScreenWidth / 4)  , y*(MainActivity.ScreenHeight / 7)+10f);
                    typeOfLevelWall[currentWall]="hori";
                    breakableWall[currentWall]='d';
                    locked[currentWall]='y';
                    currentWall++;


                }

            }


            for(int y=3;y<6;y++) {

                for (int x = 1; x < 4; x++) {

                    levelWalls[currentWall].set((x * MainActivity.ScreenWidth / 4), y * (MainActivity.ScreenHeight / 7), (x) * (MainActivity.ScreenWidth / 4) + 10f, (y + 1) * (MainActivity.ScreenHeight / 7));
                    typeOfLevelWall[currentWall] = "vert";
                    breakableWall[currentWall] = 'd';
                    locked[currentWall] = 'y';
                    currentWall++;

                }

            }




            locked[20]='n';


            numberOfLevelWalls=21;

            /*
            levelWalls[0].set(2*MainActivity.ScreenWidth / 5, 3*MainActivity.ScreenHeight / 8,  (3*MainActivity.ScreenWidth / 5), (3*MainActivity.ScreenHeight / 8) + 10f);
            typeOfLevelWall[0]="hori";

            levelWalls[1].set(2 * (MainActivity.ScreenWidth / 6), 0, 2 * (MainActivity.ScreenWidth / 6) + 20f, 1 * (MainActivity.ScreenHeight / 8));
            typeOfLevelWall[1]="vert";

            levelWalls[2].set(4 * (MainActivity.ScreenWidth / 6), 0, 4 * (MainActivity.ScreenWidth / 6) + 20f, 1* (MainActivity.ScreenHeight / 8));
            typeOfLevelWall[2]="vert";*/

           // numberOfLevelWalls=3;


        }else if(currentLevel==67){


            levelWalls[0].set(MainActivity.ScreenWidth / 2-Assets.star.getWidth() , MainActivity.ScreenHeight / 2 - (Assets.star.getHeight() / 2) ,   (MainActivity.ScreenWidth / 2)+Assets.star.getWidth()  ,MainActivity. ScreenHeight / 2 - (Assets.star.getHeight() / 2)+10f);
            typeOfLevelWall[0]="hori";

            levelWalls[1] .set(MainActivity.ScreenWidth / 6, MainActivity.ScreenHeight / 5, (MainActivity.ScreenWidth / 6) + 2 * Assets.star.getWidth(), MainActivity.ScreenHeight / 5 +10f);
            typeOfLevelWall[1]="hori";


            levelWalls[2] .set((5*MainActivity.ScreenWidth / 6) - 2*Assets.star.getWidth(), MainActivity.ScreenHeight/5,  ( 5*MainActivity.ScreenWidth / 6) , MainActivity.ScreenHeight/5 +10f);
            typeOfLevelWall[2]="hori";


            levelWalls[3] .set((5*MainActivity.ScreenWidth / 6) - 2*Assets.star.getWidth(), 4*MainActivity.ScreenHeight/5,  ( 5*MainActivity.ScreenWidth / 6) , 4*MainActivity.ScreenHeight/5 +10f);
            typeOfLevelWall[3]="hori";


            levelWalls[4] .set((MainActivity.ScreenWidth / 6), 4*MainActivity.ScreenHeight/5,  ( MainActivity.ScreenWidth / 6)+  2*Assets.star.getWidth() , 4*MainActivity.ScreenHeight/5 + 10f);
            typeOfLevelWall[4]="hori";

            numberOfLevelWalls=5;



        }else if(currentLevel==7){

            levelWalls[0] .set(MainActivity.ScreenWidth / 4 ,MainActivity. ScreenHeight / 3,   3*(MainActivity.ScreenWidth / 4)  , (MainActivity.ScreenHeight / 3)+10f);
            levelWalls[1] .set(MainActivity.ScreenWidth / 3 ,MainActivity. ScreenHeight-2*Assets.star.getHeight() ,   2*(MainActivity.ScreenWidth / 3)  , MainActivity.ScreenHeight-2*Assets.star.getHeight() +10f );
            levelWalls[2] .set(2*(MainActivity.ScreenWidth / 6) , 200f*(float)(MainActivity.ScaleHeight),   2*(MainActivity.ScreenWidth / 6) +20f , 2*(MainActivity.ScreenHeight / 10));
            levelWalls[3].set(4 * (MainActivity.ScreenWidth / 6), 200f*(float)(MainActivity.ScaleHeight), 4 * (MainActivity.ScreenWidth / 6) + 20f, 2 * (MainActivity.ScreenHeight / 10));

            typeOfLevelWall[0]="hori";
            typeOfLevelWall[1]="hori";
            typeOfLevelWall[2]="vert";
            typeOfLevelWall[3]="vert";


            numberOfLevelWalls=4;






        }else if(currentLevel==8){

            numberOfLevelWalls=6;


            levelWalls[0] .set(2 * (MainActivity.ScreenWidth / 6) ,MainActivity. ScreenHeight / 5,   3*(MainActivity.ScreenWidth / 4)  , (MainActivity.ScreenHeight /5)+ 11f*(float)(MainActivity.ScaleHeight));
            levelWalls[1] .set(MainActivity.ScreenWidth / 3, MainActivity.ScreenHeight / 2, 2 * (MainActivity.ScreenWidth / 3), MainActivity.ScreenHeight / 2 + 11f*(float)(MainActivity.ScaleHeight));
            levelWalls[2] .set(2 * (MainActivity.ScreenWidth / 6), 0, 2 * (MainActivity.ScreenWidth / 6) + 11f*(float)(MainActivity.ScaleWidth), MainActivity.ScreenHeight / 5);
            levelWalls[3] .set(4 * (MainActivity.ScreenWidth / 6), 0, 4 * (MainActivity.ScreenWidth / 6) + 11f*(float)(MainActivity.ScaleWidth), (MainActivity.ScreenHeight / 10));
            levelWalls[4] .set(0, 5*MainActivity.ScreenHeight / 7,(MainActivity.ScreenWidth / 5), 5*(MainActivity.ScreenHeight / 7) + 11f*(float)(MainActivity.ScaleHeight));
            levelWalls[5] .set(4*(MainActivity.ScreenWidth/5), 5 * MainActivity.ScreenHeight / 7, (MainActivity.ScreenWidth ), 5 * (MainActivity.ScreenHeight / 7) + 11f*(float)(MainActivity.ScaleHeight));

            typeOfLevelWall[0]="hori";
            typeOfLevelWall[1]="hori";
            typeOfLevelWall[2]="vert";
            typeOfLevelWall[3]="vert";
            typeOfLevelWall[4]="hori";
            typeOfLevelWall[5]="hori";



        }else if(currentLevel==9) {

            levelWalls[0].set(0, MainActivity.ScreenHeight / 2, (MainActivity.ScreenWidth / 6), (MainActivity.ScreenHeight / 2) + 11f*(float)(MainActivity.ScaleHeight));
            levelWalls[1].set(5 * (MainActivity.ScreenWidth / 6), MainActivity.ScreenHeight / 2, (MainActivity.ScreenWidth), MainActivity.ScreenHeight / 2 + 11f*(float)(MainActivity.ScaleHeight));

            typeOfLevelWall[0] = "hori";
            typeOfLevelWall[1] = "hori";

            numberOfLevelWalls = 2;


        }else if(currentLevel==10){

                levelWalls[0] .set(3*MainActivity. ScreenWidth / 8 ,MainActivity. ScreenHeight / 4,   5*MainActivity. ScreenWidth / 8  , (MainActivity.ScreenHeight /4)+11f*(float)(MainActivity.ScaleHeight));
                levelWalls[1] .set(3*MainActivity. ScreenWidth / 8 ,7*MainActivity. ScreenHeight / 10,   5*MainActivity. ScreenWidth / 8  , (7*MainActivity.ScreenHeight /10)+11f*(float)(MainActivity.ScaleHeight));
                levelWalls[2] .set((float)MainActivity.ScreenWidth/2 , (float)2*MainActivity.ScreenHeight/12 , (float)MainActivity.ScreenWidth/2 + 11f*(float)(MainActivity.ScaleWidth) , (float)4*MainActivity.ScreenHeight/12  );
                levelWalls[3] .set((float)MainActivity.ScreenWidth/2 , (float)7*MainActivity.ScreenHeight/12 , (float)MainActivity.ScreenWidth/2 + 11f*(float)(MainActivity.ScaleWidth), (float)9*MainActivity.ScreenHeight/12  );

                typeOfLevelWall[0]="hori";
                typeOfLevelWall[1]="hori";
                typeOfLevelWall[2]="vert";
                typeOfLevelWall[3]="vert";

                numberOfLevelWalls=4;


        }else if(currentLevel==20){


            levelWalls[0].set(4 * (MainActivity.ScreenWidth / 20), 3*MainActivity.ScreenHeight/20, 4* (MainActivity.ScreenWidth / 20) + 14f*(float)(MainActivity.ScaleHeight), 5 * (MainActivity.ScreenHeight / 20));
            levelWalls[1].set(15 * (MainActivity.ScreenWidth / 20), 3 * MainActivity.ScreenHeight / 20, 15 * (MainActivity.ScreenWidth / 20) + 14f*(float)(MainActivity.ScaleHeight), 5 * (MainActivity.ScreenHeight / 20));

            levelWalls[2] .set((8 * MainActivity.ScreenWidth / 20), 5 * MainActivity.ScreenHeight / 20, (11 * MainActivity.ScreenWidth / 20), 5 * MainActivity.ScreenHeight / 20 + 14f*(float)(MainActivity.ScaleHeight));
            levelWalls[3] .set((6 * MainActivity.ScreenWidth / 20), 8 * MainActivity.ScreenHeight / 20, (7 * MainActivity.ScreenWidth / 20), 8 * MainActivity.ScreenHeight / 20 + 14f*(float)(MainActivity.ScaleHeight));

            levelWalls[4] .set((11 * MainActivity.ScreenWidth / 20), 9 * MainActivity.ScreenHeight / 20, (12 * MainActivity.ScreenWidth / 20), 9 * MainActivity.ScreenHeight / 20 + 14f*(float)(MainActivity.ScaleHeight));

            levelWalls[5] .set(0, 10 * MainActivity.ScreenHeight / 20, (2 * MainActivity.ScreenWidth / 20), 10 * MainActivity.ScreenHeight / 20 + 14f*(float)(MainActivity.ScaleHeight));


            levelWalls[6].set(17 * (MainActivity.ScreenWidth / 20), 12 * MainActivity.ScreenHeight / 20, 17 * (MainActivity.ScreenWidth / 20) + 14f*(float)(MainActivity.ScaleHeight), 13 * (MainActivity.ScreenHeight / 20));


            levelWalls[7] .set((17 * MainActivity.ScreenWidth / 20), 12 * MainActivity.ScreenHeight / 20, MainActivity.ScreenWidth, 12 * MainActivity.ScreenHeight / 20 + 14f*(float)(MainActivity.ScaleHeight));


            levelWalls[8] .set((3 * MainActivity.ScreenWidth / 20), 13 * MainActivity.ScreenHeight / 20, (5 * MainActivity.ScreenWidth / 20), 13 * MainActivity.ScreenHeight / 20 + 14f*(float)(MainActivity.ScaleHeight));
            levelWalls[9].set(5 * MainActivity.ScreenWidth / 20, 13 * MainActivity.ScreenHeight / 20, 5 * MainActivity.ScreenWidth / 20 + 14f*(float)(MainActivity.ScaleHeight), 14 * (MainActivity.ScreenHeight / 20));


            levelWalls[10] .set((7 * MainActivity.ScreenWidth / 20), 17 * MainActivity.ScreenHeight / 20, (8 * MainActivity.ScreenWidth / 20), 17 * MainActivity.ScreenHeight / 20 + 14f*(float)(MainActivity.ScaleHeight));

            levelWalls[11].set(7 * MainActivity.ScreenWidth / 20, 5 * MainActivity.ScreenHeight / 20, 7 * MainActivity.ScreenWidth / 20 + 14f*(float)(MainActivity.ScaleHeight), 8 * (MainActivity.ScreenHeight / 20));
            levelWalls[12].set(12 * MainActivity.ScreenWidth / 20, 5 * MainActivity.ScreenHeight / 20, 12 * MainActivity.ScreenWidth / 20 + 14f*(float)(MainActivity.ScaleHeight), 7 * (MainActivity.ScreenHeight / 20));

            levelWalls[13] .set((9 * MainActivity.ScreenWidth / 20), 14 * MainActivity.ScreenHeight / 20, (11 * MainActivity.ScreenWidth / 20), 14 * MainActivity.ScreenHeight / 20 + 14f*(float)(MainActivity.ScaleHeight));
            levelWalls[14].set(14 * MainActivity.ScreenWidth / 20, 16 * MainActivity.ScreenHeight / 20, 14 * MainActivity.ScreenWidth / 20 + 14f*(float)(MainActivity.ScaleHeight), 18 * (MainActivity.ScreenHeight / 20));


            typeOfLevelWall[0]="vert";
            typeOfLevelWall[1]="vert";
            typeOfLevelWall[2]="hori";
            typeOfLevelWall[3]="hori";
            typeOfLevelWall[4]="hori";
            typeOfLevelWall[5]="hori";
            typeOfLevelWall[6]="vert";
            typeOfLevelWall[7]="hori";
            typeOfLevelWall[8]="hori";
            typeOfLevelWall[9]="vert";
            typeOfLevelWall[10]="hori";
            typeOfLevelWall[11]="vert";
            typeOfLevelWall[12]="vert";
            typeOfLevelWall[13]="hori";
            typeOfLevelWall[14]="vert";

            numberOfLevelWalls=15;


        }else if(currentLevel==12) {

            levelWalls[0] .set((6 * MainActivity.ScreenWidth / 20), (float)MainActivity.ScreenHeight - (6*Assets.bluemarker.getHeight())+ Assets.spikyVert.getHeight() + Assets.spikyVert.getHeight()/2, (14 * MainActivity.ScreenWidth / 20), (float)MainActivity.ScreenHeight - (6*Assets.bluemarker.getHeight()) + Assets.spikyVert.getHeight()/2 + Assets.spikyVert.getHeight() + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[1] .set(0, (float)MainActivity.ScreenHeight - (7*Assets.bluemarker.getHeight()), (3 * MainActivity.ScreenWidth / 20), (float)MainActivity.ScreenHeight - (7*Assets.bluemarker.getHeight())+ 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[2] .set((17* MainActivity.ScreenWidth / 20), (float)MainActivity.ScreenHeight - (7*Assets.bluemarker.getHeight()), MainActivity.ScreenWidth , (float)MainActivity.ScreenHeight - (7*Assets.bluemarker.getHeight())  + 14f * (float) (MainActivity.ScaleHeight));

            typeOfLevelWall[0]="hori";
            typeOfLevelWall[1]="hori";
            typeOfLevelWall[2]="hori";

            numberOfLevelWalls=3;

        }else if(currentLevel==13){

            //levelWalls[0] .set(MainActivity.ScreenWidth/2-Assets.dogleft1.getWidth(), (float)MainActivity.ScreenHeight/2 - Assets.dogright1.getHeight() ,MainActivity.ScreenWidth/2+Assets.dogleft1.getWidth() , (float)MainActivity.ScreenHeight/2 - Assets.dogright1.getHeight()  + 14f * (float) (MainActivity.ScaleHeight));
            //levelWalls[1] .set(MainActivity.ScreenWidth/2-Assets.dogleft1.getWidth(), (float)MainActivity.ScreenHeight/2 + Assets.dogright1.getHeight() ,MainActivity.ScreenWidth/2+Assets.dogleft1.getWidth() , (float)MainActivity.ScreenHeight/2 + Assets.dogright1.getHeight()  + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[0] .set(0, (float)MainActivity.ScreenHeight/2 - Assets.dogright1.getHeight() ,  2*Assets.dogleft1.getWidth()    , (float)MainActivity.ScreenHeight/2 - Assets.dogright1.getHeight()  + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[1] .set(0, (float) MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight(),   2*Assets.dogleft1.getWidth()   , (float) MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight() + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[2] .set(7 * (float) MainActivity.ScreenWidth / 12 ,  (float) MainActivity.ScreenHeight / 5 , 9 * (float) MainActivity.ScreenWidth / 12, (float) MainActivity.ScreenHeight / 5  + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[3] .set(7 * (float) MainActivity.ScreenWidth / 12, 0, 7 * (float) MainActivity.ScreenWidth / 12+ 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight / 5);

            levelWalls[4] .set(0 ,  2*(float) MainActivity.ScreenHeight / 8 , 3 * (float) MainActivity.ScreenWidth / 12, 2*(float) MainActivity.ScreenHeight / 8  + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[5] .set(9 * (float) MainActivity.ScreenWidth / 12, 4 * (float) MainActivity.ScreenHeight / 8, MainActivity.ScreenWidth, 4 * (float) MainActivity.ScreenHeight / 8 + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[6] .set(9 * (float) MainActivity.ScreenWidth / 12, 4 * (float) MainActivity.ScreenHeight / 8 , 9 * (float) MainActivity.ScreenWidth / 12 + 14f * (float) (MainActivity.ScaleHeight),6 * (float) MainActivity.ScreenHeight / 9 );
            levelWalls[7] .set((float) MainActivity.ScreenWidth / 2, 6 * (float) MainActivity.ScreenHeight / 8, (float) MainActivity.ScreenWidth / 2 + 14f * (float) (MainActivity.ScaleHeight),  (float) MainActivity.ScreenHeight );

            levelWalls[8] .set(3 * (float) MainActivity.ScreenWidth / 12, 6 * (float) MainActivity.ScreenHeight / 8, (float) MainActivity.ScreenWidth / 2, 6 * (float) MainActivity.ScreenHeight / 8 + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[9] .set(3 * (float) MainActivity.ScreenWidth / 12  ,  0  ,  3 * (float) MainActivity.ScreenWidth / 12 +  11f* (float)(MainActivity.ScaleWidth)   , 2*(float) MainActivity.ScreenHeight / 8 );
            levelWalls[10] .set(0, 6 * (float) MainActivity.ScreenHeight / 8, 3 * (float) MainActivity.ScreenWidth / 12, 6 * (float) MainActivity.ScreenHeight / 8 + 11f * (float) (MainActivity.ScaleHeight));

            levelWalls[11] .set(9 * (float) MainActivity.ScreenWidth / 12,    6 * (float) MainActivity.ScreenHeight / 9    , 9 * (float) MainActivity.ScreenWidth / 12 + 11f * (float) (MainActivity.ScaleWidth),  (float) MainActivity.ScreenHeight );
            levelWalls[12] .set(9 * (float) MainActivity.ScreenWidth / 12 ,  (float) MainActivity.ScreenHeight / 5 ,    (float) MainActivity.ScreenWidth      , (float) MainActivity.ScreenHeight / 5 + 11f * (float) (MainActivity.ScaleHeight) );






            typeOfLevelWall[0]="hori";
            typeOfLevelWall[1]="hori";
            typeOfLevelWall[2]="hori";
            typeOfLevelWall[3]="vert";
            typeOfLevelWall[4]="hori";
            typeOfLevelWall[5]="hori";
            typeOfLevelWall[6]="vert";
            typeOfLevelWall[7]="vert";
            typeOfLevelWall[8]="hori";
            typeOfLevelWall[9]="vert";
            typeOfLevelWall[10]="hori";
            typeOfLevelWall[11]="vert";
            typeOfLevelWall[12]="hori";


            breakableWall[9]='y';
            breakableWall[10]='y';
            breakableWall[11]='y';
            breakableWall[12]='y';



            numberOfLevelWalls=13;



        }else if(currentLevel==14) {

            levelWalls[0].set(0, MainActivity.ScreenHeight / 2, (MainActivity.ScreenWidth / 6), (MainActivity.ScreenHeight / 2) + 10f);
            levelWalls[1].set(5 * (MainActivity.ScreenWidth / 6), MainActivity.ScreenHeight / 2, (MainActivity.ScreenWidth), MainActivity.ScreenHeight / 2 + 10f);

            typeOfLevelWall[0] = "hori";
            typeOfLevelWall[1] = "hori";

            numberOfLevelWalls = 2;

        }else if(currentLevel==15){

            levelWalls[0].set((float) MainActivity.ScreenWidth / 4 , (float) 2*MainActivity.ScreenHeight / 10 , (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleWidth), (float)3* MainActivity.ScreenHeight / 10);
            typeOfLevelWall[0] = "vert";


            levelWalls[1].set((float)3* MainActivity.ScreenWidth / 4 , (float) 7*MainActivity.ScreenHeight / 10 , 3*(float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleWidth), (float)8* MainActivity.ScreenHeight / 10);
            typeOfLevelWall[1] = "vert";




            numberOfLevelWalls = 2;







        }else if(currentLevel==16) {

            levelWalls[0].set((float) MainActivity.ScreenWidth / 2 - Assets.dogright1.getWidth(), (float) MainActivity.ScreenHeight / 2 - Assets.dogright1.getHeight(), (float) MainActivity.ScreenWidth / 2 + Assets.dogright1.getWidth(), (float) MainActivity.ScreenHeight / 2 - Assets.dogright1.getHeight() + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[1].set((float) MainActivity.ScreenWidth / 2 - Assets.dogright1.getWidth(), (float) MainActivity.ScreenHeight / 2 - Assets.dogright1.getHeight(), (float) MainActivity.ScreenWidth / 2 - Assets.dogright1.getWidth() + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight());
            levelWalls[2].set((float) MainActivity.ScreenWidth / 2 + Assets.dogright1.getWidth(), (float) MainActivity.ScreenHeight / 2 - Assets.dogright1.getHeight(), (float) MainActivity.ScreenWidth / 2 + Assets.dogright1.getWidth() + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight());
            levelWalls[3].set((float) MainActivity.ScreenWidth / 2 - 3 * Assets.dogright1.getWidth(), (float) 4 * MainActivity.ScreenHeight / 5 - Assets.dogright1.getHeight(), (float) MainActivity.ScreenWidth / 2 + 3 * Assets.dogright1.getWidth(), (float) 4 * MainActivity.ScreenHeight / 5
                    - Assets.dogright1.getHeight() + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[4].set(0, (float) MainActivity.ScreenHeight / 4 + Assets.dogright1.getHeight() / 2, 3 * (float) MainActivity.ScreenWidth / 12, (float) MainActivity.ScreenHeight / 4 + Assets.dogright1.getHeight() / 2 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[5].set(9 * (float) MainActivity.ScreenWidth / 12, (float) MainActivity.ScreenHeight / 4 + Assets.dogright1.getHeight() / 2, (float) MainActivity.ScreenWidth, (float) MainActivity.ScreenHeight / 4 + Assets.dogright1.getHeight() / 2 + 14f * (float) (MainActivity.ScaleHeight));


            typeOfLevelWall[0] = "hori";
            typeOfLevelWall[1] = "vert";
            typeOfLevelWall[2] = "vert";
            typeOfLevelWall[3] = "hori";
            typeOfLevelWall[4] = "hori";
            typeOfLevelWall[5] = "hori";


            numberOfLevelWalls = 6;


        }else if(currentLevel==17){

            levelWalls[0].set((float) 4*MainActivity.ScreenWidth / 20, (float) 4*MainActivity.ScreenHeight / 20, (float)5* MainActivity.ScreenWidth / 20 , (float) 4*MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[1].set((float) 9*MainActivity.ScreenWidth / 20, (float) 4*MainActivity.ScreenHeight / 20, (float)11* MainActivity.ScreenWidth / 20 , (float) 4*MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[2].set((float) 15*MainActivity.ScreenWidth / 20, (float) 4*MainActivity.ScreenHeight / 20, (float)16* MainActivity.ScreenWidth / 20 , (float) 4*MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[3].set((float) 4*MainActivity.ScreenWidth / 20, (float) 8*MainActivity.ScreenHeight / 20, (float)5* MainActivity.ScreenWidth / 20 , (float) 8*MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[4].set((float) 9*MainActivity.ScreenWidth / 20, (float) 8*MainActivity.ScreenHeight / 20, (float)11* MainActivity.ScreenWidth / 20 , (float) 8*MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[5].set((float) 15*MainActivity.ScreenWidth / 20, (float) 8*MainActivity.ScreenHeight / 20, (float)16* MainActivity.ScreenWidth / 20 , (float) 8*MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[6].set((float) 4 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20, (float) 5 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[7].set((float) 9 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20, (float) 11 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[8].set((float) 15 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20, (float) 16 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[9].set((float) 4 * MainActivity.ScreenWidth / 20, (float) 15 * MainActivity.ScreenHeight / 20, (float) 5 * MainActivity.ScreenWidth / 20, (float) 15 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[10].set((float) 9 * MainActivity.ScreenWidth / 20, (float) 15 * MainActivity.ScreenHeight / 20, (float) 11 * MainActivity.ScreenWidth / 20, (float) 15 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[11].set((float) 15 * MainActivity.ScreenWidth / 20, (float) 15 * MainActivity.ScreenHeight / 20, (float) 16 * MainActivity.ScreenWidth / 20, (float) 15 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));


            typeOfLevelWall[0] = "hori";
            typeOfLevelWall[1] = "hori";
            typeOfLevelWall[2] = "hori";

            typeOfLevelWall[3] = "hori";
            typeOfLevelWall[4] = "hori";
            typeOfLevelWall[5] = "hori";

            typeOfLevelWall[6] = "hori";
            typeOfLevelWall[7] = "hori";
            typeOfLevelWall[8] = "hori";

            typeOfLevelWall[9] = "hori";
            typeOfLevelWall[10] = "hori";
            typeOfLevelWall[11] = "hori";

            numberOfLevelWalls = 12;

        }else if(currentLevel==18){

            levelWalls[0].set(3 * (float) MainActivity.ScreenWidth / 8, (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight())), 3 * (float) MainActivity.ScreenWidth / 8 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight()));
            levelWalls[1].set(5 * (float) MainActivity.ScreenWidth / 8, (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight() ), 5 * (float) MainActivity.ScreenWidth / 8 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight()));

            levelWalls[2].set((float) 4 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20, (float) 5 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[3].set((float) 9 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20, (float) 11 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[4].set((float) 15 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20, (float) 16 * MainActivity.ScreenWidth / 20, (float) 12 * MainActivity.ScreenHeight / 20 + 14f * (float) (MainActivity.ScaleHeight));


            typeOfLevelWall[0] = "vert";
            typeOfLevelWall[1] = "vert";
            typeOfLevelWall[2] = "hori";
            typeOfLevelWall[3] = "hori";
            typeOfLevelWall[4] = "hori";



            levelWalls[5].set(0, (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight())), 3 * (float) MainActivity.ScreenWidth / 8, (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight())+11f * (float) (MainActivity.ScaleHeight)));
            levelWalls[6].set(5 * (float) MainActivity.ScreenWidth / 8, (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight())), MainActivity.ScreenWidth , (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight())+11f * (float) (MainActivity.ScaleHeight)));


            breakableWall[5]='y';
            breakableWall[6]='y';

            typeOfLevelWall[5] = "hori";
            typeOfLevelWall[6] = "hori";


            levelWalls[7].set(0, (float) (MainActivity.ScreenHeight / 5), 2 * (float) MainActivity.ScreenWidth / 10, (float) (MainActivity.ScreenHeight / 5) + 11f * (float) (MainActivity.ScaleHeight));
            levelWalls[8].set(8 * (float) MainActivity.ScreenWidth / 10, (float) (MainActivity.ScreenHeight / 5), MainActivity.ScreenWidth, (float) (MainActivity.ScreenHeight / 5) + 11f * (float) (MainActivity.ScaleHeight));
            typeOfLevelWall[7] = "hori";
            typeOfLevelWall[8] = "hori";

            levelWalls[9].set(2 * (float) MainActivity.ScreenWidth / 10, (float) (MainActivity.ScreenHeight / 5), 8 * (float) MainActivity.ScreenWidth / 10, (float) (MainActivity.ScreenHeight / 5) + 11f * (float) (MainActivity.ScaleHeight));
            typeOfLevelWall[9] = "hori";
            breakableWall[9]='y';

            levelWalls[10].set((float) MainActivity.ScreenWidth / 2, 0,  (float) MainActivity.ScreenWidth / 2 + 11f * (float) (MainActivity.ScaleWidth), (float) (2*MainActivity.ScreenHeight / 5));
            typeOfLevelWall[10] = "vert";
            breakableWall[10]='y';


            levelWalls[11].set(0, (float) (2 * MainActivity.ScreenHeight / 5) , 5* (float) MainActivity.ScreenWidth / 10, (float) (2*MainActivity.ScreenHeight / 5) + 11f * (float) (MainActivity.ScaleHeight));
            typeOfLevelWall[11] = "hori";
            breakableWall[11]='y';

            levelWalls[12].set(5* (float) MainActivity.ScreenWidth / 10 , (float) (2 * MainActivity.ScreenHeight / 5) ,  MainActivity.ScreenWidth  , (float) (2*MainActivity.ScreenHeight / 5) + 11f * (float) (MainActivity.ScaleHeight));
            typeOfLevelWall[12] = "hori";
            breakableWall[12]='y';





            numberOfLevelWalls = 13;



        }else if(currentLevel==19){

            levelWalls[0].set(3 * (float) MainActivity.ScreenWidth / 8, (float) (MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight())), 3 * (float) MainActivity.ScreenWidth / 8 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight()));
            levelWalls[1].set(5 * (float) MainActivity.ScreenWidth / 8, (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight() + Assets.bluemarker.getHeight() ), 5 * (float) MainActivity.ScreenWidth / 8 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight - (Assets.bluemarker.getHeight()));

            typeOfLevelWall[0] = "vert";
            typeOfLevelWall[1] = "vert";


            numberOfLevelWalls = 0;


        }else if(currentLevel==21){

            levelWalls[0].set(0, (float) 1 * MainActivity.ScreenHeight / 3, (float) 1 * MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 3 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[1].set((float) 1 * MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 3, (float) 2 * MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 3 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[2].set((float) 2 * MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 3, (float) 3 * MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 3 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[3].set((float) 3 * MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 3, (float) 4 * MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 3 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[4].set(1 * (float) MainActivity.ScreenWidth / 4, (float) (MainActivity.ScreenHeight /3), 1 * (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight/2);
            levelWalls[5].set(1 * (float) MainActivity.ScreenWidth / 4, (float) 2 * (MainActivity.ScreenHeight / 4), 1 * (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) 6 * MainActivity.ScreenHeight / 10);
            levelWalls[6].set(2 * (float) MainActivity.ScreenWidth / 4, (float) (MainActivity.ScreenHeight / 3), 2 * (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight / 2);
            levelWalls[7].set(2 * (float) MainActivity.ScreenWidth / 4, (float) 2 * (MainActivity.ScreenHeight / 4), 2 * (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) 6 * MainActivity.ScreenHeight / 10);
            levelWalls[8].set(3 * (float) MainActivity.ScreenWidth / 4, (float) (MainActivity.ScreenHeight / 3), 3 * (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight / 2);
            levelWalls[9].set(3 * (float) MainActivity.ScreenWidth / 4, (float) 2 * (MainActivity.ScreenHeight / 4), 3 * (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) 6 * MainActivity.ScreenHeight / 10);
            levelWalls[10].set((float) 1 * MainActivity.ScreenWidth / 4, (float) 6 * MainActivity.ScreenHeight / 10 , (float) 2 * MainActivity.ScreenWidth / 4, (float) 6 * MainActivity.ScreenHeight / 10 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[11].set((float) 2 * MainActivity.ScreenWidth / 4, (float) 6 * MainActivity.ScreenHeight / 10 , (float) 3 * MainActivity.ScreenWidth / 4, (float) 6 * MainActivity.ScreenHeight / 10 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[12].set(3 * (float) MainActivity.ScreenWidth / 4, (float) 6 * MainActivity.ScreenHeight / 10, 3 * (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) 7.5f * MainActivity.ScreenHeight / 10);
            levelWalls[13].set(1 * (float) MainActivity.ScreenWidth / 4, (float) 6 * MainActivity.ScreenHeight / 10, 1 * (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) 7.5f * MainActivity.ScreenHeight / 10);
            levelWalls[14].set((float) 1 * MainActivity.ScreenWidth / 4, (float) 7.5f * MainActivity.ScreenHeight / 10, (float) 2 * MainActivity.ScreenWidth / 4, (float) 7.5f * MainActivity.ScreenHeight / 10 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[15].set((float) 2 * MainActivity.ScreenWidth / 4, (float) 7.5f * MainActivity.ScreenHeight / 10, (float) 3 * MainActivity.ScreenWidth / 4, (float) 7.5f * MainActivity.ScreenHeight / 10 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[16].set((float) 2 * MainActivity.ScreenWidth / 4, (float) 7.5 * MainActivity.ScreenHeight / 10, (float) 2 * MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), MainActivity.ScreenHeight );
            levelWalls[17].set((float) 3 * MainActivity.ScreenWidth / 8, (float) 1 * MainActivity.ScreenHeight / 6, (float) 5 * MainActivity.ScreenWidth / 8, (float) 1 * MainActivity.ScreenHeight / 6 + 14f * (float) (MainActivity.ScaleHeight));


            typeOfLevelWall[0] = "hori";
            typeOfLevelWall[1] = "hori";
            typeOfLevelWall[2] = "hori";
            typeOfLevelWall[3] = "hori";
            typeOfLevelWall[4] = "vert";
            typeOfLevelWall[5] = "vert";
            typeOfLevelWall[6] = "vert";
            typeOfLevelWall[7] = "vert";
            typeOfLevelWall[8] = "vert";
            typeOfLevelWall[9] = "vert";
            typeOfLevelWall[10] = "hori";
            typeOfLevelWall[11] = "hori";
            typeOfLevelWall[12] = "vert";
            typeOfLevelWall[13] = "vert";
            typeOfLevelWall[14] = "hori";
            typeOfLevelWall[15] = "hori";
            typeOfLevelWall[16] = "vert";
            typeOfLevelWall[17] = "hori";

            breakableWall[0]='n';
            breakableWall[1]='y';
            breakableWall[2]='n';
            breakableWall[3]='y';
            breakableWall[4]='n';
            breakableWall[5]='y';
            breakableWall[6]='n';
            breakableWall[7]='n';
            breakableWall[8]='n';
            breakableWall[9]='y';
            breakableWall[10]='n';
            breakableWall[11]='y';
            breakableWall[12]='n';
            breakableWall[13]='n';
            breakableWall[14]='y';
            breakableWall[15]='n';
            breakableWall[16]='n';
            breakableWall[17]='n';

            numberOfLevelWalls =18;

        }else if(currentLevel==22){

            levelWalls[0].set((float)  MainActivity.ScreenWidth/2 - (Assets.dogright1.getWidth()/2 + Assets.dogright1.getWidth()/4) , (float)  MainActivity.ScreenHeight /2 - Assets.dogright1.getHeight()/2, (float)  MainActivity.ScreenWidth/2 - (Assets.dogright1.getWidth()/2 + Assets.dogright1.getWidth()/4) + 14f * (float) (MainActivity.ScaleHeight),  (float) MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight()/2);
            levelWalls[1].set((float) MainActivity.ScreenWidth / 2 + (Assets.dogright1.getWidth() / 2 + Assets.dogright1.getWidth() / 4), (float) MainActivity.ScreenHeight /2 -Assets.dogright1.getHeight()/2, (float) MainActivity.ScreenWidth / 2 + (Assets.dogright1.getWidth() / 2 + Assets.dogright1.getWidth() / 4) + 14f * (float) (MainActivity.ScaleHeight), (float)  MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight()/2);
           // levelWalls[2].set((float) MainActivity.ScreenWidth / 4 , (float) MainActivity.ScreenHeight /2 -Assets.dogright1.getHeight() , (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float)  MainActivity.ScreenHeight / 2 + 2* Assets.dogright1.getHeight());
            levelWalls[2].set((float)  MainActivity.ScreenWidth/4 , (float)  MainActivity.ScreenHeight /2 - Assets.dogright1.getHeight()/2, (float)  MainActivity.ScreenWidth/4 + 14f * (float) (MainActivity.ScaleHeight),  (float) MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight()/2);
            levelWalls[3].set((float)3* MainActivity.ScreenWidth / 4, (float) MainActivity.ScreenHeight / 2 - Assets.dogright1.getHeight() / 2, (float)3* MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight() / 2);
            levelWalls[4].set((float) MainActivity.ScreenWidth / 4, 1*MainActivity.ScreenHeight/3 , (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight / 2 - Assets.dogright1.getHeight() / 2);
            levelWalls[5].set((float) MainActivity.ScreenWidth / 4,(float) MainActivity.ScreenHeight / 2 - Assets.dogright1.getHeight() / 2 , (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), 2*MainActivity.ScreenHeight/3);
            levelWalls[6].set((float) 3 * MainActivity.ScreenWidth / 4, 1 * MainActivity.ScreenHeight / 3, (float) 3 * MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) MainActivity.ScreenHeight / 2 - Assets.dogright1.getHeight() / 2);


            levelWalls[7].set((float) 3 * MainActivity.ScreenWidth / 4, (float) MainActivity.ScreenHeight / 2 + Assets.dogright1.getHeight() / 2, (float) 3 * MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), 2 * MainActivity.ScreenHeight / 3);
            levelWalls[8].set((float) MainActivity.ScreenWidth / 4 ,  (float) 1 * MainActivity.ScreenHeight / 3, (float) 1 * MainActivity.ScreenWidth / 2, (float) 1 * MainActivity.ScreenHeight / 3 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[9].set((float) 2*MainActivity.ScreenWidth / 4 ,  (float) 1 * MainActivity.ScreenHeight / 3, (float) 3 * MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 3 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[10].set((float) MainActivity.ScreenWidth / 4 ,  (float) 2 * MainActivity.ScreenHeight / 3, (float) 1 * MainActivity.ScreenWidth / 2, (float) 2 * MainActivity.ScreenHeight / 3 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[11].set((float) 2*MainActivity.ScreenWidth / 4 ,  (float) 2 * MainActivity.ScreenHeight / 3, (float) 3 * MainActivity.ScreenWidth / 4, (float) 2 * MainActivity.ScreenHeight / 3 + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[12].set((float) 3*MainActivity.ScreenWidth / 4 ,  (float)  MainActivity.ScreenHeight / 2, (float)  MainActivity.ScreenWidth , (float) MainActivity.ScreenHeight / 2 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[13].set((float)  3*MainActivity.ScreenWidth / 4  , (float) 2* MainActivity.ScreenHeight /3 , 3*MainActivity.ScreenWidth / 4  + 14f * (float) (MainActivity.ScaleHeight),  (float) MainActivity.ScreenHeight);

            levelWalls[14].set((float) 2*MainActivity.ScreenWidth / 4  , (float) 1 * MainActivity.ScreenHeight / 4 -Assets.gemright.getHeight() , (float) 2*MainActivity.ScreenWidth / 4  + 14f * (float) (MainActivity.ScaleHeight),  (float) 1 * MainActivity.ScreenHeight / 3   );
            levelWalls[15].set((float) 2*MainActivity.ScreenWidth / 4  , (float) 1 * MainActivity.ScreenHeight / 4 -Assets.gemright.getHeight(),(float) 3*MainActivity.ScreenWidth / 4, (float) 1 * MainActivity.ScreenHeight / 4 -Assets.gemright.getHeight() + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[16].set((float)  3*MainActivity.ScreenWidth / 4  , 0 , 3*MainActivity.ScreenWidth / 4  + 14f * (float) (MainActivity.ScaleHeight),  (float) 1 * MainActivity.ScreenHeight / 4 -Assets.gemright.getHeight() );
            levelWalls[17].set(0 , (float)  MainActivity.ScreenHeight /2 , (float)  MainActivity.ScreenWidth/4,  (float) MainActivity.ScreenHeight / 2 + 14f * (float) (MainActivity.ScaleHeight) );












            typeOfLevelWall[0] = "vert";
            typeOfLevelWall[1] = "vert";
            typeOfLevelWall[2] = "vert";
            typeOfLevelWall[3] = "vert";
            typeOfLevelWall[4] = "vert";
            typeOfLevelWall[5] = "vert";
            typeOfLevelWall[6] = "vert";
            typeOfLevelWall[7] = "vert";
            typeOfLevelWall[8] = "hori";
            typeOfLevelWall[9] = "hori";
            typeOfLevelWall[10] = "hori";
            typeOfLevelWall[11] = "hori";

            typeOfLevelWall[12] = "hori";
            typeOfLevelWall[13] = "vert";
            typeOfLevelWall[14] = "vert";
            typeOfLevelWall[15] = "hori";
            typeOfLevelWall[16] = "vert";
            typeOfLevelWall[17] = "hori";





            breakableWall[0]='n';
            breakableWall[1]='n';
            breakableWall[2]='n';
            breakableWall[3]='n';
            breakableWall[4]='y';
            breakableWall[5]='n';
            breakableWall[6]='n';
            breakableWall[7]='y';
            breakableWall[8]='n';
            breakableWall[9]='y';
            breakableWall[10]='y';
            breakableWall[11]='n';

            breakableWall[12]='n';
            breakableWall[13]='n';
            breakableWall[14]='n';
            breakableWall[15]='n';
            breakableWall[16]='n';
            breakableWall[17]='n';



            numberOfLevelWalls =18;



        }else if(currentLevel==23){

            for(int i=0;i<6;i++) {
                levelWalls[i].set((float) MainActivity.ScreenWidth / 4,  i * (MainActivity.ScreenHeight/6), (float) MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) (i+1)*MainActivity.ScreenHeight / 6);
                typeOfLevelWall[i] = "vert";
                breakableWall[i]='y';


            }



            for(int i=6;i<11;i++) {
                levelWalls[i].set((float) MainActivity.ScreenWidth / 2,  (i%6) * (MainActivity.ScreenHeight/6), (float) MainActivity.ScreenWidth / 2 + 14f * (float) (MainActivity.ScaleHeight), (float) ((i+1)%6) * MainActivity.ScreenHeight / 6);
                typeOfLevelWall[i] = "vert";
                breakableWall[i]='y';

            }


            levelWalls[11].set((float) MainActivity.ScreenWidth / 2,  5 * (MainActivity.ScreenHeight/6), (float) MainActivity.ScreenWidth / 2 + 14f * (float) (MainActivity.ScaleHeight), (float) 6 * MainActivity.ScreenHeight / 6);
            typeOfLevelWall[11] = "vert";
            breakableWall[11]='y';





            for(int i=12;i<17;i++) {
                levelWalls[i].set((float)3* MainActivity.ScreenWidth / 4,  (i%6) * (MainActivity.ScreenHeight/6), (float)3* MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) ((i+1)%6) * MainActivity.ScreenHeight / 6);
                typeOfLevelWall[i] = "vert";
                breakableWall[i]='y';

            }

            levelWalls[17].set((float)3* MainActivity.ScreenWidth / 4,  5 * (MainActivity.ScreenHeight/6), (float)3* MainActivity.ScreenWidth / 4 + 14f * (float) (MainActivity.ScaleHeight), (float) 6* MainActivity.ScreenHeight / 6);
            typeOfLevelWall[17] = "vert";
            breakableWall[17]='y';




            //Hori Part

            levelWalls[18].set((float)0,   (MainActivity.ScreenHeight/4), (float)1* MainActivity.ScreenWidth / 4 , (float) MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[19].set((float) 1* MainActivity.ScreenWidth / 4, (MainActivity.ScreenHeight / 4), (float) 2 * MainActivity.ScreenWidth / 4, (float) MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[20].set((float) 2 * MainActivity.ScreenWidth / 4, (MainActivity.ScreenHeight / 4), (float) 3 * MainActivity.ScreenWidth / 4, (float) MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[21].set((float) 3 * MainActivity.ScreenWidth / 4, (MainActivity.ScreenHeight / 4), (float) 4 * MainActivity.ScreenWidth / 4, (float) MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[22].set((float)0,  2* (MainActivity.ScreenHeight/4), (float)1* MainActivity.ScreenWidth / 4 , (float)2* MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[23].set((float) 1 * MainActivity.ScreenWidth / 4, 2 * (MainActivity.ScreenHeight / 4), (float) 2 * MainActivity.ScreenWidth / 4, (float) 2 * MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[24].set((float) 2 * MainActivity.ScreenWidth / 4,2*(MainActivity.ScreenHeight / 4), (float) 3 * MainActivity.ScreenWidth / 4, (float) 2*MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[25].set((float) 3 * MainActivity.ScreenWidth / 4,2* (MainActivity.ScreenHeight / 4), (float) 4 * MainActivity.ScreenWidth / 4, (float) 2*MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));

            levelWalls[26].set((float)0,  3* (MainActivity.ScreenHeight/4), (float)1* MainActivity.ScreenWidth / 4 , (float) 3*MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[27].set((float) 1* MainActivity.ScreenWidth / 4, 3*(MainActivity.ScreenHeight / 4), (float) 2 * MainActivity.ScreenWidth / 4, (float) 3*MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[28].set((float) 2 * MainActivity.ScreenWidth / 4,3*(MainActivity.ScreenHeight / 4), (float) 3 * MainActivity.ScreenWidth / 4, (float) 3*MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));
            levelWalls[29].set((float) 3 * MainActivity.ScreenWidth / 4,3* (MainActivity.ScreenHeight / 4), (float) 4 * MainActivity.ScreenWidth / 4, (float) 3*MainActivity.ScreenHeight / 4 + 14f * (float) (MainActivity.ScaleHeight));



            for(int i=18;i<30;i++) {
                typeOfLevelWall[i] = "hori";
                breakableWall[i]='y';

            }








            numberOfLevelWalls =30;






        }
    }



    public void breakWall(int current){

        broken[current]='y';
    }




    public char isBreakable(int current){

        return breakableWall[current];

    }


    public char isItBroken(int current){

        return  broken[current];
    }






    public int getNumberOfLevelWalls(){
        return numberOfLevelWalls;
    }



    public RectF getRectOfLevelWall(int current){


        return levelWalls[current];
    }


    public String getTypeOfWall(int current){
        return typeOfLevelWall[current];
    }


    public void checkCollisionsRainTailsWithLevelWalls(RainbowTails rainTails){


        for (int p = 0; p <numberOfLevelWalls; p++) {






                float w = (float) (0.5 * (levelWalls[p].width() + rainTails.getRectOfRainbowTails().width()));
            float h = (float) (0.5 * (levelWalls[p].height() + rainTails.getRectOfRainbowTails().height()));
            float dx = levelWalls[p].centerX() - rainTails.getRectOfRainbowTails().centerX();
            float dy = levelWalls[p].centerY() - rainTails.getRectOfRainbowTails().centerY();

            if (Math.abs(dx) <= w && Math.abs(dy) <= h && isItBroken(p)=='n' && isLocked(p)=='y') {
    /* collision! */
                float wy = w * dy;
                float hx = h * dx;



                if (wy > hx) {
                    if (wy > -hx) {
                        rainTails.updateSpeedY(-Math.abs(rainTails.getSpeedY()));
            /* collision at the top */
                    } else {
                        rainTails.updateSpeedX(Math.abs(rainTails.getSpeedX()));


            /* on the left */
                    }


                } else {
                    if (wy > -hx) {

                        rainTails.updateSpeedX(-Math.abs(rainTails.getSpeedX()));
            /* on the right */
                    } else {
                        rainTails.updateSpeedY(Math.abs(rainTails.getSpeedY()));
            /* at the bottom */

                    }
                }



                if(isBreakable(p)=='y'){

                    broken[p]='y';

                }

                if(isBreakable(p)=='d'){

                    for(int i=0;i<numberOfLevelWalls;i++){
                        if(locked[i]=='n'){
                            locked[i]='y';
                            break;
                        }
                    }

                    locked[p]='n';

                }



            }


        }
    }


    public char isLocked(int current){
        return locked[current];
    }




    public void checkCollisionSpikyDoubleWallsWithLevelWalls(SpikyWalls spikyDouble,int i){


            for(int p=0;p<numberOfLevelWalls;p++) {


                if(isItBroken(p)=='n') {

                    float w = (float) (0.5 * (levelWalls[p].width() + spikyDouble.getRectOfSpikyDouble(i).width()));
                    float h = (float) (0.5 * (levelWalls[p].height() + spikyDouble.getRectOfSpikyDouble(i).height()));
                    float dx = levelWalls[p].centerX() - spikyDouble.getRectOfSpikyDouble(i).centerX();
                    float dy = levelWalls[p].centerY() - spikyDouble.getRectOfSpikyDouble(i).centerY();

                    if (Math.abs(dx) <= w && Math.abs(dy) <= h) {
    /* collision! */
                        float wy = w * dy;
                        float hx = h * dx;

                        if (wy > hx) {
                            if (wy > -hx) {
                                spikyDouble.updateSpeedY(-Math.abs(spikyDouble.getSpeedY(i)), i);
            /* collision at the top */
                            } else {
                                spikyDouble.updateSpeedX(Math.abs(spikyDouble.getSpeedX(i)), i);


            /* on the left */
                            }


                        } else {
                            if (wy > -hx) {

                                spikyDouble.updateSpeedX(-Math.abs(spikyDouble.getSpeedX(i)), i);
            /* on the right */
                            } else {
                                spikyDouble.updateSpeedY(Math.abs(spikyDouble.getSpeedY(i)), i);
            /* at the bottom */

                            }
                        }

                    }
                }

        }


    }





    public void checkCollisionFireBallsWithLevelWalls(FireBall fireBallObj){


        for(int i=0;i<fireBallObj.getNumberOfFireballs();i++){
            for(int p=0;p<numberOfLevelWalls;p++) {


                if(isItBroken(p)=='n') {

                    float w = (float) (0.5 * (levelWalls[p].width() + fireBallObj.getRectOfFireBall(i).width()));
                    float h = (float) (0.5 * (levelWalls[p].height() + fireBallObj.getRectOfFireBall(i).height()));
                    float dx = levelWalls[p].centerX() - fireBallObj.getRectOfFireBall(i).centerX();
                    float dy = levelWalls[p].centerY() - fireBallObj.getRectOfFireBall(i).centerY();

                    if (Math.abs(dx) <= w && Math.abs(dy) <= h) {
    /* collision! */
                        float wy = w * dy;
                        float hx = h * dx;

                        if (wy > hx) {
                            if (wy > -hx) {
                                fireBallObj.updateSpeedY(-Math.abs(fireBallObj.getSpeedY(i)), i);
            /* collision at the top */
                            } else {
                                fireBallObj.updateSpeedX(Math.abs(fireBallObj.getSpeedX(i)), i);


            /* on the left */
                            }


                        } else {
                            if (wy > -hx) {

                                fireBallObj.updateSpeedX(-Math.abs(fireBallObj.getSpeedX(i)), i);
            /* on the right */
                            } else {
                                fireBallObj.updateSpeedY(Math.abs(fireBallObj.getSpeedY(i)), i);
            /* at the bottom */

                            }
                        }

                    }
                }
            }
        }


    }


}
