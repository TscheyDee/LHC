public class Person {

    protected int id;
    protected String name;
    protected int iris[][] = new int[10][10];


    public Person(String name, int iris[][]){
        this.id =  getNewId();
        this.name = name;
        this.iris = iris;
    }

    public int getNewId() {
        return (int)(Math.random() * (99999-10000) + 10000);
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
}
