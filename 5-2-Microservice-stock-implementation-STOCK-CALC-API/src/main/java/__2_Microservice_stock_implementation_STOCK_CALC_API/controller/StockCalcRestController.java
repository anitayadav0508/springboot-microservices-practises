package __2_Microservice_stock_implementation_STOCK_CALC_API.controller;

import __2_Microservice_stock_implementation_STOCK_CALC_API.binding.StockCalcApiResponse;
import __2_Microservice_stock_implementation_STOCK_CALC_API.service.StockCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockCalcRestController {
    @Autowired
    private StockCalcService calcService;

    @GetMapping("/calc/{companyName}/{quantity}")
    private StockCalcApiResponse getStocksCost(@PathVariable String companyName, @PathVariable Integer quantity){

        return calcService.getStocksCost(companyName,quantity);

    }


}
