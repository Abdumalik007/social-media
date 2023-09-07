package malik.social.com.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(value = "password", allowSetters = true)
public class UserDto implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    @NotBlank(message = "Email must not be empty")
    private String email;

    @Size(min = 6, message = "Password must contain at least 6 characters")
    @NotBlank(message = "Password must not be empty")
    private String password;

}
