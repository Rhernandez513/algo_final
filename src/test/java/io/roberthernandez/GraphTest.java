package io.roberthernandez;

import io.roberthernandez.Graph;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;


public class GraphTest {
    @Test
    public void CreateGraphTest() {
        int vertices = 2;
        Graph graph = new Graph(2);
        assertEquals(vertices, graph.getNumVertices());
    }

//    @Test
//    public void addEdgeTest() {
//        int vertices = 2;
//        Graph graph = new Graph(vertices);
//        graph.addEdge(1, 2);
//        // System.out.println(graph.getNeighbours(1));
//
//        assertEquals(graph.getNeighbours(1), 2);
//    }
}
