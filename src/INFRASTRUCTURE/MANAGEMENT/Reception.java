package INFRASTRUCTURE.MANAGEMENT;

import HUMAN_RESOURCES.Employee;
import HUMAN_RESOURCES.Visitor;
import INFRASTRUCTURE.TECHNOLOGY.Writer;

import java.util.Stack;

public enum Reception {
    instance;

    private Stack<IDCardVisitor> blankIDCards;
    private Employee employee;
    private Writer writer;


    public void addBlankIDCard() {
        IDCardVisitor idCard = new IDCardVisitor();
        blankIDCards.add(idCard);
    }

    public void createNewIDCard(Visitor visitor, String password) {
        IDCardVisitor idCard = blankIDCards.pop();
        CardManagement.instance.createIDCard(visitor, idCard, password);
    }

    public void lockIDCard(IDCardVisitor idCard){
        CardManagement.instance.lockIDCard(idCard);
    }

    public void clearIDCard(IDCardVisitor idCard){
        CardManagement.instance.clearIDCard(idCard);
    }
}
