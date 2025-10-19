package org.example;

public class Dogs {
    //dog: id, name, age, male?, ownerid
    private Integer id;
    private String name;
    private float age;
    private boolean isMale;
    private int ownerId;

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

    public float getAge() {
        return age;
    }
    public void setAge(float age) {
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
    public Dogs(Integer id, String name, float age, boolean isMale, int ownerId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.ownerId = ownerId;
    }
}
