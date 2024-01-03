package ChubbyMan;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sandbox {


    public static void main(String[] args) {




        Picture pacMan = new Picture(60, 110, "resources/Stand1Right.png");

        GridFactory start = new GridFactory();


        Rectangle startGrid = start.createGrid(0, 0, 1280, 720);
        Score score = new Score();
        CountDownTimer3 countdownTimer3 = new CountDownTimer3(20000,score);
        EventHandler startScreen = new EventHandler(startGrid, pacMan, start,countdownTimer3);
        startScreen.initStart();
        start.createGridStartScreen(startGrid, 50);

        GridFactory grid = new GridFactory();
        Rectangle mainGrid = grid.createGrid(0, 0, 1280, 720);
        grid.drawGrid(mainGrid);

        EventHandler movePacMAn = new EventHandler(mainGrid, pacMan, grid,countdownTimer3);

        pacMan.draw();
        movePacMAn.init();


        countdownTimer3.initTimer();



        EndGame endGame = new EndGame(score, countdownTimer3);
        endGame.endOfGame();



    }
}
