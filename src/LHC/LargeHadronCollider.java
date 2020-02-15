package LHC;

import INFRASTRUCTURE.Building;
import INFRASTRUCTURE.ENERGY.USP;

public class LargeHadronCollider {

    private Building building;
    private USP[] usp = new USP[2];
    private Ring ring;

    public LargeHadronCollider(Building building, USP[] usp, Ring ring){
        this.building = building;
        this.usp = usp;
        this.ring = ring;
    }

    public Building getBuilding() {
        return building;
    }

    public USP[] getUsp() {
        return usp;
    }

    public Ring getRing() {
        return ring;
    }
}
