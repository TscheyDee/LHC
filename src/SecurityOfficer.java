public class SecurityOfficer extends  Employee {

    private boolean hasWeapon;

    public SecurityOfficer(String name, int iris[][], boolean isManager,
                           boolean isMentor, boolean hasBudgetResponsibility,
                           IDCardEmployee idCardEmployee){
        super(name, iris, isManager, isMentor, hasBudgetResponsibility, idCardEmployee);
        this.hasWeapon = hasWeapon;
    }

    public boolean isHasWeapon() {
        return hasWeapon;
    }

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }
}








