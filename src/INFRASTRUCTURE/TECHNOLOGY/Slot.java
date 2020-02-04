package INFRASTRUCTURE.TECHNOLOGY;

import INFRASTRUCTURE.MANAGEMENT.IDCard;

public class Slot implements IReaderTechnology {

    private IDCard idCard;

    public Slot(){
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
