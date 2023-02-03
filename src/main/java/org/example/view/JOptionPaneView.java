package org.example.view;

import javax.swing.JOptionPane;

public class JOptionPaneView implements  ViewStrategy{
    public JOptionPaneView() {

    }

    @Override
    public void start() {
        int res = JOptionPane.showConfirmDialog(
                null,
                "Pense em um prato que você gosta",
                "Início", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE
        );
        if (res == JOptionPane.CLOSED_OPTION) {
            this.exit();
            this.start();
        }
    }

    @Override
    public void rightGuess() {
        int res = JOptionPane.showConfirmDialog(
                null,
                "Acertei de novo!",
                "Adivinhação correta", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE
        );
        if (res == JOptionPane.CLOSED_OPTION) {
            this.exit();
            this.rightGuess();
        }
    }

    @Override
    public boolean doesFoodHasAttribute(String attribute) {
        int res = JOptionPane.showConfirmDialog(
                null,
                "O prato que você pensou é do tipo " + attribute + "?",
                "Verificar atributo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        if (res == JOptionPane.CLOSED_OPTION) {
            this.exit();
            return this.doesFoodHasAttribute(attribute);
        }
        else if (res == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCorrectFood(String food) {
        int res = JOptionPane.showConfirmDialog(
                null,
                "O prato que você pensou é " + food + "?",
                "Adivinhar comida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        if (res == JOptionPane.CLOSED_OPTION) {
            this.exit();
            return this.isCorrectFood(food);
        }
        else if (res == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    @Override
    public String getNewFood() {
        String res = JOptionPane.showInputDialog(
                null,
                "Qual era a comida que você estava pensando?",
                "Nova comida"
        );
        if(res == null) {
            this.exit();
            return this.getNewFood();
        }
        return res;
    }

    @Override
    public String getNewAttribute(String lastFood) {
        String res = JOptionPane.showInputDialog(
                null,
                "Qual tipo que esse prato tem que " + lastFood + " não tem?",
                "Tipo"
        );
        if(res == null) {
            this.exit();
            return this.getNewAttribute(lastFood);
        }
        return res;
    }

    private void exit() {
        int res = JOptionPane.showConfirmDialog(
                null,
                "Deseja sair do programa?",
                "Adivinhar comida", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
        );
        if (res == JOptionPane.NO_OPTION) {
            return;
        }
        System.exit(0);
    }
}
