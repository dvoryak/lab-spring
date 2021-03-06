package domain;

public class Speaker {
    private String name;
    private String surName;

    public Speaker(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Speaker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
