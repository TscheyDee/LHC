public abstract class CryptogrpahyManagement {

    protected final String key = Configuration.cryptKey;

    public abstract String encrypt(String password, String key);

    public abstract String decrypt(String password, String key);

    public String getKey() {
        return key;
    }
}
