package INFRASTRUCTURE.TECHNOLOGY;

import HUMAN_RESOURCES.Person;

public class IrisScanner implements IScanner {

    private int[][] iris;

    public IrisScanner(){

    }

    public void scan(Person person){
        iris = person.getIris();
    }

    public int[][] scan(){
        return iris;
    }
}
