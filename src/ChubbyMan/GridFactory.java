package ChubbyMan;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridFactory {

        public static final int PADDING = 10;
        private final int cellSize = 50;

        private int cols;
        private int rows;
        private boolean startScreenOn = true;
        Sound startSound;

        Rectangle mainGrid;

        GridFactory(){
            this.startSound = new Sound("/resources/kirby-gourmet-race.wav");
        }

        //PP - I changed this. was too confusing. Now it returns a new rectangle so we can use this method to create
        //other grid and not only our main grid
        public Rectangle createGrid(int x, int y, int width, int height) {
            int startX = x + PADDING;
            int startY = y + PADDING;
            return mainGrid = new Rectangle(startX, startY, width, height);
        }

        // PP - Added this method to draw a rectangle
        public void drawGrid(Rectangle rectangle) {
            rectangle.draw();
            rectangle.fill();

        }

/*        public void drawGrid(Rectangle rectangle, Color color) {
            rectangle.draw();
            rectangle.setColor(color);
            rectangle.fill();
        }*/

        public synchronized void createGridStartScreen(Rectangle rectangle, int numberOfPacMans) {
            drawGrid(rectangle);
            //
            startSound.play();
            //
            while (startScreenOn) {
                try {
                    wait(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                int random = (int) (Math.random() * 8);
                int randomX;
                int randomY;
                do {
                    randomX = (int) (Math.abs(Math.random() * rectangle.getWidth() - GridFactory.PADDING - 20));
                    randomY = (int) (Math.abs(Math.random() * rectangle.getHeight() - GridFactory.PADDING - 20));
                } while ((randomX % 50) != 0 || (randomY % 50) != 0);
                switch (random) {
                    case 1:
                        Picture food1 = new Picture(randomX + 10, randomY + 10, "resources/Food1.png");
                        food1.draw();
                        food1.grow(20, 20);
                        break;
                    case 2:
                        Picture food2 = new Picture(randomX + 10, randomY + 10, "resources/Food2.png");
                        food2.draw();
                        food2.grow(20, 20);
                        break;
                    case 3:
                        Picture food3 = new Picture(randomX + 10, randomY + 10, "resources/Food3.png");
                        food3.draw();
                        food3.grow(20, 20);
                        break;
                    case 4:
                        Picture food4 = new Picture(randomX + 10, randomY + 10, "resources/Food4.png");
                        food4.draw();
                        food4.grow(20, 20);
                        break;
                    case 5:
                        Picture food5 = new Picture(randomX + 10, randomY + 10, "resources/Food5.png");
                        food5.draw();
                        food5.grow(20, 20);
                        break;
                    case 6:
                        Picture food6 = new Picture(randomX + 10, randomY + 10, "resources/Food6.png");
                        food6.draw();
                        food6.grow(20, 20);
                        break;
                    case 7:
                        Picture food7 = new Picture(randomX + 10, randomY + 10, "resources/Food7.png");
                        food7.draw();
                        food7.grow(20, 20);
                        break;
                    default:
                        Picture food8 = new Picture(randomX + 10, randomY + 10, "resources/Food8.png");
                        food8.draw();
                        food8.grow(20, 20);
                        break;

                }
                numberOfPacMans--;
                createStartMenu();

            }
            return;

        }

        public synchronized void doNotify() {
            notify();
        }


        public void createStartMenu() {
            int random = (int) (Math.random() * 5);
            Picture titlePic;
            Picture pressPic;
            switch (random) {
                case 1:
                    titlePic = new Picture(0, 0, "resources/PRESS1_1280x720.png");
                    titlePic.draw();
                    pressPic = new Picture(0, 0, "resources/PRESS1_1280x720.png");
                    pressPic.draw();
                    break;
                case 2:
                    titlePic = new Picture(0, 0, "resources/TITLE2_1280x720.png");
                    titlePic.draw();
                    pressPic = new Picture(0, 0, "resources/PRESS2_1280x720.png");
                    pressPic.draw();
                    break;
                case 3:
                    titlePic = new Picture(0, 0, "resources/TITLE3_1280x720.png");
                    titlePic.draw();
                    pressPic = new Picture(0, 0, "resources/PRESS3_1280x720.png");
                    pressPic.draw();
                    break;
                case 4:
                    titlePic = new Picture(0, 0, "resources/TITLE4_1280x720.png");
                    titlePic.draw();
                    pressPic = new Picture(0, 0, "resources/PRESS4_1280x720.png");
                    pressPic.draw();
                    break;
                default:
                    titlePic = new Picture(0, 0, "resources/TITLE5_1280x720.png");
                    titlePic.draw();
                    pressPic = new Picture(0, 0, "resources/PRESS5_1280x720.png");
                    pressPic.draw();
                    break;


            }
        }


        public int getPADDING() {
            return PADDING;
        }

        public int scaleX(int col) {
            return cols = col * cellSize + getPADDING();
        }

        public int scaleY(int row) {
            return rows = row * cellSize + getPADDING();
        }

        public boolean setStartScreenOff() {
            return startScreenOn = false;
        }


        public boolean getStartScreenOn() {
            return this.startScreenOn;
        }
}
