package com.groupOne.taskFour;

import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Question question = new QuestionImpl();
        startGame(question);
    }

    public static void startGame(Question question) {
        JOptionPane pane = new JOptionPane();
        int questionNo = 1;
        int userInput;
        while (questionNo <= question.getLevelLimit()) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (question.getUserAnswer() == null) {
//                        System.out.println("Test");
                        pane.getRootFrame().dispose();
                    }
                }
            };
            new Timer().schedule(task, 0, 10000);
            String answer = pane.showInputDialog(null, question.generateQuestion(), "Level " + question.getLevelNumber(), 1);
            if (answer != null && answer != "") {
                userInput = Integer.parseInt(answer);
                question.setUserAnswer(userInput);
                question.updateScore();
            }
            questionNo++;
        }
        pane.showMessageDialog(null, "Your score is " + question.getScore() + "/" + question.getLevelLimit());
        if (question.getScore() > (question.getLevelLimit() / 2)) {
            int currentLevel = question.getLevelNumber();
            currentLevel++;
            switch (currentLevel) {
                case 2 -> {
                    levelTwoStart(question);
                }
                case 3 -> {
                    levelThreeStart(question);
                }
                case 4 -> {
                    levelFourStart(question);
                }
                default -> {
                    finishedGame();
                }
            }
        } else {
            gameOver();
        }
    }

    public static void levelTwoStart(Question question) {
        Question levelTwoQuestion = new LevelTwoQuestionDecorator(question);
        startGame(levelTwoQuestion);
    }

    public static void levelThreeStart(Question question) {
        Question levelThreeQuestion = new LevelThreeQuestionDecorator(question);
        startGame(levelThreeQuestion);
    }

    public static void levelFourStart(Question question) {
        Question levelFourQuestion = new LevelFourQuestionDecorator(question);
        startGame(levelFourQuestion);
    }

    public static void finishedGame() {
        JOptionPane.showMessageDialog(null, "Oppppooooorrrrr" +
                "\nYou finished the game");
    }

    public static void gameOver() {
        JOptionPane.showMessageDialog(null, "Sorry, You did not score high enough to advance to the" +
                "next level");
        System.exit(0);
    }

}
