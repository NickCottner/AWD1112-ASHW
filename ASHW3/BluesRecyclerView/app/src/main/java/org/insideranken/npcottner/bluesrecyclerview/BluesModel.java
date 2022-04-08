package org.insideranken.npcottner.bluesrecyclerview;

public class BluesModel {
    String bluesName;
    String bluesNumber;
    String bluesPosition;
    int bluesImage;

    public BluesModel(String bluesName, String bluesNumber,
                      String bluesPosition, int bluesImage)
    {
        this.bluesName = bluesName;
        this.bluesNumber = bluesNumber;
        this.bluesPosition = bluesPosition;
        this.bluesImage = bluesImage;
    }

    public String getBluesName() {
        return bluesName;
    }

    public String getBluesNumber() {
        return bluesNumber;
    }

    public String getBluesPosition() {
        return bluesPosition;
    }

    public int getBluesImage() {
        return bluesImage;
    }
}
