package org.hoangit3.test_dao.dao;

import org.hoangit3.test_dao.mapper.IRowMapper;

import java.util.List;

public interface GenericDAO<T> {
    // select all from table
    List<T> query(String sqlQuery, IRowMapper<T> mapper, Object... params);
    // update and delete from table
    void update(String sqlQuery, Object... params);
}
