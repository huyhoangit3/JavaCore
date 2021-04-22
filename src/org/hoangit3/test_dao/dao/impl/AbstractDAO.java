package org.hoangit3.test_dao.dao.impl;

import org.hoangit3.test_dao.dao.GenericDAO;
import org.hoangit3.test_dao.mapper.IRowMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AbstractDAO<T> implements GenericDAO<T> {
    FileInputStream fileInputStream;
    Properties properties;

    public AbstractDAO() {
        try {
            fileInputStream = new FileInputStream("src/org/hoangit3/test_dao/config/db.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String db_url = properties.getProperty("db_url");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(db_url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    @Override
    public List<T> query(String sqlQuery, IRowMapper<T> mapper, Object... params) {
        List<T> list = new ArrayList<>();
        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            setParameters(preparedStatement, params);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(mapper.rowMapper(resultSet));
            }

        } catch (SQLException throwables) {
            return null;
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void update(String sqlQuery, Object... params) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlQuery);
            setParameters(preparedStatement, params);
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void setParameters(PreparedStatement statement, Object... params) {
        int index;
        try {
            for (int i = 0; i < params.length; i++) {
                index = i + 1;
                if (params[i] instanceof Integer) {
                    statement.setInt(index, (Integer) params[i]);
                } else if (params[i] instanceof Long) {
                    statement.setLong(index, (Long) params[i]);
                } else if (params[i] instanceof String) {
                    statement.setString(index, (String) params[i]);
                } else if (params[i] instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) params[i]);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
