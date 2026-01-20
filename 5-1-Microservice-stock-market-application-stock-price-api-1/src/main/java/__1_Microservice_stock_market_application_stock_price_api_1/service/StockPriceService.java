package __1_Microservice_stock_market_application_stock_price_api_1.service;

import __1_Microservice_stock_market_application_stock_price_api_1.binding.StockPriceResponse;

public interface StockPriceService {

    public StockPriceResponse getStockPrice(String companyName);


}
