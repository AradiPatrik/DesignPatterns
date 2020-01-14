package observerPattern;

public class Main {
    public static void main(String[] args) {
        Loan mortgageLoan = new Loan(10000, CurrencyType.EUR);
        Loan overdraft = new Loan(20000, CurrencyType.USD);
        Loan customLoan = new Loan(300000, CurrencyType.YPI);
        CurrencyRatesBaseHuf currencyRatesBaseHuf = new CurrencyRatesBaseHuf();
        currencyRatesBaseHuf.subscribe(mortgageLoan);
        currencyRatesBaseHuf.subscribe(overdraft);
        currencyRatesBaseHuf.subscribe(customLoan);

        System.out.println(mortgageLoan);
        System.out.println(overdraft);
        System.out.println(customLoan);
        currencyRatesBaseHuf.changeExchangeRate(CurrencyType.USD, 315.62);
        currencyRatesBaseHuf.changeExchangeRate(CurrencyType.YPI, 3.5);
        currencyRatesBaseHuf.changeExchangeRate(CurrencyType.EUR, 335);
        System.out.println();
        System.out.println(mortgageLoan);
        System.out.println(overdraft);
        System.out.println(customLoan);
    }
}
