package __2_Microservice_stock_implementation_STOCK_CALC_API.service;

import __2_Microservice_stock_implementation_STOCK_CALC_API.binding.StockCalcApiResponse;
import __2_Microservice_stock_implementation_STOCK_CALC_API.binding.StockPriceApiResponse;
import __2_Microservice_stock_implementation_STOCK_CALC_API.client.StockPriceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockCalcService {

    @Autowired
    private StockPriceClient stockPriceClient;


    public StockCalcApiResponse getStocksCost(String companyName,Integer quantity){

        StockCalcApiResponse response =  new StockCalcApiResponse();

        //access STOCK-PRICE-API with companyName

      StockPriceApiResponse stockPriceApiResponse = stockPriceClient.invokeStockPriceApi(companyName);

      Double companyStockPrice = stockPriceApiResponse.getCompanyStockPrice();

      Double totalCost =  companyStockPrice * quantity;

       response.setCompanyName(companyName);

       response.setPortNumber(stockPriceApiResponse.getPortNumber());

       response.setQuantity(quantity);

       response.setTotalCost(totalCost);
        return response;


    }
}
