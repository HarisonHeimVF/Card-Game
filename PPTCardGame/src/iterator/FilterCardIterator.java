package iterator;

import cards.Card;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FilterCardIterator implements HandIterator {

    private final List<Card> hand;
    private final String filterType; // O tipo de carta que queremos (ex: "ROCK")
    private int position;
    private Card nextCard; // Variável para armazenar o próximo item que passou no filtro

    public FilterCardIterator(List<Card> hand, String filterType) {
        this.hand = hand;
        this.filterType = filterType.toUpperCase();
        this.position = 0;
        // Inicializa o primeiro elemento filtrado
        findNextCard();
    }

    private void findNextCard() {
        // Zera o nextCard antes de procurar
        nextCard = null;

        while (position < hand.size()) {
            Card current = hand.get(position);
            position++;

            // Aplica a lógica de filtro
            if (current.getType().toUpperCase().equals(filterType)) {
                nextCard = current; // Encontrou! Armazena e sai do loop
                return;
            }
        }
    }

    @Override
    public boolean hasNext() {
        // Retorna true se a variável nextCard (que foi pré-carregada) não for nula
        return nextCard != null;
    }

    @Override
    public Card next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não há mais cartas do tipo " + filterType + " na mão.");
        }


        Card cardToReturn = nextCard;


        findNextCard();


        return cardToReturn;
    }
}