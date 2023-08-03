package com.example.JDBCTemplate.dao;

import com.example.JDBCTemplate.model.Course;
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
public class CourseDao implements DAO<Course>{

    private static final Logger logger = LoggerFactory.getLogger(CourseDao.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> list() {
        String sql = "select * from course";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(Course.class));
    }

    @Override
    public void create(Course course) {
        String sql = "insert into course (name, related_id) values (?,?)";
        int row = jdbcTemplate.update(sql, course.getName(), course.getRelated_id());
        if (row == 1) {
            logger.info("Added one column !");
        }

    }

    @Override
    public Optional<Course> get(int id) {
        String sql = "select * from course where id = ?";
        Course course = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Course.class)).stream().findAny().
                orElse(null);
        return Optional.ofNullable(course);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from course where id = ?", id);
    }
}
