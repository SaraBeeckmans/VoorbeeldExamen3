package com.example.sara.voorbeeldexamen3;

public class UserHighscore<S, S1> {
    private String mUsername;
    private long mScore;
    public UserHighscore(String username, long score) {
        mUsername = username;
        mScore = score;
    }
    public String getUsername() {
        return mUsername;
    }
    public long getScore() {
        return mScore;
    }
    public String getRanking() {
        if (mScore <= 10) {
            return "GOLD";
        } else if (mScore <= 100) {
            return "SILVER";
        } else {
            return "BRONZE";
        }
    }

    public String getFullLine(){
        String temp = getRanking()+ " " + getUsername()+ " "+ getScore();
        return temp;
    }
}