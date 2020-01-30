public interface IReader {

    public boolean insertCard(IDCardVisitor idCard,
                              IReaderTechnology iReaderTechnology,
                              String password);

    public boolean insertCard(IDCardEmployee idCard,
                              IReaderTechnology iReaderTechnology,
                              String password, int[][] iris);

    public void removeIDCard();

    //

}
