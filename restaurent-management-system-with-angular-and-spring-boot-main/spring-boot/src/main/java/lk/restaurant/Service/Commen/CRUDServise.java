package lk.restaurant.Service.Commen;

import java.util.List;

public interface CRUDServise<T> {
    public Integer add(T t) throws Exception;

    public Integer update(T t);

    public List<T> searchLike(Integer userId, String username,String pwd);

    public List<T> get(Integer id);

    public Integer delete(Integer id);

}
