public class Reader implements IReader{

    private IDCard idCard;

    private IrisScanner irisScanner;
    private FingerprintScanner fingerprintScanner;

    private IReaderTechnology iReaderTechnology;
    private CardManagement cardManagement;

    public Reader(IrisScanner irisScanner, IDCard idCard, IReaderTechnology iReaderTechnology){
        this.irisScanner = irisScanner;
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
    }

    public boolean insertCard(IDCardVisitor idCard, IReaderTechnology iReaderTechnology,
                              String password){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
        boolean passwordVerification = cardManagement.verifyPassword(idCard, password);

        return (passwordVerification == true);
    }

    public boolean insertCard(IDCardEmployee idCard, IReaderTechnology iReaderTechnology,
                              String password, int[][] iris){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
        boolean passwordVerification = cardManagement.verifyPassword(idCard, password);
        boolean irisVerification = cardManagement.verifyIris(idCard, iris);

        return (passwordVerification == true && irisVerification == true);
    }


    /*

    public IDCard insertCard(IDCardVisitor idCard,
    IReaderTechnology iReaderTechnology){

        iReaderTechnology.detectIDCard(idCard);
        return iReaderTechnology.getIDCard();
    }

    public boolean verifyIDCard(IDCardVisitor idCard,
    String password, int[][] iris){

        IDCardVisitor newDdCard = insertCard(idCard);

        boolean passwordVerification = cardManagement.verifyPassword(idCard, password);
        boolean irisVerification = cardManagement.verifyIris(idCard, iris);

        return (passwordVerification == true && irisVerification == true);
    }
    */

    public void removeIDCard(){
        if (idCard != null) {
            idCard = null;
        } else {
            System.out.println("Card can't be removed - no card inside.");
        }
    }

    public int[][] scanIris() {
        return irisScanner.getIris();
    }

    public IrisScanner getIrisScanner() {
        return irisScanner;
    }

    public void setIrisScanner(IrisScanner scanner) {
        this.irisScanner = scanner;
    }

    public FingerprintScanner getFingerprintScanner() {
        return fingerprintScanner;
    }

    public void setFingerprintScanner(FingerprintScanner fingerprintScanner) {
        this.fingerprintScanner = fingerprintScanner;
    }

    public IReaderTechnology getiReaderTechnology() {
        return iReaderTechnology;
    }

    public void setiReaderTechnology(IReaderTechnology iReaderTechnology) {
        this.iReaderTechnology = iReaderTechnology;
    }

    public CardManagement getCardManagement() {
        return cardManagement;
    }
}
