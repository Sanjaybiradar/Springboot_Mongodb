package com.learning.springboot_mongodb.service;
/*

import com.learning.springboot_mongodb.entity.Employee;
import com.learning.springboot_mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public UserDetails loadUserByUsername(String empName) throws UsernameNotFoundException {
        Optional<Employee> employee = repository.findByUserName(empName);
        return employee.map(GroupUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(empName+" does not exist"));
    }
}
*/
