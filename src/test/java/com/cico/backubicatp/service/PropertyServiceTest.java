package com.cico.backubicatp.service;

import com.cico.backubicatp.model.Property;
import com.cico.backubicatp.repo.IPropertyRepo;
import com.cico.backubicatp.service.PropertyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    private IPropertyRepo repo;

    private PropertyServiceImpl service;

    private Property PROPERTY_1;
    private Property PROPERTY_2;
    private Property PROPERTY_3;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new PropertyServiceImpl(repo);

        PROPERTY_1 = new Property(1, "Property 1", "Description 1", "Location 1", "Benefits 1", null);
        PROPERTY_2 = new Property(2, "Property 2", "Description 2", "Location 2", "Benefits 2", null);
        PROPERTY_3 = new Property(3, "Property 3", "Description 3", "Location 3", "Benefits 3", null);

        List<Property> properties = List.of(PROPERTY_1, PROPERTY_2, PROPERTY_3);

        when(repo.findAll()).thenReturn(properties);
        when(repo.findById(any())).thenReturn(Optional.of(PROPERTY_1));
        when(repo.save(any())).thenReturn(PROPERTY_1);
    }

    @Test
    void readAllTest() throws Exception {
        List<Property> response = service.readAll();
        assertEquals(3, response.size());
    }

    @Test
    void readByIdTest() throws Exception {
        final int ID = 1;
        Property response = service.readById(ID);
        assertNotNull(response);
    }

    @Test
    void saveTest() throws Exception {
        Property response = service.save(PROPERTY_1);
        assertNotNull(response);
    }

    @Test
    void updateTest() throws Exception {
        Property response = service.update(PROPERTY_1, PROPERTY_1.getIdProperty());
        assertNotNull(response);
    }

    @Test
    void deleteTest() throws Exception {
        final int ID = 1;
        service.delete(ID);
        verify(repo, times(1)).deleteById(ID);
    }
}
