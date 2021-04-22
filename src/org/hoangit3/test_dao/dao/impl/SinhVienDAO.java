package org.hoangit3.test_dao.dao.impl;

import org.hoangit3.test_dao.dao.ISinhVienDAO;
import org.hoangit3.test_dao.mapper.impl.SinhVienMapper;
import org.hoangit3.test_dao.model.SinhVien;

import java.util.List;

public class SinhVienDAO extends AbstractDAO<SinhVien> implements ISinhVienDAO {

    @Override
    public List<SinhVien> findAll() {
        String sqlQuery = "SELECT * FROM sinhvien";
        return query(sqlQuery, new SinhVienMapper());
    }

    @Override
    public void deleteById(int sid) {
        String sqlQuery = "DELETE FROM sinhvien WHERE sid = ?";
        update(sqlQuery, sid);
    }

    @Override
    public void save(SinhVien sinhVien) {
        String sqlQuery = "INSERT INTO sinhvien VALUES(?, ?, ?, ?)";
        update(sqlQuery, sinhVien.getSid(), sinhVien.getSname(),
                sinhVien.getAddress(), sinhVien.getCid());
    }
}
