package cn.ishutter.security.dao;

import cn.ishutter.security.model.UserProfile;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenyinpo on 2017/6/22.
 */

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer,UserProfile> implements  UserProfileDao {
    @Override
    public List<UserProfile> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<UserProfile>)crit.list();

    }

    @Override
    public UserProfile findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type",type));
        return (UserProfile)crit.uniqueResult();
    }

    @Override
    public UserProfile findById(int id) {
        return getByKey(id);
    }
}
