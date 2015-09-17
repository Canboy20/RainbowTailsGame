package com.rainbowtails.canatay.rainbowtails;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;


public class Assets {
    private static SoundPool soundPool;
    public static Bitmap musicbackground,musicbackgrounddark, musicbackgroundfrozen1, musicbackgroundfrozen2, musicbackgroundfrozen3, musicbackgroundfrozen4, musicbackgroundfrozen4dark,musicbackgroundblurry, jump,
            dogright1, dogright2, dogright3, dogright4, dogleft1, dogleft2, dogleft3, dogleft4,
            frozendog1left, frozendog2left,
            hearthlives,gemright,gemleft,livesbar,timeleftbar,fingerone,
            tails1,tails2,tails3,
            redgem,bluegem,heartgem,greengem,protectgem,purplegem,purplegemleft,purplegemright,
            fireball,fireball2,fireball3,thunder,/*thundertwo,*/blur,pipeleft,piperight,pipemusicnote,pipebottom,flute,fogsmall,pianocirclescript,starspot,
            spikyHori,spikyVert,spikyDouble,spikyDoubleBumpable,
            freezeButton,
            levellocked,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,
            levelselectbackground,
            selectleveltext,selectworldtext,
            count3,count2,count1,countgo,leveldialog,musiclandtext,rainbowtailscute,
            currentleveltext,lockedsmall,survivetimetext,collectgemtext,
            star,
            livestext,inktext,
            pen,bluemarker,yellowmarker,greenmarker,redmarker,
            circlespawn,
            youwinalertdialog,toobadalertdialog,gamepausedalertdialog,/*quitalertdialog*/
            smokesmall,smokemed,smokebig,
            dropone,droptwo,dropthree,droplong,
            musicworldbut,musicworldbutpressed,lostwoodsbut,horrornightmarebut,worldselectbackground,
            raintailsbig,
            playbutton,creditsbutton,optionsbutton,playbuttonpressed,creditsbuttonpressed,optionsbuttonpressed,rainbowText,tailsText,
            creditsscreen,optionsscreen,optionison,optionisoff,cleargamedatabutton,
            cleardataalertdialog;


    public static int boingID,warpID,timeTickID,gemPickUpID,accessDeniedID,starUnlockedID;
    private static MediaPlayer mediaPlayer;

