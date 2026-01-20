package __1_Microservice_stock_market_application_stock_price_api_1.service;

import __1_Microservice_stock_market_application_stock_price_api_1.binding.StockPriceResponse;
import __1_Microservice_stock_market_application_stock_price_api_1.repository.StockPriceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class StockPriceServiceImpl implements StockPriceService {

    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Autowired
    private Environment env;

    @Override
    public StockPriceResponse getStockPrice(String companyName) {


      Double stockPrice = stockPriceRepository.findStockPriceByCompanyName(companyName);

      StockPriceResponse apiResponse = new StockPriceResponse();

      apiResponse.setCompanyName(companyName);
      apiResponse.setCompanyStockPrice(stockPrice);

      String port  = env.getProperty("server.port");

      apiResponse.setPortNumber(Integer.parseInt(port));

      return apiResponse;

      /*We are setting portNo because just to know which microservice instance handle the request
      * like in case of load balancing we run multiple instances so  which instance process the request  */

    }
}
