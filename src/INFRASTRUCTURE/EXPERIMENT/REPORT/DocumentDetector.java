package INFRASTRUCTURE.EXPERIMENT.REPORT;

import java.util.ArrayList;

public class DocumentDetector {

    private ArrayList<IDocumentDetectorListener> listeners;

    public DocumentDetector(){
        this.listeners = new ArrayList<>();
    }

    public void sendMessage(Report report){
        for (IDocumentDetectorListener listner : listeners) {
            listner.documentAdded(report);
        }
    }

    public void addListenerToList(IDocumentDetectorListener listener){
        listeners.add(listener);
    }

    public void removeListenerFromList(IDocumentDetectorListener listener){
        listeners.remove(listener);
    }
}
