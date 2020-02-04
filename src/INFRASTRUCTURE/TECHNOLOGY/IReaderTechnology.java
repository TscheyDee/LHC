package INFRASTRUCTURE.TECHNOLOGY;

import INFRASTRUCTURE.MANAGEMENT.IDCard;

public interface IReaderTechnology {

    public void detectIDCard(IDCard idCard);

    public IDCard getIDCard();

}
