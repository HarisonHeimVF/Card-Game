package iterator;

import cards.Card;
import java.util.List;
import java.util.NoSuchElementException;

public class ConcreteHandIterator implements HandIterator {

    private final List<Card> hand;
    private int position = 0; // Estado da iteração

    public ConcreteHandIterator(List<Card> hand) {
        this.hand = hand;
    }

    @Override
    public boolean hasNext() {
        return position < hand.size();
    }

    @Override
    public Card next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não há mais cartas na mão.");
        }
        return hand.get(position++);
    }
}