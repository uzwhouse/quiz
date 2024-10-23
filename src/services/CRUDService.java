package services;

import java.util.LinkedList;

public interface CRUDService {
    Object create(Object object);

    Object read(String id);

    Object update(String id);

    Object delete(String id);

    LinkedList<Object> readAll();
}
