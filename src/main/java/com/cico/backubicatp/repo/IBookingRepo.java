package com.cico.backubicatp.repo;

import com.cico.backubicatp.model.Booking;
import java.util.Date;
import java.util.List;

public interface IBookingRepo extends IGenericRepo<Booking, Integer> {
    List<Booking> findByStartDate(Date startDate);
    List<Booking> findByEndDate(Date endDate);
    List<Booking> findByNumberOfPeople(int numberOfPeople);
    List<Booking> findByPrice(float price);
}
