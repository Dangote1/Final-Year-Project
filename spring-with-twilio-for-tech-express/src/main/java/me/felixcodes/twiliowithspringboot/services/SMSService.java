package me.felixcodes.twiliowithspringboot.services;

import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import me.felixcodes.twiliowithspringboot.config.TwilioConfig;
import me.felixcodes.twiliowithspringboot.dto.SMSRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

@Service
@Slf4j
public class SMSService {

    final TwilioConfig twilioConfig;

    public SMSService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }



    public void sendBookedSms(SMSRequest smsRequest) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(smsRequest.getPhoneNumber()),
                new com.twilio.type.PhoneNumber(twilioConfig.TWILIO_PHONE_NUMBER),
                String.format("Dear %s, your ticket of price GHS%s have successfully been booked with the ticked id %s",
                        smsRequest.getName(),
                        smsRequest.getPrice(),
                        smsRequest.getTicketId())

        ).create();
        Message.Status status = message.getStatus();
        log.info("details {}",smsRequest);
    }

    public void sendScannedSms(SMSRequest smsRequest) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(smsRequest.getPhoneNumber()),
                new com.twilio.type.PhoneNumber(twilioConfig.TWILIO_PHONE_NUMBER),
                String.format("Dear %s, your ticket id of %s have successfully been scanned",
                        smsRequest.getName()
                        ,smsRequest.getTicketId())
        ).create();
        Message.Status status = message.getStatus();
        log.info("details {}",smsRequest);
    }
}
