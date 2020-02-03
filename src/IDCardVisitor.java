import java.util.Date;

public class IDCardVisitor extends IDCard {

    public IDCardVisitor(String name, Date validFrom, Date validUntil) {
        super(name, validFrom, validUntil);
        getPermissionList().add(Permission.Visitor);
    }

    public IDCardVisitor() {
        super();
    }
}
