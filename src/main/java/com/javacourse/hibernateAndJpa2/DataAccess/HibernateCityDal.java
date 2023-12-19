package com.javacourse.hibernateAndJpa2.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javacourse.hibernateAndJpa2.Entities.City;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository //Bu anotasyon, bu sınıfın spring framework'e DAL sınıfı olduğunu belirtir.
public class HibernateCityDal implements ICityDal{
	//Hibernate mimarisiyle oluşturulan DAL katmanıdır. Operasyonları ICityDal interface'sinden implement eder
	
	private EntityManager entityManager; //JPA kullanarak veritabanı işlemlerini gerçekleştirmek için bir ENtityManager nesnesini depolamak için kullanılır.
	
	
	@Autowired //Bu anotasyon ile Spring framework tarafından otomatik olarak EntityManager enjekte edilir.
	public HibernateCityDal(EntityManager entityManager) { //Constructer blok sayesinde bağlı olduğu katman EntityManagera erişir.
		this.entityManager = entityManager; //JPA'dan gelen entityManager'ı argüman olarak gelen EntityManager'a enjekte eder. 
		
	}
	
	@Override
	@Transactional //Bu anotasyon, Spring frameworkten gelerek sorguda bir hata olması durumunda işlemi geri alması gerektiğini belirtir.
	public List<City> getAll() { //Bu fonksiyon liste döndürür.
		Session session = entityManager.unwrap(Session.class); //JPA'dan gelen EntityManager nesnesi üzerinden Hibernate Session nesnesine erişim sağlanır ve sorgu başlatılır.
		List<City> cities = session.createQuery("FROM City",City.class).getResultList(); //Database'i temsil eden City sınıfının bilgileri döndürülür ve getResultList fonksiyonuyla liste haline getirilir.
		return cities;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city); //saveOrUpdate fonksiyonuya city parametresi veritabanına eklenir.
		
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city); //saveOrUpdate fonksiyonuya city parametresi veritabanında güncellenir.
		
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId()); //Database'yi temsil edilen City nesnesinden, dışarıdan gelen city nesnesinin id'si getirilir ve silinir.
		session.delete(cityToDelete);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class,id); //Database'yi temsil edilen City nesnesinden, dışarıdan gelen id'nin karşılığındaki bilgiler döndürülür.
		return city;
	}
	
	
}
