package com.cico.backubicatp.service;

import com.cico.backubicatp.model.Booking;
import com.cico.backubicatp.repo.IBookingRepo;
import com.cico.backubicatp.repo.IGenericRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl extends CRUDImpl<Booking, Integer> implements IBookingService {

    private final IBookingRepo repo;

    @Override
    protected IGenericRepo<Booking, Integer> getRepo() {
        return repo;
    }
}
