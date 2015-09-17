package com.rainbowtails.canatay.rainbowtails;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;


public class GameView extends SurfaceView implements Runnable {

    Matrix matrix2;
    float px2 ;
    float py2;
    boolean testSituation=false;
    float hitStartX;
    float hitStartY;
    float hitEndX;
    float hitEndY;


    //Current level of game
    static int currentLevel= 7;

    //Will start from level select state
    public static String currentState="mainscreen";


    float statusLineThickness;
    int smokeTries=0;
    int freezeCount=0;
    boolean boingMusicStillPlaying=false;
    boolean pressed=false;
    int frozenDogMovement=0;
    int frozenDogAngle=30;
    int protectionAngle=30;
    int numberOfLives=5;
    int countdowntries=0;
    boolean countdownIsDone=false;
    boolean isstartGemCountDownRunning=false;
    boolean isBoosterTimerRunning=false;
    static boolean speedUpNow=false;
    boolean firstTimeEver=true;
    String pressedButtonOnMainScreen="none";
    String pressedButtonOnWorldSelect="none";
    boolean gameStartCountDownGoing=true;
    static String soundEffectsTurnedOn;
    char paintingwall='n';
RectF testerOfWall;



    SharedPreferences completedLevels;
    SharedPreferences optionsCheckList;
    static String mainMusicIsActive;
RectF[]  circleSpotsRectF;







    public static volatile boolean running=false;
    public static Thread gameThread;


    long beforeUpdateRender;
    long deltaMillis ;


    private static SurfaceHolder holder;



    int ScreenWidth;
    int ScreenHeight;
    String densityPhone;
    Matrix matrix3;


    Float beginCoordinateX;
    Float endCoordinateX;
    Float beginCoordinateY;
    Float endCoordinateY;


    private Bitmap mBitmap;
    private Canvas mCanvas;


    Context context;


    boolean test;



    private float mX, mY;
    private static final float TOLERANCE = 5;


    int numberOfFreezeBut=0;


    //Holds images hit

    boolean collide;
    boolean firstTime;
    int posOfTiles[];
    boolean positionOfTilesCertain=false;



    //Sounds
    MediaPlayer mp;
    MediaPlayer mp2;
    MediaPlayer mp3;
    MediaPlayer mp4;
    MediaPlayer mp5;
    MediaPlayer mp7;
    MediaPlayer mp8;
    MediaPlayer newGemCreated;
    MediaPlayer rainDrops;
    MediaPlayer poof;
    MediaPlayer extraLifeGained;
    MediaPlayer mpShield;
    MediaPlayer gameOverSound;
    MediaPlayer timetick;



    boolean MainMusicIsPlaying=true;
    boolean GameMusicIsPlaying=true;
    boolean SoundEffectsArePlaying=true;
    static boolean comesFromPause=false;




    int differenceX=0;
    int differenceY=0;
    int averagedifference=0;



    //Superpowers
    public static String superPowerUsed="none";
    public static String superPowerClicked="none";



    int rightSit=0;
    int leftSit=0;

    int tailscurrent=0;




    int levelInformationDialogStatus=3;

    //Countdown responsible variables
    CountDownTimer tickingClock;
    CountDownTimer bumpSpeedCountDown;
    CountDownTimer gemCountDown;
    CountDownTimer protectionClock;

    private long timeLeftOfTimer=125000;
    private long timeLeftOfGemCountDownTimer=10000;
    private long timeLeftOfProtection=9000;
    private long timeLeftOfSpeedUpBooster=9000;
    private long stopTimeOfBoing=-100;

    boolean isCountTimerRunning=false;
    boolean isProtectionTimerRunning=false;
    String timeLeftText;


    //Our cool superpower gem values
    int randomGem;
    String currentGem="none";


    //Objects
    LevelSelectTiles tilesObj;
    RainbowTails rainTails;
    FireBall fireBallObj;

    SpikyWalls spikyDoubleObj;
    Star starObj;
    Freezor freezorObj;
    Gem gemObj;
    PlayerPaintedWalls playerPaintedWallsObj;
    CircleSpawnSpot circleSpawnSpotObj;
    LevelWalls levelWall;
    Background gameBackground;
    MusicPipes musicPipesObj;

    Painter paintToolsObj;
    MarkerInks markerInk;

    int timeLeftOfSpeedUp=40;
    int numberOfCompletedLevels=1;



