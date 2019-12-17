package com.mp.dao;

import com.mp.po.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author meipeng
 * @date 2019-11-19 10:28
 * @function
 */

//JpaSpecificationExecutor
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
}

