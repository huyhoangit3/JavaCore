package org.hoangit3.test_dao.mapper.impl;

import org.hoangit3.test_dao.mapper.IRowMapper;
import org.hoangit3.test_dao.model.LopHoc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LopHocMapper implements IRowMapper<LopHoc> {
    @Override
    public LopHoc rowMapper(ResultSet resultSet) {
        LopHoc lopHoc = new LopHoc();
        try {
            lopHoc.setCid(resultSet.getInt("cid"));
            lopHoc.setCname(resultSet.getString("cname"));
        } catch (SQLException throwables) {
            return null;
        }
        return lopHoc;
    }
}
