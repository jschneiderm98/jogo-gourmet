package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.AnswerNode;
import org.example.model.NodeType;
import org.example.model.QuestionNode;
import org.example.view.JOptionPaneView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ControllerTest {
    Controller sut;

    JOptionPaneView view;
    @BeforeEach
    void init() {
        this.view = Mockito.mock(JOptionPaneView.class);
        this.sut = new Controller(this.view);
    }

    @Test
    void testUpdateTree() {
        QuestionNode parent = new QuestionNode("testepai", NodeType.START);
        QuestionNode node = new AnswerNode("teste1", NodeType.YES);
        parent.setYesNode(node);
        node.setParentNode(parent);
        sut.updateTree(node, "pergunta", "teste2");
        assertEquals(parent.getYesNode().getValue(), "pergunta");
        assertEquals(parent.getYesNode().getNoNode(), node);
        assertEquals(parent.getYesNode().getYesNode().getValue(), "teste2");
    }

    @Test
    void testRunTreeRightChoice() {
        Controller sutSpy = Mockito.spy(sut);
        Mockito.when(view.doesFoodHasAttribute(Mockito.any())).thenReturn(true);
        Mockito.when(view.isCorrectFood(Mockito.any())).thenReturn(true);

        sutSpy.runTree();

        Mockito.verify(view, Mockito.times(1)).rightGuess();
        Mockito
                .verify(sutSpy, Mockito.times(0))
                .updateTree(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void testRunTreeWrongChoice() {
        Controller sutSpy = Mockito.spy(sut);
        Mockito.doNothing().when(sutSpy).updateTree(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.when(view.doesFoodHasAttribute(Mockito.any())).thenReturn(true);
        Mockito.when(view.isCorrectFood(Mockito.any())).thenReturn(false);
        Mockito.when(view.getNewFood()).thenReturn("novo-prato");
        Mockito.when(view.getNewAttribute(Mockito.any())).thenReturn("novo-tipo");

        sutSpy.runTree();

        Mockito.verify(view, Mockito.times(0)).rightGuess();
        Mockito
                .verify(sutSpy, Mockito.times(1))
                .updateTree(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test
    void testRunTreeWrongChoiceThenRightChoice() {
        Controller sutSpy = Mockito.spy(sut);
        Mockito.doNothing().when(sutSpy).updateTree(Mockito.any(), Mockito.any(), Mockito.any());
        Mockito.when(view.doesFoodHasAttribute(Mockito.any())).thenReturn(true);
        Mockito.when(view.isCorrectFood(Mockito.any())).thenReturn(false);
        Mockito.when(view.getNewFood()).thenReturn("novo-prato");
        Mockito.when(view.getNewAttribute(Mockito.any())).thenReturn("novo-tipo");

        sutSpy.runTree();

        Mockito.verify(view, Mockito.times(0)).rightGuess();
        Mockito
                .verify(sutSpy, Mockito.times(1))
                .updateTree(Mockito.any(), Mockito.any(), Mockito.any());

        Mockito.when(view.isCorrectFood(Mockito.any())).thenReturn(true);

        sutSpy.runTree();

        Mockito.verify(view, Mockito.times(1)).rightGuess();
        Mockito
                .verify(sutSpy, Mockito.times(1))
                .updateTree(Mockito.any(), Mockito.any(), Mockito.any());
    }
}
