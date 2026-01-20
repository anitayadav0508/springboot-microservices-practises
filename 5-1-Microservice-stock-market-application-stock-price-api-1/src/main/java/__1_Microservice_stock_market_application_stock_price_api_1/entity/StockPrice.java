package __1_Microservice_stock_market_application_stock_price_api_1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "STOCK_PRICE_DTLS")
public class StockPrice {

    @Id
    @Column(name = "STOCK_PRICE_ID")
    private Integer stockPriceId;
    
    @Column(name = "COMPANY_NAME")
    private String companyName;
    
    @Column(name = "COMPANY_STOCK_PRICE")
    private Double companyStockPrice;

    // Default constructor (required by JPA)
    public StockPrice() {
    }

    // All-args constructor
    public StockPrice(Integer stockPriceId, String companyName, Double companyStockPrice) {
        this.stockPriceId = stockPriceId;
        this.companyName = companyName;
        this.companyStockPrice = companyStockPrice;
    }

    // Getters and Setters
    public Integer getStockPriceId() {
        return stockPriceId;
    }

    public void setStockPriceId(Integer stockPriceId) {
        this.stockPriceId = stockPriceId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getCompanyStockPrice() {
        return companyStockPrice;
    }

    public void setCompanyStockPrice(Double companyStockPrice) {
        this.companyStockPrice = companyStockPrice;
    }
}
