import java.util.ArrayList;
import java.util.UUID;

public class Experiment {

    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;
    private ArrayList<Block> blocks;

    public Experiment(UUID uuid, String dateTimeStamp, boolean isHiggsBosonFound){
        this.uuid = uuid;
        this.dateTimeStamp = dateTimeStamp;
        this.isHiggsBosonFound = isHiggsBosonFound;
    }

    public void initExperiment() {
        blocks = new ArrayList<>();

    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(String dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public boolean isHiggsBosonFound() {
        return isHiggsBosonFound;
    }

    public void setHiggsBosonFound(boolean higgsBosonFound) {
        isHiggsBosonFound = higgsBosonFound;
    }
}
