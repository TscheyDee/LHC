public class RFID implements IReaderTechnology {

    private IDCard idCard;

    public RFID(IDCard idCard){
        this.idCard = idCard;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
