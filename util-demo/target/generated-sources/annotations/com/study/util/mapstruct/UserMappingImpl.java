package com.study.util.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-26T09:59:50+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_112 (Oracle Corporation)"
)
public class UserMappingImpl implements UserMapping {

    @Override
    public void toUserDto(User user, UserDto userDto) {
        if ( user == null ) {
            return;
        }

        userDto.setUserName( user.getUser_name() );
        userDto.setUserAge( user.getUser_age() );
    }

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserName( user.getUser_name() );
        userDto.setUserAge( user.getUser_age() );

        return userDto;
    }

    @Override
    public User2 toUser2(User user) {
        if ( user == null ) {
            return null;
        }

        User2 user2 = new User2();

        user2.setUser_name( user.getUser_name() );
        user2.setUser_age( user.getUser_age() );

        return user2;
    }

    @Override
    public List<UserDto> toUserDto2List(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserDto( user ) );
        }

        return list;
    }
}
