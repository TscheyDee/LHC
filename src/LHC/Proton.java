package LHC;

public class Proton {

    private double weigth;
    private int[][][] structure = new int[100][100][100];

    public Proton(double weigth, int[][][] structure) {
        this.weigth = weigth;
        this.structure = structure;
    }
}
