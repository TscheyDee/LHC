public class Magnet {

    private boolean isActivated;
    private MagnetDirection magnetDirection;
    private int fieldStrength;

    private Ring ring;


    public Magnet(boolean isActivated, MagnetDirection magnetDirection, int fieldStrength, Ring ring){
        this.isActivated = isActivated;
        this.magnetDirection = magnetDirection;
        this.fieldStrength = fieldStrength;
        this.ring = ring;
    }

    public void activate(){
        isActivated = true;
    }

    public void deactivate(){
        isActivated = false;
    }

}
