package __2_Microservice_stock_implementation_STOCK_CALC_API.client;

import __2_Microservice_stock_implementation_STOCK_CALC_API.binding.StockPriceApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STOCK-PRICE-API")
public interface StockPriceClient {

    @GetMapping("/price/{companyName}")
    public StockPriceApiResponse invokeStockPriceApi(@PathVariable String companyName);
}
