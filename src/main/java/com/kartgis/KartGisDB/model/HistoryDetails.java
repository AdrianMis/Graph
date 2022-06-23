package com.kartgis.KartGisDB.model;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HistoryDetails {
    @ManyToOne // ?
    private Job job;
    private LocalDateTime start;
    private LocalDateTime end;
    private Time time; // tego bym raczej nie dodawał ze wzgledu, że można zostawić tylko funkcje getTime

    public Time getTime() {
        // time = start - end
        return time;
    }

    public List<Material> getUsedMaterial()
    {
        List<Material> usedMaterials = job.getMaterials().stream().filter(Material::getIsUsed).collect(Collectors.toList());
        return usedMaterials;
    }
}
