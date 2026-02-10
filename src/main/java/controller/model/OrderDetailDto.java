package controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailDto {
    private String id;
    private String code;
    private Integer qty;
    private Double price;
    private Integer discount;
    private Double total;
}
