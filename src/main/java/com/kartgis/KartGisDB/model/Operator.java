package com.kartgis.KartGisDB.model;

import javax.persistence.OneToMany;
import java.util.List;

public class Operator {
    @OneToMany(mappedBy = "operator")
    private List<Order> orderList;
}
