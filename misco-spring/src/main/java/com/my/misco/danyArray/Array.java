package com.my.misco.danyArray;
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    //添加指定索引index位置的元素data
    public void add(int index, E element) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed, Array is full");
        }
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Add failed, index is not under[0 - size]");
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(size, element);
    }

    //删除index位置的元素并返回该元素的值
    public E delete(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("delete failed, index is illegal");
        }
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }

    //寻找数组是否包含元素e，如果包含返回索引值，否则返回-1
    public int findx(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //将索引上的值改变为e
    public void set(int index, E e) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("set failed, index is illegal");
        }
        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Array: size = %d capacity = %d\n", size, data.length);
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(" ,");
            }
        }
        res.append("]");
        return res.toString();
    }
    
    
}