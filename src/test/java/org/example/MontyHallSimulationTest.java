package org.example;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MontyHallSimulationTest {

    @Test
    public void testWinsWithSwitchingGreaterThanWinsWithoutSwitching() {
        MontyHallSimulation simulation = new MontyHallSimulation();

        for (int i = 0; i < 1000; i++) {
            simulation.simulateGame();
        }

        assertTrue(simulation.getWinsWithSwitching() > simulation.getWinsWithoutSwitching());
    }

    @Test
    public void testWinsWithoutSwitchingInRange() {
        MontyHallSimulation simulation = new MontyHallSimulation();

        for (int i = 0; i < 1000; i++) {
            simulation.simulateGame();
        }

        assertTrue(simulation.getWinsWithoutSwitching() >= 0 && simulation.getWinsWithoutSwitching() <= 1000);
    }

    @Test
    public void testWinsWithSwitchingInRange() {
        MontyHallSimulation simulation = new MontyHallSimulation();

        for (int i = 0; i < 1000; i++) {
            simulation.simulateGame();
        }

        assertTrue(simulation.getWinsWithSwitching() >= 0 && simulation.getWinsWithSwitching() <= 1000);
    }

    @Test
    public void testInvalidPlayerChoice() {
        MontyHallSimulation simulation = new MontyHallSimulation();

        //почему Вы тут ожидаете IllegalArgumentException?
        assertThrows(IllegalArgumentException.class, () -> {
            simulation.simulateGame();
            simulation.setWinsWithoutSwitching(-1); // Попытка установить отрицательное значение
        });
    }

    @Test
    public void testInvalidRevealedDoor() {
        MontyHallSimulation simulation = new MontyHallSimulation();

        //почему Вы тут ожидаете IllegalArgumentException?
        assertThrows(IllegalArgumentException.class, () -> {
            simulation.simulateGame();
            simulation.setWinsWithSwitching(1001); // Попытка установить значение больше 1000
        });
    }

    @Test
    public void testInvalidFinalChoice() {
        MontyHallSimulation simulation = new MontyHallSimulation();

        //почему Вы тут ожидаете IllegalArgumentException?
        assertThrows(IllegalArgumentException.class, () -> {
            simulation.simulateGame();
            simulation.setWinsWithoutSwitching(1500); // Попытка установить значение больше 1000
        });
    }
}
