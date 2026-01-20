package __2_Microservice_stock_implementation_STOCK_CALC_API.binding;

public class StockPriceApiResponse {

    private String companyName;

    private Double companyStockPrice;

    private Integer portNumber;

    // Getters
    public String getCompanyName() {
        return companyName;
    }

    public Double getCompanyStockPrice() {
        return companyStockPrice;
    }

    public Integer getPortNumber() {
        return portNumber;
    }

    // Setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyStockPrice(Double companyStockPrice) {
        this.companyStockPrice = companyStockPrice;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    // toString
    @Override
    public String toString() {
        return "StockPriceApiResponse{" +
                "companyName='" + companyName + '\'' +
                ", companyStockPrice=" + companyStockPrice +
                ", portNumber=" + portNumber +
                '}';
    }
}
