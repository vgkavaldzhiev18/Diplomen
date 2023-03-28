package com.app.pizzashop.binding;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEdit {
    private String id;
    @NotEmpty(message = "Трябва да бъде валидно")
    private String firstName;
    @NotEmpty(message = "Трябва да бъде валидно")
    private String lastName;
}
