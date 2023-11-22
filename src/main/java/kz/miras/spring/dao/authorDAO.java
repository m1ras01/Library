package kz.miras.spring.dao;

import kz.miras.spring.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class authorDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public authorDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> index() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM author", new BeanPropertyRowMapper<>(Author.class));
    }

    public Author show(int id){
        return jdbcTemplate.query("SELECT * FROM author WHERE author_id=?",new Object[]{id},new BeanPropertyRowMapper<>(Author.class))
        .stream().findAny().orElse(null);
    }

    public void save(Author author){
        jdbcTemplate.update("INSERT INTO author(author_name,born) VALUES (?,?)",author.getAuthorName(),author.getBorn());
    }

    public void update(int id,Author upAuthor){
       jdbcTemplate.update("UPDATE author SET author_name=?, born = ? WHERE author_id=?",upAuthor.getAuthorName(),upAuthor.getBorn(),id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM author  WHERE author_id=?",id);
    }
    }
