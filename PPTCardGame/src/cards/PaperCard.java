package cards;

public class PaperCard implements Card {

    @Override
    public String getType() {
        return "Paper";
    }

    @Override
    public int fight(Card opponent) {
        String opponentType = opponent.getType();

        if (opponentType.equals("Rock")) {
            return 1;
        }
        else if (opponentType.equals("Scissors")) {
            return -1;
        }
        return 0;
    }
}