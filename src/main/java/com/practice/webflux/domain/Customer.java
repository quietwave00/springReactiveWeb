package com.practice.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
        @Id
        private Long id;
        private final String firstName;
        private final String lastName;

        @Override
        public String toString() {
                return "Customer{" +
                        "id=" + id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        '}';
        }
}
