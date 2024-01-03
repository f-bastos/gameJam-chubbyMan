package ChubbyMan;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

public class Score {

    private int score = 0;
    private String scoreString;
    private int maxScore = 10;
    private Text scoreBoard = new Text(20, 1020, scoreString);
    private boolean isWin = false;
    private CountDownTimer3 countDownTimer3;
    private AudioInputStream audioInputStream1;
    private AudioInputStream audioInputStream3;
    private Clip clip1;
    private Clip clip3;

    Sound eatSound;


    public void actualScore(Food[] food, Picture pacMan, CountDownTimer3 countDownTimer3) {
        //scoreBoard.delete();
        this.countDownTimer3 = countDownTimer3;
        for (int i = 0; i < food.length; i++) {
            if (food[i].getPosX() == pacMan.getX() && food[i].getPosY() == pacMan.getY() && food[i].isEaten == false) {
                score++;
                eatSound = new Sound("/resources/yoshi-tongue.wav");
                eatSound.play();
                food[i].isEaten = true;
                changeFoodPicture(food);
            }
        }
        win();

    }


    public void scorePrint() {
        scoreBoard.delete();
        scoreString = " Score: " + String.valueOf(score);
        scoreBoard.setText(scoreString);
        scoreBoard.setColor(Color.YELLOW);
        scoreBoard.draw();
    }


    public void changeFoodPicture(Food[] food) {
        for (int i = 0; i < food.length; i++) {
            if (food[i].isEaten) {
                Picture plate = new Picture(food[i].getPosX(), food[i].getPosY(), "resources/Goal2.png");
                plate.draw();
            }
        }
    }

    public void win() {
        if (score == maxScore) {
            Picture win = new Picture(0, 0, "resources/WINSCREEN_1280x720.png");
            win.draw();
            isWin = true;
            if (score == 10 && isWin == true) {
                countDownTimer3.stopTimer(); // Call this to stop the timer

            }

        }
    }

    public boolean getIsWin() {

        return isWin;
    }

}
