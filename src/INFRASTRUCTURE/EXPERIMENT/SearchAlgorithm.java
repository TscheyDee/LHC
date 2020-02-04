package INFRASTRUCTURE.EXPERIMENT;

public enum SearchAlgorithm {
    NATIVE("LHC_Native", "Native"),
    BOYER_MOORE("LHC_BoyerMoore", "BoyerMoore"),
    KNUTH_MORRIS_PRATT("LHC_KnuthMorrisPratt", "KnuthMorrisPratt");

    private String path;
    private String name;

    SearchAlgorithm(String path, String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return path + name + ".jar";
    }
}
