package com.javacourse.hibernateAndJpa2.Entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Sınıfın bir JPA varlığı oldupunu belirtir. Bu sınıfın veritabanı tablosunu temsil edeceği anlamına gelir.
@Table(name="City") //Database tablosunun karşılık geleceği sınıf olarak tanımlanır. Argüman olarak database tablo ismi verilir.
public class City {
	@Id	//Bu anotasyon,değişkenin primary key olduğunu belirtir.
	@Column(name="ID") //Bu anotasyon,değişkenin database sütun karşılığı verilen argümandır.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Primary key'in otomatik olarak oluşmasını sağlayan anotasyon
	private int id; //Tablodaki ID sütunu id değişkenine aktarılır Bu değişken dışarıdan getter ve setter dışında erişilememesi için yani encapulation mimarisi için private yapılır
	
	@Column(name="Name")
	private String name;
	
	@Column(name = "CountryCode")
	private String countryCode;
	
	@Column(name = "District")
	private String district;
	
	@Column(name = "Population")
	private String population;
	
	
	//Constructor blok sayesinde bu sınıf dışarıdan argümanlı olarak çağrılabilir.
	public City(int id,String name, String countryCode, String district, String population){
		
		//yukarıda tablo değişkenlerinin anotasyonu olan değişkenler dışarıdan gelen argümana eşitlenir.
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	
	public City() { //City entity nesnesini argümansız başka sınıflar içinde çağırabilmek için varsayılan constructor blok oluşturulur.
		
	}

	//getter ile değişkenin değeri döndürülür. Dışarıdan bu değişken çağrılabilir.
	public int getId() {
		return id;
	}

	//setter ile değişkenin değeri başka bir class üzerinden set edilebilir.
	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getPopulation() {
		return population;
	}


	public void setPopulation(String population) {
		this.population = population;
	}
	
	
}
