package Maps.Map;

import java.util.Iterator;

public interface MapADT<K, V> {

    void put(K key, V value);

    V remove(K key);

    V get(K key);

    V get(K key, V defaultValue);

    Iterator<K> getKeys();

    Iterator<V> getValues();

    int size();
}
