import java.util.HashMap;

public enum CardManagement implements ICardManagement {
    instance;

    private HashMap<Integer, IDCard> idCardHashMap;
    private ReaderTouchpad touchpadReader;

    public boolean verifyIDCard(IDCard idCard){
        String enteredPIN = touchpadReader.enterPIN();
        String password = idCard.getChip().getPassword();

        return (enteredPIN == password);
    }

    public boolean verifyIris(IDCardEmployee idCard){
        int[][] scannedIris = touchpadReader.getScanner().getIris();
        int[][] cardIris = idCard.getIrisStructure();

        return (scannedIris == cardIris);
    }

    public void lockIDCard(IDCard idCard){
        idCard.setLocked(true);
    }

    public void clearIDCard(IDCard idCard){
        idCard.setLocked(false);
    }
}
