package com.api.store.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.api.store.controller.StoreController;
import com.api.store.exception.NoSuchURLFoundexception;
import com.api.store.exception.UrlAlreadyExistsException;
import com.api.store.exception.UrlCannotbeNullException;
import com.api.store.model.Store;

@Service
public class StoreService {

	final static Logger logger = LoggerFactory.getLogger(StoreController.class);

	ArrayList<Store> storelist = new ArrayList<Store>();
    int count=0;
	/**
	 * Used to save store url
	 * 
	 * @author Rukesh
	 * @param url
	 * @return
	 */
	public Store SavestoreUrl(String url) {

		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		if (url == null) {
			throw new UrlCannotbeNullException(" please provide url  ");
		}

		Boolean flag = this.findByName(url);

		if (flag == true) {
			throw new UrlAlreadyExistsException(" URL already exists  ");
		}
     
		count++;
		Store store = new Store();
		store.setId(count);
		store.setUrl(url);
		store.setCount(0);
		store.setUniqueKey(this.getAlphaNumericString(5));
      
		storelist.add(store);

		logger.info("End of  ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return store;
	}

	/**
	 * used to get uniue key from url
	 * @author Rukesh
	 * @param url
	 * @return
	 */
	public String getStoreUrl(String url) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		String uniquekey = null;
		if (url == null) {
			throw new UrlCannotbeNullException(" please provide url  ");
		}

		Boolean flag = this.findByName(url);

		if (flag == false) {
			throw new NoSuchURLFoundexception(" This Url not found  ");
		}

		Store store = this.getStoreObject(url);
		if (store != null) {
			uniquekey = store.getUniqueKey();
			store.setCount(store.getCount()+1);
		}

		logger.info("End of  ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return uniquekey;

	}

	
	/**
	 * used to get count of url that no of times has been accessed
	 * @author Rukesh
	 * @param url
	 * @return
	 */
	public Integer getStoreCount(String url) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		Integer storeCount=null;
		
		if (url == null) {
			throw new UrlCannotbeNullException(" please provide url  ");
		}

		Boolean flag = this.findByName(url);

		if (flag == false) {
			throw new NoSuchURLFoundexception(" This Url not found  ");
		}
		
		Store store = this.getStoreObject(url);
		if (store != null) {
			storeCount = store.getCount();
			
		}

		logger.info("End of ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return storeCount;

	}

	/**
	 * used to get the list of urls
	 * @author Rukesh
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<String> getAllStoreUrls(Integer pageNo, Integer pageSize) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		
           
		List<String> urls =  this.geturls();
		
		
		logger.info("End of ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());
		
		return urls;

	}
	
	
	

	/**This method is used to generate unique key for url
	 * @author Rukesh
	 * @param number
	 * @return
	 */

	String getAlphaNumericString(int number) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		// chose a Character random from this String
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(number);

		for (int i = 0; i < number; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (alphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(alphaNumericString.charAt(index));
		}
		logger.info("End of ...." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return sb.toString();
	}

	
	/**This method is used to find whether url present or not
	 * @author Rukesh
	 * @param url
	 * @return
	 */
	private Boolean findByName(String url) {

		Boolean flag = false;

		if (storelist.size() > 0) {
			Iterator<Store> itr = storelist.iterator();
			while (itr.hasNext()) {
				Store store = itr.next();
				if (url.equalsIgnoreCase(store.getUrl())) {
					flag = true;
					break;
				}
			}
		}

		return flag;

	}

	
	
	/**Used to get the urls
	 * @author Rukesh
	 * @return
	 */
	
	private List<String> geturls() {
 
		List<String> urlList=null;		
		if (storelist.size() > 0) {
			Iterator<Store> itr = storelist.iterator();
			while (itr.hasNext()) {
				Store store = itr.next();
				String url = store.getUrl();
				urlList.add(url);
				
			}
		}
		
		return urlList;
	}
	
	
	
	
	/**
	 * This method is used to get Store object based on url
	 * @author Rukesh
	 * @param url
	 * @return
	 */
	private Store getStoreObject(String url) {
		Boolean flag = false;
		Store storeobj = null;
		if (storelist.size() > 0) {
			Iterator<Store> itr = storelist.iterator();
			while (itr.hasNext()) {
				Store store = itr.next();
				if (url.equalsIgnoreCase(store.getUrl())) {
					storeobj = store;
					break;
				}
			}
		}

		return storeobj;
	}

}
