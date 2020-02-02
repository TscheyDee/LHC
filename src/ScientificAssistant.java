import java.util.Date;

public class ScientificAssistant extends Employee {

    private Date periodFrom;
    private Date periodUntil;

    public ScientificAssistant(String name, int iris[][], boolean isManager,
                               boolean isMentor, boolean hasBudgetResponsibility,
                               IDCardEmployee idCardEmployee){
        super(name, iris, isManager, isMentor, hasBudgetResponsibility, idCardEmployee);
        this.periodFrom = periodFrom;
        this.periodUntil = periodUntil;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Date getPeriodUntil(){
        return periodUntil;
    }

    public void setPeriodUntil(Date periodUntil) {
        this.periodUntil = periodUntil;
    }
}
