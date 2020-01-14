package observerPattern;

public class Loan implements CurrencyLoanUpdateListener {
    double actualCurrencyExchangeRate = 0.0;
    double oldCurrencyExchangeRate = 0.0;
    double actualLoanValue = 0.0;
    CurrencyType currencyType;

    @Override
    public void updateCurrencyExchangeRate(double newCurrencyExchangeRate) {
        if (actualCurrencyExchangeRate != newCurrencyExchangeRate) {
            if (actualCurrencyExchangeRate != 0) {
                oldCurrencyExchangeRate = actualCurrencyExchangeRate;
            } else {
                oldCurrencyExchangeRate = newCurrencyExchangeRate;
            }
            actualCurrencyExchangeRate = newCurrencyExchangeRate;
            updateLoanValue();
        }
    }

    public boolean checkCurrencyType(CurrencyType currencyType) {
        return currencyType == this.currencyType;
    }

    private void updateLoanValue() {
        double loanInHuf = actualLoanValue / oldCurrencyExchangeRate;
        actualLoanValue = loanInHuf * actualCurrencyExchangeRate;
    }

    public Loan(double actualLoanValue, CurrencyType currencyType) {
        this.actualLoanValue = actualLoanValue;
        this.currencyType = currencyType;
    }

    @Override
    public String toString() {
        return "Az aktuális hitelösszeg " + currencyType.toString() + ":" + actualLoanValue +
                ", Az aktuális hitelösszeg forintban:" + actualLoanValue * actualCurrencyExchangeRate +
                ", deviza alap=" + currencyType;
    }

    public double getActualCurrencyExchangeRate() {
        return actualCurrencyExchangeRate;
    }

    public double getOldCurrencyExchangeRate() {
        return oldCurrencyExchangeRate;
    }

    public double getActualLoanValue() {
        return actualLoanValue;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
