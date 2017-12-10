package io.roberthernandez;

import io.roberthernandez.Graph;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class GraphTest {
    @Test
    public void CreateGraphTest() {
        int vertices = 2;
        Graph graph = new Graph(2);
        assertEquals(vertices, graph.getNumVertices());
    }

    @Test
    public void GetEdgeNeighborTest() {
        int vertices = 2;
        Graph graph = new Graph(vertices);
        graph.addEdge(1, 2);
        ArrayList<Integer> neighbours = graph.getNeighbours(1);
        String value = neighbours.get(0).toString();
        int valueAsInt = Integer.parseInt(value);
        assertEquals(valueAsInt, 2);
    }
}
