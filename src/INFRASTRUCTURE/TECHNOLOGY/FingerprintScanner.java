package INFRASTRUCTURE.TECHNOLOGY;

import HUMAN_RESOURCES.Person;

public class FingerprintScanner implements IScanner {

    private String fingerprint;

    public FingerprintScanner(){

    }

    public void scan(Person person){
        fingerprint = person.getName();
    }

    public String scan(){
        return fingerprint;
    }

}
