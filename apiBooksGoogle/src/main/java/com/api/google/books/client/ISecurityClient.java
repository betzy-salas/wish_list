package com.api.google.books.client;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.google.books.models.Token;


@FeignClient(name="security-service")

@RequestMapping("/authentication")
public interface ISecurityClient {
	
	@PostMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestBody Token token);
}
