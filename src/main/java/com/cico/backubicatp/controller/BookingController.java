package com.cico.backubicatp.controller;

import com.cico.backubicatp.dto.BookingDTO;
import com.cico.backubicatp.dto.GenericResponse;
import com.cico.backubicatp.dto.GenericResponseRecord;
import com.cico.backubicatp.model.Booking;
import com.cico.backubicatp.service.IBookingService;
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
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final IBookingService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponseRecord<BookingDTO>> readAll() throws Exception {
        List<BookingDTO> list = service.readAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponseRecord<>(200, "success", new ArrayList<>(list)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<BookingDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        BookingDTO dto = convertToDto(service.readById(id));
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(dto)));
    }

    @PostMapping
    public ResponseEntity<BookingDTO> save(@Valid @RequestBody BookingDTO dto) throws Exception {
        Booking obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody BookingDTO dto) throws Exception {
        Booking obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private BookingDTO convertToDto(Booking obj) {
        return modelMapper.map(obj, BookingDTO.class);
    }

    private Booking convertToEntity(BookingDTO dto) {
        return modelMapper.map(dto, Booking.class);
    }
}
