package LHC;

public class Proton {
    private int id;
    private double weigth;
    private int[][][] structure;

    public Proton(int id, int[][][] structure) {
        this.id = id;
        this.structure = structure;
    }

    public int getID() {
        return this.id;
    }

    public int[][][] getStructure() {
        return this.structure;
    }
}
