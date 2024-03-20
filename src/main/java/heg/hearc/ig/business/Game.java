public class Game {
    private int[] rolls = new int[21]; // 21 lancers sont le maximum possible
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) { // Strike
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) { // Spare
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    // Méthode principale pour tester la classe Game
    public static void main(String[] args) {
        System.out.println("Début de la démonstration de la classe Game:");

        // Définition des scénarios de test
        int[][] scenarios = {
                {0, 20}, // Tous zéros
                {1, 20}, // Tous uns
                {5, 5, 3, 17, 0}, // Un spare
                {10, 3, 4, 16, 0}, // Un strike
                {10, 12} // Jeu parfait
        };

        // Exécution des scénarios de test
        for (int i = 0; i < scenarios.length; i++) {
            Game game = new Game();
            for (int j = 0; j < scenarios[i].length; j += 2) {
                int pins = scenarios[i][j];
                int rolls = scenarios[i][j + 1];
                rollMany(game, rolls, pins);
            }
            System.out.println("Scénario " + (i + 1) + ": " + game.score());
        }
    }

    private static void rollMany(Game game, int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}
