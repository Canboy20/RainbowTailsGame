package com.rainbowtails.canatay.rainbowtails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;




public class MainActivity extends Activity {




    public static boolean done = false;

    MediaPlayer newGemCreated;
    MediaPlayer rainDrops;
    MediaPlayer poof;




    boolean soundStared = false;
    Context context;
    static String densityPhone;

    Intent restartGame;


    GameView gameView;
    public static int ScreenHeight;
    public static int ScreenWidth;
    //double PerfectScreenHeight = 1080;
    //double PerfectScreenWidth = 720;
    double PerfectScreenWidth=1600;
    double PerfectScreenHeight=2560;


    public static double ScaleHeight;
    public static double ScaleWidth;


    public static AssetManager assets;
    private long timeLeftOfTimer=120000;
    boolean isCountTimerRunning=false;

    FrameLayout game;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        ScreenHeight = metrics.heightPixels;
        ScreenWidth = metrics.widthPixels;
        Log.i("myAppTag", "Screen Width" + ScreenWidth);
        Log.i("myAppTag", "Screen Height" + ScreenHeight);

        double ScreenHeightDouble=ScreenHeight;
        double ScreenWidthDouble=ScreenWidth;


       // ScaleHeight =( ScreenHeight)*1D  / ((PerfectScreenHeight)*1D);
        ScaleHeight =( ScreenHeight)  / ((PerfectScreenHeight));
        ScaleWidth = (ScreenWidth)*1D  / ((PerfectScreenWidth)*1D);




        int density = getResources().getDisplayMetrics().densityDpi;
        switch (density) {
            case DisplayMetrics.DENSITY_LOW:
                densityPhone = "LOW";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                densityPhone = "MEDIUM";

                break;
            case DisplayMetrics.DENSITY_HIGH:
                densityPhone = "HIGH";

                break;
            case DisplayMetrics.DENSITY_XHIGH:
                densityPhone = "XHIGH";

            case DisplayMetrics.DENSITY_XXHIGH:
                densityPhone = "XXHIGH";

                break;
        }

        assets = getAssets();


        //game = new GameView(this, ScreenWidth, ScreenHeight,densityPhone);
        // setContentView(R.layout.gamescreen);



        gameView = new GameView(this, ScreenWidth, ScreenHeight, densityPhone);







       /* LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(currentGem.getLayoutParams());
        lp.setMargins(ScreenWidth / 2 - Assets.bluegem.getWidth() / 2, ScreenHeight - Assets.bluegem.getHeight(), 0, 0);*/

        //currentGem.setImageResource(R.drawable.bluegem);
        //currentGem.setLayoutParams(lp);
        // currentGem.setTag("empty");
       // currentGem.setOnClickListener(buttonClickListener);









        /*
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                currentGem.getLayoutParams());
        params.setMargins(ScreenWidth / 2 - blue.getWidth() / 2, ScreenHeight - blue.getHeight(), ScreenWidth / 2 + blue.getWidth() / 2, ScreenHeight - blue.getHeight() + blue.getHeight());
        currentGem.setLayoutParams(params);
        */

        setContentView(gameView);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        context = this;


        newGemCreated = MediaPlayer.create(context, R.raw.newgem);
        rainDrops = MediaPlayer.create(context, R.raw.rain);
        poof = MediaPlayer.create(context, R.raw.poof);






    }



























    @Override
    public void onBackPressed() {



        if(GameView.currentState.equals("playinggame")) {
            GameView.currentState = "gamepaused";
            gameView.pauseGameFromOnBack();
            GameView.comesFromPause=true;

        }else if(GameView.currentState.equals("credits")){

            GameView.currentState = "mainscreen";
            Assets.recycleBitmaps("credits");
            Assets.load("mainscreen");
            gameView.displayMainScreen();

        }else if(GameView.currentState.equals("worldselect")) {

            GameView.currentState = "mainscreen";
            Assets.recycleBitmaps("worldselect");
            Assets.load("mainscreen");
            gameView.displayMainScreen();


        }else if(GameView.currentState.equals("options")){


            GameView.currentState = "mainscreen";
            Assets.recycleBitmaps("options");
            Assets.load("mainscreen");
            gameView.displayMainScreen();


        }else if(GameView.currentState.equals("levelselect")) {

            GameView.currentState = "worldselect";
            Assets.recycleBitmaps("levelselect");
            Assets.load("worldselect");
            gameView.displayWorldSelect();


        }else if(GameView.currentState.equals("mainscreen")){
/*
            GameView.currentState = "quitgame";
            Assets.load("quitgame");
            gameView.displayQuitGameAlertDialog();*/
            gameView.setVisibility(View.GONE);
            Assets.stopMainMusic();
            System.exit(0);


        }else if(GameView.currentState.equals("youwin")){


        }else if(GameView.currentState.equals("youlose")){

        }
    }




    @Override
    public void onStop(){
        super.onStop();
        Assets.onPause();
        GameView.comesFromPause=true;

    }




    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first



       // Assets.onResume();
    }




    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first


    }
}


