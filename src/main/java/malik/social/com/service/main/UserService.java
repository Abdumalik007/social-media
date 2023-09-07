package malik.social.com.service.main;


import malik.social.com.dto.UserDto;
import malik.social.com.dto.custom.LoginRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    void register(UserDto userDto);

}
