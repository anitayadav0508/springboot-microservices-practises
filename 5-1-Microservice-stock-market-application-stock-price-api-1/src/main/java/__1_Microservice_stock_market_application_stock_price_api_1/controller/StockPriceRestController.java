package __1_Microservice_stock_market_application_stock_price_api_1.controller;

import __1_Microservice_stock_market_application_stock_price_api_1.binding.StockPriceResponse;
import __1_Microservice_stock_market_application_stock_price_api_1.service.StockPriceService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class StockPriceRestController {

    @Autowired
    private StockPriceService stockPriceService;


    @GetMapping("/price/{companyName}")
    public ResponseEntity<StockPriceResponse> getStockPrice(@PathVariable String companyName){


      StockPriceResponse response =  stockPriceService.getStockPrice(companyName);

      return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
