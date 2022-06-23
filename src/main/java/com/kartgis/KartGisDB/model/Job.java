package com.kartgis.KartGisDB.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Job extends BaseEntity{
    @ManyToOne
    private Order order;
    private LocalDateTime startTerm;
    private LocalDateTime endOfWork;
    @OneToMany
    private List<Material> materials;
    private Boolean isComplete;
    @ManyToOne
    private Brigade brigade;

    @OneToMany(mappedBy = "job")
    private List<HistoryDetails> historyDetailsList; // Lista ponieważ praca może zostać przerwana i w takim przypadku będziemy mieć 2 lub więcej historyDetails dla pracy.

    public Time getFullTimeOfJob(){
        // return historyDetailsList.forEach.( +detail.getTime) // w ten sposób powinniśmy dostać całościowy czas pracy nawet jeśli pracowało przy robocie wiele brygad nazmiennie.
        return null;
    }
}
