public class Visitor extends Person {

    private IDCardVisitor idCardVisitor;

    public Visitor(String name, IDCardVisitor idCardVisitor){
        super(name);
        this.idCardVisitor = idCardVisitor;
    }

    public IDCardVisitor getIdCardVisitor() {
        return idCardVisitor;
    }

    public void setIdCardVisitor(IDCardVisitor idCardVisitor) {
        this.idCardVisitor = idCardVisitor;
    }
}
