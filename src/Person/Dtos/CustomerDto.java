package Person.Dtos;

import java.util.Date;

public class CustomerDto extends PersonDto {
   private Date dateOfBirth; 
   private String phone;  
   private String email;
   private String address;

    public CustomerDto(String id, String name, Date dateOfBirth, String phone, String email, String address ) {
        super(id, name);
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
   
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    public String getAddress() {
        return address;
    }

}





   
