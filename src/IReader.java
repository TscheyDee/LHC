public interface IReader {

    public void insertCard(IDCardVisitor idCard,
                              IReaderTechnology iReaderTechnology);

    public void insertCard(IDCardEmployee idCard,
                              IReaderTechnology iReaderTechnology);

    public void removeIDCard();

}
