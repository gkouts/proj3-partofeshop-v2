package model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")//???
public class Product 
{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="barcode")
	protected String barcode;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="color")
	protected String color;
	
	@Column(name="description")
	protected String description;

	public Product() {
		super();
	}

	public Product(String barcode, String name, String color, String description) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.color = color;
		this.description = description;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nBarcode:  " + barcode + ", Name:  " + name 
				+ ", Color:  " + color + ", Description:  " + description;
	}
	
	
}
