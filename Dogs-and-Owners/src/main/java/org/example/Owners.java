package org.example;

public class Owners {
    //owner: id, name
    private Integer id;
    private String name;

    //getters, setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Constructor
    public Owners(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
