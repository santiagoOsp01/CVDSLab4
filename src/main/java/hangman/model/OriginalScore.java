package hangman.model;

public class OriginalScore implements GameScore{

    private int score;

    public OriginalScore(){
        score = 100;
    }

    /**
     * @pre gameScore > 0, correctCount > 0, incorrectCount > 0
     * @pos 0 < gameScore < 100
     * @param correctCount number of times when the word guesses were correct
     * @param incorrectCount number of times when the word guesses were incorrect
     * @return score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel) {
        if (incorrectCount > gameModel.getIncorrectCount()){
            score = gameModel.getScore() - 10;
        }
        if (score < 0){
            score = 0;
        } else if (score > 100){
            score = 100;
        }
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void reset(){
        score = 100;
    }
}
