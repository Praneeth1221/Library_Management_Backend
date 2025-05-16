package edu.icet.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer userid;
    private String name;
    private String email;
    private LocalDateTime createAt;
}
