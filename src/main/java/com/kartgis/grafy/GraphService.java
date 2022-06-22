package com.kartgis.grafy;

import java.util.List;
import java.util.stream.Collectors;

public class GraphService {

    public void breadthFirstSearch(Graph graph) {

        while (true){
            if (graph.getUnvisitedPoints().isEmpty()) {
                return;
            }
            Point currentPoint = graph.getUnvisitedPoints().stream().findFirst().get();
            visitPoint(graph, currentPoint);

            visitAllConnectedPoints(graph, currentPoint);
        }

    }

    private void visitAllConnectedPoints(Graph graph, Point currentPoint) {
        List<Point> listOfPoints = currentPoint.getPaths()
                .stream()
                .map(path -> findNextElement(currentPoint, path))
                .filter(nextPoint -> {
                    if (graph.getVisitedPoints().contains(nextPoint)) {
                        return false;
                    }
                    visitPoint(graph, nextPoint);
                    return true;
                })
                .collect(Collectors.toList());

        listOfPoints.forEach(point -> visitAllConnectedPoints(graph,point));
    }

    private Point findNextElement(Point currentPoint, Path path) {
        return path.getVerticles()
                .stream()
                .filter(point -> !point.getId().equals(currentPoint.getId()))
                .findFirst().get();
    }

    private void visitPoint(Graph graph, Point currentPoint) {
        graph.getVisitedPoints().add(currentPoint);
        System.out.println("Point with id:"+currentPoint.getId()+" is visited");
        graph.getUnvisitedPoints().remove(currentPoint);
    }
}
