package com.api.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.api.store.model.Store;
import com.api.store.service.StoreService;

@RestController
public class StoreController {

	final static Logger logger = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	private StoreService storeService;

	@PostMapping("/storeurl")
	public ResponseEntity<Store> saveStoreUrl(@RequestParam("url") String storeurl) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		Store store = storeService.SavestoreUrl(storeurl);

		logger.info("End  of ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return new ResponseEntity<Store>(store, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<String> getStoreUrl(@RequestParam("url") String storeurl) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		String uniquekey = storeService.getStoreUrl(storeurl);

		logger.info("End of ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return new ResponseEntity<String>(uniquekey, HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Integer> getStoreCount(@RequestParam("url") String storeurl) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		Integer urlAccessCount = storeService.getStoreCount(storeurl);

		logger.info("End of  ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return new ResponseEntity<Integer>(urlAccessCount, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Store>> getStoreUrls(@RequestParam(defaultValue = "0") String page,
			@RequestParam(defaultValue = "0") String size) {
		logger.info("Entered into ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		Integer pageno = Integer.parseInt(page);
		Integer pagesize = Integer.parseInt(size);

		List<Store> store = storeService.getAllStoreUrls(pageno, pagesize);

		logger.info("End of  ..." + Thread.currentThread().getStackTrace()[1].getMethodName() + "... IN... "
				+ this.getClass().getName());

		return new ResponseEntity<List<Store>>(store, HttpStatus.OK);
	}

}
