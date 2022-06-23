package com.kartgis.grafy;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//@SpringBootApplication
public class GrafyApplication {

    public static void main(String[] args) {
        //SpringApplication.run(GrafyApplication.class, args);

        //DATA

        Point point1 = new Point(1L);
        Point point2 = new Point(2L);
        Point point3 = new Point(3L);
        Point point4 = new Point(4L);
        Point point5 = new Point(5L);
        Point point6 = new Point(6L);
        Point point7 = new Point(7L);
        Point point8 = new Point(8L);
        Point point9 = new Point(9L);
        Point point10 = new Point(10L);
        Point point11 = new Point(11L);
        Point point12 = new Point(12L);
        Point point13 = new Point(13L);
        Point point14 = new Point(14L);

        Path path1 = new Path(point1,point8);
        Path path2 = new Path(point1,point10);
        Path path3 = new Path(point1,point12);

        Path path4 = new Path(point10,point11);
        Path path5 = new Path(point10,point9);

        Path path6 = new Path(point11,point2);
        Path path7 = new Path(point2,point9);
        Path path8 = new Path(point9,point13);

        Path path9 = new Path(point13,point3);
        Path path10 = new Path(point3,point4);
        Path path11 = new Path(point4,point5);
        Path path12 = new Path(point4,point8);
        Path path13 = new Path(point8,point7);
        Path path14 = new Path(point7,point6);

        point1.setPaths(ImmutableSet.of(path1,path2,path3));
        point2.setPaths(ImmutableSet.of(path6,path7));
        point3.setPaths(ImmutableSet.of(path9,path10));
        point4.setPaths(ImmutableSet.of(path10,path11,path12));
        point5.setPaths(ImmutableSet.of(path11));
        point6.setPaths(ImmutableSet.of(path14));
        point7.setPaths(ImmutableSet.of(path13,path14));
        point8.setPaths(ImmutableSet.of(path1,path12,path13));
        point9.setPaths(ImmutableSet.of(path5,path7,path8));
        point10.setPaths(ImmutableSet.of(path2,path4,path5));
        point11.setPaths(ImmutableSet.of(path6,path4));
        point12.setPaths(ImmutableSet.of(path3));
        point13.setPaths(ImmutableSet.of(path8,path9));
        point14.setPaths(ImmutableSet.of());

        //WHEN
        Set<Point> points = new HashSet<>(Arrays.asList(point1,point2,point3,point4,point5,point6,point7,point8,point9,point10,point11,point12,point13,point14));
        Graph graph = new Graph(1L,points);
        GraphService graphService = new GraphService();


        //THEN
        sout("BEFORE:",graphService);
        graphService.depthFirstSearch(graph);
        sout("AFTER:",graphService);

    }

    private static void sout(String status, GraphService graphService){
        System.out.println(status);
        System.out.println("visited");
        graphService.getVisitedPoints().forEach(p -> System.out.println(p.getId()));
        System.out.println("unvisited");
        graphService.getUnvisitedPoints().forEach(p -> System.out.println(p.getId()));
    }

}
