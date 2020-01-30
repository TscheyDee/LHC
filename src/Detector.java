import com.google.common.eventbus.Subscribe;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;

public class Detector extends Subscriber implements IDetector {

    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private LinkedList<Experiment> experimentList;
    private Reader reader;

    public Detector(boolean isActivated, LinkedList<Experiment> experimentList, Reader reader){
        this.higgsBosonStructure = this.higgsBosonStructure;
        this.isActivated = isActivated;
        this.experimentList = experimentList;
        this.reader = reader;
    }

    public void search(Experiment experiment) {
        String searchString = experiment.toString();

        String jarName = Configuration.searchAlgorithm.getName() + ".jar";

        Class<?> clazz = null;
        Object instance = null;
        Object port = null;


        // Hier muss nochgeändert werden: ALle auf die neue Architektur anwenden, Hierfür den Enum verwenden: Enum.name + ".jar"
        /*String fileSeparator = System.getProperty("file.separator");
        String userDirectory = System.getProperty("user.dir");
        String typeOfMemoryStick = "02";
        String nameOfSubFolder = "exchange_component_" + typeOfMemoryStick + fileSeparator + "jar";
        String nameOfJavaArchive = "MemoryStick.jar";
        String subFolderPathOfJavaArchive = nameOfSubFolder + fileSeparator + nameOfJavaArchive;
        String fullPathToJavaArchive = userDirectory + subFolderPathOfJavaArchive;
        String nameOfClass = "MemoryStick";*/

        String nameOfClass = Configuration.searchAlgorithm.getName();
        String subFolderPathOfJavaArchive = Configuration.searchAlgorithm.getPath();

        System.out.println("--- SearchConfiguration");
        System.out.println("subFolderPathOfJavaArchive : " + subFolderPathOfJavaArchive);
        System.out.println("nameOfClass                : " + nameOfClass);
        System.out.println();


        System.out.println("--- loadClazzFromJavaArchive");
        try {
            URL[] urls = {new File(subFolderPathOfJavaArchive).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Detector.class.getClassLoader());
            clazz = Class.forName(nameOfClass, true, urlClassLoader);
            System.out.println("class    : " + clazz.toString() + " - " + clazz.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("--- provideInstanceOfClass");
        try {
            instance = clazz.getMethod("getInstance").invoke(null);
            System.out.println("instance : " + instance.toString() + " - " + instance.hashCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("--- provideComponentPort");
        try {
            port = clazz.getDeclaredField("port").get(instance);
            System.out.println("port     : " + port.toString() + " - " + port.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("--- executeSearchMethodUsingPort");
        try {
            Method method = port.getClass().getMethod("search", String.class, String.class);
            System.out.println(method);

            int result = (int) method.invoke(port, searchString, higgsBosonStructure);
            System.out.println("result   : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public LinkedList<Experiment> getExperimentList() {
        return experimentList;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Subscribe
    public void receive(Analyse analyse) {

    }
}
