package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            tracker.replace(1, new Item("Bogdan"));
            assertThat(tracker.findById(1).getName(), is("Bogdan"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            tracker.delete(1);
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void showAllItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            tracker.add(new Item("name"));
            tracker.add(new Item("name"));
            assertThat(tracker.findAll().size(), is(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findToIdItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findById(1).getName(), is("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void showToNameItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            tracker.add(new Item("name"));
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}