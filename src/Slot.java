public class Slot implements IReaderTechnology {

    private IDCard idCard;

    public Slot(IDCard idCard){
        this.idCard = idCard;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
