package cards;

public class ScissorsCard implements Card {

    @Override
    public String getType() {
        return "Scissors";
    }

    @Override
    public int fight(Card opponent) {
        String opponentType = opponent.getType();

        if (opponentType.equals("Paper")) {
            return 1;
        }
        else if (opponentType.equals("Rock")) {
            return -1;
        }
        return 0;
    }
}