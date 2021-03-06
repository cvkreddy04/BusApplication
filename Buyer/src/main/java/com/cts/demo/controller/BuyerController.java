package com.cts.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.demo.pojo.Buyer;
import com.cts.demo.repo.BuyerRepository;
@RestController

@RequestMapping("/Buyer")

public class BuyerController {

	@Autowired

	private BuyerRepository buyerRepository;

	@GetMapping("/getAllbuyers")

	public Iterable<Buyer> getAllbuyers() {

		return buyerRepository.findAll();

	}

	@PostMapping("/savebuyer")

	public Buyer saveBuyer(@RequestBody Buyer buyer) {

		System.out.println(buyer);

		buyerRepository.save(buyer);

		return buyer;

	}

	@PutMapping("/updatebuyer/{name}")

	public Buyer updateBuyer(@RequestBody Buyer buyer, @PathVariable("name") String name) {

		buyer.setName(name);

		System.out.println(buyer);

		buyerRepository.save(buyer);

		return buyer;

	}

	@DeleteMapping("/deletebuyer/{name}")

	public Boolean deleteBuyer(@PathVariable("name") String name) {

		System.out.println(name);

		buyerRepository.deleteById(name);

		return true;

	}

	@GetMapping("/findOneInAll/{name}")

	public Buyer findoneinall(@PathVariable("name") String name) {

		Optional<Buyer> buyer = buyerRepository.findById(name);

		return buyer.get();

	}
	public Integer getMobile1(String name) {



		 Optional<Buyer> buyer = buyerRepository.findById(name);



		 Buyer by = buyer.get();



		 return by.getMobile();



		 }



		 @GetMapping("/name/{name}") // we get college name



		 public Integer getmobile(@PathVariable(value = "name") String name) {



		 System.out.println("Iam in college application");



		 return getMobile1(name);



		 }

			

}

