package com.cico.backubicatp.service;

import com.cico.backubicatp.model.BookingDetail;
import com.cico.backubicatp.repo.IBookingDetailRepo;
import com.cico.backubicatp.service.BookingDetailServiceImpl;
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
public class BookingDetailServiceTest {

    @Mock
    private IBookingDetailRepo repo;

    private BookingDetailServiceImpl service;

    private BookingDetail BOOKING_DETAIL_1;
    private BookingDetail BOOKING_DETAIL_2;
    private BookingDetail BOOKING_DETAIL_3;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new BookingDetailServiceImpl(repo);

        BOOKING_DETAIL_1 = new BookingDetail(1, "Rental Name 1", "Address 1", "Area 1", "Description 1", "Reference 1", "Benefits 1", null);
        BOOKING_DETAIL_2 = new BookingDetail(2, "Rental Name 2", "Address 2", "Area 2", "Description 2", "Reference 2", "Benefits 2", null);
        BOOKING_DETAIL_3 = new BookingDetail(3, "Rental Name 3", "Address 3", "Area 3", "Description 3", "Reference 3", "Benefits 3", null);

        List<BookingDetail> bookingDetails = List.of(BOOKING_DETAIL_1, BOOKING_DETAIL_2, BOOKING_DETAIL_3);

        when(repo.findAll()).thenReturn(bookingDetails);
        when(repo.findById(any())).thenReturn(Optional.of(BOOKING_DETAIL_1));
        when(repo.save(any())).thenReturn(BOOKING_DETAIL_1);
    }

    @Test
    void readAllTest() throws Exception {
        List<BookingDetail> response = service.readAll();
        assertEquals(3, response.size());
    }

    @Test
    void readByIdTest() throws Exception {
        final int ID = 1;
        BookingDetail response = service.readById(ID);
        assertNotNull(response);
    }

    @Test
    void saveTest() throws Exception {
        BookingDetail response = service.save(BOOKING_DETAIL_1);
        assertNotNull(response);
    }

    @Test
    void updateTest() throws Exception {
        BookingDetail response = service.update(BOOKING_DETAIL_1, BOOKING_DETAIL_1.getIdBookingDetail());
        assertNotNull(response);
    }

    @Test
    void deleteTest() throws Exception {
        final int ID = 1;
        service.delete(ID);
        verify(repo, times(1)).deleteById(ID);
    }
}
