package __1_Microservice_stock_market_application_stock_price_api_1.repository;

import __1_Microservice_stock_market_application_stock_price_api_1.binding.StockPriceResponse;
import __1_Microservice_stock_market_application_stock_price_api_1.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Integer> {

    /*We are using customMethod because we don't have any method which return companyStockPrice */
    @Query("select companyStockPrice from StockPrice where companyName=:companyName" )
    public Double findStockPriceByCompanyName(String companyName);


}
