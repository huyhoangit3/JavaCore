package org.hoangit3.test_dao.dao;

import org.hoangit3.test_dao.model.SinhVien;

import java.util.List;

public interface ISinhVienDAO {
    List<SinhVien> findAll();
    void deleteById(int sid);
    void save(SinhVien sinhVien);
}
