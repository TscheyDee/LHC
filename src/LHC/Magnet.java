package LHC;

public class Magnet {

    private boolean isActivated;
    private MagnetDirection magnetDirection;
    private int fieldStrength;


    public Magnet(){
        this.magnetDirection = MagnetDirection.N;
        this.fieldStrength = 1;
        this.isActivated = false;
    }

    public void activate(){
        isActivated = true;
    }

    public void deactivate(){
        isActivated = false;
    }

}
