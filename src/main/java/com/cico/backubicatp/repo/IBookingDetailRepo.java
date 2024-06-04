package com.cico.backubicatp.repo;

import com.cico.backubicatp.model.BookingDetail;
import java.util.List;

public interface IBookingDetailRepo extends IGenericRepo<BookingDetail, Integer> {
    List<BookingDetail> findByRentalName(String rentalName);
    List<BookingDetail> findByAddress(String address);
    List<BookingDetail> findByArea(String area);
}
