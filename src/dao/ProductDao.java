package dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Product;
import utl.HibernateUtil;


public class ProductDao 
{
	
	public List<String> insertProduct(Product product) {
		List<String> result = new ArrayList<String>();//"Data entered succesfully"
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(product);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
			result.add("A product with the given barcode already exists.");
			result.add("\n Try another barcode.");
			return result;
		}
		
		result.add("Barcode:     " + product.getBarcode());
		result.add("Name:        " + product.getName());
		result.add("Color:       " + product.getColor());
		result.add("Description: " + product.getDescription());
		
		return result;
	}
	
}
