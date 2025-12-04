package cards;

public interface Card {

    String getType();

    int fight(Card opponent);
}