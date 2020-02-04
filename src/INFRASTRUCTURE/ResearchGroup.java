package INFRASTRUCTURE;

import HUMAN_RESOURCES.Researcher;
import HUMAN_RESOURCES.ScientificAssistant;

public class ResearchGroup {

    Researcher[] researcher = new Researcher[3];
    ScientificAssistant[] scientificAssistant = new ScientificAssistant[2];

    public ResearchGroup(Researcher[] researcher, ScientificAssistant[] scientificAssistant, Workplace workplace){
        this.researcher = researcher;
        this.scientificAssistant = scientificAssistant;
    }

    public Researcher[] getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher[] researcher) {
        this.researcher = researcher;
    }

    public ScientificAssistant[] getScientificAssistant() {
        return scientificAssistant;
    }

    public void setScientificAssistant(ScientificAssistant[] scientificAssistant) {
        this.scientificAssistant = scientificAssistant;
    }
}
