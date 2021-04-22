package org.hoangit3.test_dao.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
    T rowMapper(ResultSet resultSet);
}
