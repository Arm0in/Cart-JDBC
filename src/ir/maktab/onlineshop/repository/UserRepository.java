package ir.maktab.onlineshop.repository;

import ir.maktab.onlineshop.domain.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository implements BaseRepository<User> {

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(4),
                                resultSet.getDate(5).toLocalDate(),
                                resultSet.getBoolean(6),
                                resultSet.getBigDecimal(7)
                        )
                );
                return users;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public User getById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from users where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getBoolean(6),
                        resultSet.getBigDecimal(7)
                );
                return user;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into users (username, password, nationalcode, birthday, status, balance) values(?, ?, ?, ?, 0, 0)");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNationalCode());
            preparedStatement.setDate(4, Date.valueOf(user.getBirthday()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update users set username = ?, password = ?, nationalcode = ?, birthday = ?, status = ?, balance = ? where id = ?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNationalCode());
            preparedStatement.setDate(4, Date.valueOf(user.getBirthday()));
            preparedStatement.setBoolean(5, user.isStatus());
            preparedStatement.setBigDecimal(6, user.getBalance());
            preparedStatement.setInt(7, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from users where id = ?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User getByUserPass(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from users where username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getBoolean(6),
                        resultSet.getBigDecimal(7)
                );
                return user;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
