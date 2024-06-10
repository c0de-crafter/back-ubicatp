package com.cico.backubicatp.service;

import com.cico.backubicatp.model.Booking;
import com.cico.backubicatp.repo.IBookingRepo;
import com.cico.backubicatp.service.BookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private IBookingRepo repo;

    private BookingServiceImpl service;

    private Booking BOOKING_1;
    private Booking BOOKING_2;
    private Booking BOOKING_3;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new BookingServiceImpl(repo);

        BOOKING_1 = new Booking(1, new Date(), new Date(), 4, 1200.00f, null, null, null);
        BOOKING_2 = new Booking(2, new Date(), new Date(), 2, 800.00f, null, null, null);
        BOOKING_3 = new Booking(3, new Date(), new Date(), 3, 900.00f, null, null, null);

        List<Booking> bookings = List.of(BOOKING_1, BOOKING_2, BOOKING_3);

        when(repo.findAll()).thenReturn(bookings);
        when(repo.findById(any())).thenReturn(Optional.of(BOOKING_1));
        when(repo.save(any())).thenReturn(BOOKING_1);
    }

    @Test
    void readAllTest() throws Exception {
        List<Booking> response = service.readAll();
        assertEquals(3, response.size());
    }

    @Test
    void readByIdTest() throws Exception {
        final int ID = 1;
        Booking response = service.readById(ID);
        assertNotNull(response);
    }

    @Test
    void saveTest() throws Exception {
        Booking response = service.save(BOOKING_1);
        assertNotNull(response);
    }

    @Test
    void updateTest() throws Exception {
        Booking response = service.update(BOOKING_1, BOOKING_1.getIdBooking());
        assertNotNull(response);
    }

    @Test
    void deleteTest() throws Exception {
        final int ID = 1;
        service.delete(ID);
        verify(repo, times(1)).deleteById(ID);
    }
}
