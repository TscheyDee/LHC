public class FingerprintScanner implements IScanner {

    private int[][] currentEmployeeFingerprint;


    public FingerprintScanner(int[][] currentEmployeeFingerprint){
        this.currentEmployeeFingerprint = currentEmployeeFingerprint;
    }

    public void scan(int[][] currentEmployeeFingerprint){
        this.currentEmployeeFingerprint = currentEmployeeFingerprint;
    }

    public int[][] getFingerprint() {
        return currentEmployeeFingerprint;
    }

}
