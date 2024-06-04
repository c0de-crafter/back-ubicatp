package com.cico.backubicatp.service.impl;

import com.cico.backubicatp.model.User;
import com.cico.backubicatp.repo.IUserRepo;
import com.cico.backubicatp.repo.IGenericRepo;
import com.cico.backubicatp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    private final IUserRepo repo;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }
}
