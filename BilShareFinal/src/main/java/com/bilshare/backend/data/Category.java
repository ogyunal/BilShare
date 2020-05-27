package com.bilshare.backend.data;

import javax.persistence.Column;


public enum Category {
    ENGINEERING("Engineering"), MANAGEMENT("Management"), LAW("Law"),
    COMPUTER_SCIENCE("Computer Science"), ECONOMICS("Economics"), MATHEMATICS("Mathematics"), PHYSICS("Physics"),
    CHEMISTRY("Chemistry"), BIOLOGY("Biology"), LANGUAGE("Language"), MUSIC("Music");

    @Column
    private final String name;

    private Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}