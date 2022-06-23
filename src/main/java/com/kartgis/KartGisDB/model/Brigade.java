package com.kartgis.KartGisDB.model;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Queue;

public class Brigade {
    private Queue<Job> jobs;// ewentualnie list/set. Wybór podjąłbym ze względu na logike biznesową
    @OneToOne
    private Foreman foreman;
    @OneToMany(mappedBy = "brigade")
    private List<Monter> monters;
}
