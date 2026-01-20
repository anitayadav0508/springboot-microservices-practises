package __1_Microservice_stock_market_application_stock_price_api_1.binding;

public class StockPriceResponse {

    private String companyName;

    private Double companyStockPrice;

    private Integer portNumber;


    public Double getCompanyStockPrice() {
        return companyStockPrice;
    }

    public Integer getPortNumber() {
        return portNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyStockPrice(Double companyStockPrice) {
        this.companyStockPrice = companyStockPrice;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    @Override
    public String toString() {
        return "StockPriceResponse{" +
                "companyName='" + companyName + '\'' +
                ", companyStockPrice=" + companyStockPrice +
                ", portNumber=" + portNumber +
                '}';
    }
}
