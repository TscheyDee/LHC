package INFRASTRUCTURE.EXPERIMENT;

import INFRASTRUCTURE.EXPERIMENT.REPORT.Report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Experiment {

    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;

    private int[] protonIDs;

    private Block[] blocks;

    private Report report;

    public Experiment() {
        this.uuid = UUID.randomUUID();
        this.protonIDs = new int[2];

        this.blocks = new Block[200000];
        for (int i = 0; i < 200000; i++) {
            this.blocks[i] = new Block();
        }

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        this.dateTimeStamp = (dateFormat.format(new Date()));
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public String toString() {
        String ret = this.isHiggsBosonFound ? "Higgs found" : "NO Higgs found";
        ret += " -- ";
        ret += this.uuid + " - " + this.dateTimeStamp;
        ret += " - Protons: " + Integer.toString(this.protonIDs[0]);
        ret += ", " + Integer.toString(this.protonIDs[1]);
        return ret;
    }

    public Block getBlock(int index) {
        return this.blocks[index];
    }

    public void setHiggsBosonFound() {
        this.isHiggsBosonFound = true;
    }

    public void setProtonIDs(int protonId1, int protonId2) {
        this.protonIDs[0] = protonId1;
        this.protonIDs[1] = protonId2;
    }
}
