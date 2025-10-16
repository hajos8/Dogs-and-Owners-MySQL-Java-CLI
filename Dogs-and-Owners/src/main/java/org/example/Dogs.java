package org.example;

public class Dogs {
    //dog: id, name, age, male?, ownerid
    private int id;
    private String name;
    private int age;
    private boolean isMale;
    private int ownerId;

    //getters, setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }
    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    


    // Constructor
    public Dogs(int id, String name, int age, boolean isMale, int ownerId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.ownerId = ownerId;
    }
}
