package INFRASTRUCTURE.MANAGEMENT;

import INFRASTRUCTURE.SECURITY.Permission;
import INFRASTRUCTURE.TECHNOLOGY.Chip;

import java.util.Date;

public class IDCardEmployee extends IDCard {

    private Chip secondChip;
    private int[][] irisStructure;

    public IDCardEmployee(String name, Date validFrom, Date validUntil,
                          int[][] irisStructure){
        super(name, validFrom, validUntil);
        getPermissionList().add(Permission.Visitor);
        this.irisStructure = irisStructure;
    }

    public IDCardEmployee() {
        super();
    }

    public Chip getFingerprintChip() {
        return secondChip;
    }

    public void setFingerprintChipChip(Chip secondChip) {
        this.secondChip = secondChip;
    }

    public int[][] getIrisStructure() {
        return irisStructure;
    }

    public void setIrisStructure(int[][] irisStructure) {
        this.irisStructure = irisStructure;
    }

}
