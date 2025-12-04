// Pacote: game
package game;

import cards.Card;
import iterator.HandIterator;
import iterator.ConcreteHandIterator;
import iterator.FilterCardIterator; // Importação do novo Iterator
import java.util.ArrayList;
import java.util.List;

public class PlayerHand {

    private final List<Card> cards;

    // ... Construtor e addCard() ...

    public PlayerHand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    // Método para criar o Iterator padrão (para iteração simples)
    public HandIterator createDefaultIterator() {
        return new ConcreteHandIterator(this.cards);
    }

    // NOVO MÉTODO: Método para criar o Iterator Filtrado
    // O cliente fornece o tipo de filtro desejado.
    public HandIterator createFilterIterator(String type) {
        return new FilterCardIterator(this.cards, type);
    }

    // ... getCards() ...
    public List<Card> getCards() {
        return cards;
    }
}