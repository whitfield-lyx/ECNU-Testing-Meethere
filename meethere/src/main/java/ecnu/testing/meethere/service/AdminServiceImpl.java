package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.AdminMapper;
import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.model.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 说明：根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号 *
     * @param key
     * @return */
    @Override
    public Admin selectByKey(Integer key) {
        return adminMapper.selectByPrimaryKey(key);
    }

    /**
     *  说明：保存一个实体，null的属性也会保存，不会使用数据库默认值 *
     *  @param entity
     *  @return */
    public int save(Admin entity) {
        return adminMapper.insert(entity);
    }

    /**
     *  说明：根据主键字段进行删除，方法参数必须包含完整的主键属性 *
     *  @param key
     *  @return */
    public int delete(Integer key) {
        return adminMapper.deleteByPrimaryKey(key);
    }

    /**
     *  说明：根据主键更新实体全部字段，null值会被更新 *
     *  @param entity
     *  @return */
    public int updateAll(Admin entity) {
        return adminMapper.updateByPrimaryKey(entity);
    }

    /**
     *  根据主键更新属性不为null的值 *
     *  @param entity
     *  @return */
    public int updateNotNull(Admin entity) {
        return adminMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     *  说明：根据Example条件进行查询
     *  重点：这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列 *
     *  @param example
     *  @return */
    public List<Admin> selectByExample(AdminExample example) {
        return adminMapper.selectByExample(example);
    }

}
