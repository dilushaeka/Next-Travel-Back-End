package lk.ijse.identityserver.service;

import lk.ijse.identityserver.dto.AuthRequestDTO;
import lk.ijse.identityserver.dto.AuthorizedRespondsDTO;
import lk.ijse.identityserver.dto.UserDTO;
import lk.ijse.identityserver.dto.UserUpdateDTO;
import lk.ijse.identityserver.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface UserService {

    void saveUser(MultipartFile file, UserDTO userDTO) throws IOException;

    UserDTO updateUser(UserDTO userDTO, MultipartFile file) throws IOException;

    UserDTO updateUserUserNameAndPassword(UserUpdateDTO userUpdateDTO);

    void deleteUser(Integer userId);

    List<UserDTO> getPageableUsers(Integer page, Integer count);

    List<UserDTO> getAll();

    UserDTO findByNic(String nic);

    AuthorizedRespondsDTO generateToken(AuthRequestDTO authRequestDTO) throws IOException;

    void validateToken(String token);

    List<UserDTO> searchByText(String text);
}
