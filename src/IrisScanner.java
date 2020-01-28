public class IrisScanner implements IScanner{

    //private String currentEmployeeIris;
    private int[][] currentEmployeeIris;


    public IrisScanner(int[][] currentEmployeeIris){
        this.currentEmployeeIris = currentEmployeeIris;
    }

    public void scan(){

    }

    //public String scanIris(Employee employee){
    //    int[][] iris =  employee.getIris();
    //
    //    return "";
    //}

    public int[][] getIris() {
        return currentEmployeeIris;
    }

    public void scanIris(int[][] currentEmployeeIris) {
        this.currentEmployeeIris = currentEmployeeIris;
    }

}
