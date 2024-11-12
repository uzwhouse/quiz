package models;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseGeneric implements Serializable {
    protected String id;

    public String getId() {
        return id;
    }

    public BaseGeneric() {
        this.id = UUID.randomUUID().toString();
    }
}
