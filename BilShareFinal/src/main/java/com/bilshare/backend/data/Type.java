package com.bilshare.backend.data;

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
