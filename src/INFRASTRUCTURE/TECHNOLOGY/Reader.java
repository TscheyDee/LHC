package INFRASTRUCTURE.TECHNOLOGY;

import INFRASTRUCTURE.SECURITY.CryptogrpahyManagement;
import INFRASTRUCTURE.MANAGEMENT.IDCard;
import INFRASTRUCTURE.MANAGEMENT.IDCardEmployee;
import INFRASTRUCTURE.MANAGEMENT.IDCardVisitor;
import HUMAN_RESOURCES.Person;

public class Reader implements IReader{

    private IDCard idCard;

    private IrisScanner irisScanner;

    private IReaderTechnology iReaderTechnology;
    private CryptogrpahyManagement cryptogrpahyManagement;


    public Reader(IrisScanner irisScanner){
        this.irisScanner = irisScanner;
    }

    public void insertCard(IDCardVisitor idCard, IReaderTechnology iReaderTechnology){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
    }

    public void insertCard(IDCardEmployee idCard, IReaderTechnology iReaderTechnology){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
    }

    public void removeIDCard(){
        if (idCard != null) {
            idCard = null;
        } else {
            System.out.println("Card can't be removed - no card inside.");
        }
    }

    public String decryptPassword(String data){
        return cryptogrpahyManagement.decrypt(data, cryptogrpahyManagement.getKey());
    }

    public int[][] scanIris(Person person) {
        return irisScanner.scan(person);
    }

    public IReaderTechnology getiReaderTechnology() {
        return iReaderTechnology;
    }
}
