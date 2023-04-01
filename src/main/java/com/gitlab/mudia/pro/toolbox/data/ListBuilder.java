package com.gitlab.mudia.pro.toolbox.data;

import java.util.ArrayList;
import java.util.List;

public class ListBuilder<T> {

    private List<T> list;

    public ListBuilder() {
        list = new ArrayList<>();
    }

    public ListBuilder<T> add(T t) {
        list.add(t);
        return this;
    }

    public List<T> build() {
        return list;
    }

}
