package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    public SqlTracker() {}

    public Connection getConnection() {
        return cn;
    }

    public void init() {
        try (InputStream in
                     = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "insert into items(name) values(?)", Statement.RETURN_GENERATED_KEYS
        )) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "update items set name=? where id=?"
        )) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "delete from items where id=?"
        )) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from items");
        while (resultSet.next()) {
            list.add(new Item(resultSet.getInt(1), resultSet.getString(2)));
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement = getConnection()
                .prepareStatement("select * from items where name=?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    rsl.add(new Item(resultSet.getInt("id"), resultSet.getString("name")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from items where id=" + id);
        resultSet.next();
        return new Item(resultSet.getInt(1), resultSet.getString(2));
    }
}