package com.example.lesson_api.models;

import java.util.List;

public class State {
   private String name;
   private String nativeName;
   private String flag;
   private List<String> borders = null;

    public State(String name, String nativeName, String flag, List<String> borders) {
        this.name = name;
        this.nativeName = nativeName;
        this.flag = flag;
        this.borders = borders;
    }

    public String getName() {
        return name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getFlag() {
        return flag;
    }

    public List<String> getBorders() {
        return borders;
    }
}
