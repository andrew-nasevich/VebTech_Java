package by.BSUIR.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The type Base mysql.
 *
 * @param <T> the type parameter
 */
public abstract class BaseMysql<T> implements AutoCloseable {
    private Connection connection;

    /**
     * Instantiates a new Base mysql.
     */
    protected BaseMysql() {
    }


    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Sets connection.
     *
     * @param connection the connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Fill fields object t.
     *
     * @param resultSet the result set
     * @return the t
     * @throws SQLException the sql exception
     */
    abstract T fillFieldsObject(ResultSet resultSet) throws SQLException;

    /**
     * Sets field statement.
     *
     * @param statement the statement
     * @param entity    the entity
     * @throws SQLException the sql exception
     */
    abstract void setFieldStatement(PreparedStatement statement, T entity) throws SQLException;

    /**
     * Fill list list.
     *
     * @param resultSet the result set
     * @return the list
     * @throws SQLException the sql exception
     */
    abstract List<T> fillList(ResultSet resultSet) throws SQLException;

    /**
     * Initialize entity t.
     *
     * @param resultSet the result set
     * @return the t
     * @throws SQLException the sql exception
     */
    abstract T initializeEntity(ResultSet resultSet) throws SQLException;

    /**
     * Default create int.
     *
     * @param sql    the sql
     * @param entity the entity
     * @return the int
     * @throws DaoException the dao exception
     */
    int defaultCreate(String sql, T entity) throws DaoException {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            setFieldStatement(statement, entity);

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e.getMessage());
            }
        }
    }

    /**
     * Default read list.
     *
     * @param sql the sql
     * @return the list
     * @throws DaoException the dao exception
     */
    List<T> defaultRead(String sql) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            return fillList(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e.getMessage());
            }
        }
    }

    /**
     * Read by string list.
     *
     * @param sql   the sql
     * @param field the field
     * @return the list
     * @throws DaoException the dao exception
     */
    List<T> readByString(String sql, String field) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, field);
            resultSet = statement.executeQuery();

            return fillList(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e.getMessage());
            }
        }
    }

    /**
     * Read by int list.
     *
     * @param connection the connection
     * @param sql        the sql
     * @param value      the value
     * @return the list
     * @throws DaoException the dao exception
     */
    List<T> readByInt(Connection connection, String sql, int[] value) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);

            if (value.length < 1) {
                statement.setInt(1, value[0]);
            } else {
                for (var i = 0; i < value.length; i++) {
                    statement.setInt(i + 1, value[i]);
                }
            }

            resultSet = statement.executeQuery();

            return fillList(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e.getMessage());
            }
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}