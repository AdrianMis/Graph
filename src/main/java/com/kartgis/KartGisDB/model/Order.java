package com.kartgis.KartGisDB.model;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class Order {
    @ManyToOne
    private Operator Operator;
    @ManyToOne
    private CustomerServiceDepartament fromDepartament;

    @OneToMany(mappedBy = "order")
    private List<Job> jobs;
    private Boolean isComplete;

    public void setComplete()  {
        isComplete = jobs
                .stream()
                .filter(job -> !job.getIsComplete())
                .count() == 0;
    }
}
