import java.util.ArrayList;
import java.util.Date;

public abstract class IDCard {

    private String id;
    private String name;
    private Date validFrom;
    private Date validUntil;

    private ArrayList<Permission> permissionList;
    private boolean isLocked;

    private Chip chip;

    public IDCard(String name, Date validFrom, Date validUntil) {
        this.id = getNewId();
        this.name = name;
        this.validFrom = validFrom;
        this.validUntil = validUntil;

        this.permissionList.add(Permission.Visitor);

        //this.chip = chip;
        this.isLocked = false;
    }

    public IDCard() {                    //blank id card
        this.id = getNewId();
        this.name = "";
        this.validFrom = null;
        this.validUntil = null;

        this.permissionList.add(Permission.Visitor);
        //this.chip = null;
        this.isLocked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewId() {
        return "ID-" + Math.random() * 100000 + 10000;
    }

    public String getId() {
        return id;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public ArrayList<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(ArrayList<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }
}
