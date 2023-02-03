package org.example.model;

public class AnswerNode extends QuestionNode {
    public AnswerNode(String value, NodeType type) {
        super(value, type);
    }

    @Override
    public boolean isEnd() {
        return true;
    }
}
