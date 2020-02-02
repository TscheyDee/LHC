public class Application {

    public void main(String[] args){
        UseCase1();
    }

    public static void UseCase1(){
        SecurityCenter.instance.addBlankIDCard();

        IrisScanner scanner = new IrisScanner();
        scanner.scan();


        SecurityCenter.instance.createNewIDCard();

        Reception.instance.addBlankIDCard();

    }

    public static void UseCase2(){

    }

    public static void UseCase3(){

    }

    public static void UseCase4(){

    }

    public static void UseCase5(){

    }

    public static void UseCase6(){

    }
}
