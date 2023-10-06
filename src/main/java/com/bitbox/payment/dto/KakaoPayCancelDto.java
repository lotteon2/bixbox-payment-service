package com.bitbox.payment.dto;

import io.github.bitbox.bitbox.dto.MemberPaymentDto;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class KakaoPayCancelDto {
    private String tid;
    private Long cancelAmount;
    private Long cancelTaxFreeAmount;

    public static KakaoPayCancelDto MemberPaymentDtoToKakaoPayCancelDto(MemberPaymentDto memberPaymentDto){
        return KakaoPayCancelDto.builder()
                .tid(memberPaymentDto.getTid())
                .cancelAmount(memberPaymentDto.getCancelAmount())
                .cancelTaxFreeAmount(memberPaymentDto.getCancelTaxFreeAmount())
                .build();
    }
}