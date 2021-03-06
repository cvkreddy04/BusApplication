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

import com.cts.demo.busticketbo.BusticketBo;
import com.cts.demo.feign.BuyerFeign;
import com.cts.demo.pojo.Busticket;
import com.cts.demo.repo.BusticketRepository;

@RestController
@RequestMapping("/Busticket")
public class BusticketController {

	@Autowired
	private BusticketRepository busticketrepository;
	@Autowired
	BuyerFeign bf;
	@RequestMapping("/getAllbusticket")
	public Iterable<Busticket>getAllbusticket()
	{
		return busticketrepository.findAll();
	}
	@PostMapping("/savebusticket")
	public Busticket saveBusticket(@RequestBody Busticket busticket)
	{
		System.out.println(busticket);
		busticketrepository.save(busticket);
		return busticket;
	}
	@PutMapping("/putbusticket/{busno}")
	public Busticket updateBusticket(@RequestBody Busticket busticket,@PathVariable("busno") int busno)
	{
		
		busticket.setBusno(busno);
		System.out.println(busticket);
		
		busticketrepository.save(busticket);
		return busticket;
	}
	@DeleteMapping("/deletebusticket/{busno}")
	public boolean deleteBusticket(@PathVariable("busno") int busno)
	{
		
	
		System.out.println(busno);
		
		busticketrepository.deleteById(busno);
		return true;
	}
	@GetMapping("/findbusticket/{busno}")
	public Busticket findAllinOne(@PathVariable("busno")  int busno)
	{
	
	Optional<Busticket> busticket=busticketrepository.findById(busno);
	
	


		return busticket.get();
	}
	@GetMapping("/findOneInAll3/{busno}")

	 public BusticketBo findOneInAll3(@PathVariable("busno") int busno) {

	 Optional<Busticket> busticket  = busticketrepository.findById(busno);

	 Busticket bt = busticket.get();



	 BusticketBo bo = new BusticketBo();

	 
	bo.setBusno(bt.getBusno());

	 bo.setSeats(bt.getSeats());

	 bo.setPrice(bt.getPrice());

	 bo.setDate(bt.getDate());

	 bo.setTime(bt.getTime());

	 bo.setSource(bt.getSource());
	  
	 bo.setDestination(bt.getDestination());
	 
	 bo.setName(bt.getName());
	 
	 


	 bo.setMobile(bf.getmobile(bt.getName()));

	 return bo;

	 }
}
