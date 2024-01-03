package ChubbyMan;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Food {

    private int posX;
    private int posY;
    Picture coin;
    public boolean isEaten;

    // Coin Constructor
    public Food(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        coin = new Picture(posX, posY, "resources/Goal1.png" ); // picture of a coin(this one is just for experience)
        coin.draw();
        this.isEaten = false;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    //Create 1 Random coin. We need to pass a parameter the rectangle of the grid we want to draw the coins so the positions are not above the grid size
    //this will be changed after for columns and rows!!!
    static Food createRandomFood(Rectangle rectangle){
        int x;
        int y;
        do{
            x = (int)( Math.abs(Math.random()*rectangle.getWidth()-GridFactory.PADDING-160));
            y = (int)( Math.abs(Math.random()*rectangle.getHeight()-GridFactory.PADDING-200 ));
        }while ((x % 50) != 0 ||  (y % 50) != 0);

        return new Food(x+60,y+110);
    }

    //creates as many coins as we want to at random positions.
    static  Food[] createRandomFoods(int numbOfCoins, Rectangle rectangle){
        Food[] foods = new Food[numbOfCoins];
        for(int i = 0; i < foods.length; i++){
            foods[i] = createRandomFood(rectangle);
        }

        return foods;
    }


}
