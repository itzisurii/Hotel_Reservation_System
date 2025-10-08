package model.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CustomerInfoDTO {
    private String cusID;
    private String name;
    private Integer age;
    private Integer phoneNumber;
    private String city;
}
