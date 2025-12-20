package Design.MakeMyTrip.Which.Act.As.RestClient.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Passenger booking request containing travel and personal details")
public class PassengerRequest {

    @Schema(description = "Full name of the passenger", example = "John Doe", required = true)
    private String name;

    @Schema(description = "Date of birth of the passenger", example = "1990-05-15", required = true)
    private String dob;

    @Schema(description = "Gender of the passenger", example = "Male", allowableValues = {"Male", "Female", "Other"})
    private String gender;

    @Schema(description = "Date of journey", example = "2025-01-15", required = true)
    private String doj;

    @Schema(description = "Source station/city", example = "Mumbai", required = true)
    private String from;

    @Schema(description = "Destination station/city", example = "Delhi", required = true)
    private String to;

    @Schema(description = "Train name or number", example = "Rajdhani Express", required = true)
    private String train;

    // Default constructor
    public PassengerRequest() {
    }

    // Parameterized constructor
    public PassengerRequest(String name, String dob, String gender, String doj, String from, String to, String train) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.doj = doj;
        this.from = from;
        this.to = to;
        this.train = train;
    }

    // Getters
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

    // Setters
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

    // toString
    @Override
    public String toString() {
        return "PassengerRequest{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", doj='" + doj + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", train='" + train + '\'' +
                '}';
    }
}
