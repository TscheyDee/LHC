import java.util.Date;

public class IDCardVisitor extends IDCard {

    public IDCardVisitor(String name, Date validFrom, Date validUntil, Chip chip) {
        super(name, validFrom, validUntil, chip);
        getPermissionList().add(Permission.Visitor);
    }

    public IDCardVisitor() {
        super();
    }
}
