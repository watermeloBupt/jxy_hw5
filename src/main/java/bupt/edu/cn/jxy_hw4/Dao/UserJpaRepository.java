package bupt.edu.cn.jxy_hw4.Dao;


import bupt.edu.cn.jxy_hw4.Infor.Contact_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<Contact_Item, Long> {
    @Transactional
    void deleteByname(String cname);
    List<Contact_Item> findByname(String cname);
}
