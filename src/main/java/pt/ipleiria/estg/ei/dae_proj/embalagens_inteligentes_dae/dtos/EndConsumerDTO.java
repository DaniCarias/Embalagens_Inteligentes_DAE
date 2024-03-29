package pt.ipleiria.estg.ei.dae_proj.embalagens_inteligentes_dae.dtos;

public class EndConsumerDTO {

    private String username;
    private String name;
    private String password;
    private String address;
    private int phoneNumber;


    public EndConsumerDTO() {
    }

    public EndConsumerDTO(String username, String name, String password, String address, int phoneNumber) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
