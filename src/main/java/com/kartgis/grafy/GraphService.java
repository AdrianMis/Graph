package com.kartgis.grafy;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class GraphService {
    private Set<Point> unvisitedPoints;
    private Set<Point> visitedPoints;

    public void depthFirstSearch(Graph graph) {
        this.unvisitedPoints = graph.getPoints();
        this.visitedPoints = new HashSet<>();

        while (true){
            if (unvisitedPoints.isEmpty()) {
                return;
            }
            Point currentPoint = unvisitedPoints.stream().findFirst().get();
            visitPoint(currentPoint);

            visitAllConnectedPoints(currentPoint);
        }
    }

    public void searchByDFS(Graph graph, Point starter, Point end){
        this.unvisitedPoints = graph.getPoints();
        this.visitedPoints = new HashSet<>();

        visitPoint(starter);
        visitAllConnectedPoints(starter);
        while (true){
            if (unvisitedPoints.isEmpty()) {
                return;
            }
            Point currentPoint = unvisitedPoints.stream().findFirst().get();
            visitPoint(currentPoint);

            visitAllConnectedPoints(currentPoint);
        }
    }

    private void visitAllConnectedPoints(Point currentPoint) {
        List<Point> listOfPoints = currentPoint.getPaths()
                .stream()
                .map(path -> findNextElement(currentPoint, path))
                .filter(nextPoint -> !visitedPoints.contains(nextPoint)).collect(Collectors.toList());

        listOfPoints.forEach(this::visitPoint);
        listOfPoints.forEach(point -> visitAllConnectedPoints(point));
    }

    private Point findNextElement(Point currentPoint, Path path) {
        return path.getVerticles()
                .stream()
                .filter(point -> !point.getId().equals(currentPoint.getId()))
                .findFirst().get();
    }

    private void visitPoint(Point currentPoint) {
        visitedPoints.add(currentPoint);
        System.out.println("Point with id:"+currentPoint.getId()+" is visited");
        unvisitedPoints.remove(currentPoint);
    }
}
