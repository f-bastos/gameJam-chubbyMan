package ChubbyMan;

public class EndGame {


    private Score score;

    private CountDownTimer3 countDownTimer3;




    public EndGame(Score score, CountDownTimer3 countDownTimer3){
        this.score = score;
        this.countDownTimer3 = countDownTimer3;
    }



    public void endOfGame() {
        if (score.getIsWin() == false) {
            countDownTimer3.endOfTime();
        }


    }


}
