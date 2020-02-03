public class Visitor extends Person {

    private IDCardVisitor idCardVisitor;

    public Visitor(String name){
        super(name);
    }

    public IDCardVisitor getIdCardVisitor() {
        return idCardVisitor;
    }

    public void setIdCardVisitor(IDCardVisitor idCardVisitor) {
        this.idCardVisitor = idCardVisitor;
    }
}
