package factory;

import cards.Card;
import cards.RockCard;
import cards.PaperCard;
import cards.ScissorsCard;

public class CardFactory {

    public static Card createCard(String type) {
        if (type == null) {
            return null;
        }

        switch (type.toUpperCase()) {
            case "ROCK":
                return new RockCard();
            case "PAPER":
                return new PaperCard();
            case "SCISSORS":
                return new ScissorsCard();
            default:
                throw new IllegalArgumentException("Tipo de carta desconhecido: " + type);
        }
    }
}