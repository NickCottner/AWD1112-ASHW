package org.insideranken.npcottner.recyclerviewexample01;

public class languageModel {
    public String name;
    public int imageId;
    public String year;
    public String description;

    public languageModel(String name, String year, String description, int imageId) {
        this.name = name;
        this.description = description;
        this.imageId = imageId;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getYear() {
        return year;
    }

    public String getDescription(){return description;}

}
