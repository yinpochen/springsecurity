package cn.ishutter.security.dao;

import cn.ishutter.security.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by chenyinpo on 2017/6/21.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao{

    @Override
    public User findById(int id) {
        return getByKey(id);
    }

    @Override
    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoid",sso));
        return (User)crit.uniqueResult();
    }

    @Override
    public void save(User user) {
        persist(user);
    }
}
