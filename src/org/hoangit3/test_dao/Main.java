package org.hoangit3.test_dao;

import org.hoangit3.test_dao.dao.ISinhVienDAO;
import org.hoangit3.test_dao.dao.impl.SinhVienDAO;
import org.hoangit3.test_dao.model.SinhVien;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ISinhVienDAO sinhVienDAO = new SinhVienDAO();
        //sinhVienDAO.deleteById(4);
        SinhVien sinhVien = new SinhVien(4, "Anh", "Thanh Hoa", 3);
        sinhVienDAO.save(sinhVien);
        List<SinhVien> sinhViens = sinhVienDAO.findAll();
        sinhViens.forEach(System.out::println);
    }
}
