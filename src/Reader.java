public class Reader implements IReader{

    private IDCard idCard;

    private IrisScanner irisScanner;
    private FingerprintScanner fingerprintScanner;

    private IReaderTechnology iReaderTechnology;
    private CryptogrpahyManagement cryptogrpahyManagement;


    public Reader(IrisScanner irisScanner, FingerprintScanner fingerprintScanner){
        this.irisScanner = irisScanner;
        this.fingerprintScanner = fingerprintScanner;
    }

    public boolean insertCard(IDCardVisitor idCard, IReaderTechnology iReaderTechnology,
                              String password){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
        boolean passwordVerification = CardManagement.instance.verifyPassword(idCard, password);

        return (passwordVerification == true);
    }

    public boolean insertCard(IDCardEmployee idCard, IReaderTechnology iReaderTechnology,
                              String password, int[][] iris){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
        boolean passwordVerification = CardManagement.instance.verifyPassword(idCard, password);
        boolean irisVerification = CardManagement.instance.verifyIris(idCard, iris);

        return (passwordVerification == true && irisVerification == true);
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
