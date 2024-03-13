import static org.junit.Assert.*;
import heg.hearc.ig.business.FizzBuzzGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzGeneratorTest {

    @Test
    @DisplayName("1 => 1")
    public void shouldBe1() {
        assertEquals("1", FizzBuzzGenerator.generateSingle(1));
    }

    @Test
    @DisplayName("5 => fizz")
    public void fizz_Given5_ShouldBeFizz() {
        assertEquals("fizz", FizzBuzzGenerator.generateSingle(5));
    }

    @Test
    @DisplayName("7 => buzz")
    public void fizz_Given7_ShouldBeBuzz() {
        assertEquals("buzz", FizzBuzzGenerator.generateSingle(7));
    }

    @Test
    @DisplayName("35 => fizzbuzz")
    public void fizz_Given35_ShouldBeBuzz() {
        assertEquals("fizzbuzz", FizzBuzzGenerator.generateSingle(35));
    }

    @Test
    @DisplayName("66 => fizzbuzz")
    public void fizz_Given66_ShouldBeFizzBuzz() {
        assertEquals("fizzbuzz", FizzBuzzGenerator.generateSingle(66));
    }

    @Test
    @DisplayName("8 => 8")
    public void fizz_Given8_ShouldBe8() {
        assertEquals("8", FizzBuzzGenerator.generateSingle(8));
    }

    @Test
    @DisplayName("-1 => IllegalArgumentExpectation")
    public void fizz_GivenNegativeNumer_ShouldBeIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new FizzBuzzGenerator().generateSingle(-1));
    }

    @Test
    @DisplayName("SequenceTest")
    public void fizz_GivenSeq_ShouldBeSeq() {
        assertArrayEquals(new String[]{"fizz", "6", "buzz", "8"}, FizzBuzzGenerator.generate(5, 4).toArray(new String[0]));
    }

}
