package ir.maktab.onlineshop.repository;

import ir.maktab.onlineshop.domain.Admin;
import ir.maktab.onlineshop.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminRepository implements BaseRepository<Admin> {
    @Override
    public ArrayList<Admin> getAll() {
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from admins");
            while (resultSet.next()) {
                admins.add(
                        new Admin(
                                resultSet.getInt(1),
                                resultSet.getString(2)
                        )
                );
                return admins;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Admin getById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from admins where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Admin admin = new Admin(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                return admin;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Admin admin) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into admins (username, password) values(?, ?)");
            preparedStatement.setString(1, admin.getUserName());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Admin admin) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update admins set username = ?, password = ? where id = ?");
            preparedStatement.setString(1, admin.getUserName());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setInt(3, admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Admin admin) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from users where id = ?");
            preparedStatement.setInt(1, admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Admin getByUserPass(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from admins where username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Admin admin = new Admin(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                return admin;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
