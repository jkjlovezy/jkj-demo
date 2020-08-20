package com.study.util.mapstruct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User user  = new User("test1",12,"adress1");
       /* UserDto userDto = new UserDto();
        UserMapping.INSTANCE.toUserDto(user,userDto);
        System.out.println(userDto);

        System.out.println(UserMapping.INSTANCE.toUserDto(user));*/

        System.out.println(UserMapping.INSTANCE.toUser2(user));

        List<User> users = Arrays.asList("a:1:address1","b:2:address2").stream().map(s->new User(s.split(":")[0],Integer.valueOf(s.split(":")[1]),s.split(":")[2])).collect(Collectors.toList());
        List<UserDto> userDtos = UserMapping.INSTANCE.toUserDto2List(users);
        userDtos.forEach(System.out::println);
    }
}
