package org.hoangit3.test_dao.mapper.impl;

import org.hoangit3.test_dao.mapper.IRowMapper;
import org.hoangit3.test_dao.model.SinhVien;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SinhVienMapper implements IRowMapper<SinhVien> {
    @Override
    public SinhVien rowMapper(ResultSet resultSet) {
        SinhVien sinhVien = new SinhVien();
        try {
            sinhVien.setSid(resultSet.getInt("sid"));
            sinhVien.setSname(resultSet.getString("sname"));
            sinhVien.setAddress(resultSet.getString("address"));
            sinhVien.setCid(resultSet.getInt("cid"));
        } catch (SQLException throwables) {
            return null;
        }
        return sinhVien;
    }
}
