/**
 * 
 */
package com.example.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author dcividin
 *
 */
@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String addressLine1;
	private String name;
	private String city;
	private String state;
	private String zip;
	
	@OneToMany
	private Set<Book> books = new HashSet<>();

	/**
	 * 
	 */
	public Publisher() {
		super();
	}

	/**
	 * @param name
	 * @param city
	 * @param state
	 */
	public Publisher(String name, String city, String state) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", addressLine1=" + addressLine1 + ", name=" + name + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, id, name, state, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Publisher other = (Publisher) obj;
		return Objects.equals(city, other.city) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(state, other.state) && Objects.equals(zip, other.zip);
	}
}
