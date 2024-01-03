package ChubbyMan;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

public class CountDownTimer3 {

    private long startTime = System.currentTimeMillis();
    private long duration;
    private long timeRemaining;
    private long secondsRemaining;
    private long millisecondsRemaining;
    private AudioInputStream audioInputStream2;
    private Clip clip2;
    private boolean stopTimer = false;
    Score score;
    Sound gameOverSound;

    public CountDownTimer3(long durationInMilliseconds, Score score) {
        this.duration = durationInMilliseconds;
        this.startTime = System.currentTimeMillis();
        this.score = score;
        this.gameOverSound = new Sound("/resources/retro-arcade-game-over.wav");
    }

    public long getTimeRemaining() {
        long elapsedTime = System.currentTimeMillis() - this.startTime;
        this.timeRemaining = this.duration - elapsedTime;
        return Math.max(this.timeRemaining, 0L);
    }
    public void setTimeDuration(long time){
        timeRemaining = time;
    }

    public boolean isFinished() {
        return this.getTimeRemaining() <= 0L;
    }

    public void stopTimer() {
        stopTimer = true;
    }

    public void initTimer() {
        Text text;
        stopTimer = false;
        while (!this.isFinished() && !stopTimer) {
            this.timeRemaining = this.getTimeRemaining();
            this.secondsRemaining = this.timeRemaining / 1000L;
            this.millisecondsRemaining = this.timeRemaining % 1000L;
            Object[] var10005 = new Object[]{this.secondsRemaining, this.millisecondsRemaining};
            Picture clock = new Picture(520,20,"/resources/CLOCK.png");
            clock.grow(20,20);
            clock.draw();
            text = new Text(660.0, 25.0, String.format("%02d:%03d", var10005));
            text.setColor(Color.WHITE);
            text.delete();
            text.draw();

            text.grow(100.0, 20.0);

            if (this.secondsRemaining <= 10) {
                text.setColor(Color.YELLOW);


                if (this.secondsRemaining <= 5) {
                    text.setColor(Color.RED);
                    if (this.secondsRemaining <= 3) {
                        Text hurryUp = new Text(660, 60, "Hurry Up!");
                        hurryUp.draw();
                        hurryUp.grow(50, 15);
                        int random = (int) (Math.random() * 4);
                        switch (random) {
                            case 1:
                                text.setColor(Color.BLUE);
                                hurryUp.setColor(Color.BLUE);
                                break;
                            case 2:
                                text.setColor(Color.GREEN);
                                hurryUp.setColor(Color.GREEN);
                                break;
                            case 3:
                                text.setColor(Color.ORANGE);
                                hurryUp.setColor(Color.ORANGE);
                                break;
                            case 4:
                                text.setColor(Color.CYAN);
                                hurryUp.setColor(Color.CYAN);
                                break;
                            case 5:
                                text.setColor(Color.PINK);
                                hurryUp.setColor(Color.PINK);
                                break;
                            case 6:
                                text.setColor(Color.MAGENTA);
                                hurryUp.setColor(Color.MAGENTA);
                                break;
                            default:
                                text.setColor(Color.RED);
                                hurryUp.setColor(Color.RED);
                                break;
                        }


                    }

                }
            }

            try {
                Thread.sleep(50L);
                text.delete();

            } catch (InterruptedException var3) {
                var3.printStackTrace();
            }


        }
    }



            /*text = new Text(500.0, 25.0, "Time up!");
            text.draw();
            text.setColor(Color.GRAY);
            text.grow(50.0, 15.0);*/



    public void endOfTime() {
        if (isFinished()) {
            Picture gameOver = new Picture(0, 0, "resources/GAMEOVER_1280x720.png");
            gameOver.draw();
            gameOverSound.play();

        }

    }



}
