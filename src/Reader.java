public class Reader implements IReader{

    private IrisScanner scanner;
    private IDCard idCard;
    private IReaderTechnology iReaderTechnology;
    private CardManagement cardManagement;

    public Reader(IrisScanner scanner, IDCard idCard, IReaderTechnology iReaderTechnology){
        this.scanner = scanner;
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
    }

    public boolean insertCard(IDCardVisitor idCard, IReaderTechnology iReaderTechnology){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
        boolean passwordVerification = cardManagement.verifyIDCard(idCard);

        return (passwordVerification == true);
    }

    public boolean insertCard(IDCardEmployee idCard, IReaderTechnology iReaderTechnology){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
        boolean passwordVerification = cardManagement.verifyIDCard(idCard);
        boolean irisVerification = cardManagement.verifyIris(idCard);

        return (passwordVerification == true && irisVerification == true);
    }

    public void removeIDCard(){
        if (idCard != null) {
            idCard = null;
        } else {
            throw new RuntimeException("Leg Karte ein du Opfer");
        }
    }

    public int[][] scanIris() {
        return scanner.getIris();
    }

    public IrisScanner getScanner() {
        return scanner;
    }

    public void setScanner(IrisScanner scanner) {
        this.scanner = scanner;
    }
}
