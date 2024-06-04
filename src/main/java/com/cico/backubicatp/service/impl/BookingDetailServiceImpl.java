package com.cico.backubicatp.service.impl;

import com.cico.backubicatp.model.BookingDetail;
import com.cico.backubicatp.repo.IBookingDetailRepo;
import com.cico.backubicatp.repo.IGenericRepo;
import com.cico.backubicatp.service.IBookingDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingDetailServiceImpl extends CRUDImpl<BookingDetail, Integer> implements IBookingDetailService {

    private final IBookingDetailRepo repo;

    @Override
    protected IGenericRepo<BookingDetail, Integer> getRepo() {
        return repo;
    }
}
