package services;

public interface CRUDService {
    Object create(Object object);

    Object read(String username);

    Object update(String username);

    Object delete(String username);

    Object readAll();

    void creatStaticUsers();
}
