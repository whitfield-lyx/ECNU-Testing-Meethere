package ecnu.testing.meethere.service;

import java.util.List;

/**
 * 通用接口类
 */
public interface IService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

}
