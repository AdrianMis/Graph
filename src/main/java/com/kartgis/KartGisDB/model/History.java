package com.kartgis.KartGisDB.model;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class History {
    @OneToMany(mappedBy = "serviceClaimSettlement")
    private List<HistoryDetails> historyDetailsList;
    @OneToOne
    private Order order;
}
