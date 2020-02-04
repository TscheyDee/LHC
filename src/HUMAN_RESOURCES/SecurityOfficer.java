package HUMAN_RESOURCES;

public class SecurityOfficer extends Employee {

    private boolean hasWeapon;

    public SecurityOfficer(String name){
        super(name);
    }

    public boolean isHasWeapon() {
        return hasWeapon;
    }

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }
}








