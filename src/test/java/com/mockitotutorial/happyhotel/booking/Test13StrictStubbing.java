package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Test13StrictStubbing {

	@InjectMocks
	private BookingService bookingService;
	
	@Mock
	private PaymentService paymentServiceMock;
	@Mock
	private RoomService roomServiceMock;
	@Mock
	private BookingDAO bookingDAOMock;
	@Mock
	private MailSender mailSenderMock;
	@Captor
	private ArgumentCaptor<Double> doubleCaptor;
	
	

//	@BeforeEach
//	void setUp() {
//
//		this.paymentServiceMock = mock(PaymentService.class);
//		this.roomServiceMock = mock(RoomService.class);
//		this.bookingDAOMock = mock(BookingDAO.class);
//		this.mailSenderMock = mock(MailSender.class);
//		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
//		
//		this.doubleCaptor = ArgumentCaptor.forClass(Double.class);
//	}

	
	@Test
	void should_InvokePayment_When_Prepaid() {

		// given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 05),
				2, false);
		
		//this is unnecessay stubbing
		//lenient().when. Note: lenient cannot be used with given()
		given(paymentServiceMock.pay(any(), anyDouble())).willReturn("1");
		
		// when
		bookingService.makeBooking(bookingRequest);
		
		// then
		//verify(paymentServiceMock).pay(bookingRequest, 400.0);
		//then(paymentServiceMock).should(times(1)).pay(bookingRequest, 400.0);
		//verify(paymentServiceMock, times(1)).pay(any(), anyDouble());	--works fine
		//verifyNoMoreInteractions(paymentServiceMock);	//it verifies if any more methods were called on paymentServiceMock

	}
	


}
