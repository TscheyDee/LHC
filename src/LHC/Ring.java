package LHC;

import INFRASTRUCTURE.EXPERIMENT.Experiment;
import INFRASTRUCTURE.EXPERIMENT.RunExperimentFull;
import INFRASTRUCTURE.EXPERIMENT.RunExperimentPartial;
import com.google.common.eventbus.Subscribe;

public class Ring extends Subscriber {

    private boolean isActvated;
    private Experiment currentExperiment;
    private int energy;

    private Magnet[] magnet = new Magnet[72];
    private Detector detector;
    private ProtonTrap[] protonTrap = new ProtonTrap[2];

    public Ring() {
        this.energy = 0;
    }

    public void activate(){
        for (int i = 0; i < magnet.length; i++) {
            magnet[i] = new Magnet(true, MagnetDirection.N, energy, this);
        }
    }

    public void activate(int initialEnergy){
        this.energy = initialEnergy;
    }

    public void activateMagnetField(){

    }

    public void releaseProton(){

    }

    public void increaseEnergy(int delta){
        this.energy += delta;
    }

    public void collide(Proton proton01, Proton proton02){
        currentExperiment.getBlocks();
    }

    public int decreaseEnergy(){
        return energy-=5;
    }

    public void shutdown(){

    }

    @Subscribe
    public void receive(RunExperimentFull experimentFull) {

    }

    @Subscribe
    public void receive(RunExperimentPartial experimentPartial) {
        // Only the first n-th Protons collide!
    }
}
