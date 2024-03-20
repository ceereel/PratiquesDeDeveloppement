package heg.hearc.ig.business;

public class Game {
    private int[] rolls = new int[21]; // 21 lancers sont le maximum possible dans un jeu de bowling
    private int currentRoll = 0;

    public void roll(int pins) {
        // Vérifie que nous ne dépassons pas la capacité du tableau
        if (currentRoll < rolls.length) {
            rolls[currentRoll++] = pins;
        } else {
            System.out.println("Tentative d'ajouter plus de lancers que prévu.");
        }
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) { // Vérification d'un strike
                score += 10 + strikeBonus(frameIndex);
                frameIndex++; // Avance d'un lancer car le strike n'occupe qu'une case dans le tableau
            } else if (isSpare(frameIndex)) { // Vérification d'un spare
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2; // Avance de deux lancers car le spare occupe deux cases
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2; // Avance de deux lancers dans le cas général
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
}
