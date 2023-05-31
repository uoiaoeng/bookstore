package com.example.springboot.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.example.entity.User;
import com.example.springboot.example.mapper.UserMapper;
import com.example.springboot.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.springboot.example.utils.DateTool;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;

//日志注解
//@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private UserService userService;

    @Override
    public Boolean add(User user) {
        user.setSex("男");
        user.setRole(0);
        user.setCreateTime(DateTool.getCurrTime());

        this.save(user);
        return true;
    }

    @Override
    public void deleteByIds(String id) {
        this.removeById(id);
    }

    @Override
    public User getByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("username",username);

        return this.getOne(queryWrapper);
    }

    @Override
    public Boolean update(User user) {
        this.update(user);
        return true;
    }

    @Override
    public Boolean updateColle(User User, String bookId, Boolean flag) {
        if(flag){
            User.setLikeBookId(User.getLikeBookId()+bookId+",");
        }else{
            User.setLikeBookId(User.getLikeBookId().replace(bookId+",",""));
        }
        this.updateById(User);
        return true;
    }

    //事务回滚注解
    @Transactional
    @Override
    public Boolean trans(String fromId, String toId, Double money) throws SQLException {
        //日志
        logger.trace("trace is here");
        logger.debug("debug is here");
        logger.info("info is here");
        logger.warn("warn is here");
        logger.error("error is here");


        //log.trace("trace is here");

        User userB = this.getById(toId);
        if(userB == null){
            return false;
        }
//        userB.setAge(userB.getAge()+money);
        this.updateById(userB);

        User userA = this.getById(fromId);
        if(userA == null){
            return false;
        }
        if(userA.getAge()<money){
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new SQLException(userA.getUsername()+"'s balance is less than "+money);
            //触发RuntimeException时自动回滚
            //throw new RuntimeException(userA.getName()+"'s balance is less than "+money);
        }else{
//            userA.setAge(userA.getAge()-money);
            this.updateById(userA);
        }
        return true;
    }
}
