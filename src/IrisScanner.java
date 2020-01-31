public class IrisScanner implements IScanner{

    private int[][] currentEmployeeIris;


    public IrisScanner(int[][] currentEmployeeIris){
        this.currentEmployeeIris = currentEmployeeIris;
    }

    public void scan(int[][] currentEmployeeIris){
        this.currentEmployeeIris = currentEmployeeIris;
    }

    public int[][] getIris() {
        return currentEmployeeIris;
    }

}
