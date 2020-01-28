public class SecurityOfficer extends  Employee {

    private boolean hasWeapon;

    public SecurityOfficer(int id, String name, int iris[][], boolean isManager, boolean isMentor, boolean hasBudgetResponsibility, boolean hasWeapon){
        super(id, name, iris, isManager, isMentor, hasBudgetResponsibility);
        this.hasWeapon = hasWeapon;
    }

    public boolean isHasWeapon() {
        return hasWeapon;
    }

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }
}








