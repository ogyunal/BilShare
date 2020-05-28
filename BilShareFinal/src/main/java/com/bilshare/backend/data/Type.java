package com.bilshare.backend.data;

/**
 * The Type Enum in order to hold some types
 * @author BilShare
 * @version 1.0
 */
public enum Type {
    BOOKS("Book"), LECTURE_NOTES("Lecture Note"), OTHER("Other");

    private final String name;

    private Type(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
