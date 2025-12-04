package cards;

public class RockCard implements Card {

    @Override
    public String getType() {
        return "Rock";
    }

    @Override
    public int fight(Card opponent) {
        String opponentType = opponent.getType();

        if (opponentType.equals("Scissors")) {
            return 1;
        }
        else if (opponentType.equals("Paper")) {
            return -1;
        }
        return 0;
    }
}