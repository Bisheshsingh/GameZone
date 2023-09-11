package com.example.games.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BiDirectionMove<T> implements Move {
    protected Coordinate2D coordinates;
    protected T value;
}
