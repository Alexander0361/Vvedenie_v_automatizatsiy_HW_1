package org.example;

import java.util.Random;

public class MontyHallSimulation {
    private int winsWithoutSwitching;
    private int winsWithSwitching;

    public int getWinsWithoutSwitching() {
        return winsWithoutSwitching;
    }

    public void setWinsWithoutSwitching(int winsWithoutSwitching) {
        this.winsWithoutSwitching = winsWithoutSwitching;
    }

    public int getWinsWithSwitching() {
        return winsWithSwitching;
    }

    public void setWinsWithSwitching(int winsWithSwitching) {
        this.winsWithSwitching = winsWithSwitching;
    }

    public void simulateGame() {
        int carDoor = new Random().nextInt(3);
        int playerChoice = new Random().nextInt(3);

        int revealedDoor;
        do {
            revealedDoor = new Random().nextInt(3);
        } while (revealedDoor == carDoor || revealedDoor == playerChoice);

        int finalChoice;
        do {
            finalChoice = new Random().nextInt(3);
        } while (finalChoice == playerChoice || finalChoice == revealedDoor);

        if (playerChoice == carDoor) {
            winsWithoutSwitching++;
        }
        if (finalChoice == carDoor) {
            winsWithSwitching++;
        }
    }

    public static void main(String[] args) {
        MontyHallSimulation simulation = new MontyHallSimulation();

        for (int i = 0; i < 1000; i++) {
            simulation.simulateGame();
        }

        System.out.println("Wins without switching: " + simulation.getWinsWithoutSwitching());
        System.out.println("Wins with switching: " + simulation.getWinsWithSwitching());
    }
}
