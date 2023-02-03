package org.example.model;

public class QuestionNode {
    QuestionNode yesNode;
    QuestionNode noNode;
    QuestionNode parentNode;
    String value;
    NodeType type;

    public QuestionNode(String value, NodeType type) {
        this.value = value;
        this.type = type;
    }

    public QuestionNode getYesNode() {
        return yesNode;
    }

    public void setYesNode(QuestionNode yesNode) {
        this.yesNode = yesNode;
    }

    public QuestionNode getNoNode() {
        return noNode;
    }

    public void setNoNode(QuestionNode noNode) {
        this.noNode = noNode;
    }

    public QuestionNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(QuestionNode parentNode) {
        this.parentNode = parentNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public boolean isEnd() {
        return false;
    }
}
