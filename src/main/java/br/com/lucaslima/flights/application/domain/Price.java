package br.com.lucaslima.flights.application.domain;

import java.math.BigDecimal;

public class Price {

    private final String currencyCode;
    private final BigDecimal base;
    private final BigDecimal total;

    public Price(String currencyCode, BigDecimal base, BigDecimal total) {
        this.currencyCode = currencyCode;
        this.base = base;
        this.total = total;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public BigDecimal getBase() {
        return base;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
