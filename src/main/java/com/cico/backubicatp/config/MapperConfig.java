package com.cico.backubicatp.config;

import com.cico.backubicatp.dto.BookingDTO;
import com.cico.backubicatp.dto.BookingDetailDTO;
import com.cico.backubicatp.dto.PropertyDTO;
import com.cico.backubicatp.dto.UserDTO;
import com.cico.backubicatp.model.Booking;
import com.cico.backubicatp.model.BookingDetail;
import com.cico.backubicatp.model.Property;
import com.cico.backubicatp.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

//    @Bean("bookingMapper")
//    public ModelMapper bookingMapper(){
//        return new ModelMapper();
//    }
//
//    @Bean("bookingDetailMapper")
//    public ModelMapper bookingDetailMapper(){
//        return new ModelMapper();
//    }
//
//    @Bean("propertyMapper")
//    public ModelMapper propertyMapper(){
//        return new ModelMapper();
//    }
//
//    @Bean("userMapper")
//    public ModelMapper userMapper(){
//        return new ModelMapper();
//    }

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }
}
