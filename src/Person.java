public class Person {

    protected int id;
    protected String name;
    protected int iris[][] = new int[10][10];


    public Person(String name){
        this.id =  getNewId();
        this.name = name;
        this.iris = generateIris();
    }

    public int getNewId() {
        return (int)(Math.random() * (99999-10000) + 10000);
    }

    public int[][] generateIris(){
        int[][] generatedIris = new int[10][10];

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                generatedIris[i][j] = (int)(Math.random() * (9-1) + 1);
            }
        }

        return generatedIris;
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
