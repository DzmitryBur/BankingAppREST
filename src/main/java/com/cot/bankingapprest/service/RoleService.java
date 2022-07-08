package com.cot.bankingapprest.service;

import com.cot.bankingapprest.mapper.RoleMapper;
import com.cot.bankingapprest.model.Role;
import com.cot.bankingapprest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleRepository {

    private JdbcTemplate jdbcTemplate;
    private RoleMapper roleMapper;

    @Autowired
    public RoleService(JdbcTemplate jdbcTemplate, RoleMapper roleMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> getAllRoles() {
        return jdbcTemplate.query("SELECT * FROM roles", roleMapper);
    }

    @Override
    public Role getRole(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM roles WHERE id=?", roleMapper, id);
    }

    @Override
    public int createRole(String role) {
        return jdbcTemplate.update("INSERT INTO roles (id, role) VALUES (DEFAULT,?)", role);

    }

    @Override
    public void updateRole(long id, String role) {
    }


    @Override
    public void deleteRole(long id) {
        jdbcTemplate.update("DELETE FROM roles WHERE id=?", id);
    }
}
