public class Person {

    protected int id;
    protected String name;
    protected int iris[][] = new int[10][10];
    protected IDCard idCard;


    public Person(int id, String name, int iris[][]){
        this.id = id;
        this.name = name;
        this.iris = iris;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getIris() {
        return iris;
    }

    public void setIris(int[][] iris) {
        this.iris = iris;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
}
