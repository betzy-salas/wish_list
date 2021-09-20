package com.ms_wish_list.client;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms_wish_list.model.User;

@FeignClient(name="ms-user")

@RequestMapping("/user")
public interface IUserClient {
	@GetMapping("/userId/{idUser}")
	public @ResponseBody ResponseEntity<Optional<User>> checkUserById(@Valid @PathVariable int idUser) throws Exception;

}
