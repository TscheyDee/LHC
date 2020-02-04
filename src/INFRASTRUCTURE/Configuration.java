package INFRASTRUCTURE;

import INFRASTRUCTURE.EXPERIMENT.SearchAlgorithm;
import INFRASTRUCTURE.SECURITY.Keystore;

public class Configuration {

    public final static SearchAlgorithm searchAlgorithm = SearchAlgorithm.NATIVE;

    public final static String cryptKey = Keystore.KEY_1.getName();
}
