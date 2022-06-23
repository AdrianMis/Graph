package com.kartgis.KartGisDB.model;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Monter extends Worker {
    @ManyToOne
    private Brigade brigade;
    // Some Additionaly info connected with this type of worker
}
