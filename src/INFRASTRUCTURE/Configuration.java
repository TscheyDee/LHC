package INFRASTRUCTURE;

import INFRASTRUCTURE.EXPERIMENT.SearchAlgorithm;
import INFRASTRUCTURE.SECURITY.Keystore;

public enum Configuration {
    instance;
    public String AESKey = "7z4kL481";
    public SearchAlgorithm searchAlgorithm = SearchAlgorithm.NATIVE;

    public String protonData = System.getProperty("user.dir") + "/data/";

    private String dir = System.getProperty("user.dir") + "/";
    public String pathToJar = dir + searchAlgorithm.getPath();

    public String getSearchAlgorithmPath() {
        return pathToJar;
    }
}
