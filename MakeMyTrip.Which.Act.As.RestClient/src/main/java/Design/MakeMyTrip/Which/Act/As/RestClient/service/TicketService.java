package Design.MakeMyTrip.Which.Act.As.RestClient.service;

import Design.MakeMyTrip.Which.Act.As.RestClient.request.PassengerRequest;
import Design.MakeMyTrip.Which.Act.As.RestClient.response.TicketResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
/*This class used to represent HTTP-client logic which is used to access rest api*/
public class TicketService {
    /*How to send post request from Rest-client to IRCTC application api or this method is used to send post request to server */
    public TicketResponse initiateTicketBookProcess(PassengerRequest requestData){
        /*Here  do we need to write logic to book ticket to IRCTC website or
        * to invoke IRCTC api to book ticket */
        String endPointUrl = "http://localhost:9090/api/irctc/bookticket";

        /*I want to send data(i.e requestData) along with header do following changes start ---*/
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type","application/json");
        headers.set("Accept","application/json");
        HttpEntity<PassengerRequest> request =  new HttpEntity<>(requestData,headers);

        /*FINISH HERE send HttpHeaders along with request */
        RestTemplate rt = new RestTemplate();
//       ResponseEntity<TicketResponse> response =rt.postForEntity(endPointUrl,request,TicketResponse.class);
       // OR
        ResponseEntity<TicketResponse> response =   rt.exchange(endPointUrl, HttpMethod.POST,request,TicketResponse.class);

        return response.getBody();

    }
}
