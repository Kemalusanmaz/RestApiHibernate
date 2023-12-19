package com.javacourse.hibernateAndJpa2.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacourse.hibernateAndJpa2.DataAccess.ICityDal;
import com.javacourse.hibernateAndJpa2.Entities.City;

import jakarta.transaction.Transactional;

@Service //Bu anotasyon, spring frameworkn gelir ve bu sınıfın Spring business sınıfı olduğunu belirtir.
public class CityManager implements ICityService{
	
	private ICityDal cityDal; //Bu sınıfa enjekte edilecek CityDal nesnesinin referansını tutması için bir değişken tanımlnır.
	
	@Autowired
	public CityManager(ICityDal cityDal) { //Bu constructor blok, bağımlılıkların enjekte edildiği yerdir. ICityDal interface'ten implemente edilmiş bir nesnenin örneği bu sınıfa enjekte edilir.
		this.cityDal = cityDal; //CityDal nesnesini temsil eden cityDal değişkenine dışarıdan gelen cityDal nesnesi atanır.
	}

	//Dependency injection yöntemiyle cityDal nesnesi Business katmanında döndürülür.
	
	@Override
	@Transactional
	public List<City> getAll() { 
		return cityDal.getAll();
		
	}

	@Override
	@Transactional
	public void add(City city) {
		cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		cityDal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		cityDal.delete(city);
		
	}

	@Override
	public City getById(int id) {
		return cityDal.getById(id);
	}
	

}
