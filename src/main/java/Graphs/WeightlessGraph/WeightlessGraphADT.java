package Graphs.WeightlessGraph;

import Graphs.Graph.GraphADT;

public interface WeightlessGraphADT<T> extends GraphADT<T> {

    void addEdge(T vertex1, T vertex2);

}
