package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.util.*;

public interface AdminService {
        public Admin selectByKey(Integer key);
        public int save(Admin entity);
        public int delete(Integer key);
        public int updateAll(Admin entity);
        public int updateNotNull(Admin entity);

        public Result login(Admin admin);
        public Integer getIdByName(String name);
}
