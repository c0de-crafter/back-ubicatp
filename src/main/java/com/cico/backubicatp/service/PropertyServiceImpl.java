package com.cico.backubicatp.service;

import com.cico.backubicatp.model.Property;
import com.cico.backubicatp.repo.IPropertyRepo;
import com.cico.backubicatp.repo.IGenericRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl extends CRUDImpl<Property, Integer> implements IPropertyService {

    private final IPropertyRepo repo;

    @Override
    protected IGenericRepo<Property, Integer> getRepo() {
        return repo;
    }
}
