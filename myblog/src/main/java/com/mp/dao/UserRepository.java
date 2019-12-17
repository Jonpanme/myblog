package com.mp.dao;
//dao层用于操作数据库
import com.mp.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

//参数User代表操作的对象是User，主键为Long型
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String usename,String password);
}
