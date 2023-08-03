package com.example.JDBCTemplate.dao;

import com.example.JDBCTemplate.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDao implements DAO<User> {

    private static Logger logger = LoggerFactory.getLogger(UserDao.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> list() {
        String sql = "select * from \"user\" ";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void create(User user) {
        String sql = "insert into \"user\" (name, age) values(?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge() );
    }

    @Override
    public Optional<User> get(int id) {
        String sql = "select * from \"user\" where id = ?";
        User user = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
        return Optional.ofNullable(user);
    }

    @Override
    public void delete(int id) {
        String sql = "delete  from \"user\" where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void getCourses(int id){
        int row = jdbcTemplate.update("update course set related_id = ?",id);
        System.out.println(row);
        logger.info("Updated courses : "+ row);
    }
}
