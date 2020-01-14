package observerPattern;

public interface CurrencyLoanUpdateListener {
    void updateCurrencyExchangeRate(double newCurrencyExchangeRate);

    boolean checkCurrencyType(CurrencyType currencyType);

    CurrencyType getCurrencyType();
}
