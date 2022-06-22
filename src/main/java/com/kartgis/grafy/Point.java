package com.kartgis.grafy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    private Long id;
    private Set<Path> paths;

    public Point(Long id) {
        this.id = id;
    }
}
