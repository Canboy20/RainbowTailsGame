package com.rainbowtails.canatay.rainbowtails;

/**
 * Created by Can Atay on 6/10/2015.
 */
public class MarkerInks {

    int bluepreviousstate;
    int greenpreviousstate;
    int redpreviousstate;
    int yellowprevioustate;
    char blueavailable;
    char redavailable;
    char yellowavailable;
    char greenavailable;
    String currentmarker;



    public MarkerInks(int currentlevel){

        bluepreviousstate=MainActivity.ScreenWidth-18;
        greenpreviousstate=MainActivity.ScreenWidth-18;
        redpreviousstate=MainActivity.ScreenWidth-18;
        yellowprevioustate=MainActivity.ScreenWidth-18;
        blueavailable='y';
        redavailable='y';
        yellowavailable='y';
        greenavailable='y';
        currentmarker="blue";

        updateavailableMarkers(currentlevel);

    }


    public void updateInkLevel(int amount,String color){

        if(color.equals("blue")){

            bluepreviousstate=amount;

        }else if(color.equals("red")){


            redpreviousstate=amount;

        }else if(color.equals("green")){

            greenpreviousstate=amount;

        }else if(color.equals("yellow")){

            yellowprevioustate=amount;

        }
    }







    public int getInkLevel(String color){

        if(color.equals("blue")){

            return bluepreviousstate;

        }else if(color.equals("red")){


            return redpreviousstate;

        }else if(color.equals("green")){

            return greenpreviousstate;

        }else if(color.equals("yellow")){

            return yellowprevioustate;

        }
        return 0;
    }



    public char isMarkerAvailable(int currentlevel,char markerSelected){


        if(markerSelected=='b'){

            return blueavailable;

        }else if(markerSelected=='r'){

            return redavailable;

        }else if(markerSelected=='g'){

            return  greenavailable;

        }else{

            return yellowavailable;


        }

    }




    public String getCurrentMarker(){


        return currentmarker;
    }


    public void updateCurrentMarker(String newSelectedMarker){

        currentmarker=newSelectedMarker;

    }



    public void updateavailableMarkers(int currentlevel) {


        if (currentlevel == 1 || currentlevel == 2 ||  currentlevel == 4) {


            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'n';
            yellowavailable = 'y';
            greenavailable = 'n';

        }else if(currentlevel==3){


            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'n';
            yellowavailable = 'y';
            greenavailable = 'y';

        } else if (currentlevel == 5) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'n';
            yellowavailable = 'n';
            greenavailable = 'n';


        } else if (currentlevel == 6 || currentlevel == 7 || currentlevel == 8) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'n';
            yellowavailable = 'y';
            greenavailable = 'n';


        } else if (currentlevel == 9) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'y';
            yellowavailable = 'y';
            greenavailable = 'y';

        } else if (currentlevel == 10) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'n';
            yellowavailable = 'n';
            greenavailable = 'n';

        } else if (currentlevel == 11) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'n';
            yellowavailable = 'y';
            greenavailable = 'y';


        } else if (currentlevel == 12) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'y';
            yellowavailable = 'y';
            greenavailable = 'y';

        } else if (currentlevel == 13) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'y';
            yellowavailable = 'y';
            greenavailable = 'y';


        } else if (currentlevel == 14 || currentlevel == 15) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'y';
            yellowavailable = 'n';
            greenavailable = 'y';


        } else if (currentlevel == 16) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'y';
            yellowavailable = 'y';
            greenavailable = 'y';

        } else if (currentlevel == 17 || currentlevel == 18) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'y';
            yellowavailable = 'y';
            greenavailable = 'y';


        } else if (currentlevel == 19) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'y';
            yellowavailable = 'n';
            greenavailable = 'y';


        } else if (currentlevel == 20 || currentlevel == 21 || currentlevel == 22 || currentlevel==23) {

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'y';
            yellowavailable = 'y';
            greenavailable = 'y';


        }else if(currentlevel==24){

            currentmarker = "blue";
            blueavailable = 'y';
            redavailable = 'n';
            yellowavailable = 'n';
            greenavailable = 'n';


        }
    }
}
