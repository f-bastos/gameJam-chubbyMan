package ChubbyMan;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

import static ChubbyMan.Food.createRandomFoods;

public class EventHandler implements KeyboardHandler {


    public Rectangle grid1;
    GridFactory gridFactory;
    public Picture chubbyRight1;
    public Picture chubbyRight2;

    public Picture chubbyLeft1;
    public Picture chubbyLeft2;
    public Picture chubbyDown1;
    public Picture chubbyDown2;

    Sound movesSound;
    Score score = new Score();
    Food[] foodArray;
    CountDownTimer3 countDownTimer3;
    Sound winSound;

    int i = 0;


    //PAcMAn Picture that we be given as parameter when we create the EventHandler
    public Picture chubbyManMain;


    //Constructor of the eventHandler
    public EventHandler(Rectangle rectangle, Picture picture, GridFactory gridFactory, CountDownTimer3 countDownTimer3) {
        this.countDownTimer3 = countDownTimer3;
        this.chubbyManMain = picture;
        this.grid1 = rectangle;
        this.gridFactory = gridFactory;
        foodArray = createRandomFoods(10, rectangle);
        this.winSound = new Sound("/resources/kirbys-victory-dance.wav");
    }

    public void initStart() {
        Keyboard kb1 = new Keyboard(this);
        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        kb1.addEventListener(space);
    }

    //Initiate the keys we want to use.
    public void init() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(down);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (chubbyManMain.getX() + chubbyManMain.getWidth() >= grid1.getWidth() - 50) {
                    chubbyManMain.translate(0, 0);
                    break;
                }
                score.actualScore(foodArray, chubbyManMain, countDownTimer3);
                moveRight();
                movesSound = new Sound("/resources/kirby-walking-sound-made-with-Voicemod-technology.wav");
                movesSound.play();
                break;

            case KeyboardEvent.KEY_LEFT:

                if (chubbyManMain.getX() <= grid1.getX() + 50) {
                    chubbyManMain.translate(0, 0);
                    break;
                }
                score.actualScore(foodArray, chubbyManMain, countDownTimer3);
                moveLeft();
                movesSound = new Sound("/resources/kirby-walking-sound-made-with-Voicemod-technology.wav");
                movesSound.play();
                break;
            case KeyboardEvent.KEY_UP:

                if (chubbyManMain.getY() <= grid1.getY() + 100) {
                    chubbyManMain.translate(0, 0);
                    break;
                }
                score.actualScore(foodArray, chubbyManMain, countDownTimer3);
                moveUp();
                movesSound = new Sound("/resources/kirby-walking-sound-made-with-Voicemod-technology.wav");
                movesSound.play();
                break;
            case KeyboardEvent.KEY_DOWN:
                if (chubbyManMain.getY() + chubbyManMain.getHeight() >= grid1.getHeight() - 50) {
                    chubbyManMain.translate(0, 0);
                    break;
                }
                score.actualScore(foodArray, chubbyManMain, countDownTimer3);
                moveDown();
                movesSound = new Sound("/resources/kirby-walking-sound-made-with-Voicemod-technology.wav");
                movesSound.play();
                break;
            case KeyboardEvent.KEY_SPACE:
                gridFactory.setStartScreenOff();
                gridFactory.startSound.stop();

                break;
        }
        if (score.getIsWin()) {
            chubbyManMain = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/50x50_Transparent.png");
            winSound.play();
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void moveRight() {
        if (score.getIsWin() || countDownTimer3.isFinished()) {
            return;
        }
        if (chubbyManMain == chubbyRight1) {
            chubbyRight2 = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/Walk3Right.png");
            chubbyRight2.draw();
            chubbyManMain.delete();
            chubbyManMain = chubbyRight2;
            chubbyManMain.translate(50, 0);
            return;

        }
        chubbyRight1 = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/Walk1Right.png");
        chubbyRight1.draw();
        chubbyManMain.delete();
        chubbyManMain = chubbyRight1;
        chubbyManMain.translate(50, 0);
    }

    public void moveLeft() {
        if (score.getIsWin() || countDownTimer3.isFinished()) {
            return;
        }
        if (chubbyManMain == chubbyLeft1) {
            chubbyLeft2 = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/Walk3Left.png");
            chubbyLeft2.draw();
            chubbyManMain.delete();
            chubbyManMain = chubbyLeft2;
            chubbyManMain.translate(-50, 0);
            return;

        }
        chubbyLeft1 = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/Walk1Left.png");
        chubbyLeft1.draw();
        chubbyManMain.delete();
        chubbyManMain = chubbyLeft1;
        chubbyManMain.translate(-50, 0);
    }

    public void moveDown() {
        if (score.getIsWin() || countDownTimer3.isFinished()) {
            return;
        }
        if (chubbyManMain == chubbyDown1) {
            chubbyDown2 = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/Walk3Left.png");
            chubbyDown2.draw();
            chubbyManMain.delete();
            chubbyManMain = chubbyDown2;
            chubbyManMain.translate(0, 50);
            return;

        }
        chubbyDown1 = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/Walk1Right.png");
        chubbyDown1.draw();
        chubbyManMain.delete();
        chubbyManMain = chubbyDown1;
        chubbyManMain.translate(0, 50);
    }

    public void moveUp() {
        if (score.getIsWin() || countDownTimer3.isFinished()) {
            return;
        }
        if (chubbyManMain == chubbyDown1) {
            chubbyDown2 = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/Walk3Left.png");
            chubbyDown2.draw();
            chubbyManMain.delete();
            chubbyManMain = chubbyDown2;
            chubbyManMain.translate(0, -50);
            return;

        }
        chubbyDown1 = new Picture(chubbyManMain.getX(), chubbyManMain.getY(), "resources/Walk1Right.png");
        chubbyDown1.draw();
        chubbyManMain.delete();
        chubbyManMain = chubbyDown1;
        chubbyManMain.translate(0, -50);
    }


}
