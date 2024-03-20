import heg.hearc.ig.business.Game;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @Test
    @DisplayName("20x0 => 0")
    public void score_GivenAllZeros_ShouldReturnZero() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    @DisplayName("20x1 => 20")
    public void score_GivenAllOnes_ShouldReturnTwenty() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    @DisplayName("/+3 => 16")
    public void score_GivenOneSpare_ShouldIncludeSpareBonus() {
        game.roll(5);
        game.roll(5); // spare
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    @DisplayName("X+3+4 => 24")
    public void score_GivenOneStrike_ShouldIncludeStrikeBonus() {
        game.roll(10); // strike
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    @DisplayName("12X = > 300")
    public void score_GivenPerfectGame_ShouldReturnThreeHundred() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }
}
