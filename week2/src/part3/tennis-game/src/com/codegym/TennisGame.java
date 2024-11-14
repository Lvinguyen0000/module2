package com.codegym;

public class TennisGame {

    public static final int scoreZero = 0;
    public static final int scoreOne = 1;
    public static final int scoreTwo = 2;
    public static final int scoreThree = 3;

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score = "";
        int tempScore=0;
        if (equalScore(m_score1, m_score2))
        {
            score = playerDraw(m_score1);
        }
        else if (winning(m_score1) || winning(m_score2))
        {
            score = playerWinning(m_score1, m_score2);
        }
        else
        {
            score = playerPlaying(m_score1, m_score2, score);
        }
        return score;
    }

    private static String playerPlaying(int m_score1, int m_score2, String score) {
        int tempScore;
        for (int i = scoreOne; i<scoreThree; i++)
        {
            if (equalScore(i, 1)) tempScore = m_score1;
            else { score +="-"; tempScore = m_score2;}
            switch(tempScore)
            {
                case scoreZero:
                    score +="Love";
                    break;
                case scoreOne:
                    score +="Fifteen";
                    break;
                case scoreTwo:
                    score +="Thirty";
                    break;
                case scoreThree:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private static String playerWinning(int m_score1, int m_score2) {
        String score;
        int minusResult = m_score1 - m_score2;
        if (equalScore(minusResult, 1)) score ="Advantage player1";
        else if (equalScore(minusResult, -1)) score ="Advantage player2";
        else if (isWon(minusResult)) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String playerDraw(int m_score) {
        String score;
        switch (m_score)
        {
            case scoreZero:
                score = "Love-All";
                break;
            case scoreOne:
                score = "Fifteen-All";
                break;
            case scoreTwo:
                score = "Thirty-All";
                break;
            case scoreThree:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static boolean isWon(int minusResult) {
        return minusResult >= 2;
    }

    private static boolean winning(int m_score) {
        return m_score >= 4;
    }
    

    private static boolean equalScore(int m_score1, int m_score2) {
        return m_score1 == m_score2;
    }
}