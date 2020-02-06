package LHC;

import INFRASTRUCTURE.EXPERIMENT.Analyse;
import INFRASTRUCTURE.Configuration;
import INFRASTRUCTURE.EXPERIMENT.Experiment;
import INFRASTRUCTURE.EXPERIMENT.REPORT.Report;
import INFRASTRUCTURE.EXPERIMENT.REPORT.ReportEngine;
import INFRASTRUCTURE.TECHNOLOGY.Reader;
import com.google.common.eventbus.Subscribe;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

public class Detector extends Subscriber implements IDetector {

    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private LinkedList<Experiment> experimentList;
    private Reader reader;

    private Instant start;

    private Method searchString;
    private Object port;

    private ReportEngine reportEngine;

    public Detector(){
        super();
        this.experimentList = new LinkedList<>();
        this.createSearchMethod();
    }

    public void addExperimentToList(Experiment experiment) {
        this.experimentList.add(experiment);

        Report newReport = reportEngine.createReport(experiment);
        experiment.setReport(newReport);
    }

    public Report getReportFromExperiment(Experiment experiment){
        return experiment.getReport();
    }

    public Experiment getExperimentFromReport(Report report){
        return report.getExperiment();
    }

    public void viewExperiments() {
        for(Experiment experiment : this.experimentList) {
            System.out.println(experiment);
        }
    }

    private void createSearchMethod() {
        Object instance;
        try {
            URL[] urls = {new File(Configuration.instance.pathToJar).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Detector.class.getClassLoader());
            Class clazz = Class.forName(Configuration.instance.searchAlgorithm.toString(), true, urlClassLoader);

            instance = clazz.getMethod("getInstance").invoke(null);
            port = clazz.getDeclaredField("port").get(instance);
            searchString = port.getClass().getMethod("search", String.class, String.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(Experiment experiment) {
        for (int i = 0; i < 200000; i++) {
            String hayStack = experiment.getBlock(i).getStructure();
            try {
                int pos = (Integer) this.searchString.invoke(this.port, hayStack, higgsBosonStructure);

                if (pos != -1) {
                    // Analysis time
                    Instant end = Instant.now();
                    long analyseTime = Duration.between(this.start, end).toMillis();

                    experiment.setHiggsBosonFound();

                    System.out.println(experiment + " -  Block-ID: " + Integer.toString(i) + " - "
                            + hayStack + " - Analyse-Time " + Long.toString(analyseTime) + " ms");

                    return;
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
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
        start = Instant.now();
        for(Experiment experiment : this.experimentList) {
            this.search(experiment);
        }
    }
}
