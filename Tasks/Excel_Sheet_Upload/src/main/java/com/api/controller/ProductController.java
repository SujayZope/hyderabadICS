package com.api.controller;

import com.api.entity.Product;
import com.api.helper.Helper;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/excel")
	public ResponseEntity<Resource> download() throws IOException {

		String filename = "product.xlsx";

		ByteArrayInputStream actualData = productService.getActualData();
		InputStreamResource file = new InputStreamResource(actualData);

		ResponseEntity<Resource> body = ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);

		return body;
	}

	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		if (Helper.checkExcelFormat(file)) {
			// true

			this.productService.save(file);

			return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	}

	@GetMapping("/product")
	public List<Product> getAllProduct() {
		return this.productService.getAllProducts();
	}

}
