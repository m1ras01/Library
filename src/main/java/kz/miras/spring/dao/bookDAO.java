package kz.miras.spring.dao;

import kz.miras.spring.models.Author;
import kz.miras.spring.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.sql.SQLException;
import java.util.List;

import static java.util.Arrays.stream;

@Component
public class bookDAO {

    private final JdbcTemplate jdbcTemplatel;

    @Autowired
    public bookDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplatel = jdbcTemplate;}

    public List<Book> index() throws SQLException{
        return jdbcTemplatel.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplatel.query("SELECT * FROM book WHERE book_id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Book.class))
        .stream().findAny().orElse(null);
    }

    public void save(Book book){
        jdbcTemplatel.update("INSERT INTO book(book_name,written) VALUES (?,?)",book.getBook(),book.getYear());
    }

    public void update(int id,Book UpdateBook){
        jdbcTemplatel.update("UPDATE book SET book_name=?,written=? WHERE book_id=?",UpdateBook.getBook(),UpdateBook.getYear());
    }

    public void delete(int id){
        jdbcTemplatel.update("DELETE FROM book WHERE book_id =?",id);
    }
}