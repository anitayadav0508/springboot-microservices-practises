package __2_Microservice_stock_implementation_STOCK_CALC_API.binding;

public class StockCalcApiResponse {

    private String companyName;

    private Double totalCost;

    private Integer portNumber;

    private Integer quantity;

    // Getters
    public String getCompanyName() {
        return companyName;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Integer getPortNumber() {
        return portNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    // Setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // toString
    @Override
    public String toString() {
        return "StockCalcApiResponse{" +
                "companyName='" + companyName + '\'' +
                ", totalCost=" + totalCost +
                ", portNumber=" + portNumber +
                ", quantity=" + quantity +
                '}';
    }
}
