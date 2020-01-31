public class Person {

    protected int id;
    protected String name;


    public Person(String name){
        this.id =  getNewId();
        this.name = name;
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

}
