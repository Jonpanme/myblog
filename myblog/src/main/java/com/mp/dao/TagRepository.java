package com.mp.dao;

import com.mp.po.Tag;
import com.mp.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author meipeng
 * @date 2019-11-6 15:36
 * @function Repository用于实现数据库的增删改查
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);
}
