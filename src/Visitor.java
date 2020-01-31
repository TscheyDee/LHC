public class Visitor extends Person {

    private IDCardVisitor idCardVisitor;

    public Visitor(int id, String name, int iris[][], IDCardVisitor idCardVisitor){
        super(id, name, iris);
        this.idCardVisitor = idCardVisitor;
    }

    public IDCardVisitor getIdCardVisitor() {
        return idCardVisitor;
    }

    public void setIdCardVisitor(IDCardVisitor idCardVisitor) {
        this.idCardVisitor = idCardVisitor;
    }
}
