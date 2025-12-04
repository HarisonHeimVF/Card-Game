package game;

import cards.Card;
import factory.CardFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {

    private int playerHealth = 10;
    private int opponentHealth = 10;

    public static final List<Card> BASE_DECK = createBaseDeck();

    private static List<Card> createBaseDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) deck.add(CardFactory.createCard("ROCK"));
        for (int i = 0; i < 3; i++) deck.add(CardFactory.createCard("PAPER"));
        for (int i = 0; i < 3; i++) deck.add(CardFactory.createCard("SCISSORS"));

        Collections.shuffle(deck);
        return deck;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getOpponentHealth() {
        return opponentHealth;
    }

    public void updateHealth(int result) {
        if (result > 0) {
            opponentHealth--;
            System.out.println("-> Vilão perde 1 vida.");
        } else if (result < 0) {
            playerHealth--;
            System.out.println("-> Jogador perde 1 vida.");
        } else {
            System.out.println("-> Nenhuma vida perdida.");
        }
    }

    public boolean isGameOver() {
        return playerHealth <= 0 || opponentHealth <= 0;
    }

    public String getGameResult() {
        if (playerHealth <= 0 && opponentHealth <= 0) {
            return "O jogo terminou em EMPATE! Ambos chegaram a zero ao mesmo tempo.";
        } else if (playerHealth <= 0) {
            return "DERROTA! O Vilão Venceu por Nocaute!";
        } else if (opponentHealth <= 0) {
            return "VITÓRIA! O Jogador Venceu por Nocaute!";
        }

        System.out.println("--- FIM DOS DECKS ---");
        System.out.println("Pontuação Final: Jogador (" + playerHealth + ") vs. Vilão (" + opponentHealth + ")");

        if (playerHealth > opponentHealth) {
            return "VITÓRIA! O Jogador Venceu por Pontuação!";
        } else if (opponentHealth > playerHealth) {
            return "DERROTA! O Vilão Venceu por Pontuação!";
        } else {
            return "O jogo terminou em EMPATE por Pontuação!";
        }
    }
}