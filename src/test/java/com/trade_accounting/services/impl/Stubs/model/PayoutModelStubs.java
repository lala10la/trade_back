package com.trade_accounting.services.impl.Stubs.model;

import com.trade_accounting.models.Payout;

import java.time.LocalDateTime;

import static com.trade_accounting.services.impl.Stubs.ModelStubs.getCompany;
import static com.trade_accounting.services.impl.Stubs.ModelStubs.getRetailStore;

public class PayoutModelStubs {
    public static Payout getPayout(Long id) {
        return Payout.builder()
                .id(id)
                .date(LocalDateTime.parse(LocalDateTime.now().toString()))
                .retailStore(getRetailStore(id))
                .whoWasPaid("whoPaid")
                .company(getCompany(id))
                .isSent(true)
                .isPrint(true)
                .comment("comment")
                .build();
    }
}
