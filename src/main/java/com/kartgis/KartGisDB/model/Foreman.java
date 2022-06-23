package com.kartgis.KartGisDB.model;

import javax.persistence.OneToOne;

//Brygadzista
public class Foreman extends BaseEntity{

    @OneToOne
    private Brigade brigade;
    // Some Additionaly info connected with this type of worker
}
