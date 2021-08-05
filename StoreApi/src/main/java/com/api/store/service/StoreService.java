package com.api.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.store.controller.StoreController;
import com.api.store.exception.NoSuchURLFoundexception;
import com.api.store.exception.UrlAlreadyExistsException;
import com.api.store.exception.UrlCannotbeNullException;
import com.api.store.model.Store;
import com.api.store.repository.StoreRepository;

@Service
@Transactional
public class StoreService {

	final static Logger logger = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	private StoreRepository storeRepository;
	
	/**used for save URL
	 * @author @rukesh
	 * @param url
	 * @return
	 */

	public Store SavestoreUrl(String url) {

		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		if (url == null) {
			throw new UrlCannotbeNullException(" please provide url  ");
		}

		Optional<Store> optstore = storeRepository.findByUrl(url);

		if (optstore.isPresent()) {
			throw new UrlAlreadyExistsException("This Url UrlAlreadyExists");
		}

		Store store = new Store();
		store.setUrl(url);
		store.setCount(0);
		store.setUniqueKey(this.getAlphaNumericString(5));

		logger.info("End of  ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return storeRepository.save(store);
	}

	
	
	/**used for  get  uniquekey for url
	 * @author Rukesh  
	 * @param url
	 * @return
	 */
	public String getStoreUrl(String url) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());
     
		if (url == null) {
			throw new UrlCannotbeNullException(" please provide url  ");
		}  
		
		Optional<Store> optstore = storeRepository.findByUrl(url);

		if (!optstore.isPresent()) {
			throw new NoSuchURLFoundexception("This Url not found ");
		}

		Store store = optstore.get();
		store.setCount(store.getCount() + 1);

		storeRepository.save(store);

		logger.info("End of  ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return store.getUniqueKey();

	}

	
	/**used for get count of no.of times url has been accessed
	 * @author Rukesh
	 * @param url
	 * @return
	 */
	public Integer getStoreCount(String url) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		if (url == null) {
			throw new UrlCannotbeNullException(" please provide url  ");
		}
		
		Optional<Store> optstore = storeRepository.findByUrl(url);

		if (!optstore.isPresent()) {
			throw new NoSuchURLFoundexception("This Url not found ");
		}

		logger.info("End of ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return optstore.get().getCount();

	}

	/**
	 * used to get list of urls
	 * @author Rukesh
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Store> getAllStoreUrls(Integer pageNo, Integer pageSize) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		PageRequest paging = PageRequest.of(pageNo, pageSize);

		Page<Store> pagedResult = storeRepository.findAll(paging);

		logger.info("End of ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Store>();
		}

	}

	/**
	 * Used for generate random key
	 * @author Rukesh
	 * @param n
	 * @return
	 */
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