    public static void load(String currentstate) {
        if(currentstate.equals("test")) {
            musicbackground = loadBitmap("musiclandtestt.jpg", false);
            musicbackground = Bitmap.createScaledBitmap(musicbackground, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);
            musicbackgrounddark = loadBitmap("musiclandtestdark.jpg", false);
            musicbackgrounddark = Bitmap.createScaledBitmap(musicbackgrounddark, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);
            dogright1 = loadBitmap("dogrightone.png", false);
            dogright1 = Bitmap.createScaledBitmap(dogright1, 100, 100, true);
            dogright1 = Bitmap.createScaledBitmap(dogright1, (int) Math.round(dogright1.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogright1.getHeight() * MainActivity.ScaleHeight), true);


            dogright2 = loadBitmap("dogrighttwo.png", false);
            dogright2 = Bitmap.createScaledBitmap(dogright2, 100, 100, true);
            dogright2 = Bitmap.createScaledBitmap(dogright2, (int) Math.round(dogright2.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogright2.getHeight() * MainActivity.ScaleHeight), true);


            dogright3 = loadBitmap("dogrightthree.png", false);
            dogright3 = Bitmap.createScaledBitmap(dogright3, 100, 100, true);
            dogright3 = Bitmap.createScaledBitmap(dogright3, (int) Math.round(dogright3.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogright3.getHeight() * MainActivity.ScaleHeight), true);


            dogright4 = loadBitmap("dogrightfour.png", false);
            dogright4 = Bitmap.createScaledBitmap(dogright4, 100, 100, true);
            dogright4 = Bitmap.createScaledBitmap(dogright4, (int) Math.round(dogright4.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogright4.getHeight() * MainActivity.ScaleHeight), true);


            dogleft1 = loadBitmap("dogleftone.png", false);
            dogleft1 = Bitmap.createScaledBitmap(dogleft1, 100, 100, true);
            dogleft1 = Bitmap.createScaledBitmap(dogleft1, (int) Math.round(dogleft1.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogleft1.getHeight() * MainActivity.ScaleHeight), true);


            dogleft2 = loadBitmap("doglefttwo.png", false);
            dogleft2 = Bitmap.createScaledBitmap(dogleft2, 100, 100, true);
            dogleft2 = Bitmap.createScaledBitmap(dogleft1, (int) Math.round(dogleft2.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogleft2.getHeight() * MainActivity.ScaleHeight), true);


            dogleft3 = loadBitmap("dogleftthree.png", false);
            dogleft3 = Bitmap.createScaledBitmap(dogleft3, 100, 100, true);
            dogleft3 = Bitmap.createScaledBitmap(dogleft3, (int) Math.round(dogleft3.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogleft3.getHeight() * MainActivity.ScaleHeight), true);


            dogleft4 = loadBitmap("dogleftfour.png", false);
            dogleft4 = Bitmap.createScaledBitmap(dogleft4, 100, 100, true);
            dogleft4 = Bitmap.createScaledBitmap(dogleft4, (int) Math.round(dogleft4.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogleft4.getHeight() * MainActivity.ScaleHeight), true);


            hearthlives = loadBitmap("hearth.png", false);
            hearthlives = Bitmap.createScaledBitmap(hearthlives, (int) Math.round(hearthlives.getWidth() * MainActivity.ScaleWidth), (int) Math.round(hearthlives.getHeight() * MainActivity.ScaleHeight), true);



            gemright = loadBitmap("gem.png", false);


            tails1 = loadBitmap("tailtester.png", false);
            tails2 = loadBitmap("tailtestertwo.png", false);
            tails3 = loadBitmap("tailtesterthree.png", false);


            redgem = loadBitmap("redgem.png", false);
            redgem = Bitmap.createScaledBitmap(redgem, (int) Math.round(redgem.getWidth() * MainActivity.ScaleWidth), (int) Math.round(redgem.getHeight() * MainActivity.ScaleHeight), true);

            bluegem = loadBitmap("bluegem.png", false);
            bluegem = Bitmap.createScaledBitmap(bluegem, (int) Math.round(bluegem.getWidth() * MainActivity.ScaleWidth), (int) Math.round(bluegem.getHeight() * MainActivity.ScaleHeight), true);


            heartgem = loadBitmap("heartgem.png", false);
            heartgem = Bitmap.createScaledBitmap(heartgem, (int) Math.round(heartgem.getWidth() * MainActivity.ScaleWidth), (int) Math.round(heartgem.getHeight() * MainActivity.ScaleHeight), true);


            spikyHori = loadBitmap("spikeshori.png", false);
            spikyHori = Bitmap.createScaledBitmap(spikyHori, (int) Math.round(spikyHori.getWidth() * MainActivity.ScaleWidth), (int) Math.round(spikyHori.getHeight() * MainActivity.ScaleHeight), true);

            spikyVert = loadBitmap("spikesvert.png", false);
            spikyVert = Bitmap.createScaledBitmap(spikyVert, (int) Math.round(spikyVert.getWidth() * MainActivity.ScaleWidth), (int) Math.round(spikyVert.getHeight() * MainActivity.ScaleHeight), true);

            star = loadBitmap("star.png", false);
            star = Bitmap.createScaledBitmap(star, (int) Math.round(star.getWidth() * MainActivity.ScaleWidth), (int) Math.round(star.getHeight() * MainActivity.ScaleHeight), true);


        }else if(currentstate.equals("worldselect")) {


            musicworldbut = loadBitmap("musicworldbut.png", false);
            musicworldbut = Bitmap.createScaledBitmap(musicworldbut, (int) Math.round(musicworldbut.getWidth() * MainActivity.ScaleWidth), (int) Math.round(musicworldbut.getHeight() * MainActivity.ScaleHeight), true);

            musicworldbutpressed = loadBitmap("musicworldbutpressed.png", false);
            musicworldbutpressed = Bitmap.createScaledBitmap(musicworldbutpressed, (int) Math.round(musicworldbutpressed.getWidth() * MainActivity.ScaleWidth), (int) Math.round(musicworldbutpressed.getHeight() * MainActivity.ScaleHeight), true);

            lostwoodsbut = loadBitmap("lostwoodsbut.png", false);
            lostwoodsbut = Bitmap.createScaledBitmap(lostwoodsbut, (int) Math.round(lostwoodsbut.getWidth() * MainActivity.ScaleWidth), (int) Math.round(lostwoodsbut.getHeight() * MainActivity.ScaleHeight), true);

            horrornightmarebut = loadBitmap("horrornightmarebut.png", false);
            horrornightmarebut = Bitmap.createScaledBitmap(horrornightmarebut, (int) Math.round(horrornightmarebut.getWidth() * MainActivity.ScaleWidth), (int) Math.round(horrornightmarebut.getHeight() * MainActivity.ScaleHeight), true);

            worldselectbackground = loadBitmap("worldselectbackground.jpg", false);
            worldselectbackground = Bitmap.createScaledBitmap(worldselectbackground, (int) Math.round(worldselectbackground.getWidth() * MainActivity.ScaleWidth), (int) Math.round(worldselectbackground.getHeight() * MainActivity.ScaleHeight), true);

            selectworldtext = loadBitmap("selectworldtext.png", false);
            selectworldtext = Bitmap.createScaledBitmap(selectworldtext, (int) Math.round(selectworldtext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(selectworldtext.getHeight() * MainActivity.ScaleHeight), true);



        }else if(currentstate.equals("mainscreen")){

            raintailsbig=loadBitmap("raintailsbigtwo.png", false);
            raintailsbig = Bitmap.createScaledBitmap(raintailsbig, (int) Math.round(raintailsbig.getWidth() * MainActivity.ScaleWidth), (int) Math.round(raintailsbig.getHeight() * MainActivity.ScaleHeight), true);


            worldselectbackground = loadBitmap("worldselectbackground.jpg", false);
            worldselectbackground = Bitmap.createScaledBitmap(worldselectbackground, (int) Math.round(worldselectbackground.getWidth() * MainActivity.ScaleWidth), (int) Math.round(worldselectbackground.getHeight() * MainActivity.ScaleHeight), true);

            playbutton=loadBitmap("button2.png", false);
            playbutton = Bitmap.createScaledBitmap(playbutton, (int) Math.round(playbutton.getWidth() * MainActivity.ScaleWidth), (int) Math.round(playbutton.getHeight() * MainActivity.ScaleHeight), true);

            rainbowText=loadBitmap("rainbowtext.png", false);
            rainbowText = Bitmap.createScaledBitmap(rainbowText, (int) Math.round(rainbowText.getWidth() * MainActivity.ScaleWidth), (int) Math.round(rainbowText.getHeight() * MainActivity.ScaleHeight), true);

            tailsText=loadBitmap("tailstext.png", false);
            tailsText = Bitmap.createScaledBitmap(tailsText, (int) Math.round(tailsText.getWidth() * MainActivity.ScaleWidth), (int) Math.round(tailsText.getHeight() * MainActivity.ScaleHeight), true);

            creditsbutton=loadBitmap("button.png", false);
            creditsbutton = Bitmap.createScaledBitmap(creditsbutton, (int) Math.round(creditsbutton.getWidth() * MainActivity.ScaleWidth), (int) Math.round(creditsbutton.getHeight() * MainActivity.ScaleHeight), true);

            optionsbutton=loadBitmap("button3.png", false);
            optionsbutton = Bitmap.createScaledBitmap(optionsbutton, (int) Math.round(optionsbutton.getWidth() * MainActivity.ScaleWidth), (int) Math.round(optionsbutton.getHeight() * MainActivity.ScaleHeight), true);

            playbuttonpressed=loadBitmap("playbuttonpressed.png", false);
            playbuttonpressed = Bitmap.createScaledBitmap(playbuttonpressed, (int) Math.round(playbuttonpressed.getWidth() * MainActivity.ScaleWidth), (int) Math.round(playbuttonpressed.getHeight() * MainActivity.ScaleHeight), true);

            creditsbuttonpressed=loadBitmap("creditsbuttonpressed.png", false);
            creditsbuttonpressed = Bitmap.createScaledBitmap(creditsbuttonpressed, (int) Math.round(creditsbuttonpressed.getWidth() * MainActivity.ScaleWidth), (int) Math.round(creditsbuttonpressed.getHeight() * MainActivity.ScaleHeight), true);

            optionsbuttonpressed=loadBitmap("optionsbuttonpressed.png", false);
            optionsbuttonpressed = Bitmap.createScaledBitmap(optionsbuttonpressed, (int) Math.round(optionsbuttonpressed.getWidth() * MainActivity.ScaleWidth), (int) Math.round(optionsbuttonpressed.getHeight() * MainActivity.ScaleHeight), true);



        }else if(currentstate.equals("playinggame")) {

            musicbackground = loadBitmap("musiclandtestt.jpg", false);
            musicbackground = Bitmap.createScaledBitmap(musicbackground, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);


            musicbackgrounddark = loadBitmap("musiclandtestdark.jpg", false);
            musicbackgrounddark = Bitmap.createScaledBitmap(musicbackgrounddark, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);


            dogright1 = loadBitmap("dogrightone.png", false);
            dogright1 = Bitmap.createScaledBitmap(dogright1, 170, 170, true);
            dogright1 = Bitmap.createScaledBitmap(dogright1, (int) Math.round(dogright1.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogright1.getHeight() * MainActivity.ScaleHeight), true);


            dogright2 = loadBitmap("dogrighttwo.png", false);
            dogright2 = Bitmap.createScaledBitmap(dogright2, 170, 170, true);
            dogright2 = Bitmap.createScaledBitmap(dogright2, (int) Math.round(dogright2.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogright2.getHeight() * MainActivity.ScaleHeight), true);


            dogright3 = loadBitmap("dogrightthree.png", false);
            dogright3 = Bitmap.createScaledBitmap(dogright3, 170, 170, true);
            dogright3 = Bitmap.createScaledBitmap(dogright3, (int) Math.round(dogright3.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogright3.getHeight() * MainActivity.ScaleHeight), true);


            dogright4 = loadBitmap("dogrightfour.png", false);
            dogright4 = Bitmap.createScaledBitmap(dogright4, 170, 170, true);
            dogright4 = Bitmap.createScaledBitmap(dogright4, (int) Math.round(dogright4.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogright4.getHeight() * MainActivity.ScaleHeight), true);


            dogleft1 = loadBitmap("dogleftone.png", false);
            dogleft1 = Bitmap.createScaledBitmap(dogleft1, 170, 170, true);
            dogleft1 = Bitmap.createScaledBitmap(dogleft1, (int) Math.round(dogleft1.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogleft1.getHeight() * MainActivity.ScaleHeight), true);


            dogleft2 = loadBitmap("doglefttwo.png", false);
            dogleft2 = Bitmap.createScaledBitmap(dogleft2, 170, 170, true);
            dogleft2 = Bitmap.createScaledBitmap(dogleft1, (int) Math.round(dogleft2.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogleft2.getHeight() * MainActivity.ScaleHeight), true);


            dogleft3 = loadBitmap("dogleftthree.png", false);
            dogleft3 = Bitmap.createScaledBitmap(dogleft3, 170, 170, true);
            dogleft3 = Bitmap.createScaledBitmap(dogleft3, (int) Math.round(dogleft3.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogleft3.getHeight() * MainActivity.ScaleHeight), true);


            dogleft4 = loadBitmap("dogleftfour.png", false);
            dogleft4 = Bitmap.createScaledBitmap(dogleft4, 170, 170, true);
            dogleft4 = Bitmap.createScaledBitmap(dogleft4, (int) Math.round(dogleft4.getWidth() * MainActivity.ScaleWidth), (int) Math.round(dogleft4.getHeight() * MainActivity.ScaleHeight), true);


            circlespawn = loadBitmap("circlespawn.png", false);
            circlespawn = Bitmap.createScaledBitmap(circlespawn, 170, 170, true);
            circlespawn = Bitmap.createScaledBitmap(circlespawn, (int) Math.round(circlespawn.getWidth() * MainActivity.ScaleWidth), (int) Math.round(circlespawn.getHeight() * MainActivity.ScaleHeight), true);


            hearthlives = loadBitmap("hearth.png", false);
            //hearthlives=Bitmap.createScaledBitmap(hearthlives, 26, 26, true);
            hearthlives = Bitmap.createScaledBitmap(hearthlives, (int) Math.round(hearthlives.getWidth() * (MainActivity.ScaleWidth)), (int) Math.round(hearthlives.getHeight() * (MainActivity.ScaleHeight)), true);


            livesbar = loadBitmap("livesbar.png", false);
            livesbar = Bitmap.createScaledBitmap(livesbar, (int) Math.round(livesbar.getWidth() * (MainActivity.ScaleWidth)), (int) Math.round(livesbar.getHeight() * (MainActivity.ScaleHeight)), false);

            timeleftbar = loadBitmap("timeleftbar.png", false);
            timeleftbar = Bitmap.createScaledBitmap(timeleftbar, (int) Math.round(timeleftbar.getWidth() * (MainActivity.ScaleWidth)), (int) Math.round(timeleftbar.getHeight() * (MainActivity.ScaleHeight)), true);


            gemright = loadBitmap("gem.png", false);
            gemright = Bitmap.createScaledBitmap(gemright, (int) Math.round(gemright.getWidth() * (MainActivity.ScaleWidth)), (int) Math.round(gemright.getHeight() * (MainActivity.ScaleHeight)), true);


            gemleft = loadBitmap("gemleft.png", false);
            gemleft = Bitmap.createScaledBitmap(gemleft, (int) Math.round(gemleft.getWidth() * (MainActivity.ScaleWidth)), (int) Math.round(gemleft.getHeight() * (MainActivity.ScaleHeight)), true);


            tails1 = loadBitmap("tailtester.png", false);
            tails1 = Bitmap.createScaledBitmap(tails1, (int) Math.round(tails1.getWidth() * MainActivity.ScaleWidth), (int) Math.round(tails1.getHeight() * MainActivity.ScaleHeight), true);

            tails2 = loadBitmap("tailtestertwo.png", false);
            tails2 = Bitmap.createScaledBitmap(tails2, (int) Math.round(tails2.getWidth() * MainActivity.ScaleWidth), (int) Math.round(tails2.getHeight() * MainActivity.ScaleHeight), true);

            tails3 = loadBitmap("tailtesterthree.png", false);
            tails3 = Bitmap.createScaledBitmap(tails3, (int) Math.round(tails3.getWidth() * MainActivity.ScaleWidth), (int) Math.round(tails3.getHeight() * MainActivity.ScaleHeight), true);


            redgem = loadBitmap("redgem.png", false);
            redgem = Bitmap.createScaledBitmap(redgem, (int) Math.round(redgem.getWidth() * MainActivity.ScaleWidth), (int) Math.round(redgem.getHeight() * MainActivity.ScaleHeight), true);

            bluegem = loadBitmap("bluegem.png", false);
            bluegem = Bitmap.createScaledBitmap(bluegem, (int) Math.round(bluegem.getWidth() * MainActivity.ScaleWidth), (int) Math.round(bluegem.getHeight() * MainActivity.ScaleHeight), true);

            greengem = loadBitmap("greengem.png", false);
            greengem = Bitmap.createScaledBitmap(greengem, (int) Math.round(greengem.getWidth() * MainActivity.ScaleWidth), (int) Math.round(greengem.getHeight() * MainActivity.ScaleHeight), true);

            protectgem = loadBitmap("protectgem.png", false);
            protectgem = Bitmap.createScaledBitmap(protectgem, (int) Math.round(protectgem.getWidth() * MainActivity.ScaleWidth), (int) Math.round(protectgem.getHeight() * MainActivity.ScaleHeight), true);


            heartgem = loadBitmap("heartgem.png", false);
            heartgem = Bitmap.createScaledBitmap(heartgem, (int) Math.round(heartgem.getWidth() * MainActivity.ScaleWidth), (int) Math.round(heartgem.getHeight() * MainActivity.ScaleHeight), true);


            spikyHori = loadBitmap("spikeshori.png", false);
            spikyHori = Bitmap.createScaledBitmap(spikyHori, (int) Math.round(spikyHori.getWidth() * MainActivity.ScaleWidth), (int) Math.round(spikyHori.getHeight() * MainActivity.ScaleHeight), true);

            spikyVert = loadBitmap("spikesvert.png", false);
            spikyVert = Bitmap.createScaledBitmap(spikyVert, (int) Math.round(spikyVert.getWidth() * MainActivity.ScaleWidth), (int) Math.round(spikyVert.getHeight() * MainActivity.ScaleHeight), true);


            spikyDouble = loadBitmap("spikesdouble.png", false);
            spikyDouble = Bitmap.createScaledBitmap(spikyDouble, (int) Math.round(spikyDouble.getWidth() * MainActivity.ScaleWidth), (int) Math.round(spikyDouble.getHeight() * MainActivity.ScaleHeight), true);


            spikyDoubleBumpable = loadBitmap("spikesdoublebumper.png", false);
            spikyDoubleBumpable = Bitmap.createScaledBitmap(spikyDoubleBumpable, (int) Math.round(spikyDoubleBumpable.getWidth() * MainActivity.ScaleWidth), (int) Math.round(spikyDoubleBumpable.getHeight() * MainActivity.ScaleHeight), true);


            musicbackgroundfrozen1 = loadBitmap("backgroundfreezeone.jpg", false);
            musicbackgroundfrozen1 = Bitmap.createScaledBitmap(musicbackgroundfrozen1, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);


            musicbackgroundfrozen2 = loadBitmap("backgroundfreezetwo.jpg", false);
            musicbackgroundfrozen2 = Bitmap.createScaledBitmap(musicbackgroundfrozen2, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);


            musicbackgroundfrozen3 = loadBitmap("backgroundfreezethree.jpg", false);
            musicbackgroundfrozen3 = Bitmap.createScaledBitmap(musicbackgroundfrozen3, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);


            musicbackgroundfrozen4 = loadBitmap("backgroundfreezefourr.jpg", false);
            musicbackgroundfrozen4 = Bitmap.createScaledBitmap(musicbackgroundfrozen4, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);

            musicbackgroundfrozen4dark = loadBitmap("backgroundfreezefourdark.jpg", false);
            musicbackgroundfrozen4dark = Bitmap.createScaledBitmap(musicbackgroundfrozen4dark, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);


            frozendog1left = loadBitmap("frozendogoneleft.png", false);
            frozendog1left = Bitmap.createScaledBitmap(frozendog1left, 170, 170, true);
            frozendog1left = Bitmap.createScaledBitmap(frozendog1left, (int) Math.round(frozendog1left.getWidth() * MainActivity.ScaleWidth), (int) Math.round(frozendog1left.getHeight() * MainActivity.ScaleHeight), true);

            frozendog2left = loadBitmap("frozendogtwoleft.png", false);
            frozendog2left = Bitmap.createScaledBitmap(frozendog2left, 170, 170, true);
            frozendog2left = Bitmap.createScaledBitmap(frozendog2left, (int) Math.round(frozendog2left.getWidth() * MainActivity.ScaleWidth), (int) Math.round(frozendog2left.getHeight() * MainActivity.ScaleHeight), true);


            freezeButton = loadBitmap("freezebuttwo.png", false);
            freezeButton = Bitmap.createScaledBitmap(freezeButton, (int) Math.round(freezeButton.getWidth() * MainActivity.ScaleWidth), (int) Math.round(freezeButton.getHeight() * MainActivity.ScaleHeight), true);


            fireball = loadBitmap("fireball.png", false);
            fireball = Bitmap.createScaledBitmap(fireball, (int) Math.round(fireball.getWidth() * MainActivity.ScaleWidth), (int) Math.round(fireball.getHeight() * MainActivity.ScaleHeight), true);

            fireball2 = loadBitmap("fireball2.png", false);
            fireball2 = Bitmap.createScaledBitmap(fireball2, (int) Math.round(fireball2.getWidth() * MainActivity.ScaleWidth), (int) Math.round(fireball2.getHeight() * MainActivity.ScaleHeight), true);

            fireball3 = loadBitmap("fireball3.png", false);
            fireball3 = Bitmap.createScaledBitmap(fireball3, (int) Math.round(fireball3.getWidth() * MainActivity.ScaleWidth), (int) Math.round(fireball3.getHeight() * MainActivity.ScaleHeight), true);


            thunder = loadBitmap("thunderone.png", false);
            thunder = Bitmap.createScaledBitmap(thunder, (int) Math.round(thunder.getWidth() * MainActivity.ScaleWidth), (int) Math.round(thunder.getHeight() * MainActivity.ScaleHeight), true);

            pipeleft = loadBitmap("pipeleft.png", false);
            pipeleft = Bitmap.createScaledBitmap(pipeleft, (int) Math.round(pipeleft.getWidth() * MainActivity.ScaleWidth), (int) Math.round(pipeleft.getHeight() * MainActivity.ScaleHeight), true);

            piperight = loadBitmap("piperight.png", false);
            piperight = Bitmap.createScaledBitmap(piperight, (int) Math.round(piperight.getWidth() * MainActivity.ScaleWidth), (int) Math.round(piperight.getHeight() * MainActivity.ScaleHeight), true);


            pipemusicnote = loadBitmap("pipemusicnote.png", false);
            pipemusicnote = Bitmap.createScaledBitmap(pipemusicnote, (int) Math.round(pipemusicnote.getWidth() * MainActivity.ScaleWidth), (int) Math.round(pipemusicnote.getHeight() * MainActivity.ScaleHeight), true);

            fogsmall = loadBitmap("fogsmall.png", false);
            fogsmall = Bitmap.createScaledBitmap(fogsmall, (int) Math.round(fogsmall.getWidth() * MainActivity.ScaleWidth), (int) Math.round(fogsmall.getHeight() * MainActivity.ScaleHeight), true);



            pipebottom = loadBitmap("pipebottom.png", false);
            pipebottom = Bitmap.createScaledBitmap(pipebottom, (int) Math.round(pipebottom.getWidth() * MainActivity.ScaleWidth), (int) Math.round(pipebottom.getHeight() * MainActivity.ScaleHeight), true);




            pianocirclescript = loadBitmap("pianocirclescript.png", false);
            pianocirclescript = Bitmap.createScaledBitmap(pianocirclescript, (int) Math.round(pianocirclescript.getWidth() * MainActivity.ScaleWidth), (int) Math.round(pianocirclescript.getHeight() * MainActivity.ScaleHeight), true);



            //thundertwo = loadBitmap("thundertwo.png", false);
            //thundertwo = Bitmap.createScaledBitmap(thundertwo, (int) Math.round(thundertwo.getWidth() * MainActivity.ScaleWidth), (int) Math.round(thundertwo.getHeight() * MainActivity.ScaleHeight), true);


            blur = loadBitmap("blur.png", false);
            blur = Bitmap.createScaledBitmap(blur, (int) Math.round(blur.getWidth() * MainActivity.ScaleWidth), (int) Math.round(blur.getHeight() * MainActivity.ScaleHeight), true);


            star = loadBitmap("star.png", false);
            star = Bitmap.createScaledBitmap(star, 2 * (int) Math.round(star.getWidth() * MainActivity.ScaleWidth), 2 * (int) Math.round(star.getHeight() * MainActivity.ScaleHeight), true);



            starspot = loadBitmap("starspot.png", false);
            starspot = Bitmap.createScaledBitmap(starspot, 2 * (int) Math.round(starspot.getWidth() * MainActivity.ScaleWidth), 2 * (int) Math.round(starspot.getHeight() * MainActivity.ScaleHeight), true);

            purplegem = loadBitmap("purplegemmusic.png", false);
            purplegem = Bitmap.createScaledBitmap(purplegem, 2 * (int) Math.round(purplegem.getWidth() * MainActivity.ScaleWidth), 2 * (int) Math.round(purplegem.getHeight() * MainActivity.ScaleHeight), true);

            purplegemleft = loadBitmap("purplegemleft.png", false);
            purplegemleft = Bitmap.createScaledBitmap(purplegemleft, 2 * (int) Math.round(purplegemleft.getWidth() * MainActivity.ScaleWidth), 2 * (int) Math.round(purplegemleft.getHeight() * MainActivity.ScaleHeight), true);

            purplegemright = loadBitmap("purplegemright.png", false);
            purplegemright = Bitmap.createScaledBitmap(purplegemright, 2 * (int) Math.round(purplegemright.getWidth() * MainActivity.ScaleWidth), 2 * (int) Math.round(purplegemright.getHeight() * MainActivity.ScaleHeight), true);


            fingerone = loadBitmap("fingerone.png", false);
            fingerone = Bitmap.createScaledBitmap(fingerone, 2 * (int) Math.round(fingerone.getWidth() * MainActivity.ScaleWidth), 2 * (int) Math.round(fingerone.getHeight() * MainActivity.ScaleHeight), true);


            livestext = loadBitmap("livestext.png", false);
            livestext = Bitmap.createScaledBitmap(livestext, (int) Math.round(livestext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(livestext.getHeight() * MainActivity.ScaleHeight), true);


            inktext = loadBitmap("inktext.png", false);
            inktext = Bitmap.createScaledBitmap(inktext, (int) Math.round(inktext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(inktext.getHeight() * MainActivity.ScaleHeight), true);


            pen = loadBitmap("pen.png", false);
            pen = Bitmap.createScaledBitmap(pen, (int) Math.round(pen.getWidth() * MainActivity.ScaleWidth), (int) Math.round(pen.getHeight() * MainActivity.ScaleHeight), true);

            // pen=Bitmap.createScaledBitmap(pen, pen.getWidth() * (int) (MainActivity.ScaleWidth), pen.getHeight() * (int) (MainActivity.ScaleHeight), true);


/*

                bluemarker = loadBitmap("bluemarkerperfect.png", false);
                yellowmarker = loadBitmap("yellowmarkerperfect.png", false);
                greenmarker = loadBitmap("greenmarkerperfect.png", false);
                redmarker = loadBitmap("redmarkerperfect.png", false);

            */

            bluemarker = loadBitmap("bluemarker.png", false);
            bluemarker = Bitmap.createScaledBitmap(bluemarker, (int) Math.round(bluemarker.getWidth() * MainActivity.ScaleWidth), (int) Math.round(bluemarker.getHeight() * MainActivity.ScaleHeight), true);

            yellowmarker = loadBitmap("yellowmarker.png", false);
            yellowmarker = Bitmap.createScaledBitmap(yellowmarker, (int) Math.round(yellowmarker.getWidth() * MainActivity.ScaleWidth), (int) Math.round(yellowmarker.getHeight() * MainActivity.ScaleHeight), true);

            greenmarker = loadBitmap("greenmarker.png", false);
            greenmarker = Bitmap.createScaledBitmap(greenmarker, (int) Math.round(greenmarker.getWidth() * MainActivity.ScaleWidth), (int) Math.round(greenmarker.getHeight() * MainActivity.ScaleHeight), true);

            redmarker = loadBitmap("redmarker.png", false);
            redmarker = Bitmap.createScaledBitmap(redmarker, (int) Math.round(redmarker.getWidth() * MainActivity.ScaleWidth), (int) Math.round(redmarker.getHeight() * MainActivity.ScaleHeight), true);


            count3 = loadBitmap("count3.png", false);
            count3 = Bitmap.createScaledBitmap(count3, (int) Math.round(count3.getWidth() * MainActivity.ScaleWidth), (int) Math.round(count3.getHeight() * MainActivity.ScaleHeight), true);

            count2 = loadBitmap("count2.png", false);
            count2 = Bitmap.createScaledBitmap(count2, (int) Math.round(count2.getWidth() * MainActivity.ScaleWidth), (int) Math.round(count2.getHeight() * MainActivity.ScaleHeight), true);

            count1 = loadBitmap("count1.png", false);
            count1 = Bitmap.createScaledBitmap(count1, (int) Math.round(count1.getWidth() * MainActivity.ScaleWidth), (int) Math.round(count1.getHeight() * MainActivity.ScaleHeight), true);

            countgo = loadBitmap("countgo.png", false);
            countgo = Bitmap.createScaledBitmap(countgo, (int) Math.round(countgo.getWidth() * MainActivity.ScaleWidth), (int) Math.round(countgo.getHeight() * MainActivity.ScaleHeight), true);

            leveldialog = loadBitmap("leveldialog.png", false);
            leveldialog = Bitmap.createScaledBitmap(leveldialog, (int) Math.round(leveldialog.getWidth() * MainActivity.ScaleWidth), (int) Math.round(leveldialog.getHeight() * MainActivity.ScaleHeight), true);


            if (GameView.currentLevel == 1){

                currentleveltext = loadBitmap("level1text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);

            }else if(GameView.currentLevel==2){

                currentleveltext = loadBitmap("level2text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==3){

                currentleveltext = loadBitmap("level3text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==4){

                currentleveltext = loadBitmap("level4text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==5){

                currentleveltext = loadBitmap("level5text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==6){

                currentleveltext = loadBitmap("level6text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==7){

                currentleveltext = loadBitmap("level7text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==8){

                currentleveltext = loadBitmap("level8text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==9){

                currentleveltext = loadBitmap("level9text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==10){

                currentleveltext = loadBitmap("level10text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==11){

                currentleveltext = loadBitmap("level11text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==12){

                currentleveltext = loadBitmap("level12text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==13){

                currentleveltext = loadBitmap("level13text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==14){

                currentleveltext = loadBitmap("level14text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==15){

                currentleveltext = loadBitmap("level15text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==16){

                currentleveltext = loadBitmap("level16text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==17){

                currentleveltext = loadBitmap("level17text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==18){

                currentleveltext = loadBitmap("level18text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==19){

                currentleveltext = loadBitmap("level19text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==20){

                currentleveltext = loadBitmap("level20text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==21){

                currentleveltext = loadBitmap("level21text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==22){

                currentleveltext = loadBitmap("level22text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==23){

                currentleveltext = loadBitmap("level23text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }else if(GameView.currentLevel==24){

                currentleveltext = loadBitmap("level24text.png", false);
                currentleveltext = Bitmap.createScaledBitmap(currentleveltext, (int) Math.round(currentleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(currentleveltext.getHeight() * MainActivity.ScaleHeight), true);


            }


            /*
            level2text=loadBitmap("level2text.png", false);
            level2text=Bitmap.createScaledBitmap(level2text, (int) Math.round(level2text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level2text.getHeight() * MainActivity.ScaleHeight), true);

            level3text=loadBitmap("level3text.png", false);
            level3text=Bitmap.createScaledBitmap(level3text, (int) Math.round(level3text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level3text.getHeight() * MainActivity.ScaleHeight), true);

            level4text=loadBitmap("level4text.png", false);
            level4text=Bitmap.createScaledBitmap(level4text, (int) Math.round(level4text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level4text.getHeight() * MainActivity.ScaleHeight), true);

            level5text=loadBitmap("level5text.png", false);
            level5text=Bitmap.createScaledBitmap(level5text, (int) Math.round(level5text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level5text.getHeight() * MainActivity.ScaleHeight), true);

            level6text=loadBitmap("level6text.png", false);
            level6text=Bitmap.createScaledBitmap(level6text, (int) Math.round(level6text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level6text.getHeight() * MainActivity.ScaleHeight), true);

            level7text=loadBitmap("level7text.png", false);
            level7text=Bitmap.createScaledBitmap(level7text, (int) Math.round(level7text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level7text.getHeight() * MainActivity.ScaleHeight), true);

            level8text=loadBitmap("level8text.png", false);
            level8text=Bitmap.createScaledBitmap(level8text, (int) Math.round(level8text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level8text.getHeight() * MainActivity.ScaleHeight), true);

            level9text=loadBitmap("level9text.png", false);
            level9text=Bitmap.createScaledBitmap(level9text, (int) Math.round(level9text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level9text.getHeight() * MainActivity.ScaleHeight), true);

            level10text=loadBitmap("level10text.png", false);
            level10text=Bitmap.createScaledBitmap(level10text, (int) Math.round(level10text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level10text.getHeight() * MainActivity.ScaleHeight), true);

            level11text=loadBitmap("level11text.png", false);
            level11text=Bitmap.createScaledBitmap(level11text, (int) Math.round(level11text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level11text.getHeight() * MainActivity.ScaleHeight), true);

            level12text=loadBitmap("level12text.png", false);
            level12text=Bitmap.createScaledBitmap(level12text, (int) Math.round(level12text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level12text.getHeight() * MainActivity.ScaleHeight), true);

            level13text=loadBitmap("level13text.png", false);
            level13text=Bitmap.createScaledBitmap(level13text, (int) Math.round(level13text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level13text.getHeight() * MainActivity.ScaleHeight), true);

            level14text=loadBitmap("level14text.png", false);
            level14text=Bitmap.createScaledBitmap(level14text, (int) Math.round(level14text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level14text.getHeight() * MainActivity.ScaleHeight), true);

            level15text=loadBitmap("level15text.png", false);
            level15text=Bitmap.createScaledBitmap(level15text, (int) Math.round(level15text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level15text.getHeight() * MainActivity.ScaleHeight), true);

            level16text=loadBitmap("level16text.png", false);
            level16text=Bitmap.createScaledBitmap(level16text, (int) Math.round(level16text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level16text.getHeight() * MainActivity.ScaleHeight), true);

            level17text=loadBitmap("level17text.png", false);
            level17text=Bitmap.createScaledBitmap(level17text, (int) Math.round(level17text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level17text.getHeight() * MainActivity.ScaleHeight), true);

            level18text=loadBitmap("level18text.png", false);
            level18text=Bitmap.createScaledBitmap(level18text, (int) Math.round(level18text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level18text.getHeight() * MainActivity.ScaleHeight), true);

            level19text=loadBitmap("level19text.png", false);
            level19text=Bitmap.createScaledBitmap(level19text, (int) Math.round(level19text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level19text.getHeight() * MainActivity.ScaleHeight), true);

            level20text=loadBitmap("level20text.png", false);
            level20text=Bitmap.createScaledBitmap(level20text, (int) Math.round(level20text.getWidth() * MainActivity.ScaleWidth), (int) Math.round(level20text.getHeight() * MainActivity.ScaleHeight), true);
*/
            lockedsmall=loadBitmap("lockersmall.png", false);
            lockedsmall=Bitmap.createScaledBitmap(lockedsmall, (int) Math.round(lockedsmall.getWidth() * MainActivity.ScaleWidth), (int) Math.round(lockedsmall.getHeight() * MainActivity.ScaleHeight), true);


            survivetimetext=loadBitmap("survivetimetext.png", false);
            survivetimetext=Bitmap.createScaledBitmap(survivetimetext, (int) Math.round(survivetimetext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(survivetimetext.getHeight() * MainActivity.ScaleHeight), true);



            collectgemtext=loadBitmap("collectgemstext.png", false);
            collectgemtext=Bitmap.createScaledBitmap(collectgemtext, (int) Math.round(collectgemtext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(collectgemtext.getHeight() * MainActivity.ScaleHeight), true);


            rainbowtailscute=loadBitmap("rainbowtailscute.png", false);
            rainbowtailscute=Bitmap.createScaledBitmap(rainbowtailscute, (int) Math.round(rainbowtailscute.getWidth() * MainActivity.ScaleWidth), (int) Math.round(rainbowtailscute.getHeight() * MainActivity.ScaleHeight), true);

            musiclandtext=loadBitmap("musiclandtext.png", false);
            musiclandtext=Bitmap.createScaledBitmap(musiclandtext, (int) Math.round(musiclandtext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(musiclandtext.getHeight() * MainActivity.ScaleHeight), true);







            smokesmall=loadBitmap("smokeone.png", false);
            smokesmall=Bitmap.createScaledBitmap(smokesmall, (int) Math.round(smokesmall.getWidth() * MainActivity.ScaleWidth), (int) Math.round(smokesmall.getHeight() * MainActivity.ScaleHeight), true);


            smokemed=loadBitmap("smoketwo.png", false);
            smokemed=Bitmap.createScaledBitmap(smokemed, (int) Math.round(smokemed.getWidth() * MainActivity.ScaleWidth), (int) Math.round(smokemed.getHeight() * MainActivity.ScaleHeight), true);

            smokebig=loadBitmap("smokethree.png", false);
            smokebig=Bitmap.createScaledBitmap(smokebig, (int) Math.round(smokebig.getWidth() * MainActivity.ScaleWidth), (int) Math.round(smokebig.getHeight() * MainActivity.ScaleHeight), true);


            dropone=loadBitmap("dropone.png", false);
            //inktext=Bitmap.createScaledBitmap(inktext, (int) Math.round(inktext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(inktext.getHeight() * MainActivity.ScaleHeight), true);

            droptwo=loadBitmap("droptwo.png", false);
            //inktext=Bitmap.createScaledBitmap(inktext, (int) Math.round(inktext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(inktext.getHeight() * MainActivity.ScaleHeight), true);

            dropthree=loadBitmap("dropthree.png", false);
            //inktext=Bitmap.createScaledBitmap(inktext, (int) Math.round(inktext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(inktext.getHeight() * MainActivity.ScaleHeight), true);

            droplong=loadBitmap("rainlong.png", false);
           // inktext=Bitmap.createScaledBitmap(inktext, (int) Math.round(inktext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(inktext.getHeight() * MainActivity.ScaleHeight), true);

            //droplong=Bitmap.createScaledBitmap(star, (int) Math.round(droplong.getWidth() * MainActivity.ScaleWidth), (int) Math.round(droplong.getHeight() * MainActivity.ScaleHeight), true);





        }else if(currentstate.equals("levelselect")){
            levellocked=loadBitmap("levellocked.jpg", false);
            levellocked = Bitmap.createScaledBitmap(levellocked, (int) Math.round(levellocked.getWidth() * MainActivity.ScaleWidth), (int) Math.round(levellocked.getHeight() * MainActivity.ScaleHeight), true);

            l1=loadBitmap("level1.png", false);
            l1 = Bitmap.createScaledBitmap(l1, (int) Math.round(l1.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l1.getHeight() * MainActivity.ScaleHeight), true);

            l2=loadBitmap("level2.png", false);
            l2 = Bitmap.createScaledBitmap(l2, (int) Math.round(l2.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l2.getHeight() * MainActivity.ScaleHeight), true);

            l3=loadBitmap("level3.png", false);
            l3 = Bitmap.createScaledBitmap(l3, (int) Math.round(l3.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l3.getHeight() * MainActivity.ScaleHeight), true);

            l4=loadBitmap("level4.png", false);
            l4 = Bitmap.createScaledBitmap(l4, (int) Math.round(l4.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l4.getHeight() * MainActivity.ScaleHeight), true);

            l5=loadBitmap("level5.png", false);
            l5 = Bitmap.createScaledBitmap(l5, (int) Math.round(l5.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l5.getHeight() * MainActivity.ScaleHeight), true);

            l6=loadBitmap("level6.png", false);
            l6 = Bitmap.createScaledBitmap(l6, (int) Math.round(l6.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l6.getHeight() * MainActivity.ScaleHeight), true);

            l7=loadBitmap("level7.png", false);
            l7 = Bitmap.createScaledBitmap(l7, (int) Math.round(l7.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l7.getHeight() * MainActivity.ScaleHeight), true);

            l8=loadBitmap("level8.png", false);
            l8 = Bitmap.createScaledBitmap(l8, (int) Math.round(l8.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l8.getHeight() * MainActivity.ScaleHeight), true);

            l9=loadBitmap("level9.png", false);
            l9 = Bitmap.createScaledBitmap(l9, (int) Math.round(l9.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l9.getHeight() * MainActivity.ScaleHeight), true);

            l10=loadBitmap("level10.png", false);
            l10 = Bitmap.createScaledBitmap(l10, (int) Math.round(l10.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l10.getHeight() * MainActivity.ScaleHeight), true);

            l11=loadBitmap("level11.png", false);
            l11 = Bitmap.createScaledBitmap(l11, (int) Math.round(l11.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l11.getHeight() * MainActivity.ScaleHeight), true);

            l12=loadBitmap("level12.png", false);
            l12 = Bitmap.createScaledBitmap(l12, (int) Math.round(l12.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l12.getHeight() * MainActivity.ScaleHeight), true);

            l13=loadBitmap("level13.png", false);
            l13 = Bitmap.createScaledBitmap(l13, (int) Math.round(l13.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l13.getHeight() * MainActivity.ScaleHeight), true);

            l14=loadBitmap("level14.png", false);
            l14 = Bitmap.createScaledBitmap(l14, (int) Math.round(l14.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l14.getHeight() * MainActivity.ScaleHeight), true);

            l15=loadBitmap("level15.png", false);
            l15 = Bitmap.createScaledBitmap(l15, (int) Math.round(l15.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l15.getHeight() * MainActivity.ScaleHeight), true);

            l16=loadBitmap("level16.png", false);
            l16 = Bitmap.createScaledBitmap(l16, (int) Math.round(l16.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l16.getHeight() * MainActivity.ScaleHeight), true);

            l17=loadBitmap("level17.png", false);
            l17 = Bitmap.createScaledBitmap(l17, (int) Math.round(l17.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l17.getHeight() * MainActivity.ScaleHeight), true);

            l18=loadBitmap("level18.png", false);
            l18 = Bitmap.createScaledBitmap(l18, (int) Math.round(l18.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l18.getHeight() * MainActivity.ScaleHeight), true);

            l20=loadBitmap("level20.png", false);
            l20 = Bitmap.createScaledBitmap(l20, (int) Math.round(l20.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l20.getHeight() * MainActivity.ScaleHeight), true);

            l19=loadBitmap("level19.png", false);
            l19 = Bitmap.createScaledBitmap(l19, (int) Math.round(l19.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l19.getHeight() * MainActivity.ScaleHeight), true);

            l21=loadBitmap("level21.png", false);
            l21 = Bitmap.createScaledBitmap(l21, (int) Math.round(l21.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l21.getHeight() * MainActivity.ScaleHeight), true);

            l22=loadBitmap("level22.png", false);
            l22 = Bitmap.createScaledBitmap(l22, (int) Math.round(l22.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l22.getHeight() * MainActivity.ScaleHeight), true);

            l23=loadBitmap("level23.png", false);
            l23 = Bitmap.createScaledBitmap(l23, (int) Math.round(l23.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l23.getHeight() * MainActivity.ScaleHeight), true);

            l24=loadBitmap("level24.png", false);
            l24 = Bitmap.createScaledBitmap(l24, (int) Math.round(l24.getWidth() * MainActivity.ScaleWidth), (int) Math.round(l24.getHeight() * MainActivity.ScaleHeight), true);


            levelselectbackground=loadBitmap("worldselectbackground.jpg", false);
            levelselectbackground = Bitmap.createScaledBitmap(levelselectbackground, (int) Math.round(levelselectbackground.getWidth() * MainActivity.ScaleWidth), (int) Math.round(levelselectbackground.getHeight() * MainActivity.ScaleHeight), true);

            selectleveltext=loadBitmap("selectlevel.png", false);
            selectleveltext = Bitmap.createScaledBitmap(selectleveltext, (int) Math.round(selectleveltext.getWidth() * MainActivity.ScaleWidth), (int) Math.round(selectleveltext.getHeight() * MainActivity.ScaleHeight), true);






        }else if(currentstate.equals("youwin")){

            youwinalertdialog=loadBitmap("youwinalertdialog.png",false);
            youwinalertdialog = Bitmap.createScaledBitmap(youwinalertdialog, (int) Math.round(youwinalertdialog.getWidth() * MainActivity.ScaleWidth), (int) Math.round(youwinalertdialog.getHeight() * MainActivity.ScaleHeight), true);



            // musicbackgroundblurry=loadBitmap("musiclandtesttblurry.jpg", false);
           // musicbackgroundblurry = Bitmap.createScaledBitmap(musicbackgroundblurry, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);


        }else if(currentstate.equals("youlose")){


            toobadalertdialog=loadBitmap("toobadalertdialog.png",false);
            toobadalertdialog = Bitmap.createScaledBitmap(toobadalertdialog, (int) Math.round(toobadalertdialog.getWidth() * MainActivity.ScaleWidth), (int) Math.round(toobadalertdialog.getHeight() * MainActivity.ScaleHeight), true);



            //musicbackgroundblurry=loadBitmap("musiclandtesttblurry.jpg", false);
            //musicbackgroundblurry = Bitmap.createScaledBitmap(musicbackgroundblurry, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);

        }else if(currentstate.equals("gamepaused")){

            gamepausedalertdialog=loadBitmap("pausedalertdialog.png",false);
            gamepausedalertdialog = Bitmap.createScaledBitmap(gamepausedalertdialog, (int) Math.round(gamepausedalertdialog.getWidth() * MainActivity.ScaleWidth), (int) Math.round(gamepausedalertdialog.getHeight() * MainActivity.ScaleHeight), true);


        }else if(currentstate.equals("cleardata")) {

            cleardataalertdialog = loadBitmap("cleardataalertdialog.png", false);
            cleardataalertdialog = Bitmap.createScaledBitmap(cleardataalertdialog, (int) Math.round(cleardataalertdialog.getWidth() * MainActivity.ScaleWidth), (int) Math.round(cleardataalertdialog.getHeight() * MainActivity.ScaleHeight), true);


        }else if(currentstate.equals("quitgame")){


          //  quitalertdialog = loadBitmap("cleardataalertdialog.png", false);
            //quitalertdialog = Bitmap.createScaledBitmap(quitalertdialog, (int) Math.round(quitalertdialog.getWidth() * MainActivity.ScaleWidth), (int) Math.round(quitalertdialog.getHeight() * MainActivity.ScaleHeight), true);



        }else if(currentstate.equals("credits")){

            creditsscreen=loadBitmap("creditsscreen.jpg", false);
            creditsscreen=Bitmap.createScaledBitmap(creditsscreen, (int) Math.round(creditsscreen.getWidth() * MainActivity.ScaleWidth), (int) Math.round(creditsscreen.getHeight() * MainActivity.ScaleHeight), true);



        }else if(currentstate.equals("options")){

            worldselectbackground = loadBitmap("worldselectbackground.jpg", false);
            worldselectbackground = Bitmap.createScaledBitmap(worldselectbackground, MainActivity.ScreenWidth, MainActivity.ScreenHeight, true);

            optionsscreen=loadBitmap("optionsscreen.png", false);
            optionsscreen=Bitmap.createScaledBitmap(optionsscreen, (int) Math.round(optionsscreen.getWidth() * MainActivity.ScaleWidth), (int) Math.round(optionsscreen.getHeight() * MainActivity.ScaleHeight), true);


            optionison =loadBitmap("optionison.png", false);
            optionison=Bitmap.createScaledBitmap(optionison, (int) Math.round(optionison.getWidth() * MainActivity.ScaleWidth), (int) Math.round(optionison.getHeight() * MainActivity.ScaleHeight), true);

            optionisoff =loadBitmap("optionisoff.png", false);
            optionisoff=Bitmap.createScaledBitmap(optionisoff, (int) Math.round(optionisoff.getWidth() * MainActivity.ScaleWidth), (int) Math.round(optionisoff.getHeight() * MainActivity.ScaleHeight), true);

            cleargamedatabutton =loadBitmap("cleargamedatabutton.png", false);
            cleargamedatabutton=Bitmap.createScaledBitmap(cleargamedatabutton, (int) Math.round(cleargamedatabutton.getWidth() * MainActivity.ScaleWidth), (int) Math.round(cleargamedatabutton.getHeight() * MainActivity.ScaleHeight), true);





        }
    }





    public static void recycleBitmaps(String currentstate){


        if(currentstate.equals("levelselect")) {

            levellocked.recycle();
            levelselectbackground.recycle();
            selectleveltext.recycle();


        }else if(currentstate.equals("playinggame")){




            musicbackground.recycle();
            musicbackgrounddark .recycle();
            dogright1.recycle();


            dogright2.recycle();


            dogright3.recycle();

            dogright4.recycle();
            dogleft1.recycle();

            dogleft2.recycle();

            dogleft3.recycle();

            dogleft4.recycle();

            circlespawn.recycle();


            hearthlives.recycle();

            gemright.recycle();
            gemleft.recycle();



            tails1.recycle();
            tails2.recycle();
            tails3.recycle();



            redgem.recycle();
            bluegem.recycle();
            heartgem.recycle();

            spikyHori.recycle();
            spikyVert.recycle();
            musicbackgroundfrozen1.recycle();
            musicbackgroundfrozen2.recycle();
            musicbackgroundfrozen3.recycle();
            musicbackgroundfrozen4.recycle();
            musicbackgroundfrozen4dark.recycle();


            frozendog1left.recycle();
            frozendog2left.recycle();

            freezeButton.recycle();

            fireball.recycle();

            star.recycle();

            livestext.recycle();

            inktext.recycle();

            pen.recycle();
            bluemarker.recycle();
            yellowmarker.recycle();
            greenmarker.recycle();
            redmarker.recycle();

            count3.recycle();
            count2.recycle();
            count1.recycle();
            countgo.recycle();
            leveldialog.recycle();
            rainbowtailscute.recycle();
            musiclandtext.recycle();



        }else if(currentstate.equals("youwin")){


            youwinalertdialog.recycle();
          //  musicbackgroundblurry.recycle();


        }else if(currentstate.equals("youlose")){


            toobadalertdialog.recycle();
            //musicbackgroundblurry.recycle();


        }else if(currentstate.equals("worldselect")){


            musicworldbut.recycle();
            musicworldbutpressed.recycle();
            lostwoodsbut.recycle();
            horrornightmarebut.recycle();
            worldselectbackground .recycle();
            selectworldtext .recycle();


        }else if(currentstate.equals("mainscreen")){

            raintailsbig.recycle();
            worldselectbackground.recycle();


        }else if(currentstate.equals("gamepaused")){
            gamepausedalertdialog.recycle();


        }else if(currentstate.equals("credits")){

            creditsscreen.recycle();

        }else if(currentstate.equals("options")){

            worldselectbackground.recycle();
            optionsscreen.recycle();
            optionison.recycle();
            optionisoff.recycle();
            cleargamedatabutton.recycle();

        }
    }







    public static void onResume(String GameMusicIsEnabled, String MainMusicIsEnabled , String currentStateOfGame) {


            boingID = loadSound("boing.mp3");
            //timeTickID=loadSound("timetick.mp3");
            warpID = loadSound("warp.mp3");
            gemPickUpID = loadSound("whitegempickedup.mp3");
            accessDeniedID = loadSound("accessdenied.mp3");
        starUnlockedID=loadSound("starunlocked.mp3");

        /*
        if(currentStateOfGame.equals("playinggame")) {

            if (GameMusicIsEnabled.equals("enabled")) {

                playMusic("happysadpiano.mp3", true);
            }

        }else{

            if (MainMusicIsEnabled.equals("enabled")) {

                playMusic("mainscreenmusic.mp3", true);
            }






        }*/
        // hitID = loadSound("hit.wav");
        //onJumpID = loadSound("onjump.wav");
        //playMusic("bgmusic.mp3", true);
    }


    public static void onResumeMainScreen(String GameMusicIsEnabled) {



        if(GameMusicIsEnabled.equals("enabled")) {

            playMusic("mainscreenmusic.ogg", true);

        }
    }





    public static void onPause() {
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }



    public static void stopMainMusic(){

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }


    public static void stopGameMusic(){

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }



    public static void startGameMusic(String GameMusicIsEnabled){

        boingID = loadSound("boing.mp3");
        //timeTickID=loadSound("timetick.mp3");
        warpID = loadSound("warp.mp3");
        gemPickUpID = loadSound("whitegempickedup.mp3");
        accessDeniedID = loadSound("accessdenied.mp3");
        starUnlockedID=loadSound("starunlocked.mp3");




        if (GameMusicIsEnabled.equals("enabled")) {

            playMusic("happysadpiano.ogg", true);
        }
    }



    public static void startMainMusic(String MainMusicIsEnabled){

        boingID = loadSound("boing.mp3");
        //timeTickID=loadSound("timetick.mp3");
        warpID = loadSound("warp.mp3");
        gemPickUpID = loadSound("whitegempickedup.mp3");
        accessDeniedID = loadSound("accessdenied.mp3");



        if (MainMusicIsEnabled.equals("enabled")) {

            playMusic("mainscreenmusic.ogg" , true);
        }
    }



    //This loads bitmaps from sd card
    private static Bitmap loadBitmap(String filename, boolean transparency) {
        InputStream inputStream = null;
        try {
            inputStream = MainActivity.assets.open(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Options options = new Options();
        options.inScaled = false;
       // options.inPreferredConfig = Config.ARGB_8888;

        if (transparency) {
            options.inPreferredConfig = Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Config.RGB_565;
        }



        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null,
                options);
        return bitmap;
    }



    private static int loadSound(String filename) {
        int soundID = 0;
        if (soundPool == null) {
            soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
        }
        try {
            soundID = soundPool.load(MainActivity.assets.openFd(filename),
                    1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soundID;
    }




    public static void playSound(int soundID) {
        if (soundPool != null) {

            if(GameView.soundEffectsTurnedOn.equals("enabled")) {
                soundPool.play(soundID, 1, 1, 1, 0, 1);
            }else{
                soundPool.play(soundID, 0, 0, 0, 0, 1);
            }
        }
    }









    public static void playMusic(String filename, boolean looping) {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        try {
            AssetFileDescriptor afd = MainActivity.assets.openFd(filename);
            mediaPlayer.setDataSource(afd.getFileDescriptor(),
                    afd.getStartOffset(), afd.getLength());
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();
            mediaPlayer.setLooping(looping);
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Bitmap scaleBitmap(Bitmap bitmap, int newHeight, int newWidth) {
        Bitmap scaledBitmap = Bitmap.createBitmap(newWidth, newHeight, Config.ARGB_8888);

        float scaleX = newWidth / (float) bitmap.getWidth();
        float scaleY = newHeight / (float) bitmap.getHeight();
        float pivotX = 0;
        float pivotY = 0;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(scaleX, scaleY, pivotX, pivotY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bitmap, 0, 0, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;
    }












}