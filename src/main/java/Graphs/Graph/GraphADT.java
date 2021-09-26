package Graphs.Graph;

import Exceptions.EmptyCollectionException;
import Exceptions.PathNotFoundException;
import Exceptions.VertexNotFoundException;

import java.util.Iterator;

public interface GraphADT<T> {

    void addVertex(T vertex);

    void removeVertex(T vertex);

    void removeEdge(T vertex1, T vertex2);

    Iterator<T> iteratorBFS(T startVertex) throws EmptyCollectionException;

    Iterator<T> iteratorDFS(T startVertex) throws EmptyCollectionException;

    Iterator<T> iteratorShortestPath(T startVertex, T targetVertex)
            throws EmptyCollectionException, VertexNotFoundException, PathNotFoundException;

    boolean isEmpty();

    boolean isConnected() throws EmptyCollectionException;

    int size();

}
