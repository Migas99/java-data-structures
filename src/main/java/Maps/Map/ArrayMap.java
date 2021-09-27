package Maps.Map;

import Iterators.ArrayIterator;
import Maps.Entries.Entry;

import java.util.Iterator;

public class ArrayMap<K, V> implements MapADT<K, V> {

    private int DEFAULT_CAPACITY = 16;
    private int numKeys;
    private Entry<K, V>[] values = new Entry[DEFAULT_CAPACITY];

    @Override
    public void put(K key, V value) {
        if (this.values.length == this.numKeys) {
            this.expandCapacity();
        }

        boolean found = false;
        for (int index = 0; index < this.numKeys && !found; index++) {
            if (key.equals(this.values[index].getKey())) {
                found = true;
                this.values[index].setValue(value);
            }
        }

        if (!found) {
            Entry<K, V> entry = new Entry<>(key, value);
            this.values[this.numKeys] = entry;
            this.numKeys++;
        }
    }

    @Override
    public V remove(K key) {
        for (int index = 0; index < this.numKeys; index++) {
            if (key.equals(this.values[index].getKey())) {
                V valueToRemove = this.values[index].getValue();
                this.values[index] = null;
                this.numKeys--;
                this.pushArrayBack(index);
                return valueToRemove;
            }
        }

        return null;
    }

    @Override
    public V get(K key) {
        for (int index = 0; index < this.numKeys; index++) {
            if (key.equals(this.values[index].getKey())) {
                return this.values[index].getValue();
            }
        }

        return null;
    }

    @Override
    public V get(K key, V defaultValue) {
        V value = this.get(key);
        return value == null ? defaultValue : value;
    }

    @Override
    public Iterator<K> getKeys() {
        K[] keys = (K[]) new Object[this.numKeys];

        for (int index = 0; index < this.numKeys; index++) {
            keys[index] = this.values[index].getKey();
        }

        return new ArrayIterator<>(keys);
    }

    @Override
    public Iterator<V> getValues() {
        V[] values = (V[]) new Object[this.numKeys];

        for (int index = 0; index < this.numKeys; index++) {
            values[index] = this.values[index].getValue();
        }

        return new ArrayIterator<>(values);
    }

    @Override
    public int size() {
        return this.numKeys;
    }

    private void pushArrayBack(int start) {
        for (int index = start; index < this.numKeys; index++) {
            this.values[index] = this.values[index + 1];
        }
    }

    private void expandCapacity() {
        Entry<K, V>[] expanded = new Entry[this.values.length + DEFAULT_CAPACITY];
        for (int index = 0; index < this.values.length; index++) {
            expanded[index] = this.values[index];
        }
        this.values = expanded;
    }

}
