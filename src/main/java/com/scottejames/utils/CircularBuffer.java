package com.scottejames.utils;

import java.util.Objects;

public class CircularBuffer<T> {
    public CircularBuffer<T> next = this;
    public CircularBuffer<T> previous = this;

    public final T value;

    public CircularBuffer(T value) {
        this.value = value;
    }

    public CircularBuffer<T> remove() {
        previous.next = next;
        next.previous = previous;

        return this;
    }

    public CircularBuffer<T> forward(int count) {
        CircularBuffer<T> rv = this;
        for (int i = 0; i < count; i++) {
            rv = rv.next;
        }
        return rv;
    }

    public CircularBuffer<T> back(int count) {
        CircularBuffer<T> rv = this;
        for (int i = 0; i < count; i++) {
            rv = rv.previous;
        }
        return rv;
    }

    public CircularBuffer<T> insertAfter(CircularBuffer<T> node) {
        next.previous = node;
        node.previous = this;
        node.next = next;
        this.next = node;

        return node;
    }

    public CircularBuffer<T> insertBefore(CircularBuffer<T> node) {
        previous.next = node;
        node.previous = previous;
        node.next = this;
        this.previous = node;

        return node;
    }

    @Override
    public String toString() {
        StringBuffer prefix = new StringBuffer();
        prefix.append("(" + value + ")");

        return next.toString(prefix, this);
    }
    public String toString(StringBuffer prefix, CircularBuffer<T> finish) {
        if (Objects.equals(this, finish)) {
            return prefix.toString();
        } else {
            prefix.append(',').append(value);
            return next.toString(prefix, finish);
        }
    }
}