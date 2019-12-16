package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.model.AdminExample;

import java.util.List;

public interface AdminService {
        public Admin selectByKey(Integer key);
        public int save(Admin entity);
        public int delete(Integer key);
        public int updateAll(Admin entity);
        public int updateNotNull(Admin entity);
        public List<Admin> selectByExample(AdminExample example);
}
