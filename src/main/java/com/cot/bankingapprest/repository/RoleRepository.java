package com.cot.bankingapprest.repository;

import com.cot.bankingapprest.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository {
    List<Role> getAllRoles();

    Role getRole(long id);

    int createRole(Role role);

    void updateRole(Role role);

    void deleteRole(long id);

}

