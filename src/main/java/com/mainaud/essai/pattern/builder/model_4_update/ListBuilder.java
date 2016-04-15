package com.mainaud.essai.pattern.builder.model_4_update;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public final class ListBuilder<E> {
    private List<E> oldData;
    private List<E> data;

    private ListBuilder() {
    }

    public static <E> ListBuilder<E> of() {
        return new ListBuilder<>();
    }

    public static <E> ListBuilder<E> of(List<E> oldList) {
        ListBuilder<E> builder = new ListBuilder<>();
        builder.oldData = oldList;
        return builder;
    }

    private void init() {
        if (data == null) {
            data = new ArrayList<>();
            if (oldData != null) {
                data.addAll(oldData);
            }
        }
    }

    public ListBuilder<E> add(E element) {
        init();
        data.add(element);
        return this;
    }

    public ListBuilder<E> map(UnaryOperator<E> mapper) {
        init();
        for (ListIterator<E> i = data.listIterator(); i.hasNext(); ) {
            i.set(mapper.apply(i.next()));
        }
        return this;
    }

    public ListBuilder<E> updateIf(Predicate<E>predicate, UnaryOperator<E> mapper) {
        init();
        for (ListIterator<E> i = data.listIterator(); i.hasNext(); ) {
            E elem = i.next();
            if (predicate.test(elem)) {
                i.set(mapper.apply(elem));
            }
        }
        return this;
    }

    public List<E> build() {
        return data == null ? oldData == null ? new ArrayList<>() : oldData : Collections.unmodifiableList(data);
    }
}
