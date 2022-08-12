package be.digitalcity.exojwt.models.forms;


import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserForm {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
