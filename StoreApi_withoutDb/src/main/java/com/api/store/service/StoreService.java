package com.api.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.store.controller.StoreController;
import com.api.store.exception.UrlAlreadyExistsException;
import com.api.store.exception.UrlCannotbeNullException;
import com.api.store.model.Store;

@Service
public class StoreService {

	final static Logger logger = LoggerFactory.getLogger(StoreController.class);

	

	public Store SavestoreUrl(String url) {

		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		if (url == null) {
			throw new UrlCannotbeNullException(" please provide url  ");
		}

		

		

		Store store = new Store();
		store.setUrl(url);
		store.setCount(0);
		store.setUniqueKey(this.getAlphaNumericString(5));

		logger.info("End of  ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return null;
	}

	public String getStoreUrl(String url) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		//Optional<Store> optstore = storeRepository.findByUrl(url);

		/*
		 * if (!optstore.isPresent()) { throw new
		 * UrlAlreadyExistsException("This Url not found "); }
		 */

		//Store store = optstore.get();
		//store.setCount(store.getCount() + 1);

		//storeRepository.save(store);

		logger.info("End of  ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return null;

	}

	public Integer getStoreCount(String url) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		//Optional<Store> optstore = storeRepository.findByUrl(url);

		/*
		 * if (!optstore.isPresent()) { throw new
		 * UrlAlreadyExistsException("This Url not found "); }
		 */

		logger.info("End of ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return null;

	}

	public List<Store> getAllStoreUrls(Integer pageNo, Integer pageSize) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		
		

		logger.info("End of ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return null;

	}

	String getAlphaNumericString(int n) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		// chose a Character random from this String
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

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

}
