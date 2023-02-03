package org.example.view;

public interface ViewStrategy {
    public void start();
    public void rightGuess();
    public boolean doesFoodHasAttribute(String attribute);
    public boolean isCorrectFood(String food);
    public String getNewFood();
    public String getNewAttribute(String food);
}
