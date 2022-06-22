package com.kartgis.grafy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class Graph {
    private Long id;
    private Set<Point> unvisitedPoints;
    private Set<Point> visitedPoints;
}
