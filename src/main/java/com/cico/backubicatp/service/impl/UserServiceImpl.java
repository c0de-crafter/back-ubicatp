package com.cico.backubicatp.service.impl;

import com.cico.backubicatp.model.User;
import com.cico.backubicatp.repo.IUserRepo;
import com.cico.backubicatp.repo.IGenericRepo;
import com.cico.backubicatp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    private final IUserRepo repo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return super.save(user);
    }

    @Override
    public User update(User user, Integer integer) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return super.update(user, integer);
    }

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }
}