    public GameView(Context c, final int ScreenW, final int ScreenH,String density) {
        super(c);
        context = c;
        matrix3 = new Matrix();

testerOfWall=new RectF(0,0,0,0);

        circleSpotsRectF=new RectF[48];
        posOfTiles=new int[6];


      int a=0;
        for(int xLine=0;xLine<=5;xLine++){
            for(int yLine=1;yLine<=8;yLine++){

                circleSpotsRectF[a]=new RectF(0,0,0,0);



                    circleSpotsRectF[a].set((xLine * MainActivity.ScreenWidth / 5) - 150*(float)(MainActivity.ScaleWidth), (yLine * MainActivity.ScreenHeight / 8) - 150*(float)(MainActivity.ScaleWidth), (xLine * MainActivity.ScreenWidth / 5) + 150*(float)(MainActivity.ScaleWidth), (yLine * MainActivity.ScreenHeight / 8) + 150*(float)(MainActivity.ScaleWidth));

                a++;

            }
        }

        //So all methods can see it!!
        ScreenWidth=ScreenW;
        ScreenHeight=ScreenH;
        densityPhone=density;
        statusLineThickness=17f*(float)(MainActivity.ScaleHeight);


        completedLevels = c.getSharedPreferences("COMPLETEDLEVELSLIST", c.MODE_PRIVATE);
        optionsCheckList = c.getSharedPreferences("OPTIONSCHECKLIST", c.MODE_PRIVATE);


        //If game is opened for first time,enable all music sound effects by default
        if(optionsCheckList.getString("MainMusicIsEnabled","").equals("") &&
                optionsCheckList.getString("GameMusicIsEnabled","").equals("") &&
                optionsCheckList.getString("SoundEffectsAreEnabled","").equals("")){



            SharedPreferences.Editor prefEditor = optionsCheckList.edit();

            prefEditor.putString("MainMusicIsEnabled", "enabled");
            prefEditor.putString("GameMusicIsEnabled", "enabled");
            prefEditor.putString("SoundEffectsAreEnabled", "enabled");
            prefEditor.commit();

        }


        mainMusicIsActive=optionsCheckList.getString("MainMusicIsEnabled","");

        soundEffectsTurnedOn=optionsCheckList.getString("SoundEffectsAreEnabled","");




        //GetNumberOfCompletedLevels
        if(completedLevels.getInt("COMPLETEDLEVELS", 0)==0){
            numberOfCompletedLevels=1;

        }else{
            numberOfCompletedLevels=completedLevels.getInt("COMPLETEDLEVELS",0);
        }








        //Creates Paint
        paintToolsObj=new Painter(context);
        paintToolsObj.initializePaint();


        //will move raintails
        matrix2=new Matrix();
        test = false;



        //Sounds
        mp = MediaPlayer.create(c, R.raw.levelcompleted);
        mp2 = MediaPlayer.create(c, R.raw.fireburn);
        mp3 = MediaPlayer.create(c, R.raw.pianoone);
        mp4 = MediaPlayer.create(c, R.raw.violin);
        mp5 = MediaPlayer.create(c, R.raw.spikyhit);
        mp7 = MediaPlayer.create(c, R.raw.wind);
        mp8 = MediaPlayer.create(c, R.raw.markerclicked);
        newGemCreated = MediaPlayer.create(c, R.raw.newgem);
        rainDrops = MediaPlayer.create(c, R.raw.rain);
        poof = MediaPlayer.create(c, R.raw.poof);
        extraLifeGained= MediaPlayer.create(c, R.raw.extralifegain);
        mpShield=MediaPlayer.create(c,R.raw.shield);
        gameOverSound=MediaPlayer.create(c,R.raw.youlose);
        timetick=MediaPlayer.create(c,R.raw.timetick);



        //Images will always be used


        collide = false;



        firstTime = true;

        //iniyialize canvas
        mBitmap = Bitmap.createBitmap(ScreenW, ScreenH, Bitmap.Config.RGB_565);
        mCanvas = new Canvas(mBitmap);


        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {


                if(currentState.equals("youwin") || currentState.equals("youlose") ) {



                }else if(currentState.equals("playinggame")) {

                    if(timetick.isPlaying()){

                        timetick.pause();
                        timetick.seekTo(0);

                    }

                    if(mpShield.isPlaying()){
                        mpShield.pause();
                        mpShield.seekTo(0);
                    }


                    if(rainDrops.isPlaying()){
                        rainDrops.pause();
                        rainDrops.seekTo(0);
                    }




                    gemCountDown.cancel();
                    tickingClock.cancel();
                    isCountTimerRunning = false;


                    pauseGame();


                }else{


                }
            }


            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                Assets.onResume(optionsCheckList.getString("GameMusicIsEnabled",""), optionsCheckList.getString("MainMusicIsEnabled","")   , currentState);

                if(currentState.equals("worldselect")){

                    Assets.load("worldselect");
                    displayWorldSelect();


                    Assets.startMainMusic(optionsCheckList.getString("MainMusicIsEnabled", ""));

                }else if(currentState.equals("mainscreen")){


                    Assets.load("mainscreen");
                    displayMainScreen();

                    Assets.startMainMusic(optionsCheckList.getString("MainMusicIsEnabled", ""));



                }else if (currentState.equals("levelselect")) {

                    //Load Images
                    Assets.load("levelselect");
                    displayLevelSelect();
                    Assets.startMainMusic(optionsCheckList.getString("MainMusicIsEnabled", ""));



                } else if(currentState.equals("playinggame")){


                    Assets.recycleBitmaps("playinggame");
                    Assets.load("gamepaused");
                    currentState="gamepaused";
                    displayGamePausedAlertDialog();



                }else if(currentState.equals("gamepaused")){

                    Assets.recycleBitmaps("gamepaused");
                    Assets.load("gamepaused");
                    currentState="gamepaused";
                    displayGamePausedAlertDialog();




                }else if(currentState.equals("youwin")){

                    displayYouWinAlertDialog2();


                }else if(currentState.equals("youlose")){

                    displayYouLoseAlertDialog2();

                }else if(currentState.equals("options")){

                    displayOptions();
                    Assets.startMainMusic(optionsCheckList.getString("MainMusicIsEnabled", ""));


                }else if(currentState.equals("credits")){

                    displayCredits();
                    Assets.startMainMusic(optionsCheckList.getString("MainMusicIsEnabled", ""));

                }

            }


            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }
        });
    }




    public static void pauseGame(){

        running=false;
        while(gameThread.isAlive()){
            try {
                gameThread.join();



            }catch(InterruptedException e){

            }
            break;
        }
    }


    public  void pauseGameFromOnBack(){

        gemCountDown.cancel();
        tickingClock.cancel();
        isCountTimerRunning = false;

        running=false;

        while(gameThread.isAlive()){
            try {
                gameThread.join();



            }catch(InterruptedException e){

            }
            break;
        }

        Assets.recycleBitmaps("playinggame");
        Assets.load("gamepaused");

        displayGamePausedAlertDialog();
    }






    public void initObjects(){

        //Creates Raintails
        rainTails=new RainbowTails(0,0,0,0,Assets.dogright1.getWidth(),Assets.dogright1.getHeight());
        rainTails.initializeRainbowTails(currentLevel);

        //Creates Fireballs
        fireBallObj=new FireBall();
        fireBallObj.initializeFireBall(currentLevel);


        //Creates spikyWalls

        spikyDoubleObj=new SpikyWalls();
        spikyDoubleObj.initializeSpikyDoubleWalls(currentLevel);


        //Creates respawnspot
        circleSpawnSpotObj=new CircleSpawnSpot();
        circleSpawnSpotObj.initializeCircleSpawnSpot(currentLevel);


        //Creates Star
        starObj=new Star();
        starObj.initializeStar(currentLevel);


        //Creates Freezor
        if(currentLevel==7 || currentLevel==8 || currentLevel==20 || currentLevel==13 || currentLevel==18 || currentLevel==19 || currentLevel==24){
            freezorObj=new Freezor();
            freezorObj.initializeFreezor(currentLevel);
        }


        //Creates Gems
        gemObj=new Gem();
        gemObj.initializeGem(currentLevel);


        //Creates Music Pipes
        musicPipesObj=new MusicPipes();
        musicPipesObj.initializeMusicPipes(currentLevel);

        //Creates Level Walls
        levelWall=new LevelWalls();
        levelWall.initializeLevelWalls(currentLevel);


        //Creates PaintedWalls Obj
        playerPaintedWallsObj=new PlayerPaintedWalls();


        //Creates ink of our markers
        markerInk=new MarkerInks(currentLevel);

        //Creates background
        gameBackground=new Background();

    }





    private void displayLevelSelect(){

    tilesObj=new LevelSelectTiles();
    tilesObj.initializeLevelSelectTiles();

    mCanvas = getHolder().lockCanvas();
    mCanvas.drawBitmap(Assets.levelselectbackground, 0, -60, null);
    //mCanvas.drawBitmap(Assets.selectleveltext, ScreenWidth / 2 - Assets.selectleveltext.getWidth() / 2, ScreenHeight / 10, null);


    for(int i=1;i<=numberOfCompletedLevels;i++) {

        if(i==1){
            mCanvas.drawBitmap(Assets.l1, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==2){
            mCanvas.drawBitmap(Assets.l2, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==3){
            mCanvas.drawBitmap(Assets.l3, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==4){
            mCanvas.drawBitmap(Assets.l4, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==5){
            mCanvas.drawBitmap(Assets.l5, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==6){
            mCanvas.drawBitmap(Assets.l6, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==7){
            mCanvas.drawBitmap(Assets.l7, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==8){
            mCanvas.drawBitmap(Assets.l8, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==9){
            mCanvas.drawBitmap(Assets.l9, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==10){
            mCanvas.drawBitmap(Assets.l10, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==11){
            mCanvas.drawBitmap(Assets.l11, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==12){
            mCanvas.drawBitmap(Assets.l12, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==13){
            mCanvas.drawBitmap(Assets.l13, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==14){
            mCanvas.drawBitmap(Assets.l14, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==15){
            mCanvas.drawBitmap(Assets.l15, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==16){
            mCanvas.drawBitmap(Assets.l16, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==17){
            mCanvas.drawBitmap(Assets.l17, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==18){
            mCanvas.drawBitmap(Assets.l18, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==19){
            mCanvas.drawBitmap(Assets.l19, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==20){
            mCanvas.drawBitmap(Assets.l20, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==21){
            mCanvas.drawBitmap(Assets.l21, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==22){
            mCanvas.drawBitmap(Assets.l22, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==23){
            mCanvas.drawBitmap(Assets.l23, null, tilesObj.getRectOfTile(i-1), null);

        }else if(i==24){
            mCanvas.drawBitmap(Assets.l24, null, tilesObj.getRectOfTile(i-1), null);

        }

    }


        for(int i=numberOfCompletedLevels+1;i<=24;i++){
            mCanvas.drawBitmap(Assets.levellocked, null, tilesObj.getRectOfTile(i-1), null);

        }

    getHolder().unlockCanvasAndPost(mCanvas);

}


    public void displayWorldSelect(){

        mCanvas=getHolder().lockCanvas();

        mCanvas.drawBitmap(Assets.worldselectbackground, 0, 0, null);
        mCanvas.drawBitmap(Assets.selectworldtext, ScreenWidth / 2 - (Assets.selectworldtext.getWidth() / 2), Assets.selectworldtext.getHeight(), null);




        if(pressedButtonOnWorldSelect.equals("musicland")) {

            mCanvas.drawBitmap(Assets.musicworldbutpressed, 0, 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2, null);
        }else{

            mCanvas.drawBitmap(Assets.musicworldbut, 0, 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2, null);

        }




        mCanvas.drawBitmap(Assets.lostwoodsbut, ScreenWidth - Assets.lostwoodsbut.getWidth(), 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() + Assets.musicworldbut.getHeight(), null);
        mCanvas.drawBitmap(Assets.horrornightmarebut, 0, 2*Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight()+Assets.musicworldbut.getHeight() +Assets.lostwoodsbut.getHeight()+(Assets.selectworldtext.getHeight()/2), null);


        getHolder().unlockCanvasAndPost(mCanvas);
    }


    private void displayCredits(){

        mCanvas = getHolder().lockCanvas();

        mCanvas.drawBitmap(Assets.creditsscreen, 0, 0, null);
        getHolder().unlockCanvasAndPost(mCanvas);

    }


    private void displayClearDataAlertDialog(){

        mCanvas = getHolder().lockCanvas();
        mCanvas.drawBitmap(Assets.cleardataalertdialog, ScreenWidth/2 - Assets.cleardataalertdialog.getWidth()/2, ScreenHeight/2 - Assets.cleardataalertdialog.getHeight()/2, null);
        getHolder().unlockCanvasAndPost(mCanvas);
    }



    private void displayOptions(){

        mCanvas = getHolder().lockCanvas();

        mCanvas.drawBitmap(Assets.worldselectbackground, 0, 0, null);
        mCanvas.drawBitmap(Assets.optionsscreen, ScreenWidth / 2 - Assets.optionsscreen.getWidth() / 2, ScreenHeight / 2 - Assets.optionsscreen.getHeight() / 2, null);

        if(soundEffectsTurnedOn.equals("enabled")) {
            mCanvas.drawBitmap(Assets.optionison, ScreenWidth / 2, ScreenHeight / 2 - 1 * Assets.optionison.getHeight(), null);
        }else{
            mCanvas.drawBitmap(Assets.optionisoff, ScreenWidth / 2, ScreenHeight / 2 - 1 * Assets.optionison.getHeight(), null);


        }


        if(optionsCheckList.getString("GameMusicIsEnabled","").equals("enabled")) {
            mCanvas.drawBitmap(Assets.optionison, ScreenWidth / 2, ScreenHeight / 2 - 3 * Assets.optionison.getHeight(), null);
        }else{
            mCanvas.drawBitmap(Assets.optionisoff, ScreenWidth / 2, ScreenHeight / 2 - 3 * Assets.optionison.getHeight(), null);


        }

        if(optionsCheckList.getString("MainMusicIsEnabled","").equals("enabled")) {
            mCanvas.drawBitmap(Assets.optionison, ScreenWidth / 2, ScreenHeight / 2 - 5 * Assets.optionison.getHeight(), null);
        }else{

            mCanvas.drawBitmap(Assets.optionisoff, ScreenWidth / 2, ScreenHeight / 2 - 5 * Assets.optionison.getHeight(), null);

        }



        mCanvas.drawBitmap(Assets.cleargamedatabutton,  ScreenWidth/2, ScreenHeight/2 + Assets.cleargamedatabutton.getHeight()/2, null);
        getHolder().unlockCanvasAndPost(mCanvas);



    }



    public void displayMainScreen(){

        mCanvas=getHolder().lockCanvas();
        Paint test=new Paint();
        test.setColor(Color.WHITE);
        test.setStyle(Paint.Style.FILL);

        mCanvas.drawBitmap(Assets.worldselectbackground, 0, 0, null);
        //mCanvas.drawRect(0,0,ScreenWidth,ScreenHeight,test);


        mCanvas.drawBitmap(Assets.raintailsbig, ScreenWidth / 2 - Assets.raintailsbig.getWidth() / 2, 0, null);
        mCanvas.drawBitmap(Assets.rainbowText, ScreenWidth / 2 - Assets.rainbowText.getWidth() / 2, Assets.rainbowText.getHeight() + Assets.rainbowText.getHeight() / 4, null);
        mCanvas.drawBitmap(Assets.tailsText, ScreenWidth / 2 - Assets.tailsText.getWidth() / 2, Assets.rainbowText.getHeight() + Assets.rainbowText.getHeight() / 4 + Assets.rainbowText.getHeight(), null);


        // mCanvas.drawBitmap(Assets.playbutton,ScreenWidth/2 -Assets.playbutton.getWidth()/2,ScreenHeight/4,null);

        if(pressedButtonOnMainScreen.equals("play")) {

            mCanvas.drawBitmap(Assets.playbuttonpressed, ScreenWidth / 2 - Assets.playbutton.getWidth() / 2, 3 * ScreenHeight / 8, null);
            mCanvas.drawBitmap(Assets.optionsbutton, ScreenWidth / 2 - Assets.optionsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2, null);
            mCanvas.drawBitmap(Assets.creditsbutton, ScreenWidth / 2 - Assets.creditsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2, null);
        }else if(pressedButtonOnMainScreen.equals("options")){

            mCanvas.drawBitmap(Assets.playbutton, ScreenWidth / 2 - Assets.playbutton.getWidth() / 2, 3 * ScreenHeight / 8, null);
            mCanvas.drawBitmap(Assets.optionsbuttonpressed, ScreenWidth / 2 - Assets.optionsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2, null);
            mCanvas.drawBitmap(Assets.creditsbutton, ScreenWidth / 2 - Assets.creditsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2, null);

        }else if(pressedButtonOnMainScreen.equals("credits")){

            mCanvas.drawBitmap(Assets.playbutton, ScreenWidth / 2 - Assets.playbutton.getWidth() / 2, 3 * ScreenHeight / 8, null);
            mCanvas.drawBitmap(Assets.optionsbutton, ScreenWidth / 2 - Assets.optionsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2, null);
            mCanvas.drawBitmap(Assets.creditsbuttonpressed, ScreenWidth / 2 - Assets.creditsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2, null);



        }else{
            mCanvas.drawBitmap(Assets.playbutton, ScreenWidth / 2 - Assets.playbutton.getWidth() / 2, 3 * ScreenHeight / 8, null);
            mCanvas.drawBitmap(Assets.optionsbutton, ScreenWidth / 2 - Assets.optionsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2, null);
            mCanvas.drawBitmap(Assets.creditsbutton, ScreenWidth / 2 - Assets.creditsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2, null);

        }

        getHolder().unlockCanvasAndPost(mCanvas);
    }


    private void displayYouWinAlertDialog() {
        Assets.onPause();  //Pause All Sounds
        mCanvas = getHolder().lockCanvas();
        //mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        //mCanvas.drawBitmap(Assets.musicbackgroundblurry,0,0,null);
        mCanvas.drawBitmap(Assets.youwinalertdialog, ScreenWidth / 2 - Assets.youwinalertdialog.getWidth() / 2, ScreenHeight / 2 - Assets.youwinalertdialog.getHeight() / 2, null);
        getHolder().unlockCanvasAndPost(mCanvas);


        gemCountDown.cancel();
        tickingClock.cancel();
        isCountTimerRunning=false;
        timeLeftOfTimer=125000;
        pauseGame();
    }



    private void displayYouWinAlertDialog2() {
        Assets.onPause();  //Pause All Sounds
        mCanvas = getHolder().lockCanvas();
        //mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        //mCanvas.drawBitmap(Assets.musicbackgroundblurry,0,0,null);
        mCanvas.drawBitmap(Assets.youwinalertdialog, ScreenWidth / 2 - Assets.youwinalertdialog.getWidth() / 2, ScreenHeight / 2 - Assets.youwinalertdialog.getHeight() / 2, null);
        getHolder().unlockCanvasAndPost(mCanvas);


    }

    private void displayYouLoseAlertDialog() {

        Assets.onPause();  //Pause All Sounds
        mCanvas = getHolder().lockCanvas();
        // mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        // mCanvas.drawBitmap(Assets.musicbackgroundblurry,0,0,null);
        mCanvas.drawBitmap(Assets.toobadalertdialog, ScreenWidth / 2 - Assets.toobadalertdialog.getWidth() / 2, ScreenHeight / 2 - Assets.toobadalertdialog.getHeight() / 2, null);
        getHolder().unlockCanvasAndPost(mCanvas);

        gemCountDown.cancel();
        tickingClock.cancel();
        isCountTimerRunning=false;
        pauseGame();
    }



    public void displayQuitGameAlertDialog() {


        mCanvas = getHolder().lockCanvas();

       // mCanvas.drawBitmap(Assets.quitalertdialog, ScreenWidth / 2 - Assets.quitalertdialog.getWidth() / 2, ScreenHeight / 2 - Assets.quitalertdialog.getHeight() / 2, null);
        getHolder().unlockCanvasAndPost(mCanvas);

    }


    private void displayYouLoseAlertDialog2() {

        Assets.onPause();  //Pause All Sounds
        mCanvas = getHolder().lockCanvas();
        mCanvas.drawBitmap(Assets.toobadalertdialog, ScreenWidth / 2 - Assets.toobadalertdialog.getWidth() / 2, ScreenHeight / 2 - Assets.toobadalertdialog.getHeight() / 2, null);
        getHolder().unlockCanvasAndPost(mCanvas);

    }

    private void displayGamePausedAlertDialog(){

        Assets.onPause();  //Pause All Sounds
        mCanvas = getHolder().lockCanvas();
        mCanvas.drawBitmap(Assets.gamepausedalertdialog, ScreenWidth / 2 - Assets.gamepausedalertdialog.getWidth() / 2, ScreenHeight / 2 - Assets.gamepausedalertdialog.getHeight() / 2, null);
        getHolder().unlockCanvasAndPost(mCanvas);


    }





    private void initGame() {

        //Assets.onResume(optionsCheckList.getString("GameMusicIsEnabled",""));
        Assets.startGameMusic(optionsCheckList.getString("GameMusicIsEnabled",""));


        running=true;
        gameThread=new Thread(this, "Game Thread");
        gameThread.start();
        boingMusicStillPlaying=false;
        speedUpNow = false;
        stopTimeOfBoing=-100;
        startCountDownClock();


        if(isstartGemCountDownRunning==true || firstTimeEver==true ) {
            startGemCountDown();
            firstTimeEver=false;
        }

    }






    @Override
    public void run(){

        long updateDurationMillis = 0;
        long sleepDurationMillis = 0;

        while (running) {

            if(currentState.equals("playinggame") || currentState.equals("levelselect")) {




                superPowerUpdates();

                if(countdownIsDone==true) {
                    moveImagesOnScreen();
                }
                //updateImagesRectFOnScreen();

                beforeUpdateRender = System.nanoTime();
                deltaMillis = sleepDurationMillis + updateDurationMillis;
                updateAndRender(deltaMillis);
                updateDurationMillis = (System.nanoTime() - beforeUpdateRender) / 1500000L;
                sleepDurationMillis = Math.max(2, 17 - updateDurationMillis);

            }else if(currentState.equals("youwin")){







                System.gc();
                Assets.recycleBitmaps("playinggame");
                Assets.load("youwin");
                displayYouWinAlertDialog();

            }else if(currentState.equals("youlose")){

                System.gc();
                Assets.recycleBitmaps("playinggame");
                Assets.load("youlose");
                displayYouLoseAlertDialog();
            }


            try {
                Thread.sleep(sleepDurationMillis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }






    private void moveImagesOnScreen() {

        rainTails.updatePos();
        fireBallObj.updatePos(currentLevel);
        spikyDoubleObj.updatePos();

    }







    @Override
    public boolean onTouchEvent(MotionEvent event) {



        if(currentState.equals("levelselect")) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    beginCoordinateX = event.getX();
                    endCoordinateX = event.getX();
                    beginCoordinateY = event.getY();
                    endCoordinateY = event.getY();

                    Log.i("From SHAREDPREFERENCES", String.valueOf(completedLevels.getInt("COMPLETEDLEVELS", 0)));


                    for (int i = 0; i < 24; i++) {
                        if (tilesObj.getRectOfTile(i).contains(beginCoordinateX, beginCoordinateY)) {

                            currentLevel=i+1;

                            if(currentLevel<=(numberOfCompletedLevels)) {



                                currentState = "playinggame";
                                //Starts the game

                                Assets.load("playinggame");
                                numberOfLives = 5;
                                initObjects();

                                Assets.stopMainMusic();


                                countdownIsDone = false;
                                levelInformationDialogStatus=3;
                                initGame();
                                System.gc();
                            }
                        }
                    }


                case MotionEvent.ACTION_UP:
                    beginCoordinateX = 0f;
                    endCoordinateX = 0f;
                    beginCoordinateY = 0f;
                    endCoordinateY = 0f;
            }

            return false;


        }else if(currentState.equals("worldselect")){


           // mCanvas.drawBitmap(Assets.musicworldbut, 0, 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2, null);

            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    if(event.getX()<Assets.musicworldbut.getWidth() && event.getY() > 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2 &&  event.getY() < 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2 + Assets.musicworldbut.getHeight()){

                        pressedButtonOnWorldSelect="musicland";
                        displayWorldSelect();
                        return true;

                    }

                    break;


                case MotionEvent.ACTION_UP:



                    if(pressedButtonOnWorldSelect.equals("musicland")) {
                        if(event.getX()<Assets.musicworldbut.getWidth() && event.getY() > 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2 &&  event.getY() < 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2 + Assets.musicworldbut.getHeight()){

                            Assets.recycleBitmaps("worldselect");
                            Assets.load("levelselect");
                            currentState="levelselect";
                            displayLevelSelect();


                            return true;


                        }else{
                            pressedButtonOnWorldSelect = "none";
                            displayWorldSelect();
                        }




                    }else{

                        pressedButtonOnWorldSelect = "none";
                        displayWorldSelect();

                    }

                    break;



            }


            return false;
/*
            if(event.getX()<Assets.musicworldbut.getWidth() && event.getY() > 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2 &&  event.getY() < 2 * Assets.selectworldtext.getHeight() + Assets.selectworldtext.getHeight() / 2 + Assets.musicworldbut.getHeight()){



                Assets.recycleBitmaps("worldselect");
                Assets.load("levelselect");
                currentState="levelselect";
                displayLevelSelect();


                return true;

            }

            return false;*/





        }else if(currentState.equals("mainscreen")) {



            mCanvas.drawBitmap(Assets.playbuttonpressed, ScreenWidth / 2 - Assets.playbutton.getWidth() / 2, 3 * ScreenHeight / 8, null);
            mCanvas.drawBitmap(Assets.optionsbutton, ScreenWidth / 2 - Assets.optionsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2, null);
            mCanvas.drawBitmap(Assets.creditsbutton, ScreenWidth / 2 - Assets.creditsbutton.getWidth() / 2, 3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2, null);



            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    if (event.getX() > ScreenWidth / 2 - Assets.playbutton.getWidth() / 2 && event.getX()<ScreenWidth / 2 - Assets.playbutton.getWidth() / 2+Assets.playbutton.getWidth() && event.getY()>3 * ScreenHeight / 8 && event.getY()<3 * ScreenHeight / 8 + Assets.playbutton.getHeight()) {

                        pressedButtonOnMainScreen="play";
                        displayMainScreen();
                        return true;

                    }else if(event.getX() > ScreenWidth / 2 - Assets.playbutton.getWidth() / 2 && event.getX()<ScreenWidth / 2 - Assets.playbutton.getWidth() / 2+Assets.playbutton.getWidth() && event.getY()>3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2 && event.getY()<3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2 + Assets.playbutton.getHeight())  {

                        pressedButtonOnMainScreen="options";
                        displayMainScreen();
                        return true;

                    }else if(event.getX() > ScreenWidth / 2 - Assets.playbutton.getWidth() / 2 && event.getX()<ScreenWidth / 2 - Assets.playbutton.getWidth() / 2+Assets.playbutton.getWidth() && event.getY()>3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2 && event.getY()<3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2 + Assets.playbutton.getHeight()){

                        pressedButtonOnMainScreen="credits";
                        displayMainScreen();
                        return true;
                    }

                    break;


                case MotionEvent.ACTION_UP:



                    if(pressedButtonOnMainScreen.equals("play")) {
                        if (event.getX() > ScreenWidth / 2 - Assets.playbutton.getWidth() / 2 && event.getX() < ScreenWidth / 2 - Assets.playbutton.getWidth() / 2 + Assets.playbutton.getWidth() && event.getY() > 3 * ScreenHeight / 8 && event.getY() < 3 * ScreenHeight / 8 + Assets.playbutton.getHeight()) {

                            pressedButtonOnMainScreen = "none";
                            Assets.recycleBitmaps("mainscreen");
                            Assets.load("worldselect");
                            currentState = "worldselect";
                            displayWorldSelect();
                            return true;


                        } else {
                            pressedButtonOnMainScreen = "none";

                            displayMainScreen();
                        }


                    }else if(pressedButtonOnMainScreen.equals("options")){




                        if (event.getX() > ScreenWidth / 2 - Assets.playbutton.getWidth() / 2 && event.getX()<ScreenWidth / 2 - Assets.playbutton.getWidth() / 2+Assets.playbutton.getWidth() && event.getY()>3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2 && event.getY()<3 * ScreenHeight / 8 + 3*Assets.playbutton.getHeight()/2 + Assets.playbutton.getHeight()){

                            pressedButtonOnMainScreen = "none";
                            Assets.recycleBitmaps("mainscreen");
                            Assets.load("options");
                            currentState = "options";
                            displayOptions();
                            return true;


                        } else {
                            pressedButtonOnMainScreen = "none";

                            displayMainScreen();
                        }



                    }else if(pressedButtonOnMainScreen.equals("credits")){


                        if (event.getX() > ScreenWidth / 2 - Assets.playbutton.getWidth() / 2 && event.getX()<ScreenWidth / 2 - Assets.playbutton.getWidth() / 2+Assets.playbutton.getWidth() && event.getY()>3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2 && event.getY()<3 * ScreenHeight / 8 + 6 * Assets.playbutton.getHeight()/2 + Assets.playbutton.getHeight()){

                            pressedButtonOnMainScreen = "none";
                            Assets.recycleBitmaps("mainscreen");
                            Assets.load("credits");
                            currentState = "credits";
                            displayCredits();
                            return true;


                        } else {
                            pressedButtonOnMainScreen = "none";

                            displayMainScreen();
                        }



                    }else{

                        pressedButtonOnMainScreen = "none";

                        displayMainScreen();

                    }

                    break;



            }


                return false;









            /*if (event.getX() > 0) {

                Assets.recycleBitmaps("mainscreen");
                Assets.load("worldselect");
                currentState = "worldselect";
                displayWorldSelect();

                return true;

            }

            return false;*/

        }else if(currentState.equals("gamepaused")){


            if(event.getX()<4* ScreenWidth/5 && event.getX()>3*ScreenWidth/5 && event.getY()>ScreenHeight/2 && event.getY()<ScreenHeight/2 + ScreenHeight/8){


                Assets.recycleBitmaps("gamepaused");
                Assets.load("playinggame");
                currentState = "playinggame";
                initGame();
                System.gc();


                return true;


            }else if(event.getX()<3* ScreenWidth/5 && event.getX()>2*ScreenWidth/5 && event.getY()>ScreenHeight/2 && event.getY()<ScreenHeight/2 + ScreenHeight/8){


                Assets.recycleBitmaps("gamepaused");
                Assets.load("playinggame");
                currentState = "playinggame";
                timeLeftOfTimer = 125000;
                countdownIsDone = false;
                levelInformationDialogStatus=3;

                numberOfLives = 5;
                initObjects();
                initGame();
                System.gc();




            }else if(event.getX()<2* ScreenWidth/5 && event.getX()>ScreenWidth/5 && event.getY()>ScreenHeight/2 && event.getY()<ScreenHeight/2 + ScreenHeight/8){

                Assets.recycleBitmaps("gamepaused");
                Assets.load("mainscreen");
                currentState = "mainscreen";
                timeLeftOfTimer=125000;
                countdownIsDone = false;
                levelInformationDialogStatus=3;
                displayMainScreen();
                System.gc();




            }

            return false;



        }else if(currentState.equals("youwin")) {


            if (event.getX() < 3 * ScreenWidth / 4 && event.getX() > ScreenWidth / 2 && event.getY() > ScreenHeight / 2 && event.getY() < ScreenHeight / 2 + ScreenHeight / 8) {


                Assets.recycleBitmaps("youwin");

                currentState = "playinggame";
                freezeCount = 0;



                //Restore number of lives if less than 5
                if(numberOfLives<5){
                    numberOfLives=5;
                }



                if(currentLevel!=24) {
                    currentLevel++;


                    Assets.load("playinggame");


                    countdownIsDone = false;
                    levelInformationDialogStatus=3;


                    initObjects();
                    initGame();
                    System.gc();

                }else{


                    currentState = "mainscreen";
                    Assets.load("mainscreen");
                    displayMainScreen();

                }


                return true;

            } else if (event.getX() < 2 * ScreenWidth / 4 && event.getX() > ScreenWidth / 4 && event.getY() > ScreenHeight / 2 && event.getY() < ScreenHeight / 2 + ScreenHeight / 8) {

                Assets.recycleBitmaps("youwin");
                Assets.load("playinggame");
                countdownIsDone = false;
                levelInformationDialogStatus=3;
                numberOfLives=5;

                currentState = "playinggame";
                initObjects();
                initGame();
                System.gc();


            }

            return false;


        }else if(currentState.equals("youlose")) {


            if (event.getX() < 3 * ScreenWidth / 4 && event.getX() > ScreenWidth / 2 && event.getY() > ScreenHeight / 2 && event.getY() < ScreenHeight / 2 + ScreenHeight / 8) {

                Assets.recycleBitmaps("youlose");
                Assets.load("mainscreen");
                currentState = "mainscreen";
                timeLeftOfTimer = 125000;
                numberOfLives = 5;
                displayMainScreen();
                System.gc();


            } else if (event.getX() < 2 * ScreenWidth / 4 && event.getX() > ScreenWidth / 4 && event.getY() > ScreenHeight / 2 && event.getY() < ScreenHeight / 2 + ScreenHeight / 8) {

                Assets.recycleBitmaps("youlose");
                Assets.load("playinggame");
                currentState = "playinggame";
                timeLeftOfTimer = 125000;
                countdownIsDone = false;
                levelInformationDialogStatus=3;

                numberOfLives = 5;
                initObjects();
                initGame();
                System.gc();
            }

            return false;


        }else if(currentState.equals("cleardata")) {


            if (event.getX() < 3 * ScreenWidth / 4 && event.getX() > ScreenWidth / 2 && event.getY() > ScreenHeight / 2 && event.getY() < ScreenHeight / 2 + ScreenHeight / 8) {

                Assets.load("options");
                currentState = "options";
                Assets.playSound(Assets.boingID);
                displayOptions();
                System.gc();


            } else if (event.getX() < 2 * ScreenWidth / 4 && event.getX() > ScreenWidth / 4 && event.getY() > ScreenHeight / 2 && event.getY() < ScreenHeight / 2 + ScreenHeight / 8) {

                SharedPreferences.Editor prefEditor = completedLevels.edit();
                prefEditor.putInt("COMPLETEDLEVELS", 1);
                prefEditor.commit();
                numberOfCompletedLevels = 1;
                Assets.playSound(Assets.boingID);

                Assets.load("options");
                currentState = "options";
                displayOptions();
                System.gc();
            }

            return false;


        }else if(currentState.equals("quitgame")){


                if (event.getX() < 3 * ScreenWidth / 4 && event.getX() > ScreenWidth / 2 && event.getY() > ScreenHeight / 2 && event.getY() < ScreenHeight / 2 + ScreenHeight / 8) {

                    Assets.load("mainscreen");
                    currentState = "mainscreen";
                    System.gc();


                } else if (event.getX() < 2 * ScreenWidth / 4 && event.getX() > ScreenWidth / 4 && event.getY() > ScreenHeight / 2 && event.getY() < ScreenHeight / 2 + ScreenHeight / 8) {


                }

                return false;





            }else if(currentState.equals("options")){

            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:


                    if (event.getX() > ScreenWidth / 2 && event.getX() < ScreenWidth / 2 + Assets.optionison.getWidth() && event.getY() > ScreenHeight / 2 - 1 * Assets.optionison.getHeight() && event.getY() < ScreenHeight / 2 - 1 * Assets.optionison.getHeight() + Assets.optionison.getHeight()) {
                        return true;

                    } else if (event.getX() > ScreenWidth / 2 && event.getX() < ScreenWidth / 2 + Assets.optionison.getWidth() && event.getY() > ScreenHeight / 2 - 3 * Assets.optionison.getHeight() && event.getY() < ScreenHeight / 2 - 3 * Assets.optionison.getHeight() + Assets.optionison.getHeight()) {
                        return true;


                    } else if (event.getX() > ScreenWidth / 2 && event.getX() < ScreenWidth / 2 + Assets.optionison.getWidth() && event.getY() > ScreenHeight / 2 - 5 * Assets.optionison.getHeight() && event.getY() < ScreenHeight / 2 - 5 * Assets.optionison.getHeight() + Assets.optionison.getHeight()) {
                        return true;
                    }else if(event.getX()> ScreenWidth/2 && event.getX()<ScreenWidth/2 + Assets.cleargamedatabutton.getWidth() && event.getY()>ScreenHeight/2 + Assets.cleargamedatabutton.getHeight()/2 && event.getY()<ScreenHeight/2 + Assets.cleargamedatabutton.getHeight()/2 + Assets.cleargamedatabutton.getHeight()){
                        return  true;
                    }
                    break;


                case MotionEvent.ACTION_UP:




                    if (event.getX() > ScreenWidth / 2 && event.getX() < ScreenWidth / 2 + Assets.optionison.getWidth() && event.getY() > ScreenHeight / 2 - 1 * Assets.optionison.getHeight() && event.getY() < ScreenHeight / 2 - 1 * Assets.optionison.getHeight() + Assets.optionison.getHeight()) {

                        if (optionsCheckList.getString("SoundEffectsAreEnabled","").equals("enabled")) {


                            SharedPreferences.Editor prefEditor = optionsCheckList.edit();
                            prefEditor.putString("SoundEffectsAreEnabled", "disabled");
                            prefEditor.commit();
                            soundEffectsTurnedOn=optionsCheckList.getString("SoundEffectsAreEnabled","");
                            if(soundEffectsTurnedOn.equals("disabled")){
                            }



                        } else {

                            SharedPreferences.Editor prefEditor = optionsCheckList.edit();
                            prefEditor.putString("SoundEffectsAreEnabled", "enabled");
                            prefEditor.commit();
                            soundEffectsTurnedOn=optionsCheckList.getString("SoundEffectsAreEnabled","");
                            mp5.start();

                        }




                        displayOptions();

                        return true;

                    } else if (event.getX() > ScreenWidth / 2 && event.getX() < ScreenWidth / 2 + Assets.optionison.getWidth() && event.getY() > ScreenHeight / 2 - 3 * Assets.optionison.getHeight() && event.getY() < ScreenHeight / 2 - 3 * Assets.optionison.getHeight() + Assets.optionison.getHeight()) {


                        if (optionsCheckList.getString("GameMusicIsEnabled","").equals("enabled")) {


                            SharedPreferences.Editor prefEditor = optionsCheckList.edit();
                            prefEditor.putString("GameMusicIsEnabled", "disabled");
                            prefEditor.commit();


                        } else {

                            SharedPreferences.Editor prefEditor = optionsCheckList.edit();
                            prefEditor.putString("GameMusicIsEnabled", "enabled");
                            prefEditor.commit();

                        }


                        displayOptions();


                        return true;


                    } else if (event.getX() > ScreenWidth / 2 && event.getX() < ScreenWidth / 2 + Assets.optionison.getWidth() && event.getY() > ScreenHeight / 2 - 5 * Assets.optionison.getHeight() && event.getY() < ScreenHeight / 2 - 5 * Assets.optionison.getHeight() + Assets.optionison.getHeight()) {


                        if (optionsCheckList.getString("MainMusicIsEnabled","").equals("enabled")) {


                            SharedPreferences.Editor prefEditor = optionsCheckList.edit();
                            prefEditor.putString("MainMusicIsEnabled", "disabled");
                            prefEditor.commit();
                            Assets.stopMainMusic();


                        } else {

                            SharedPreferences.Editor prefEditor = optionsCheckList.edit();
                            prefEditor.putString("MainMusicIsEnabled", "enabled");
                            prefEditor.commit();
                            Assets.playMusic("mainscreenmusic.ogg", true);

                        }
                        displayOptions();
                        return true;



                    }else if(event.getX()> ScreenWidth/2 && event.getX()<ScreenWidth/2 + Assets.cleargamedatabutton.getWidth() && event.getY()>ScreenHeight/2 + Assets.cleargamedatabutton.getHeight()/2 && event.getY()<ScreenHeight/2 + Assets.cleargamedatabutton.getHeight()/2 + Assets.cleargamedatabutton.getHeight()) {


                        Assets.load("cleardata");
                        currentState="cleardata";
                        displayClearDataAlertDialog();
                        return true;

                    }

                break;



            }
            return false;













        }else if(currentState.equals("playinggame") &&  countdownIsDone==true && comesFromPause==false) {


            if(event.getY()>ScreenHeight-Assets.redmarker.getHeight() && paintingwall=='n') {

                if (event.getX() < Assets.bluemarker.getWidth()) {


                    if(markerInk.isMarkerAvailable(currentLevel,'b')=='y') {
                        paintToolsObj.updatePaintedWallsPaint("blue");
                        markerInk.updateCurrentMarker( "blue");
                        mp8.start();


                    }else {

                        Assets.playSound(Assets.accessDeniedID);

                    }



                } else if (event.getX() > Assets.bluemarker.getWidth() && event.getX() < Assets.bluemarker.getWidth()+ Assets.greenmarker.getWidth()){


                    if(markerInk.isMarkerAvailable(currentLevel,'g')=='y') {

                        paintToolsObj.updatePaintedWallsPaint("green");
                        markerInk.updateCurrentMarker( "green");
                        mp8.start();


                    }else{
                        Assets.playSound(Assets.accessDeniedID);

                    }


                }else if (event.getX() > ScreenWidth-(Assets.yellowmarker.getWidth()+Assets.redmarker.getWidth()) && event.getX() < ScreenWidth-Assets.yellowmarker.getWidth()) {


                    if(markerInk.isMarkerAvailable(currentLevel,'r')=='y') {

                        paintToolsObj.updatePaintedWallsPaint("red");
                        markerInk.updateCurrentMarker( "red");
                        mp8.start();

                    }else{

                        Assets.playSound(Assets.accessDeniedID);


                    }


                }else if (event.getX() > ScreenWidth-Assets.yellowmarker.getWidth() && event.getX() < ScreenWidth) {


                    if(markerInk.isMarkerAvailable(currentLevel,'y')=='y') {

                        paintToolsObj.updatePaintedWallsPaint("yellow");
                        markerInk.updateCurrentMarker( "yellow");
                        mp8.start();

                    }else {

                        Assets.playSound(Assets.accessDeniedID);

                    }



                }else if(event.getX() > ((ScreenWidth/2) -(Assets.bluegem.getWidth()/2)) && event.getX() < ((ScreenWidth/2) +(Assets.bluegem.getWidth()/2))){


                    if(currentGem.equals("blue")){

                        rainDrops.start();
                        superPowerUsed="blue";
                        superPowerClicked="blue";
                        currentGem="none";
                        countDownLetItRain();
                        startGemCountDown();


                    }else if(currentGem.equals("red")){


                        poof.start();
                        smokeTries=24;
                        superPowerUsed="red";
                        currentGem="none";
                        startGemCountDown();


                    }else if(currentGem.equals("heart")){

                        extraLifeGained.start();
                        superPowerUsed="heart";
                        currentGem="none";
                        startGemCountDown();


                    }else if(currentGem.equals("green")){

                        startBoostSpeedOfRainTails();
                        currentGem="none";
                        startGemCountDown();

                    }else if(currentGem.equals("protect")){

                        rainTails.protectRainTails();
                        startProtectionOfRainTails();
                        currentGem="none";
                        startGemCountDown();



                    }

                }


            }else {



                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        paintingwall='y';
                        beginCoordinateX = event.getX();
                        endCoordinateX = event.getX();
                        beginCoordinateY = event.getY();
                        endCoordinateY = event.getY();



                        break;


                    case MotionEvent.ACTION_MOVE:


                        endCoordinateX = event.getX();
                        endCoordinateY = event.getY();

                        if(endCoordinateY>MainActivity.ScreenHeight - (Assets.redmarker.getHeight())){
                            endCoordinateY= (float)MainActivity.ScreenHeight  - (Assets.redmarker.getHeight());

                            return true;
                        }



                        //  if(endCoordinateX>beginCoordinateX){


                        differenceX = (int) Math.abs((endCoordinateX - beginCoordinateX)) - differenceX;
                        differenceY = (int) Math.abs(endCoordinateY - beginCoordinateY) - differenceY;



                        //If player paints less than 20 * ratio pixels don't consume
                        if(differenceX>differenceY) {
                            averagedifference = (int) Math.round((differenceX + differenceY) / (35 / ((MainActivity.ScaleWidth))));
                        }else{

                            averagedifference = (int) Math.round((differenceX + differenceY) / (35 / ((MainActivity.ScaleHeight))));
                        }


                        markerInk.updateInkLevel(  (markerInk.getInkLevel(markerInk.getCurrentMarker()) - averagedifference) , markerInk.getCurrentMarker());


                        if (Math.abs(beginCoordinateX - endCoordinateX) > 90) {

                            Log.i("myAppTag", "STOP IT!!!!!!!!!" + endCoordinateX);


                        }


                        test = true;
                        break;




                    case MotionEvent.ACTION_UP:


                        differenceX = 0;
                        differenceY = 0;


                        //If condition met then lets get this started
                        if (playerPaintedWallsObj.getNumberOfWallsPainted() < 30 && (markerInk.getInkLevel(markerInk.getCurrentMarker()) >  ScreenWidth-Assets.pen.getWidth() )) {


                            playerPaintedWallsObj.createPlayerPaintedWall(beginCoordinateX,beginCoordinateY,endCoordinateX,endCoordinateY,markerInk.getCurrentMarker(),rainTails);

                            firstTime = false;
                        }


                        paintingwall='n';

                        test = false;
                        break;
                }
            }



            return true;





        }else{
            comesFromPause=false;
            return true;
        }
    }







    public void checkRainTailsScreenCollision(Canvas canvas) {


        for (int f = 0; f < 1; f++) {
            if (rainTails.getPosX() - rainTails.getSpeedX() < 0) {

                rainTails.updateSpeedX(Math.abs(rainTails.getSpeedX()));

            } else if (rainTails.getPosX() + rainTails.getSpeedX() > canvas.getWidth() - Assets.dogright1.getWidth()) {

                rainTails.updateSpeedX(-Math.abs(rainTails.getSpeedX()));
            }


            if (rainTails.getPosY() <110f* (float) (MainActivity.ScaleHeight)) {

                rainTails.updateSpeedY(Math.abs(rainTails.getSpeedY()));

            } else if (rainTails.getPosY() + rainTails.getSpeedY() > (canvas.getHeight()-3*(Assets.bluemarker.getHeight()/4)) - Assets.dogright1.getHeight()) {

                rainTails.updateSpeedY(-Math.abs(rainTails.getSpeedY()));
            }
        }
    }


    public void checkFireballScreenCollision(Canvas canvas) {


        for (int f = 0; f < fireBallObj.getNumberOfFireballs(); f++) {
            if (fireBallObj.getPosX(f) - fireBallObj.getSpeedX(f) < 0) {

                fireBallObj.updateSpeedX(Math.abs(fireBallObj.getSpeedX(f)), f);

            } else if (fireBallObj.getPosX(f) + fireBallObj.getSpeedX(f) > canvas.getWidth() - Assets.fireball.getWidth()) {

                fireBallObj.updateSpeedX(-Math.abs(fireBallObj.getSpeedX(f)), f);
            }


            if (fireBallObj.getPosY(f)  < 110f* (float) (MainActivity.ScaleHeight)) {

                fireBallObj.updateSpeedY(Math.abs(fireBallObj.getSpeedY(f)), f);

            } else if (fireBallObj.getPosY(f) + Assets.fireball.getHeight() > (canvas.getHeight()-3*(Assets.bluemarker.getHeight()/4)) - Assets.fireball.getHeight()) {

                fireBallObj.updateSpeedY(-Math.abs(fireBallObj.getSpeedY(f)), f);
            }
        }
    }






    private void drawMonster(){

        px2 = starObj.getPosX() + Assets.star.getWidth() / 2;
        py2= starObj.getPosY() + Assets.star.getHeight() / 2;
        matrix2.postTranslate(-Assets.star.getWidth() / 2, -Assets.star.getHeight() / 2);
        matrix2.postRotate(frozenDogAngle);
        matrix2.postTranslate(px2, py2);
        mCanvas.drawBitmap(Assets.star, matrix2, null);
        matrix2.reset();
        frozenDogAngle = frozenDogAngle + 1;
        frozenDogAngle = frozenDogAngle % 360;

    }





    private void renderGameImage() {

        mCanvas = getHolder().lockCanvas();

        if (mCanvas != null) {

            mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);


            //will display background
            gameBackground.displayBackground(mCanvas, superPowerUsed, rainTails);










/*
            //Draw status
            mCanvas.drawLine(0, 0, ScreenWidth, 0, paintToolsObj.getTransparentTopRowPaint2());    //Status white background

            mCanvas.drawLine(0, 0, ScreenWidth, 0, paintToolsObj.getTransparentTopRowPaint());    //Status white background


            //Circle respawn
            mCanvas.drawBitmap(Assets.circlespawn, null, circleSpawnSpotObj.getCircleRect(), null);



            if (markerInk.getInkLevel(colorOfMarker) > ScreenWidth- (Assets.pen.getWidth()- Assets.pen.getWidth()/6)) {
                mCanvas.drawLine(ScreenWidth - Assets.pen.getWidth() + Assets.pen.getWidth() / 5, Assets.pen.getHeight() / 2 + Assets.pen.getHeight()/8, markerInk.getInkLevel(colorOfMarker), Assets.pen.getHeight() / 2 + Assets.pen.getHeight()/8, paintToolsObj.getInkLeftPaint(colorOfMarker));   //Status blue ink
            }




            mCanvas.drawBitmap(Assets.pen, ScreenWidth - Assets.pen.getWidth(), 10, null);


            mCanvas.drawBitmap(Assets.livesbar, 0, 0, null);





            mCanvas.drawBitmap(Assets.timeleftbar, MainActivity.ScreenWidth / 2 - Assets.timeleftbar.getWidth() / 2, 0, null);
            mCanvas.drawText(String.valueOf(timeLeftOfTimer / 1000), MainActivity.ScreenWidth / 2, Assets.timeleftbar.getHeight() / 2 + 36 / 2 * (float) (MainActivity.ScaleHeight), paintToolsObj.getWorldInfoPaint());


            //Hearths are drawn
            for (int i = 1; i <= numberOfLives; i++) {
                mCanvas.drawBitmap(Assets.hearthlives, Assets.hearthlives.getWidth() / 2 + i * Assets.hearthlives.getWidth(), Assets.livesbar.getHeight() / 2 - Assets.hearthlives.getHeight() / 2, null);

            }
*/

            //Our star will finally pop out when all gems collected
            if (starObj.isStarVisible() == true) {
                drawMonster();
            } else {
                mCanvas.drawBitmap(Assets.starspot, starObj.getPosX(), starObj.getPosY(), null);


            }


            //Draws level walls
            for (int i = 0; i < levelWall.getNumberOfLevelWalls(); i++) {




                if (levelWall.getTypeOfWall(i).equals("hori") && levelWall.isItBroken(i) == 'n') {


                    if (levelWall.isBreakable(i) == 'y') {

                        mCanvas.drawLine(levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).top, levelWall.getRectOfLevelWall(i).right, levelWall.getRectOfLevelWall(i).top, paintToolsObj.getBreakablelevelWallsPaint());

                    } else if (levelWall.isBreakable(i) == 'n') {

                        mCanvas.drawLine(levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).top, levelWall.getRectOfLevelWall(i).right, levelWall.getRectOfLevelWall(i).top, paintToolsObj.getLevelWallsPaint());


                    }else if(levelWall.isBreakable(i)=='d'){


                        if(levelWall.isLocked(i)=='y') {
                            mCanvas.drawLine(levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).top, levelWall.getRectOfLevelWall(i).right, levelWall.getRectOfLevelWall(i).top, paintToolsObj.getLockableWallsPaint());
                        }
                    }





                } else if (levelWall.getTypeOfWall(i).equals("vert") && levelWall.isItBroken(i) == 'n') {


                    if (levelWall.isBreakable(i) == 'y') {

                        mCanvas.drawLine(levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).top, levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).bottom, paintToolsObj.getBreakablelevelWallsPaint());
                    } else if (levelWall.isBreakable(i) == 'n') {

                        mCanvas.drawLine(levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).top, levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).bottom, paintToolsObj.getLevelWallsPaint());


                     }else if(levelWall.isBreakable(i)=='d'){

                        if(levelWall.isLocked(i)=='y') {

                            mCanvas.drawLine(levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).top, levelWall.getRectOfLevelWall(i).left, levelWall.getRectOfLevelWall(i).bottom, paintToolsObj.getLockableWallsPaint());
                        }
                }
                }
            }





            //Draws spiky double walls
            for (int i = 0; i < spikyDoubleObj.getNumberOfDoubleSpikyWalls(); i++) {


                if (spikyDoubleObj.getTypeOfSpikyWall(i) == 'v') {


                    mCanvas.drawBitmap(Assets.spikyVert, null, spikyDoubleObj.getRectOfSpikyDouble(i), null);


                } else if (spikyDoubleObj.getTypeOfSpikyWall(i) == 'h') {


                    mCanvas.drawBitmap(Assets.spikyHori, null, spikyDoubleObj.getRectOfSpikyDouble(i), null);


                } else if (spikyDoubleObj.getTypeOfSpikyWall(i) == 'd') {


                    if (spikyDoubleObj.isItBumpable(i) == 'n') {

                        mCanvas.drawBitmap(Assets.spikyDouble, null, spikyDoubleObj.getRectOfSpikyDouble(i), null);

                    } else if (spikyDoubleObj.isItBumpable(i) == 'y') {

                        mCanvas.drawBitmap(Assets.spikyDoubleBumpable, null, spikyDoubleObj.getRectOfSpikyDouble(i), null);

                    }


                }

            }


            //Draws rain or blows walls
            if (superPowerUsed.equals("blue")) {


                for (int i = 0; i < 10; i++) {
                    int x = (int) (Math.random() * ScreenWidth);
                    int y = (int) (Math.random() * ScreenHeight);
                    mCanvas.drawBitmap(Assets.droplong, x, y, null);
                }

                for (int i = 0; i < 3; i++) {
                    int x = (int) (Math.random() * ScreenWidth);
                    int y = (int) (Math.random() * ScreenHeight);
                    mCanvas.drawBitmap(Assets.dropone, x, y, null);
                }

                for (int i = 0; i < 3; i++) {
                    int x = (int) (Math.random() * ScreenWidth);
                    int y = (int) (Math.random() * ScreenHeight);
                    mCanvas.drawBitmap(Assets.droptwo, x, y, null);
                }

                for (int i = 0; i < 3; i++) {
                    int x = (int) (Math.random() * ScreenWidth);
                    int y = (int) (Math.random() * ScreenHeight);
                    mCanvas.drawBitmap(Assets.dropthree, x, y, null);
                }


            } else if (superPowerUsed.equals("red")) {


                if (smokeTries == 24 || smokeTries == 23 || smokeTries == 22 || smokeTries == 21 || smokeTries == 20 || smokeTries == 19 || smokeTries == 18 || smokeTries == 17) {

                    for (int i = 0; i < playerPaintedWallsObj.getNumberOfWallsPainted(); i++) {

                        mCanvas.drawBitmap(Assets.smokebig, playerPaintedWallsObj.rectOfWall(i).left + playerPaintedWallsObj.rectOfWall(i).width() / 2 + Assets.smokebig.getWidth() / 2, playerPaintedWallsObj.rectOfWall(i).top + playerPaintedWallsObj.rectOfWall(i).height() / 2 + Assets.smokebig.getHeight() / 2, null);

                    }
                    smokeTries--;

                } else if (smokeTries == 16 || smokeTries == 15 || smokeTries == 14 || smokeTries == 13 || smokeTries == 12 || smokeTries == 11 || smokeTries == 10 || smokeTries == 9) {

                    for (int i = 0; i < playerPaintedWallsObj.getNumberOfWallsPainted(); i++) {

                        mCanvas.drawBitmap(Assets.smokemed, playerPaintedWallsObj.rectOfWall(i).left + playerPaintedWallsObj.rectOfWall(i).width() / 2 + Assets.smokemed.getWidth() / 2, playerPaintedWallsObj.rectOfWall(i).top + playerPaintedWallsObj.rectOfWall(i).height() / 2 + Assets.smokemed.getHeight() / 2, null);
                    }
                    smokeTries--;


                } else if (smokeTries == 8 || smokeTries == 7 || smokeTries == 6 || smokeTries == 5 || smokeTries == 4 || smokeTries == 3 || smokeTries == 2 || smokeTries == 1) {


                    for (int i = 0; i < playerPaintedWallsObj.getNumberOfWallsPainted(); i++) {

                        mCanvas.drawBitmap(Assets.smokebig, playerPaintedWallsObj.rectOfWall(i).left + playerPaintedWallsObj.rectOfWall(i).width() / 2 + Assets.smokebig.getWidth() / 2, playerPaintedWallsObj.rectOfWall(i).top + playerPaintedWallsObj.rectOfWall(i).height() / 2 + Assets.smokebig.getHeight() / 2, null);
                    }

                    smokeTries--;
                    if (smokeTries == 1) {
                        superPowerUsed = "none";
                        playerPaintedWallsObj.resetAllPaintedWalls();

                    }

                }
            } else if (superPowerUsed.equals("heart")) {

                numberOfLives++;
                superPowerUsed = "none";


            }


            //Draws gems
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 1) {
                    mCanvas.drawBitmap(Assets.gemright, null, gemObj.getRectOfGem(i), null);
                } else {
                    mCanvas.drawBitmap(Assets.gemleft, null, gemObj.getRectOfGem(i), null);

                }
            }




           /* if(currentLevel==6) {
                mCanvas.drawBitmap(Assets.purplegem, ScreenWidth / 2 - Assets.purplegem.getWidth() / 2, ScreenHeight / 2 - Assets.purplegem.getHeight() / 2, null);
            }*/





            //Circle respawn
            mCanvas.drawBitmap(Assets.circlespawn, null, circleSpawnSpotObj.getCircleRect(), null);






            //Draws moving images. If monster eats it, won't draw
            for (int c = 0; c < 1; c++) {

                if (rainTails.isRainbowTailsVisible() == true) {


                    if (rainTails.isRainTailsSlipping() == true) {


                        if (rainTails.isRainTailsProtected() == true) {

                            Matrix matrix2 = new Matrix();
                            float px2 = rainTails.getCenterXOfRectOfRainTails();
                            float py2 = rainTails.getCenterYOfRectOfRainTails();
                            matrix2.postTranslate(-Assets.protectgem.getWidth() / 2, -Assets.protectgem.getHeight() / 2);
                            matrix2.postRotate(protectionAngle);
                            matrix2.postTranslate(px2, py2);
                            //mCanvas.drawBitmap(Assets.protectgem,rainTails.getCenterXOfRectOfRainTails()- Assets.protectgem.getWidth()/2, rainTails.getCenterYOfRectOfRainTails()- Assets.protectgem.getHeight()/2,null);
                            mCanvas.drawBitmap(Assets.protectgem, matrix2, null);

                            matrix2.reset();
                            protectionAngle = protectionAngle + 4;
                            protectionAngle = protectionAngle % 360;


                        }


                        //  Matrix matrix = new Matrix();
                        //matrix.setRotate(frozenDogAngle, movingImages[0].left + frozenDogOne.getWidth() / 2, movingImages[0].top + frozenDogOne.getHeight() / 2);
                        float rotation = 30.0f;


                        Matrix matrix = new Matrix();
                        float px = rainTails.getPosX() + Assets.frozendog1left.getWidth() / 2;
                        float py = rainTails.getPosY() + Assets.frozendog1left.getHeight() / 2;
                        matrix.postTranslate(-Assets.frozendog1left.getWidth() / 2, -Assets.frozendog1left.getHeight() / 2);
                        matrix.postRotate(frozenDogAngle);
                        matrix.postTranslate(px, py);
                        if (frozenDogMovement == 0 || frozenDogMovement == 1 || frozenDogMovement == 2 || frozenDogMovement == 3 || frozenDogMovement == 4 || frozenDogMovement == 5 || frozenDogMovement == 6) {
                            mCanvas.drawBitmap(Assets.frozendog1left, matrix, null);
                            frozenDogMovement++;
                            matrix.reset();
                            frozenDogAngle = frozenDogAngle + 4;
                            frozenDogAngle = frozenDogAngle % 360;

                        } else if (frozenDogMovement == 7 || frozenDogMovement == 8 || frozenDogMovement == 9 || frozenDogMovement == 10 || frozenDogMovement == 11 || frozenDogMovement == 12 || frozenDogMovement == 13) {

                            mCanvas.drawBitmap(Assets.frozendog2left, matrix, null);
                            if (frozenDogMovement != 13) {
                                frozenDogMovement++;
                                matrix.reset();
                                frozenDogAngle = frozenDogAngle + 4;
                                frozenDogAngle = frozenDogAngle % 360;


                            } else {
                                frozenDogMovement = 0;
                                matrix.reset();
                                frozenDogAngle = frozenDogAngle + 4;
                                frozenDogAngle = frozenDogAngle % 360;


                            }
                        }


                    } else {

                        if (rainTails.isRainTailsProtected() == true) {

                            Matrix matrix2 = new Matrix();
                            float px2 = rainTails.getCenterXOfRectOfRainTails();
                            float py2 = rainTails.getCenterYOfRectOfRainTails();
                            matrix2.postTranslate(-Assets.protectgem.getWidth() / 2, -Assets.protectgem.getHeight() / 2);
                            matrix2.postRotate(protectionAngle);
                            matrix2.postTranslate(px2, py2);
                            //mCanvas.drawBitmap(Assets.protectgem,rainTails.getCenterXOfRectOfRainTails()- Assets.protectgem.getWidth()/2, rainTails.getCenterYOfRectOfRainTails()- Assets.protectgem.getHeight()/2,null);
                            mCanvas.drawBitmap(Assets.protectgem, matrix2, null);

                            matrix2.reset();
                            protectionAngle = protectionAngle + 4;
                            protectionAngle = protectionAngle % 360;


                        }


                        if (rainTails.getSpeedX() >= 0) {

                            if (rightSit == 0 || rightSit == 1 || rightSit == 2 || rightSit == 3 || rightSit == 4 || rightSit == 5 || rightSit == 6) {
                                mCanvas.drawBitmap(Assets.dogright1, null, rainTails.getRectOfRainbowTails(), null);
                                rightSit++;


                            } else if (rightSit == 7 || rightSit == 8 || rightSit == 9 || rightSit == 10 || rightSit == 11 || rightSit == 12 || rightSit == 13) {

                                mCanvas.drawBitmap(Assets.dogright2, null, rainTails.getRectOfRainbowTails(), null);
                                rightSit++;

                            } else if (rightSit == 14 || rightSit == 15 || rightSit == 16 || rightSit == 17 || rightSit == 18 || rightSit == 19 || rightSit == 20) {

                                mCanvas.drawBitmap(Assets.dogright3, null, rainTails.getRectOfRainbowTails(), null);
                                rightSit++;


                            } else if (rightSit == 21 || rightSit == 22 || rightSit == 23 || rightSit == 24 || rightSit == 25 || rightSit == 26 || rightSit == 27) {

                                mCanvas.drawBitmap(Assets.dogright4, null, rainTails.getRectOfRainbowTails(), null);


                                if (rightSit == 27) {
                                    rightSit = 0;

                                } else {
                                    rightSit++;
                                }


                            }


                        } else {


                            if (leftSit == 0 || leftSit == 1 || leftSit == 2 || leftSit == 3 || leftSit == 4 || leftSit == 5 || leftSit == 6) {
                                mCanvas.drawBitmap(Assets.dogleft1, null, rainTails.getRectOfRainbowTails(), null);
                                leftSit++;

                            } else if (leftSit == 7 || leftSit == 8 || leftSit == 9 || leftSit == 10 || leftSit == 11 || leftSit == 12 || leftSit == 13) {

                                mCanvas.drawBitmap(Assets.dogleft2, null, rainTails.getRectOfRainbowTails(), null);
                                leftSit++;

                            } else if (leftSit == 14 || leftSit == 15 || leftSit == 16 || leftSit == 17 || leftSit == 18 || leftSit == 19 || leftSit == 20) {

                                mCanvas.drawBitmap(Assets.dogleft3, null, rainTails.getRectOfRainbowTails(), null);
                                leftSit++;


                            } else if (leftSit == 21 || leftSit == 22 || leftSit == 23 || leftSit == 24 || leftSit == 25 || leftSit == 26 || leftSit == 27) {

                                mCanvas.drawBitmap(Assets.dogleft4, null, rainTails.getRectOfRainbowTails(), null);

                                if (leftSit == 27) {
                                    leftSit = 0;

                                } else {
                                    leftSit++;
                                }

                            }

                        }


                    }

                }
            }




/*
            for(int i=0;i<10;i++) {

                if(i>4) {
                    mCanvas.drawBitmap(Assets.pipeleft, null, musicPipesObj.getPipeRect(i), null);

                    if (musicPipesObj.showMusicNoteOfPipe(i) == 'y') {
                        mCanvas.drawBitmap(Assets.pipemusicnote, musicPipesObj.getPipeRect(i).right - Assets.pipemusicnote.getWidth(), musicPipesObj.getPipeRect(i).top, null);

                    }

                }else{

                    mCanvas.drawBitmap(Assets.piperight, null, musicPipesObj.getPipeRect(i), null);

                    if (musicPipesObj.showMusicNoteOfPipe(i) == 'y') {
                        mCanvas.drawBitmap(Assets.pipemusicnote, musicPipesObj.getPipeRect(i).left , musicPipesObj.getPipeRect(i).top, null);

                    }

                }
            }





            for(int i=0;i<musicPipesObj.getNumberOfPipes();i++) {
                mCanvas.drawBitmap(Assets.pipebottom, null, musicPipesObj.getPipeRect(i), null);

                if(musicPipesObj.showMusicNoteOfPipe(i)=='y'){



                    mCanvas.drawBitmap(Assets.fogsmall, musicPipesObj.getPipeRect(i).left, musicPipesObj.getPipeRect(i).top-Assets.fogsmall.getHeight()  , null);

                    mCanvas.drawBitmap(Assets.pipemusicnote, musicPipesObj.getPipeRect(i).left, musicPipesObj.getPipeRect(i).top  , null);



                }
                if(rainTails.getRectOfRainbowTails().intersect(musicPipesObj.getPipeRect(i))) {




                if(musicPipesObj.showMusicNoteOfPipe(i)=='y') {

                    if (mp5.isPlaying()) {

                    } else {
                        numberOfLives--;
                    }

                    mp5.start();

                }




                    rainTails.bumpMusicPipe(musicPipesObj.getPipeRect(i));





                }






            }






            musicPipesObj.updateSpeed(currentLevel);
*/

           // mCanvas.drawBitmap(Assets.fingerone, 300 , 200,null);


         /*   for(int xLine=0;xLine<=5;xLine++){
                for(int yLine=1;yLine<=8;yLine++){


                    // mCanvas.drawLine(xLine * MainActivity.ScreenWidth / 5, yLine * MainActivity.ScreenHeight / 8, (xLine + 1) * MainActivity.ScreenWidth / 5, yLine * MainActivity.ScreenHeight / 8, paintToolsObj.getWhiteWallsPaint());

                 //   mCanvas.drawBitmap(Assets.circlespawn, (float)(xLine*MainActivity.ScreenWidth/5 - Assets.circlespawn.getWidth()/2) , (float)(yLine*MainActivity.ScreenHeight/10 - Assets.circlespawn.getHeight()/2),null);


                    //mCanvas.drawLine(xLine * MainActivity.ScreenWidth / 5, yLine * MainActivity.ScreenHeight / 8, (xLine) * MainActivity.ScreenWidth / 5, (yLine + 1) * MainActivity.ScreenHeight / 8, paintToolsObj.getWhiteWallsPaint());



                        mCanvas.drawCircle((xLine * MainActivity.ScreenWidth / 5), (yLine * MainActivity.ScreenHeight / 8), 25*(float)(MainActivity.ScaleWidth), paintToolsObj.getTrailCirclePaint2());
                        mCanvas.drawCircle((xLine * MainActivity.ScreenWidth / 5), (yLine * MainActivity.ScreenHeight / 8), 20*(float)(MainActivity.ScaleWidth), paintToolsObj.getTrailCirclePaint());





                }
            }*/




            //Draws fireballs
            for (int c = 0; c < fireBallObj.getNumberOfFireballs(); c++) {

                //  mCanvas.drawBitmap(bitmap3, xFirePos[c], yFirePos[c], null);

                if(c%3==0) {
                    mCanvas.drawBitmap(Assets.fireball, null, fireBallObj.getRectOfFireBall(c), null);
                }else if(c%3==1){
                    mCanvas.drawBitmap(Assets.fireball2, null, fireBallObj.getRectOfFireBall(c), null);
                }else{
                    mCanvas.drawBitmap(Assets.fireball3, null, fireBallObj.getRectOfFireBall(c), null);

                }

            }


            //Level Walls collision
            levelWall.checkCollisionsRainTailsWithLevelWalls(rainTails);


            //Spiky Walls Collision
            if (  spikyDoubleObj.checkCollisionsRainTailsWithSpikyDoubleWalls(rainTails)==true && rainTails.isRainTailsProtected()==false) {



                if (mp5.isPlaying()) {

                } else {
                    numberOfLives--;
                    mp5.start();

                }

            }


            if (gemObj.checkCollisionOfRainTailsWithGem(rainTails, starObj, currentLevel) == true) {

                if(starObj.isStarVisible()==false) {
                    Assets.playSound(Assets.gemPickUpID);
                }else{

                    Assets.playSound(Assets.starUnlockedID);

                }
            }


            levelWall.checkCollisionFireBallsWithLevelWalls(fireBallObj);


            if (test == true) {

                mCanvas.drawLine(beginCoordinateX, beginCoordinateY, endCoordinateX, endCoordinateY, paintToolsObj.getPaintedWallsPaint());
            }


            for (int c = 0; c < playerPaintedWallsObj.getNumberOfWallsPainted(); c++) {


                paintToolsObj.updatePaintedWallsPaint(playerPaintedWallsObj.getColor(c));


                mCanvas.drawLine(playerPaintedWallsObj.paintWall(c).left, playerPaintedWallsObj.paintWall(c).top, playerPaintedWallsObj.paintWall(c).right, playerPaintedWallsObj.paintWall(c).bottom, paintToolsObj.getPaintedWallsPaint());

            }


            paintToolsObj.updatePaintedWallsPaint(markerInk.getCurrentMarker());


            mCanvas.drawCircle(ScreenWidth / 2, ScreenHeight - 60f*(float)MainActivity.ScaleWidth, 60f*(float)MainActivity.ScaleHeight, paintToolsObj.getBottomCirclePaint());   ///CHANGE!!!


            if (MainActivity.done == false) {

            } else {

                if (rainTails.getSpeedX() > 0) {
                    //mCanvas.drawBitmap(redGemScaled, rainTails.getPosX() , rainTails.getPosY() , null);
                    //  mCanvas.drawBitmap(blueGem,ScreenWidth/2-blueGem.getWidth()/2,ScreenHeight-blueGem.getHeight()-blueGem.getHeight()/2 , null);              //CHANGE!!!!
                } else {

                    //mCanvas.drawBitmap(redGemScaled, rainTails.getPosX()  + movingImages[0].width()-redGemScaled.getWidth(), movingImages[0].top, null);


                }

            }


            if (currentLevel == 7 || currentLevel == 8 || currentLevel == 20 || currentLevel==13 || currentLevel==18 || currentLevel==19 || currentLevel==24)   {


                mCanvas.drawBitmap(Assets.freezeButton, null, freezorObj.getFreezorRect(0), null);
                mCanvas.drawBitmap(Assets.freezeButton, null, freezorObj.getFreezorRect(1), null);
                mCanvas.drawBitmap(Assets.freezeButton, null, freezorObj.getFreezorRect(2), null);



                for (int i = 0; i < 3; i++) {

                    if (rainTails.getRectOfRainbowTails().intersect(freezorObj.getFreezorRect(i)) && freezorObj.checkIfFreezorIsPressed() == false) {
                        rainTails.letRainTailsSlip();
                        rainTails.setRainTailsSlipSpeed();


                        mp7.start();


                        rainTails.startFreezeCount();
                        freezorObj.pressFreezor();
                    }
                }

            }


            if(currentLevel==4) {
                mCanvas.drawBitmap(Assets.pianocirclescript, ScreenWidth / 2 - Assets.pianocirclescript.getWidth() / 2, 3 * ScreenHeight / 5 - Assets.pianocirclescript.getHeight() / 2, null);
            }




/*
            if (currentLevel == 1 || currentLevel == 2 || currentLevel == 3){
                mCanvas.drawBitmap(Assets.purplegemleft, -Assets.purplegemleft.getWidth() / 2, ScreenHeight / 3 - Assets.purplegem.getHeight() / 2, null);
                mCanvas.drawBitmap(Assets.purplegemright, MainActivity.ScreenWidth - Assets.purplegemright.getWidth() / 2, ScreenHeight / 3 - Assets.purplegem.getHeight() / 2, null);
            }*/


        //    mCanvas.drawBitmap(Assets.purplegem, -Assets.purplegemleft.getWidth() / 2, ScreenHeight / 3 - Assets.purplegem.getHeight() / 2, null);


            Rect tttt = new Rect(0, ScreenHeight - Assets.tails1.getHeight(), ScreenWidth, ScreenHeight);
            if (tailscurrent < 40) {
                mCanvas.drawBitmap(Assets.tails1, null, tttt, null);
                mCanvas.drawBitmap(Assets.tails3, null, tttt, null);

                tailscurrent++;
            } else if (tailscurrent < 80) {
                mCanvas.drawBitmap(Assets.tails2, null, tttt, null);
                mCanvas.drawBitmap(Assets.tails2, null, tttt, null);


                tailscurrent++;

            } else if (tailscurrent < 120) {
                mCanvas.drawBitmap(Assets.tails3, null, tttt, null);
                mCanvas.drawBitmap(Assets.tails1, null, tttt, null);

                tailscurrent++;

            } else if (tailscurrent < 161) {
                mCanvas.drawBitmap(Assets.tails2, null, tttt, null);
                mCanvas.drawBitmap(Assets.tails2, null, tttt, null);

                tailscurrent++;
                if (tailscurrent == 160) {

                    tailscurrent = 0;
                }


            }









            //Markers
            mCanvas.drawBitmap(Assets.bluemarker, 0, ScreenHeight - Assets.bluemarker.getHeight(), null);
            if(markerInk.isMarkerAvailable(currentLevel,'b')=='n'){

                mCanvas.drawBitmap(Assets.lockedsmall, Assets.bluemarker.getWidth()/2 - Assets.lockedsmall.getWidth()/2, ScreenHeight - Assets.greenmarker.getHeight(), null);

            }



            mCanvas.drawBitmap(Assets.greenmarker, Assets.bluemarker.getWidth(), ScreenHeight - Assets.greenmarker.getHeight(), null);
            if(markerInk.isMarkerAvailable(currentLevel,'g')=='n'){

                mCanvas.drawBitmap(Assets.lockedsmall, Assets.bluemarker.getWidth(), ScreenHeight - Assets.greenmarker.getHeight(), null);

            }



            mCanvas.drawBitmap(Assets.yellowmarker, ScreenWidth - Assets.yellowmarker.getWidth(), ScreenHeight - Assets.bluemarker.getHeight(), null);
            if(markerInk.isMarkerAvailable(currentLevel,'y')=='n'){

                mCanvas.drawBitmap(Assets.lockedsmall, ScreenWidth - (Assets.yellowmarker.getWidth()), ScreenHeight - Assets.greenmarker.getHeight(), null);

            }



            mCanvas.drawBitmap(Assets.redmarker, ScreenWidth - (Assets.yellowmarker.getWidth() + Assets.redmarker.getWidth()), ScreenHeight - Assets.redmarker.getHeight(), null);
            if(markerInk.isMarkerAvailable(currentLevel,'r')=='n'){

                mCanvas.drawBitmap(Assets.lockedsmall, ScreenWidth - (Assets.yellowmarker.getWidth() + Assets.redmarker.getWidth()), ScreenHeight - Assets.lockedsmall.getHeight(), null);

            }





            //mCanvas.drawBitmap(Assets.pipe, ScreenWidth - (Assets.yellowmarker.getWidth() + Assets.redmarker.getWidth()/2), ScreenHeight - Assets.lockedsmall.getHeight(), null);








            //Now time to draw that cool gem!
            if (currentGem.equals("blue")) {

                mCanvas.drawBitmap(Assets.bluegem, ScreenWidth / 2 - ((Assets.bluegem.getWidth()) / 2), ScreenHeight - Assets.bluegem.getHeight(), null);

            } else if (currentGem.equals("red")) {

                mCanvas.drawBitmap(Assets.redgem, ScreenWidth / 2 - ((Assets.bluegem.getWidth()) / 2), ScreenHeight - Assets.bluegem.getHeight(), null);

            } else if (currentGem.equals("heart")) {

                mCanvas.drawBitmap(Assets.heartgem, ScreenWidth / 2 - ((Assets.bluegem.getWidth()) / 2), ScreenHeight - Assets.bluegem.getHeight(), null);

            } else if (currentGem.equals("green")) {

                mCanvas.drawBitmap(Assets.greengem, ScreenWidth / 2 - ((Assets.greengem.getWidth()) / 2), ScreenHeight - Assets.greengem.getHeight(), null);


            } else if (currentGem.equals("protect")) {

                mCanvas.drawBitmap(Assets.protectgem, ScreenWidth / 2 - ((Assets.protectgem.getWidth()) / 2), ScreenHeight - Assets.protectgem.getHeight(), null);


            } else if (currentGem.equals("none")) {

            }





            //Star collision
            if (rainTails.isRainbowTailsVisible() == true && starObj.isStarVisible() == true) {
                if (starObj.checkCollision(rainTails.getRectOfRainbowTails()) == true) {

                    gameWon();

                    if(timetick.isPlaying()){

                        timetick.pause();
                        timetick.seekTo(0);

                    }




                } else {

                }
            }


            for (int i = 0; i < playerPaintedWallsObj.getNumberOfWallsPainted(); i++) {


                testerOfWall.set(playerPaintedWallsObj.rectOfWall(i).left, playerPaintedWallsObj.rectOfWall(i).top, playerPaintedWallsObj.rectOfWall(i).right, playerPaintedWallsObj.rectOfWall(i).bottom);


                //rainTails.checkCollisionWithPaintedWalls(playerPaintedWallsObj.rectOfWall(i), playerPaintedWallsObj.getColor(i),i,playerPaintedWallsObj);


                rainTails.checkCollisionWithPaintedWalls(testerOfWall, playerPaintedWallsObj.getColor(i),i,playerPaintedWallsObj);

            }





            if(speedUpNow==true ){

                if(boingMusicStillPlaying==false) {
                    Assets.playSound(Assets.boingID);
                    boingMusicStillPlaying=true;

                    stopTimeOfBoing= timeLeftOfTimer;


                    if (rainTails.getSpeedY() > 0) {

                        if(rainTails.isRainTailsSlipping()==true) {
                            rainTails.updateSpeedY(7f * (float) MainActivity.ScaleWidth);
                        }else{

                            rainTails.updateSpeedY(5f * (float) MainActivity.ScaleWidth);
                        }

                    } else {

                        if(rainTails.isRainTailsSlipping()==true) {
                            rainTails.updateSpeedY(-7f * (float) MainActivity.ScaleWidth);
                        }else{

                            rainTails.updateSpeedY(-5f * (float) MainActivity.ScaleWidth);
                        }
                    }


                    if (rainTails.getSpeedX() > 0) {

                        if(rainTails.isRainTailsSlipping()==true) {
                            rainTails.updateSpeedX(7f * (float) MainActivity.ScaleWidth);
                        }else{

                            rainTails.updateSpeedX(5f * (float) MainActivity.ScaleWidth);
                        }

                    } else {

                        if(rainTails.isRainTailsSlipping()==true) {
                            rainTails.updateSpeedX(-7f * (float) MainActivity.ScaleWidth);
                        }else{

                            rainTails.updateSpeedX(-5f * (float) MainActivity.ScaleWidth);
                        }

                    }





                }



                if(timeLeftOfTimer/1000 == (stopTimeOfBoing/1000) -2 ){

                    boingMusicStillPlaying=false;
                    rainTails.returnToOriginalSpeed();
                    boingMusicStillPlaying = false;
                    speedUpNow = false;
                    stopTimeOfBoing=-100;

                }





            }





/*
            if (speedUpNow == true && timeLeftOfSpeedUp > 0 && boingMusicStillPlaying == false) {


                Assets.playSound(Assets.boingID);
                boingMusicStillPlaying = true;

                if (rainTails.getSpeedX() > 0) {

                    if(rainTails.isRainTailsSlipping()==true) {
                        rainTails.updateSpeedX(14f * (float) MainActivity.ScaleWidth);
                    }else{

                        rainTails.updateSpeedX(3f * (float) MainActivity.ScaleWidth);
                    }

                } else {

                    if(rainTails.isRainTailsSlipping()==true) {
                        rainTails.updateSpeedX(-14f * (float) MainActivity.ScaleWidth);
                    }else{

                        rainTails.updateSpeedX(-3f * (float) MainActivity.ScaleWidth);
                    }

                }





                if (rainTails.getSpeedY() > 0) {

                    if(rainTails.isRainTailsSlipping()==true) {
                        rainTails.updateSpeedY(20f * (float) MainActivity.ScaleWidth);
                    }else{

                        rainTails.updateSpeedY(3f * (float) MainActivity.ScaleWidth);
                    }

                } else {

                    if(rainTails.isRainTailsSlipping()==true) {
                        rainTails.updateSpeedY(-20f * (float) MainActivity.ScaleWidth);
                    }else{

                        rainTails.updateSpeedY(-3f * (float) MainActivity.ScaleWidth);
                    }
                }

                timeLeftOfSpeedUp--;


            } else if (speedUpNow == true && timeLeftOfSpeedUp > 0) {


                if (rainTails.getSpeedY() > 0) {

                    if(rainTails.isRainTailsSlipping()==true) {
                        rainTails.updateSpeedY(20f * (float) MainActivity.ScaleWidth);
                    }else{

                        rainTails.updateSpeedY(3f * (float) MainActivity.ScaleWidth);
                    }

                } else {

                    if(rainTails.isRainTailsSlipping()==true) {
                        rainTails.updateSpeedY(-20f * (float) MainActivity.ScaleWidth);
                    }else{

                        rainTails.updateSpeedY(-3f * (float) MainActivity.ScaleWidth);
                    }
                }


                timeLeftOfSpeedUp--;

            } else if (speedUpNow == true && timeLeftOfSpeedUp == 0) {


                rainTails.returnToOriginalSpeed();


                boingMusicStillPlaying = false;
                speedUpNow = false;
                timeLeftOfSpeedUp = 40;
            }*/




            //Check
            //playerPaintedWallsObj.checkCollisionFireBallWithPlayerPaintedWalls(fireBallObj);




            playerPaintedWallsObj.checkCollisionFireBallWithPlayerPaintedWallls(fireBallObj);




            if (rainTails.isRainbowTailsVisible() == true && fireBallObj.checkCollisionsRainTailsWithFireball(rainTails) == true) {

                if (mp2.isPlaying()) {


                } else {

                    numberOfLives--;
                }

                mp2.start();

            }


            //checks screen collisions
            checkRainTailsScreenCollision(mCanvas);
            checkFireballScreenCollision(mCanvas);


           // spikyVertObj.updateSpeed(currentLevel);
            //spikyHoriObj.updateSpeed(currentLevel);
            spikyDoubleObj.updateSpeed(currentLevel,levelWall,spikyDoubleObj);



            //Will draw countdown
            if (countdownIsDone == false) {

                mCanvas.drawBitmap(Assets.leveldialog, ScreenWidth / 2 - Assets.leveldialog.getWidth() / 2, ScreenHeight / 2 - 3 * (Assets.leveldialog.getHeight() / 5), null);
                mCanvas.drawBitmap(Assets.currentleveltext, ScreenWidth / 2 - Assets.currentleveltext.getWidth() / 2, (ScreenHeight / 2) - (9 * Assets.currentleveltext.getHeight() / 5), null);





                if(currentLevel==5 || currentLevel==10 || currentLevel==14 || currentLevel==15 || currentLevel==19 || currentLevel==24) {
                    mCanvas.drawBitmap(Assets.survivetimetext, ScreenWidth / 2 - Assets.survivetimetext.getWidth() / 2, (ScreenHeight / 2) - (2 * Assets.survivetimetext.getHeight() / 5), null);

                }else{
                    mCanvas.drawBitmap(Assets.collectgemtext, ScreenWidth / 2 - Assets.collectgemtext.getWidth() / 2, (ScreenHeight / 2) - (2 * Assets.survivetimetext.getHeight() / 5), null);


                }



                //mCanvas.drawBitmap(Assets.musiclandtext, ScreenWidth / 2 , ScreenHeight / 2 - 3 * Assets.level7text.getHeight(), null);
                //mCanvas.drawBitmap(Assets.rainbowtailscute,(ScreenWidth / 7) - Assets.rainbowtailscute.getWidth()/4, ScreenHeight / 2 - Assets.rainbowtailscute.getHeight()/2, null);


                if (levelInformationDialogStatus ==3) {

                    mCanvas.drawBitmap(Assets.count3, ScreenWidth / 2 - Assets.count3.getWidth() / 2, (ScreenHeight / 2) + Assets.count3.getHeight() , null);

                } else if (levelInformationDialogStatus ==2) {

                    mCanvas.drawBitmap(Assets.count2, ScreenWidth / 2 - Assets.count2.getWidth() / 2, (ScreenHeight / 2) + Assets.count2.getHeight() , null);

                } else if (levelInformationDialogStatus ==1) {
                    mCanvas.drawBitmap(Assets.count1, ScreenWidth / 2 - Assets.count1.getWidth() / 2, (ScreenHeight / 2) + Assets.count1.getHeight() , null);


                } else if (levelInformationDialogStatus ==0) {

                    mCanvas.drawBitmap(Assets.countgo, ScreenWidth / 2 - Assets.countgo.getWidth() / 2, (ScreenHeight / 2) + Assets.countgo.getHeight() , null);

                }else if(levelInformationDialogStatus==-1){

                    countdownIsDone = true;
                }

            }






            //Draw status
            mCanvas.drawLine(0, 0, ScreenWidth, 0, paintToolsObj.getTransparentTopRowPaint2());    //Status white background

            mCanvas.drawLine(0, 0, ScreenWidth, 0, paintToolsObj.getTransparentTopRowPaint());    //Status white background





            if (markerInk.getInkLevel(markerInk.getCurrentMarker()) > ScreenWidth- (Assets.pen.getWidth()- Assets.pen.getWidth()/6)) {
                mCanvas.drawLine(ScreenWidth - Assets.pen.getWidth() + Assets.pen.getWidth() / 5, Assets.pen.getHeight() / 2 + Assets.pen.getHeight()/8, markerInk.getInkLevel(markerInk.getCurrentMarker()), Assets.pen.getHeight() / 2 + Assets.pen.getHeight()/8, paintToolsObj.getInkLeftPaint(markerInk.getCurrentMarker()));   //Status blue ink
            }




            mCanvas.drawBitmap(Assets.pen, ScreenWidth - Assets.pen.getWidth(), 10*(float)MainActivity.ScaleHeight, null);


            mCanvas.drawBitmap(Assets.livesbar, 0, 0, null);





            mCanvas.drawBitmap(Assets.timeleftbar, MainActivity.ScreenWidth / 2 - Assets.timeleftbar.getWidth() / 2, 0, null);

            //mCanvas.drawText(String.valueOf(timeLeftOfTimer / 1000), MainActivity.ScreenWidth / 2, Assets.timeleftbar.getHeight() / 2 + 36 / 2 * (float) (MainActivity.ScaleHeight), paintToolsObj.getWorldInfoPaint());


            if(levelInformationDialogStatus<-1) {
               mCanvas.drawText(String.valueOf(timeLeftOfTimer / 1000), MainActivity.ScreenWidth / 2, Assets.timeleftbar.getHeight() / 2 + 36 / 2 * (float) (MainActivity.ScaleHeight), paintToolsObj.getWorldInfoPaint());

           }else{
               mCanvas.drawText(String.valueOf(120), MainActivity.ScreenWidth / 2, Assets.timeleftbar.getHeight() / 2 + 36 / 2 * (float) (MainActivity.ScaleHeight), paintToolsObj.getWorldInfoPaint());

           }

            //Hearths are drawn
            for (int i = 1; i <= numberOfLives; i++) {
                mCanvas.drawBitmap(Assets.hearthlives, Assets.hearthlives.getWidth() / 2 + i * Assets.hearthlives.getWidth(), Assets.livesbar.getHeight() / 2 - Assets.hearthlives.getHeight() / 2, null);

            }






            getHolder().unlockCanvasAndPost(mCanvas);

        }


        if(numberOfLives==0){
            currentState="youlose";

            if(timetick.isPlaying()){
                timetick.pause();
                timetick.seekTo(0);

            }


            gameOverSound.start();

        }
    }




public void updatePosSpeedOfEveything(){


}



    private void gameWon(){
        if(soundEffectsTurnedOn.equals("enabled")) {
            mp.start();
        }

        rainTails.letRainbowTailsDisappear();
        currentState = "youwin";
        if(currentLevel>=numberOfCompletedLevels){
            SharedPreferences.Editor prefEditor = completedLevels.edit();
            prefEditor.putInt("COMPLETEDLEVELS", currentLevel+1);
            prefEditor.commit();
            numberOfCompletedLevels=completedLevels.getInt("COMPLETEDLEVELS",0);


        }
    }



    private void updateAndRender(long delta) {
        renderGameImage();
    }







    void superPowerUpdates(){


        if(superPowerClicked.equals("blue")){


            fireBallObj.decreaseNumberOfFireballs();



            //Slow down spikes speed from the rain
            spikyDoubleObj.slowDownSpikyWallsFromRain();
            fireBallObj.slowDownMusicalNotesFromRain();



            superPowerClicked="empty";


        }else if(superPowerClicked.equals("red") ){


            smokeTries=24;
            superPowerClicked="empty";

        }else if(superPowerClicked.equals("hearth")){

            numberOfLives++;
        }

    }





    public  void timeForNextLevel(){

        currentLevel++;
        collide = false;
        starObj.initializeStar(currentLevel);
        rainTails.initializeRainbowTails(currentLevel);

        firstTime = true;
        initObjects();
        initGame();
    }







public void startGemCountDown() {

    isstartGemCountDownRunning = true;

    gemCountDown = new CountDownTimer(timeLeftOfGemCountDownTimer, 1000) {//CountDownTimer(edittext1.getText()+edittext2.getText()) also parse it to long

        public void onTick(long millisUntilFinished) {
            timeLeftOfGemCountDownTimer = millisUntilFinished;

        }

        public void onFinish() {


            timeLeftOfGemCountDownTimer = 10000;
            newGemCreated.start();

            if(numberOfLives<8) {

                if(rainTails.getNumberOfTimesProtected()==2){

                    randomGem = (int) (Math.random() * 4);


                    if (randomGem == 0) {

                        currentGem = "blue";

                    } else if (randomGem == 1) {

                        currentGem = "red";


                    } else if (randomGem == 2) {
                        currentGem = "heart";


                    }else if(randomGem==3){

                        currentGem = "green";

                    }
                }else{

                    randomGem = (int) (Math.random() * 5);


                    if (randomGem == 0) {

                        currentGem = "blue";

                    } else if (randomGem == 1) {

                        currentGem = "red";


                    } else if (randomGem == 2) {
                        currentGem = "protect";
                        rainTails.increaseNumberOfTimesProtected();


                    }else if(randomGem==3){

                        currentGem = "green";


                    }else if(randomGem==4){
                        currentGem = "heart";

                    }
                }


            }else{

                if(rainTails.getNumberOfTimesProtected()==2) {


                    randomGem = (int) (Math.random() * 3);


                    if (randomGem == 0) {

                        currentGem = "blue";

                    } else if (randomGem == 1) {

                        currentGem = "red";


                    } else if (randomGem == 2) {
                        currentGem = "green";

                    }

                }else{

                    randomGem = (int) (Math.random() * 4);


                    if (randomGem == 0) {

                        currentGem = "blue";

                    } else if (randomGem == 1) {

                        currentGem = "red";


                    } else if (randomGem == 2) {
                        currentGem = "protect";
                        rainTails.increaseNumberOfTimesProtected();


                    }else if(randomGem==3){

                        currentGem = "green";


                    }
                }

            }




            isstartGemCountDownRunning = false;
        }
    }
            .start();

}





    private void countDownLetItRain() {

        new CountDownTimer(8000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                superPowerUsed = "empty";


                //Restore to normal speed after rain

                spikyDoubleObj.restoreNormalSpeedAfterRain(currentLevel);
                fireBallObj.restoreSpeedFromRain(currentLevel);


                //customCanvas.updateLevel();
            }


        }
                .start();
    }





    private void startCountDownClock(){
        isCountTimerRunning=true;
        tickingClock = new CountDownTimer(timeLeftOfTimer, 1000) {

            public void onTick(long millisUntilFinished) {


                timeLeftOfTimer=millisUntilFinished;
                timeLeftText="Time Left: " +  millisUntilFinished/1000;



                if ((millisUntilFinished/1000)==123 || (millisUntilFinished/1000)==122 || (millisUntilFinished/1000)==121 || (millisUntilFinished/1000)==120 || (millisUntilFinished/1000)==119 ) {
                    levelInformationDialogStatus--;

                }




                if ((millisUntilFinished/1000)==10) {
                    //Assets.playSound(Assets.timeTickID);
                    timetick.start();
                   // clockTick.start();
                }
            }



            public void onFinish() {
                timeLeftText="Times Up!";

                if(currentLevel==5){
                    gameWon();
                    isCountTimerRunning = false;
                    timeLeftOfTimer = 125000;

                }else if(currentLevel==10) {
                    gameWon();
                    isCountTimerRunning = false;
                    timeLeftOfTimer = 125000;


                }else if(currentLevel==14 || currentLevel==15 || currentLevel==19 || currentLevel==24){
                        gameWon();
                        isCountTimerRunning = false;
                        timeLeftOfTimer = 125000;



                }else{

                    gameOverSound.start();
                    currentState = "youlose";
                    isCountTimerRunning = false;
                    timeLeftOfTimer = 125000;

                }

            }

        }
                .start();
    }





    private void startProtectionOfRainTails(){
        isProtectionTimerRunning=true;
        mpShield.start();
        protectionClock = new CountDownTimer(timeLeftOfProtection, 1000) {

            public void onTick(long millisUntilFinished) {
                timeLeftOfProtection=millisUntilFinished;



            }



            public void onFinish() {
                isProtectionTimerRunning=false;
                timeLeftOfProtection=9000;
               /* mpShield.stop();

                try {
                    mpShield.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

                mpShield.pause();
                mpShield.seekTo(0);

                rainTails.stopProtectingRainTails();


            }


        }
                .start();

    }






    private void startBoostSpeedOfRainTails(){
        isBoosterTimerRunning=true;

        if(rainTails.isSlipping==true) {
            if(rainTails.getSpeedX()>0) {
                rainTails.updateSpeedX(3f * (float) MainActivity.ScaleWidth);
            }else {
                rainTails.updateSpeedX(-3f * (float) MainActivity.ScaleWidth);

            }

            if(rainTails.getSpeedY()>0){
                rainTails.updateSpeedY(3f * (float) MainActivity.ScaleHeight);

            }else{

                rainTails.updateSpeedY(-3f * (float) MainActivity.ScaleHeight);

            }




        }else{
            if(rainTails.getSpeedX()>0) {
                rainTails.updateSpeedX(4f * (float) MainActivity.ScaleWidth);
            }else {
                rainTails.updateSpeedX(-4f * (float) MainActivity.ScaleWidth);

            }

            if(rainTails.getSpeedY()>0){
                rainTails.updateSpeedY(4f * (float) MainActivity.ScaleHeight);

            }else{

                rainTails.updateSpeedY(-4f * (float) MainActivity.ScaleHeight);

            }
        }

        protectionClock = new CountDownTimer(timeLeftOfSpeedUpBooster, 1000) {


            public void onTick(long millisUntilFinished) {
                timeLeftOfSpeedUpBooster=millisUntilFinished;

            }

            public void onFinish() {
                isBoosterTimerRunning=false;
                timeLeftOfSpeedUpBooster=9000;
                rainTails.setOriginalSpeedBack();



            }


        }
                .start();

    }






}