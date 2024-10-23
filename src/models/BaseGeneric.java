package models;

import java.util.UUID;

public abstract class BaseGeneric {
    protected String id;

    public String getId() {
        return id;
    }

    public BaseGeneric() {
        this.id = UUID.randomUUID().toString();
    }
}
