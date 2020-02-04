package INFRASTRUCTURE.MANAGEMENT;

import HUMAN_RESOURCES.Employee;
import HUMAN_RESOURCES.Visitor;
import INFRASTRUCTURE.SECURITY.MD5CryptoUtilities;
import INFRASTRUCTURE.TECHNOLOGY.ReaderTouchpad;
import INFRASTRUCTURE.TECHNOLOGY.Writer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public enum CardManagement implements ICardManagement {
    instance;

    private HashMap<Integer, IDCard> idCardHashMap;
    private ReaderTouchpad touchpadReader;
    private Writer writer;


    public void createIDCard(Employee employee, int[][] iris, String fingerprint, IDCard idCard) {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        Date nextYear = cal.getTime();

        int[][] newIris = touchpadReader.scanIris(employee);

        IDCardEmployee idCardEmployee = new IDCardEmployee(
                employee.getName(), today, nextYear, newIris);

        String password = "helloLHC2020";
        writeDataAES(idCardEmployee, password);

        writeDataMD5(idCardEmployee, employee.getName());

        employee.setIdCardEmployee(idCardEmployee);
    }

    public void createIDCard(Visitor visitor, IDCard idCard, String password){
        idCard.setName(visitor.getName());

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        Date nextYear = cal.getTime();

        IDCardVisitor idCardVisitor = new IDCardVisitor(
                visitor.getName(), today, nextYear);

        String newPassword = touchpadReader.setPassword(password);
        writeDataAES(idCardVisitor, newPassword);

        visitor.setIdCardVisitor(idCardVisitor);
    }

    public void changePassword(IDCard idCard, String oldPassword, String newPassword){
        if(verifyPassword(idCard, oldPassword)){
            writeDataAES(idCard, newPassword);
        }
        else{
            System.out.println("---Invalid ID card verification!");
        }
    }

    public boolean verifyPassword(IDCard idCard, String enteredPassword) {
        String enteredPIN = touchpadReader.setPassword(enteredPassword);
        String password = idCard.getChip().getData();
        password = touchpadReader.decryptPassword(password);

        return (enteredPIN == password);
    }

    public boolean verifyFingerprint(IDCardEmployee idCard, String scannedFinerprint) {
        String cardFingerprint = idCard.getFingerprintChip().getData();
        scannedFinerprint = MD5CryptoUtilities.instance.generate(scannedFinerprint);

        return (scannedFinerprint == cardFingerprint);
    }

    public boolean verifyIris(Employee employee) {
        int[][] iris = touchpadReader.scanIris(employee);
        int[][] cardIris = employee.getIdCardEmployee().getIrisStructure();

        return (iris == cardIris);
    }

    public void lockIDCard(IDCard idCard){
        idCard.setLocked(true);
    }

    public void clearIDCard(IDCard idCard){
        idCard.setLocked(false);
    }

    public boolean validDate(IDCard idCard){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date today = new Date();
        simpleDateFormat.format(today);

        Date until = idCard.getValidUntil();
        simpleDateFormat.format(until);

        if(today.compareTo(until) > 0) {
            System.out.println("Date 1 occurs after Date 2");
            return false;

        } else if(today.compareTo(until) < 0) {
            System.out.println("Date 1 occurs before Date 2");
            return true;

        } else { //if(today.compareTo(until) == 0) {
            System.out.println("Both dates are equal");
            return false;
        }
    }

    public void writeDataAES(IDCard idCard, String data){
        writer.setIdCard(idCard);
        writer.writeWithAES(data);
        writer.removeIDCard();
    }

    public void writeDataMD5(IDCard idCard, String data){
        writer.setIdCard(idCard);
        writer.writeWithMD5(data);
        writer.removeIDCard();
    }
}
