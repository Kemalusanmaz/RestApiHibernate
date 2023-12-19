package com.javacourse.hibernateAndJpa2.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.hibernateAndJpa2.Business.ICityService;
import com.javacourse.hibernateAndJpa2.Entities.City;

@RestController //Bu anotasyon, sınıfın bir Restful Api kontorlcüsü olduğunu belirtir. Yani bu sınıf HTTP isteklerine cevap verir ve JSON formatında veri döndürür.
@RequestMapping("/api") //Bu anotasyon, bu sınıfın içindeki tüm operasyonların /api yolunu paylaştığını belirtir. Yani bu sınıftaki tüm metodlar /api yolu altında bulunur.
public class Controller {
	
	private ICityService cityService; //Bu sınıfa enjekte edilecek CityService nesnesinin referansını tutması için bir değişken tanımlnır.

	@Autowired
	public Controller(ICityService cityService) { //Bu constructor blok, bağımlılıkların enjekte edildiği yerdir. ICityService interface'ten implemente edilmiş bir nesnenin örneği bu sınıfa enjekte edilir.
		this.cityService = cityService;
	}
	
	@GetMapping("/cities") //Bu anotasyon, HTTP GET isteğine cevap verecek olan get metodunu belirtir. api/cities yoluna gelen GET istekleri bu metodu çalıştırır ve şehir verilerini liste olarak döndürür. 
	public List<City> get(){
		return cityService.getAll();
	}
	
	@PostMapping("/add") //Bu anotasyon, HTTP POST isteğine cevap verecek olan add metodunu belirtir. api/add yoluna gelen POST istekleri bu metodu çalıştırır ve şehir verilerini liste olarak döndürür. 
	public void add(@RequestBody City city) { //RequestBody anotasyonu, bir pring MVC contoller metodunun parametre olarak bir HTTP isteğinin gövdesinden gelen veriyi alması gerektiğini belirtir. JSON verisini temsil eder.
		cityService.add(city);
	}
	
	@PostMapping("/update") //Bu anotasyon, HTTP POST isteğine cevap verecek olan add metodunu belirtir. api/add yoluna gelen POST istekleri bu metodu çalıştırır ve şehir verilerini liste olarak döndürür. 
	public void update(@RequestBody City city) { //RequestBody anotasyonu, bir pring MVC contoller metodunun parametre olarak bir HTTP isteğinin gövdesinden gelen veriyi alması gerektiğini belirtir. JSON verisini temsil eder. 
		cityService.update(city);
	}
	
	@PostMapping("/delete") //Bu anotasyon, HTTP POST isteğine cevap verecek olan add metodunu belirtir. api/delete yoluna gelen POST istekleri bu metodu çalıştırır ve şehir verilerini liste olarak döndürür. 
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	
	@GetMapping("/cities/{id}") ////Bu anotasyon, HTTP GET isteğine cevap verecek olan get metodunu belirtir. api/cities/{id} yoluna gelen GET istekleri bu metodu çalıştırır ve şehir verilerini liste olarak döndürür.{id} dinamik değişkendir
	public City getById (@PathVariable int id) {
		return cityService.getById(id);
	}
	
}
