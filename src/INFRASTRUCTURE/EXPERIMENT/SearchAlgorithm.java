package INFRASTRUCTURE.EXPERIMENT;

public enum SearchAlgorithm {
    NATIVE("Native"),
    BOYER_MOORE("BoyerMoore"),
    KNUTH_MORRIS_PRATT("KnuthMorrisPratt");

    private String pathName;
    private String name;

    SearchAlgorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return "components/" + name + "/jar/" + name + ".jar";
    }
}
