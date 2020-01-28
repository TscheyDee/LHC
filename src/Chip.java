public class Chip {

    private String password = "helloLHC2020";
    private IDCard idCard;

    public Chip(String password, IDCard idCard) {
        this.password = password;
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}