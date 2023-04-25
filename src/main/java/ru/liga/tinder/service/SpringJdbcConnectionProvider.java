package ru.liga.tinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SpringJdbcConnectionProvider {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUser() {
        String sql = "select * from homework.customers";
        ExchangeMapper mapper = new ExchangeMapper();
        return jdbcTemplate.query(sql, mapper);
    }

    public User getUserById(int id) {
        List<User> user = getAllUser();
        for (User customer : user) {
            if (customer.getId() == id) {
                return customer;

            }
        }
        return null;
    }

    private static class ExchangeMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return User.builder()
                    .id(rs.getInt(1))
                    .userId(rs.getString(2))
                    .name(rs.getString(3))
                    .gender(rs.getString(4))
                    .description(rs.getString(5))
                    .searchGender(rs.getString("search_gender"))
                    .build();
        }
    }
}
