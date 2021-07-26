package ir.maktab.onlineshop.repository;

import java.sql.Connection;
import java.util.ArrayList;

public interface BaseRepository<T> {
    ConnectionInitializer connectDb = new ConnectionInitializer("hw8db", "root", "@A135246789a");
    Connection connection = connectDb.getConnection();

    ArrayList<T> getAll();

    T getById(int id);

    void save(T t);

    void update(T t);

    void delete(T t);
}
