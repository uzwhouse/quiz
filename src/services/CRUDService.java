package services;

public interface CRUDService {
    Object create(Object object);

    Object read(String str);

    Object update(String str);

    Object delete(String str);

    Object readAll();

}
