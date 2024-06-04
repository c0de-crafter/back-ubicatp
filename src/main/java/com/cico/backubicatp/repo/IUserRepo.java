package com.cico.backubicatp.repo;

import com.cico.backubicatp.model.User;
import java.util.List;

public interface IUserRepo extends IGenericRepo<User, Integer> {
    User findByEmail(String email);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByRole(String role);
}
