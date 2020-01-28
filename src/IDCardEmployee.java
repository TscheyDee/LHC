import java.util.ArrayList;
import java.util.Date;

public class IDCardEmployee extends IDCard {

    private Chip secondChip;
    private int[][] irisStructure;

    public IDCardEmployee(String name, Date validFrom, Date validUntil,
                          int[][] irisStructure, Chip chip, Chip secondChip){
        super(name, validFrom, validUntil, chip);
        getPermissionList().add(Permission.Visitor);
        this.irisStructure = irisStructure;
        this.secondChip = secondChip;
    }

    public Chip getSecondChipChip() {
        return secondChip;
    }

    public void setSecondChip(Chip secondChip) {
        this.secondChip = secondChip;
    }

    public int[][] getIrisStructure() {
        return irisStructure;
    }

    public void setIrisStructure(int[][] irisStructure) {
        this.irisStructure = irisStructure;
    }

}
