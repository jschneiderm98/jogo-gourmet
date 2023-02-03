package org.example.view;

import java.util.Scanner;

public class ConsoleView implements  ViewStrategy{
    Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        System.out.println("Digite alguma coisa para iniciar");
        this.scanner.nextLine();
    }

    @Override
    public void rightGuess() {
        System.out.println("Acertei mais uma vez, digite para continuar");
        this.scanner.nextLine();
    }

    @Override
    public boolean doesFoodHasAttribute(String attribute) {
        System.out.println("A comida que você está pensando é do tipo " + attribute + "? Digite 'S' para Sim e 'N' para Não");
        String answer = this.scanner.nextLine();
        if(!answer.isEmpty()) {
            if(answer.charAt(0) == 'S') {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isCorrectFood(String food) {
        System.out.println("A comida que você está pensando é " + food + "? Digite 'S' para Sim e 'N' para Não");
        String answer = this.scanner.nextLine();
        if(!answer.isEmpty()) {
            if(answer.charAt(0) == 'S') {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getNewFood() {
        System.out.println("Qual era a comida que você estava pensando?");
        return this.scanner.nextLine();
    }

    @Override
    public String getNewAttribute(String lastFood) {
        System.out.println("Qual tipo que essa comida tem que " + lastFood + " não tem?");
        return this.scanner.nextLine();
    }
}
