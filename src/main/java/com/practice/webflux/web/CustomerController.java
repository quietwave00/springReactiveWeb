package com.practice.webflux.web;

import com.practice.webflux.domain.Customer;
import com.practice.webflux.domain.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;
import java.util.concurrent.AbstractExecutorService;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;


    //한번에 flush
    @GetMapping("/flux")
    public Flux<Integer> flux() {
        return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1)).log();
    }

    //한건씩 flush
    @GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> fluxstream() {
        return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Customer> findAll() {
        return customerRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> findById(@PathVariable("id") Long id) {
        return customerRepository.findById(id).log();
    }


}
