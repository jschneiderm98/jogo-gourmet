package org.example;

import org.example.view.ConsoleView;
import org.example.view.JOptionPaneView;
import org.example.view.ViewStrategy;

public class App 
{
    static final String viewStrategy = "joptionpane";
    public static void main(String[] args)
    {
        ViewStrategy view = viewStrategy == "joptionpane" ? new JOptionPaneView() : new ConsoleView();
        Controller controller = new Controller(view);
        while(true) {
            controller.runTree();
        }
    }
}
