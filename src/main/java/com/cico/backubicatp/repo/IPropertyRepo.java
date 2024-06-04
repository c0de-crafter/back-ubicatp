package com.cico.backubicatp.repo;

import com.cico.backubicatp.model.Property;
import java.util.List;

public interface IPropertyRepo extends IGenericRepo<Property, Integer> {
    List<Property> findByPropertyName(String propertyName);
    List<Property> findByLocation(String location);
    List<Property> findByLandlordIdUser(Integer landlordId);
}
