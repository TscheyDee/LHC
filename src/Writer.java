public class Writer implements IWriter {

    private IDCard idCard;
    private CryptogrpahyManagement cryptogrpahyManagement;

    public Writer(){

    }

    public void writeWithAES(String data) {
        String encryptedData = encryptPassword(data);
        idCard.getChip().setData(encryptedData);
    }

    public void writeWithMD5(String data) {
        String encryptedData = MD5CryptoUtilities.instance.generate(data);
        idCard.getChip().setData(encryptedData);
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    public void removeIDCard(){
        if (idCard != null) {
            idCard = null;
        } else {
            System.out.println("Card can't be removed - no card inside.");
        }
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public String encryptPassword(String data){
        return cryptogrpahyManagement.encrypt(data, cryptogrpahyManagement.getKey());
    }
}
