package me.felixcodes.twiliowithspringboot.controllers;


import me.felixcodes.twiliowithspringboot.dto.SMSRequest;
import me.felixcodes.twiliowithspringboot.services.SMSService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
public class SMSController {

    final SMSService smsService;

    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/scanned")
    public void sms(@RequestBody SMSRequest smsRequest){
        smsService.sendScannedSms(smsRequest);
    }

    @PostMapping("/booked")
    public void mms(@RequestBody SMSRequest smsRequest) throws IOException {
        smsService.sendBookedSms(smsRequest);
    }
}
