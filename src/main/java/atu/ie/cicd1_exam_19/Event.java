package atu.ie.cicd1_exam_19;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    @NotBlank ( max =40)
    private String EventId;


    @NotBlank @Size ( max =60)
    private String EventId;

}
