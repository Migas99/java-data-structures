package Graphs.HeavyGraph;

import Graphs.Graph.GraphADT;

public interface HeavyGraphADT<T> extends GraphADT<T> {

    void addEdge(T vertex1, T vertex2, T weight);

}
