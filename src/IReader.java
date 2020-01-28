public interface IReader {

    public boolean insertCard(IDCardVisitor idCard, IReaderTechnology iReaderTechnology);

    public boolean insertCard(IDCardEmployee idCard, IReaderTechnology iReaderTechnology);

    public void removeIDCard();

}
