package iterator;

import cards.Card;

public interface HandIterator {
    boolean hasNext();
    Card next();
}