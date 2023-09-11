package com.example.games.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public abstract class Board2D<T, U extends Cell<T>, V extends BiDirectionMove<T>> implements Board<V> {
    protected List<List<U>> rawBoard;
    private final Integer rows;
    private final Integer columns;

    private List<List<U>> defaultInitialize() {
        final List<List<U>> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            list.add(new ArrayList<>(Collections.nCopies(columns, null)));
        }

        return list;
    }

    public Board2D(final Integer row, final Integer column) {
        this.rows = row;
        this.columns = column;
        this.rawBoard = defaultInitialize();
    }
}
