package com.kartgis.KartGisDB.model;

import javax.persistence.OneToMany;
import java.util.List;

public class CustomerServiceDepartament extends BaseEntity {
    @OneToMany(mappedBy = "fromDepartament")
    private List<Order> orderList;
}
