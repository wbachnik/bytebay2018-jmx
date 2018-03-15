package pl.bytebay;

import java.beans.ConstructorProperties;

public class ComplexInfo {
    private final int value;
    private final String description;

    //@ConstructorProperties({"value", "description"})
    public ComplexInfo(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
