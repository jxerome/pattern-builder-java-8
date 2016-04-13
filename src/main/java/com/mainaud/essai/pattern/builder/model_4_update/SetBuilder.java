package com.mainaud.essai.pattern.builder.model_4_update;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class SetBuilder<E> {
    private Set<E> oldData;
    private Set<E> data;

    private SetBuilder() {
    }

    public static <E> SetBuilder<E> of() {
        return new SetBuilder<>();
    }

    public static <E> SetBuilder<E> of(Set<E> oldList) {
        SetBuilder<E> builder = new SetBuilder<>();
        builder.oldData = oldList;
        return builder;
    }

    private void init() {
        if (data == null) {
            data = new HashSet<>();
            if (oldData != null) {
                data.addAll(oldData);
            }
        }
    }

    public SetBuilder<E> add(E element) {
        init();
        data.add(element);
        return this;
    }

    public SetBuilder<E> map(UnaryOperator<E> mapper) {
        init();
        data = data.stream().map(mapper).collect(Collectors.toSet());
        return this;
    }

    public Set<E> build() {
        return data == null ? oldData == null? new HashSet<>() : oldData : Collections.unmodifiableSet(data);
    }
}
