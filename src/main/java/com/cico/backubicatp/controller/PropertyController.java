package com.cico.backubicatp.controller;

import com.cico.backubicatp.dto.PropertyDTO;
import com.cico.backubicatp.dto.GenericResponse;
import com.cico.backubicatp.dto.GenericResponseRecord;
import com.cico.backubicatp.model.Property;
import com.cico.backubicatp.service.IPropertyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final IPropertyService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponseRecord<PropertyDTO>> readAll() throws Exception {
        List<PropertyDTO> list = service.readAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponseRecord<>(200, "success", new ArrayList<>(list)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<PropertyDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        PropertyDTO dto = convertToDto(service.readById(id));
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(dto)));
    }

    @PostMapping
    public ResponseEntity<PropertyDTO> save(@Valid @RequestBody PropertyDTO dto) throws Exception {
        Property obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody PropertyDTO dto) throws Exception {
        Property obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private PropertyDTO convertToDto(Property obj) {
        return modelMapper.map(obj, PropertyDTO.class);
    }

    private Property convertToEntity(PropertyDTO dto) {
        return modelMapper.map(dto, Property.class);
    }
}
