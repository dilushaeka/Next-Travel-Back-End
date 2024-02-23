package lk.ijse.identityserver.dto;

import lk.ijse.identityserver.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthorizedRespondsDTO {

    private String token;

    private Role role;

    private String username;

    private String nic;

    private String email;

    private byte[] imgArray;
}
