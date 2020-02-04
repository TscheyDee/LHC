package INFRASTRUCTURE.TECHNOLOGY;

import HUMAN_RESOURCES.Person;

public class FingerprintScanner {// implements IScanner {

    public FingerprintScanner(){

    }

    public String scan(Person person){
        return person.getName();
    }

}
