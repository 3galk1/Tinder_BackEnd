package ru.liga.tinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.liga.tinder.dto.UserDto;
import ru.liga.tinder.entity.User;
import ru.liga.tinder.mapper.UserMapper;
import ru.liga.tinder.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SpringDataConnectionProvider {

    private UserMapper userMapper;
    private UserRepository userRepository;

    public List<UserDto> getAllUser() {
        return userMapper.createUserDtoList(userRepository.findAll());

    }

    public UserDto getUserById(long id) {
        return userMapper.createUserDto(userRepository.getUserById(id));
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.createUser(userDto);
        userRepository.save(user);
        return getUserById(userDto.getId());
    }


//        public void updateCustomer(long id){
//            Customer customer = userRepository.getCustomerById(id);
//            customer.setState();
//            userRepository.save(customer);
//        }


}
