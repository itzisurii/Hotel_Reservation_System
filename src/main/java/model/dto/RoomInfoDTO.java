package model.dto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class RoomInfoDTO {
    private String roomID;
    private String type;
    private String description;
    private double price;
}
