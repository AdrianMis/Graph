package com.kartgis.grafy;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class Path {
    private Long id;
    private Point start;
    private Point end;
    private ImmutableSet<Point> verticles;

    public Path (Point start, Point end){
        this.start = start;
        this.end = end;
    }

    public Set<Point> getVerticles() {
        verticles = ImmutableSet.of(start,end);
        return verticles;
    }
}
