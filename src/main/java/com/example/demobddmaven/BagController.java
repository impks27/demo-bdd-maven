package com.example.demobddmaven;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/things")
public class BagController {

	private final Bag bag = new Bag();

	@GetMapping
	public Bag getBag() {
		return bag;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addAnything(@RequestBody String something) {
		bag.getThings().add(something);
	}

	@DeleteMapping
	public void removeEverything() {
		bag.getThings().clear();
	}
}
