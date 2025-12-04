package game;

import cards.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        GameManager gameManager = new GameManager();

        List<Card> deck = new ArrayList<>(GameManager.BASE_DECK);

        List<Card> playerHand = new ArrayList<>(deck);
        List<Card> opponentHand = new ArrayList<>(deck);

        System.out.println("=================================================");
        System.out.println("== CARD GAME: Pedra, Papel e Tesoura (PPT) ==");
        System.out.println("=================================================");
        System.out.println("Regras: 10 Cartas no Deck. Escolha 2 por rodada.");
        System.out.println("Vida Inicial: Jogador: 10 | Vilão: 10");

        int round = 1;

        while (!gameManager.isGameOver() && !playerHand.isEmpty()) {

            System.out.println("\n-------------------------------------------------");
            System.out.println("RODADA " + round++);

            List<Card> playerSelectedCards = new ArrayList<>();

            for (int i = 0; i < 2; i++) {

                System.out.println("\nSuas Cartas Restantes (" + playerHand.size() + "):");
                for (int j = 0; j < playerHand.size(); j++) {
                    System.out.println("  [" + (j + 1) + "] " + playerHand.get(j).getType());
                }

                int selectedIndex = -1;
                int currentHandSize = playerHand.size();

                while (selectedIndex < 1 || selectedIndex > currentHandSize) {
                    System.out.print("Escolha sua " + (i + 1) + "ª carta (índice 1-" + currentHandSize + "): ");
                    try {
                        selectedIndex = scanner.nextInt();
                    } catch (java.util.InputMismatchException e) {
                        scanner.next();
                        selectedIndex = -1;
                    }
                    if (selectedIndex < 1 || selectedIndex > currentHandSize) {
                        System.out.println("Índice inválido. Tente novamente.");
                    }
                }

                playerSelectedCards.add(playerHand.remove(selectedIndex - 1));
            }

            List<Card> opponentSelectedCards = new ArrayList<>();
            Collections.shuffle(opponentHand);

            opponentSelectedCards.add(opponentHand.remove(0));
            opponentSelectedCards.add(opponentHand.remove(0));

            System.out.println("\n--- RESULTADOS DA RODADA ---");

            for (int i = 0; i < 2; i++) {
                Card pCard = playerSelectedCards.get(i);
                Card oCard = opponentSelectedCards.get(i);

                int result = pCard.fight(oCard);

                System.out.println("\nBatalha " + (i + 1) + ": Jogador (" + pCard.getType() + ") vs. Vilão (" + oCard.getType() + ")");

                if (result == 1) {
                    System.out.println("-> Resultado: VITÓRIA do Jogador.");
                } else if (result == -1) {
                    System.out.println("-> Resultado: VITÓRIA do Vilão.");
                } else {
                    System.out.println("-> Resultado: EMPATE.");
                }

                gameManager.updateHealth(result);
                System.out.println("[VIDAS] Jogador: " + gameManager.getPlayerHealth() + " | Vilão: " + gameManager.getOpponentHealth());

                if (gameManager.isGameOver()) {
                    break;
                }
            }

            if (playerHand.isEmpty() && !gameManager.isGameOver()) {
                break;
            }
        }

        System.out.println("\n=================================================");
        System.out.println("== FIM DE JOGO ==");

        System.out.println(gameManager.getGameResult());

        System.out.println("=================================================");
        scanner.close();
    }
}