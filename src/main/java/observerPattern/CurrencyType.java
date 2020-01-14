package observerPattern;

public enum CurrencyType {
    USD(298.32, "Dollar"), EUR(332.48, "Euro"), CHF(308.62, "Frank"),
    YPI(2.7151, "Ypi"), GBP(388.79, "Font");

    private double exchangeRate;
    private String name;

    CurrencyType(double exchangeRate, String name) {
        this.exchangeRate = exchangeRate;
        this.name = name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "" + name + "ban/ben";
    }
}
