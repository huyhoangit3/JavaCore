package org.hoangit3.test_dao.dao.impl;

import org.hoangit3.test_dao.dao.ILopHocDAO;
import org.hoangit3.test_dao.mapper.impl.LopHocMapper;
import org.hoangit3.test_dao.model.LopHoc;

import java.util.List;

public class LopHocDAO extends AbstractDAO<LopHoc> implements ILopHocDAO {
    @Override
    public List<LopHoc> findAll() {
        String sqlQuery = "SELECT * FROM lophoc";
        return query(sqlQuery, new LopHocMapper());
    }
}
