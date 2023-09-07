package malik.social.com.mapper;


import malik.social.com.dto.UserDto;
import malik.social.com.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
