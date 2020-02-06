package INFRASTRUCTURE.EXPERIMENT;

public class RunExperimentFull {
    private int initialEnergy;

    public RunExperimentFull(int initialEnergy) {
        if (initialEnergy != 25 && initialEnergy != 50 && initialEnergy != 100)
            this.initialEnergy = 25000;
        else
            this.initialEnergy = initialEnergy * 1000;
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }
}
