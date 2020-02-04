package INFRASTRUCTURE.TECHNOLOGY;

import HUMAN_RESOURCES.Person;

public class IrisScanner implements IScanner {

    public IrisScanner(){

    }

    public int[][] scan(Person person){
        return person.getIris();
    }
}
