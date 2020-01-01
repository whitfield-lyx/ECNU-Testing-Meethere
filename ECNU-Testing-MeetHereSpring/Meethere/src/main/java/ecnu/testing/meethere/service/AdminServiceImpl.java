package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.AdminMapper;
import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
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

    @Override
    public Result login(Admin admin){
        /* 此处只含有name与password信息 */
        String name = admin.getName();
        //System.out.println("admin name is "+name+" password is "+admin.getPassword());
        Admin myAdmin = adminMapper.selectByName(name);
        if(myAdmin == null){
            return ResultFactory.buildFailResult("不存在该管理员名");
        }
        if(!myAdmin.getPassword().equals(admin.getPassword())){
            return ResultFactory.buildFailResult("管理员名或密码错误");
        }else {
            return ResultFactory.buildSuccessResult("管理员登录成功");
        }
    }

    @Override
    public Integer getIdByName(String name) {
        Admin admin = adminMapper.selectByName(name);
        if(admin==null){
            //System.out.println("不存在该管理员名");
            return 0;
        }
        else{
            return admin.getAdminId();
        }
    }
}
