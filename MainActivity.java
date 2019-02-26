package com.jmiller.spellingtest;

import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    EditText spellingWord;
    public String wordEntered;
    public TextView splashScreen;
    public TextView scoreBoard;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    String selectedWord;
    int scoreTotal, scoreCorrect;

    int[] wordsAudio = new int[12];
    String[] wordsString = new String[12];
    int index;
    String currentWord;
    int id;


    //I'm leaving this here for now because LinkedHashSet might be useful in the future.
    //LinkedHashSets seem to be only useful for storing data in order, but not referencing the data.
    //The intention was to be able to use this as a dictionary like in Python.
    //LinkedHashSet<SpellingWord> words = new LinkedHashSet<>();
    //Iterator<SpellingWord> nextWord;
    //Iterator<SpellingWord> nextWordA;

    Hashtable<SpellingWord> words;



    public Random random = new Random();
    //private Iterator<SpellingWord> nextWord;
    //Set<Integer> orderOfWords = new LinkedHashSet<>();


    //when submit button is clicked
    public void readText (View view){
        //mediaPlayer.release();
        wordEntered =  spellingWord.getText().toString();
        //selectedWord = "";
        splashScreen.setText("");
        //splashScreen.setText(selectedWord);



        if (index==0){
            //splashScreen.setText("Click OK to begin");
//            if ( mediaPlayer.isPlaying() ){
//                //mediaPlayer.pause();
//                //mediaPlayer.release();
//            }
            splashScreen.setText("");
            spellingWord.getText().clear();
            scoreTotal = 0;
            scoreCorrect = 0;
        }
        if(wordEntered.equalsIgnoreCase(selectedWord)){
            splashScreen.setText("Good Job!");
            scoreCorrect ++;
        }
        if(!wordEntered.equalsIgnoreCase(selectedWord) && !wordEntered.isEmpty()){
            splashScreen.setText(selectedWord);
        }


        //There is a better way to do this. I had an error that turned out not to be this.
        switch (index){
            case 0:
                //
                selectedWord = "babies";
                mediaPlayer = MediaPlayer.create(this, R.raw.babies);
                break;
            case 1:
                //
                selectedWord = "baby";
                mediaPlayer = MediaPlayer.create(this, R.raw.baby);
                break;
            case 2:
                //
                selectedWord = "lunch";
                mediaPlayer = MediaPlayer.create(this, R.raw.lunch);
                break;
            case 3:
                //
                selectedWord = "lunches";
                mediaPlayer = MediaPlayer.create(this, R.raw.lunches);
                break;
            case 4:
                //
                selectedWord = "note";
                mediaPlayer = MediaPlayer.create(this, R.raw.note);
                break;
            case 5:
                //
                selectedWord = "notes";
                mediaPlayer = MediaPlayer.create(this, R.raw.notes);
                break;
            case 6:
                //
                selectedWord = "stories";
                mediaPlayer = MediaPlayer.create(this, R.raw.stories);
                break;
            case 7:
                //
                selectedWord = "story";
                mediaPlayer = MediaPlayer.create(this, R.raw.story);
                break;
            case 8:
                //
                selectedWord = "switch";
                mediaPlayer = MediaPlayer.create(this, R.raw.switch_);
                break;
            case 9:
                //
                selectedWord = "switches";
                mediaPlayer = MediaPlayer.create(this, R.raw.switches);
                break;
            case 10:
                //
                selectedWord = "tune";
                mediaPlayer = MediaPlayer.create(this, R.raw.tune);
                break;
            case 11:
                //
                selectedWord = "tunes";
                mediaPlayer = MediaPlayer.create(this, R.raw.tunes);
                break;

        }

        mediaPlayer.start();
        spellingWord.getText().clear();
        index ++;
        scoreTotal ++;
        scoreBoard.setText(scoreCorrect + "/" + scoreTotal);

        if (index >12){
            splashScreen.setText("Good Job Ella!\nYou got " + scoreCorrect + " out of " + scoreTotal);
            index = 0;
        }


//        while (nextWord.hasNext() && nextWordA.hasNext()) {
//            currentWord = nextWord.next().wordString;//wordsString[0];
//            id = nextWordA.next().wordAudio; //wordsAudio[0];
//
//            if (wordEntered.equalsIgnoreCase(currentWord)) {
//                scoreCorrect++;
//
//                //splashScreen.setText("");
//                splashScreen.setText("Correct!");
//
//            } else {
//                splashScreen.setText("Incorrect\n" + currentWord);
//            }
//            scoreBoard.setText(scoreCorrect + "/" + scoreTotal);
//
//            spellingWord.setText("");
//
//            //mediaPlayer = MediaPlayer.create(this, R.raw.babies);
//            mediaPlayer = MediaPlayer.create(this, id);
//            mediaPlayer.start();
//            //mediaPlayer.release();
//
//            index++;
//        }

    }



    /*
        This creates the options menu. It calls on main_menu.xml
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.reset:
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Reset")
                        .setMessage("Reset?")
                        .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //RESET


                            }
                        })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //null
                    }
                })
                .show();
                return true;
            default:
                return false;
        }// end switch
    }

    /*

     */

    public void clickRandom (View view){
        //int randomNum = ThreadLocalRandom.current().nextInt(0, 12);
//        while (orderOfWords.size() < 12){
//            Integer next = random.nextInt(11)+1;
//            orderOfWords.add(next);
//        }
//        Iterator<Integer> itr = orderOfWords.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        words = new Hashtable<>();

        index = 0;
//        wordsString[0] = "babies";
//        wordsString[1] = "baby";
//        wordsString[2] = "lunch";
//        wordsString[3] = "lunches";
//        wordsString[4] = "note";
//        wordsString[5] = "notes";
//        wordsString[6] = "stories";
//        wordsString[7] = "story";
//        wordsString[8] = "switch_";
//        wordsString[9] = "switches";
//        wordsString[10] = "tune";
//        wordsString[11] = "tunes";
//
//        wordsAudio[0] = R.raw.babies;
//        wordsAudio[1] = R.raw.baby;
//        wordsAudio[2] = R.raw.lunch;
//        wordsAudio[3] = R.raw.lunches;
//        wordsAudio[4] = R.raw.note;
//        wordsAudio[5] = R.raw.notes;
//        wordsAudio[6] = R.raw.stories;
//        wordsAudio[7] = R.raw.story;
//        wordsAudio[8] = R.raw.switch_;
//        wordsAudio[9] = R.raw.switches;
//        wordsAudio[10] = R.raw.tune;
//        wordsAudio[11] = R.raw.tunes;




        //This is the textView that displays the grade and any messages
        splashScreen = findViewById(R.id.gradeTextView);
        scoreBoard = findViewById(R.id.scoreTextView);
        spellingWord = findViewById(R.id.spellingWordEditText);

        splashScreen.setText("Click OK to begin");

        //Setup the textEdit Field called spellingWord
        //it is initialized with a message


        //spellingWord objects
//        SpellingWord w1 = new SpellingWord(0, R.raw.babies,"babies");
//        SpellingWord w2 = new SpellingWord(1, R.raw.baby,"baby");
//        SpellingWord w3 = new SpellingWord(2, R.raw.lunch,"lunch");
//        SpellingWord w4 = new SpellingWord(3, R.raw.lunches,"lunches");
//        SpellingWord w5 = new SpellingWord(4, R.raw.note,"note");
//        SpellingWord w6 = new SpellingWord(5, R.raw.notes,"notes");
//        SpellingWord w7 = new SpellingWord(6, R.raw.stories,"stories");
//        SpellingWord w8 = new SpellingWord(7, R.raw.story,"story");
//        SpellingWord w9 = new SpellingWord(8, R.raw.switch_,"switch_");
//        SpellingWord w10 = new SpellingWord(9, R.raw.switches,"switches");
//        SpellingWord w11 = new SpellingWord(10,R.raw.tune,"tune");
//        SpellingWord w12 = new SpellingWord(11, R.raw.tunes,"tunes");
//
//        words.add(w1);
//        words.add(w2);
//        words.add(w3);
//        words.add(w4);
//        words.add(w5);
//        words.add(w6);
//        words.add(w7);
//        words.add(w8);
//        words.add(w9);
//        words.add(w10);
//        words.add(w11);
//        words.add(w12);
//
//        nextWord = words.iterator();
//        nextWordA = words.iterator();





        //setup audioManager for volume control


//        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//
//        SeekBar volumeControl = findViewById(R.id.seekBar);
//        volumeControl.setMax(maxVolume);
//        volumeControl.setProgress(currentVolume);
//
//        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });





    }// end onCreate




}// end class
