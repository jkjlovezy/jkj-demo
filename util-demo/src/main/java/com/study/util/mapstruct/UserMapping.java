package com.study.util.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapping {

    UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

    @Mappings({
            @Mapping(source = "user_name", target = "userName"),
            @Mapping(source = "user_age", target = "userAge"),
    })
    public void toUserDto(User user, @MappingTarget UserDto userDto);

    @Mappings({
            @Mapping(source = "user_name", target = "userName"),
            @Mapping(source = "user_age", target = "userAge"),
    })
    public UserDto toUserDto(User user);


    public User2 toUser2(User user);

    public List<UserDto> toUserDto2List(List<User> userList); //若两个bean字段名称不一致，必须有一个转换单个bean的方法user-userDto。
}
