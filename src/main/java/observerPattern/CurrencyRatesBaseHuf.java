package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRatesBaseHuf {
    private List<CurrencyLoanUpdateListener> observantList = new ArrayList<>();

    private void updateAll(CurrencyType currencyType) {
        observantList.stream().filter(x -> x.checkCurrencyType(currencyType)).forEach(x -> x.updateCurrencyExchangeRate(currencyType.getExchangeRate()));
    }

    public void subscribe(CurrencyLoanUpdateListener currencyLoanUpdateListener) {
        observantList.add(currencyLoanUpdateListener);
        CurrencyType currencyType = currencyLoanUpdateListener.getCurrencyType();
        currencyLoanUpdateListener.updateCurrencyExchangeRate(currencyType.getExchangeRate());
    }

    public void unsubscribe(CurrencyLoanUpdateListener currencyLoanUpdateListener) {
        observantList.remove(currencyLoanUpdateListener);
    }

    public void changeExchangeRate(CurrencyType currencyType, double newValue) {
        currencyType.setExchangeRate(newValue);
        updateAll(currencyType);
    }
}
