public class FingerprintChip {
    private int[][] fingerprint;
    private IDCard idCard;

    public FingerprintChip(int[][] fingerprint, IDCard idCard){
        this.fingerprint = fingerprint;
        this.idCard = idCard;
    }

    public int[][] getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(int[][] fingerprint) {
        this.fingerprint = fingerprint;
    }
}
