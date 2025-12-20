package Design.MakeMyTrip.Which.Act.As.RestClient.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ticket booking response containing confirmed ticket details")
public class TicketResponse {

    @Schema(description = "Unique PNR number for ticket identification", example = "PNR1234567890")
    private String pnr;

    @Schema(description = "Full name of the passenger", example = "John Doe")
    private String name;

    @Schema(description = "Date of birth of the passenger", example = "1990-05-15")
    private String dob;

    @Schema(description = "Gender of the passenger", example = "Male")
    private String gender;

    @Schema(description = "Date of journey", example = "2025-01-15")
    private String doj;

    @Schema(description = "Source station/city", example = "Mumbai")
    private String from;

    @Schema(description = "Destination station/city", example = "Delhi")
    private String to;

    @Schema(description = "Train name or number", example = "Rajdhani Express")
    private String train;

    @Schema(description = "Booking status", example = "CONFIRMED", allowableValues = {"CONFIRMED", "WAITING", "RAC", "CANCELLED"})
    private String status;

    @Schema(description = "Ticket price in INR", example = "1500.00")
    private Float price;

    // Default constructor
    public TicketResponse() {
    }

    // Parameterized constructor
    public TicketResponse(String name, String dob, String gender, String doj, String from, String to, String train, String status, Float price) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.doj = doj;
        this.from = from;
        this.to = to;
        this.train = train;
        this.status = status;
        this.price = price;
    }

    // Getters
    public String getPnr() {
        return pnr;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getDoj() {
        return doj;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTrain() {
        return train;
    }

    public String getStatus() {
        return status;
    }

    public Float getPrice() {
        return price;
    }

    // Setters
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "TicketResponse{" +
                "pnr='" + pnr + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", doj='" + doj + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", train='" + train + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }
}
