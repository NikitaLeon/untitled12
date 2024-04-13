import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Player petya = new Player(123, "Петя", 120);
        Player sasha = new Player(123321, "Саша", 100);
        Game game = new Game();

        game.register(petya);
        game.register(sasha);
        int expected = 2;
        int actual = game.round("Саша", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player petya = new Player(123, "Петя", 120);
        Player sasha = new Player(123321, "Саша", 100);
        Game game = new Game();

        game.register(petya);
        game.register(sasha);
        int expected = 1;
        int actual = game.round("Петя", "Саша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenStrengthsEqual() {
        Player petya = new Player(1, "Саша", 100);
        Player sasha = new Player(2, "Рафис", 100);
        Game game = new Game();

        game.register(petya);
        game.register(sasha);
        int expected = 0;
        int actual = game.round("Саша", "Рафис");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player sasha = new Player(1, "Саша", 100);
        Game game = new Game();

        game.register(sasha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вова", "Саша"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player sasha = new Player(1, "Саша", 100);
        Game game = new Game();

        game.register(sasha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Саша", "Вова"));
    }
}
