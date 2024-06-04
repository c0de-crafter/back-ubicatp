package com.cico.backubicatp.controller;

import com.cico.backubicatp.dto.BookingDetailDTO;
import com.cico.backubicatp.dto.GenericResponse;
import com.cico.backubicatp.dto.GenericResponseRecord;
import com.cico.backubicatp.model.BookingDetail;
import com.cico.backubicatp.service.IBookingDetailService;
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
@RequestMapping("/booking-details")
@RequiredArgsConstructor
public class BookingDetailController {

    private final IBookingDetailService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponseRecord<BookingDetailDTO>> readAll() throws Exception {
        List<BookingDetailDTO> list = service.readAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponseRecord<>(200, "success", new ArrayList<>(list)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<BookingDetailDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        BookingDetailDTO dto = convertToDto(service.readById(id));
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(dto)));
    }

    @PostMapping
    public ResponseEntity<BookingDetailDTO> save(@Valid @RequestBody BookingDetailDTO dto) throws Exception {
        BookingDetail obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDetailDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody BookingDetailDTO dto) throws Exception {
        BookingDetail obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private BookingDetailDTO convertToDto(BookingDetail obj) {
        return modelMapper.map(obj, BookingDetailDTO.class);
    }

    private BookingDetail convertToEntity(BookingDetailDTO dto) {
        return modelMapper.map(dto, BookingDetail.class);
    }
}
