package com.jmiller.spellingtest;

public class SpellingWord {

    int index;
    int wordAudio;
    String wordString;

    public SpellingWord(int index, int id, String word) {
        this.index = index;
        wordAudio = id;
        wordString = word;
    }

//    public SpellingWord(int babies, String babies1) {
//        wordAudio = babies;
//        wordString = babies1;
//    }

//    public void SpellingWord(int wordAudioId, String wordStringId) {
//        wordAudio = wordAudioId;
//        wordString = wordStringId;
//    }
}