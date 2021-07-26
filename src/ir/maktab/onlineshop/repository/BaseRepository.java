package ir.maktab.onlineshop.repository;

import java.sql.Connection;
import java.util.ArrayList;

public interface BaseRepository<T> {

    Connection connection = ConnectionInitializer.connect();

    ArrayList<T> getAll();

    T getById(int id);

    void save(T t);

    void update(T t);

    void delete(T t);
}
