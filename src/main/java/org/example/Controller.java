package org.example;

import org.example.model.AnswerNode;
import org.example.model.NodeType;
import org.example.model.QuestionNode;
import org.example.view.ViewStrategy;

public class Controller {
    QuestionNode gameTree;
    ViewStrategy view;

    public Controller(ViewStrategy view) {
        QuestionNode gameTree = new QuestionNode("Massa", NodeType.START);
        QuestionNode bolo = new AnswerNode("Bolo de chocolate", NodeType.NO);
        QuestionNode lasanha = new AnswerNode("Lasanha", NodeType.YES);
        bolo.setParentNode(gameTree);
        lasanha.setParentNode(gameTree);
        gameTree.setNoNode(bolo);
        gameTree.setYesNode(lasanha);
        this.gameTree = gameTree;
        this.view = view;
    }

    public void runTree() {
        QuestionNode node = gameTree;
        view.start();
        while (!node.isEnd()) {
            node = view.doesFoodHasAttribute(node.getValue()) ? node.getYesNode() : node.getNoNode();
        }

        if(view.isCorrectFood(node.getValue())) {
            view.rightGuess();
            return;
        }

        String newAnswer = view.getNewFood();
        String newQuestion = view.getNewAttribute(node.getValue());
        updateTree(node, newQuestion, newAnswer);
    }

    public void updateTree(QuestionNode node, String newQuestion, String newAnswer) {
        QuestionNode newQuestionNode = new QuestionNode(newQuestion, node.getType());
        QuestionNode newAnswerNode = new AnswerNode(newAnswer, NodeType.YES);

        if (node.getType() == NodeType.YES) {
            node.getParentNode().setYesNode(newQuestionNode);
        }
        else {
            node.getParentNode().setNoNode(newQuestionNode);
        }
        newQuestionNode.setParentNode(node.getParentNode());
        newQuestionNode.setNoNode(node);
        newQuestionNode.setYesNode(newAnswerNode);
        node.setType(NodeType.NO);
        node.setParentNode(newQuestionNode);
        newAnswerNode.setParentNode(newQuestionNode);
    }
}
