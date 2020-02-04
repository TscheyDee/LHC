package INFRASTRUCTURE;

public class Workplace {

    ResearchGroup researchGroup;

    public Workplace(ResearchGroup researchGroup){
        this.researchGroup = researchGroup;
    }

    public ResearchGroup getResearchGroup() {
        return researchGroup;
    }

    public void setResearchGroup(ResearchGroup researchGroup) {
        this.researchGroup = researchGroup;
    }
}
