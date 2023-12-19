package com.javacourse.hibernateAndJpa2.DataAccess;

import java.util.List;

import com.javacourse.hibernateAndJpa2.Entities.City;

public interface ICityDal {
	//Database temsili olan Entities nesnesine erişen katmandır.
	
	List<City> getAll(); //bu operasyon City nesnesini liste halinde döndürür.
	void add(City city); //bu operasyon parametre olarak aldığı city nesnesini ekleme işlemi yapar.
	void update(City city); //bu operasyon parametre olarak aldığı city nesnesini güncelleme işlemi yapar.
	void delete(City city); //bu operasyon parametre olarak aldığı city nesnesini silme işlemi yapar.
	City getById(int id); //bu operasyon parametre olarak aldığı Entites nesnesinden id değişkenini döndürür.
}
