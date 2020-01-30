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

    public boolean insertCard(IDCardVisitor idCard, IReaderTechnology iReaderTechnology,
                              String password){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
        boolean passwordVerification = cardManagement.verifyIDCard(idCard, password);

        return (passwordVerification == true);
    }

    public boolean insertCard(IDCardEmployee idCard, IReaderTechnology iReaderTechnology,
                              String password, int[][] iris){
        this.idCard = idCard;
        this.iReaderTechnology = iReaderTechnology;
        boolean passwordVerification = cardManagement.verifyIDCard(idCard, password);
        boolean irisVerification = cardManagement.verifyIris(idCard, iris);

        return (passwordVerification == true && irisVerification == true);
    }

    public void removeIDCard(){
        if (idCard != null) {
            idCard = null;
        } else {
            System.out.println("Card can't be removed - no card inside.");
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
