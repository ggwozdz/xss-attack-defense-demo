package com.neoteric.xss;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by ggwozdz on 20.09.15.
 */
public class DataRepo <T>{
    private final List<T> data;

    public DataRepo() {
        this.data = new ArrayList<>();
    }

    public Optional<T> findOne(Predicate<T> match){
        return this.data.stream().filter(match).findFirst();
    }

    public List<T> findAll(Predicate<T> match){
        return  this.data.stream().filter(match).collect(Collectors.toList());
    }

    public T add(T dataItem){
        this.data.add(dataItem);
        return dataItem;
    }
}
