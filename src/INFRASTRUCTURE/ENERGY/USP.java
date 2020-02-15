package INFRASTRUCTURE.ENERGY;

public class USP {

    private boolean isStandBy;
    private boolean isActivated;
    private Battery[] batteries;


    public USP(){
        this.isStandBy = false;
        this.isActivated = false;
        this.batteries = new Battery[25];

        for(int i=0; i<25; i++){
            batteries[i] = new Battery();
        }
    }

    public void determineChargeState(){

    }

    public void charge(ThreePinPlug plug){

    }

    public int takeOut(){
        return 0;
    }
}
