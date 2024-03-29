package com.javacourse.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.City;

@RestController
@RequestMapping(value = "/api/v1/")
public class CityController {

	private ICityService cityService;

	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/cities")
	public List<City> get() {
		return this.cityService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody City city) {
		this.cityService.add(city);
	}

	@PostMapping("/update")
	public void update(@RequestBody City city) {
		this.cityService.update(city);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		this.cityService.delete(city);
	}

	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id) {

		return this.cityService.getById(id);
	}

}
