public class RFID implements IReaderTechnology {

    private IDCard idCard;

    public RFID(){

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
