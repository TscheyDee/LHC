import com.google.common.eventbus.Subscribe;

public class Ring extends Subscriber {

    private boolean isActvated;
    private Experiment currentExperiment;
    private int energy;

    private Magnet[] magnet = new Magnet[72];
    private Detector detector;
    private ProtonTrap[] protonTrap = new ProtonTrap[2];

    public void activate(){

    }

    public void activate(int initialEnergy){

    }

    public void activateMagnetField(){

    }

    public void releaseProton(){

    }

    public void increaseEnergy(int delta){

    }

    public void collide(Proton proton01, Proton proton02){

    }

    public int decreaseEnergy(){
        return energy--;
    }

    public void shutdown(){

    }

    @Subscribe
    public void receive(RunExperimentFull experimentFull) {

    }

    @Subscribe
    public void receive(RunExperimentPartial experimentPartial) {

    }
}
