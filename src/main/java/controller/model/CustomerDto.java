package controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private Integer id;
    private String title;
    private String name;
    private String DOB;
    private Double salary;
    private String address;
    private String city;
    private String province;
    private Integer postalCode;
}
