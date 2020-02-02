public class RFID implements IReaderTechnology {

    private IDCard idCard;

    public RFID(IDCard idCard){
        this.idCard = idCard;
    }

    public void detectIDCard(IDCard idCard){
        if (idCard != null){
            this.idCard = idCard;
        }
    }

    public IDCard getIDCard() {
        return idCard;
    }
}
