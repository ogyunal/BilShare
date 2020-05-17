package com.bilshare.bilshare.bookstore.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "CATEGORY")
public enum Category {
    ENGINEERING("Engineering"), MANAGEMENT("Management"), LAW("Law"),
    COMPUTER_SCIENCE("Computer Science"), ECONOMICS("Economics"), PHYSICS("Physics"),
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

