package ir.maktab.onlineshop.repository;

import ir.maktab.onlineshop.domain.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryRepository implements BaseRepository<Category> {
    @Override
    public ArrayList<Category> getAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from categories");
            while (resultSet.next()) {
                categories.add(
                        new Category(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return categories;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Category getById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from categories where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Category category = new Category(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                return category;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Category category) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into categories (title, description) values(?, ?)");
            preparedStatement.setString(1, category.getTitle());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update categories set title = ?, description = ? where id = ?");
            preparedStatement.setString(1, category.getTitle());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setInt(3, category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Category category) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from categories where id = ?");
            preparedStatement.setInt(1, category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
