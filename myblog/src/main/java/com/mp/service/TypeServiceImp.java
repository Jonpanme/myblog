package com.mp.service;

import com.mp.NotFoundException;
import com.mp.dao.TypeRepository;
import com.mp.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author meipeng
 * @date 2019-11-6 15:33
 * @function
 */

@Service
public class TypeServiceImp implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional   //增删改查都要放在事务里面
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).orElse(null);
    }


    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }


    public List<Type> listType(){
        return typeRepository.findAll();
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
       Type t=typeRepository.findById(id).orElse(null);
       if(t==null){
           throw new NotFoundException("不存在该类型");
       }
       BeanUtils.copyProperties(type,t); //将type里面的值赋给t
        return typeRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
       typeRepository.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }
}
