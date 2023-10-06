package com.bitbox.payment.controller;

import com.bitbox.payment.dto.PaymentDto;
import com.bitbox.payment.util.EntityValidation;
import com.bitbox.payment.util.KakaoPayUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/kakao-pay")
@RequiredArgsConstructor
public class KakaoPayController {
    private final KakaoPayUtil kakaoPayUtil;
    private String headerMemberId = "csh"; // TODO HEADER값으로 변경 필요
    @PostMapping("/payment-request")
    public ResponseEntity<String> paymentRequest(@RequestBody @Valid PaymentDto paymentDto){
        EntityValidation.validPaymentDto(paymentDto);
        paymentDto.setPartnerUserId(headerMemberId);

        return kakaoPayUtil.callKakaoReadyApi(paymentDto);
    }
}