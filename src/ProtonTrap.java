import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProtonTrap {

    private ProtonTrapID id;
    private Proton[] protons = new Proton[100];

    public ProtonTrap(ProtonTrapID id, Proton[] protons) {
        this.id = id;
        this.protons = protons;
    }

    public void loadData(String dataFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("proton.txt"));
        StringBuilder builder = new StringBuilder();

        String str;
        while((str = reader.readLine()) != null) {
            builder.append(str);
        }

        String protonData = builder.toString();
    }

    public void release(){

    }
}
