package INFRASTRUCTURE.EXPERIMENT;

import INFRASTRUCTURE.EXPERIMENT.Experiment;

import java.util.UUID;

public class Block {

    private UUID uuid;
    private String structure;
    private Experiment experiment;

    public Block(UUID uuid, String structure, Experiment experiment){
        this.uuid = uuid;
        this.structure = structure;
        this.experiment = experiment;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getStructure() {
        return structure;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }
}
