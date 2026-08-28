package string.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        try {
            // Demo predefined player inputs for 5 rounds
            String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
            runGame(playerMoves);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void runGame(String[] playerMoves) {
        if (playerMoves == null || playerMoves.length == 0) {
            throw new IllegalArgumentException("Player moves array cannot be null or empty.");
        }

        String[] options = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;
        int totalRounds = playerMoves.length;

        System.out.printf("%-8s | %-12s | %-13s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            String playerMove = playerMoves[i];
            String computerMove = options[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("Round %-2d | %-12s | %-13s | %-12s\n", (i + 1), playerMove, computerMove, result);
        }

        double winPercent = ((double) wins / totalRounds) * 100;
        System.out.println("---------------------------------------------------------");
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercent);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            throw new IllegalArgumentException("Moves cannot be null.");
        }

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }
}
