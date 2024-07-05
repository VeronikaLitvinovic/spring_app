//package com.example.demo.Dao;
//
//import com.example.demo.model.User;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserDAO {
//    private final NamedParameterJdbcTemplate template;
//
//    public UserDAO(NamedParameterJdbcTemplate template) {
//        this.template = template;
//    }
//
//    public Long createUser(User user) {
//        String sql = "INSERT INTO USERS (username, password, address, phone, email, first_name, last_name)"
//                + " VALUES (:username, :password, :address, :phone, :email, :first_name, :last_name RETURNING id)";
//        SqlParameterSource parameterSource = new MapSqlParameterSource()
//                .addValue("username", user.getUsername())
//                .addValue("password", user.getPassword())
//                .addValue("address", user.getAddress())
//                .addValue("phone", user.getPhone())
//                .addValue("email", user.getEmail())
//                .addValue("first_name", user.getFirst_name())
//                .addValue("last_name", user.getLast_name());
//        return template.queryForObject(sql, parameterSource, Long.class);
//    }
//
//    public User getUserById(long id) {
//        String sql = "SELECT * FROM users WHERE user.id = :id";
//        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
//        return template.queryForObject(sql, parameterSource, (rs, rowNum) -> {
//            User user = new User();
//            user.setId(rs.getLong("id"));
//            user.setUsername(rs.getString("username"));
//            user.setPassword(rs.getString("password"));
//            user.setAddress(rs.getString("address"));
//            user.setPhone(rs.getString("phone"));
//            user.setEmail(rs.getString("email"));
//            user.setFirst_name(rs.getString("first_name"));
//            user.setLast_name(rs.getString("last_name"));
//            user.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
//            return user;
//
//        });
//
//    }
//
//
//}