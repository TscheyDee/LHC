package INFRASTRUCTURE.TECHNOLOGY;

import INFRASTRUCTURE.MANAGEMENT.IDCardEmployee;
import INFRASTRUCTURE.MANAGEMENT.IDCardVisitor;

public interface IReader {

    public void insertCard(IDCardVisitor idCard,
                           IReaderTechnology iReaderTechnology);

    public void insertCard(IDCardEmployee idCard,
                           IReaderTechnology iReaderTechnology);

    public void removeIDCard();

}
