package com.example.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import com.example.service.LoginUserDetails;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET) //getCustomersメソッドに対して、Getを割り当て（POSTではなく）
	Page<Customer> getCustomers(@PageableDefault(page=0,size=5) Pageable pageable 
	/*引数にPageableオブジェクトを追加することで、ページネーションの情報を取得できる
	 * リクエストパラメータに設定したpage sizeがこのPageableオブジェクトにマッピングされる
	 * PageableDefaultアノテーションは、パラメータが指定されたかった場合のため*/)
	{
		
		Page<Customer> customers=customerService.findAll(pageable);
		return customers;
	}
	//顧客一件取得
	@RequestMapping(value="{id}",method= RequestMethod.GET) //GET割り当て
	Customer getCustomer(@PathVariable Integer id){
		Customer customer = customerService.findOne(id);
		//customer.setFirstName("XXXXX");
		System.out.println("★"+customer.getFirstName());
		return customer;
	}
	
	//顧客作成
	@RequestMapping(method=RequestMethod.POST) //POSTでアクセスすると、このメソッドが呼ばれる
	//@ResponseStatus(HttpStatus.CREATED) //正常時のHTTPレスポンスを指定する
	ResponseEntity<Customer> postCustomers(@RequestBody Customer customer/*HTTPのリクエストをCustomerにMapping*/
			,UriComponentsBuilder uriBuilder /*コンテキストパス相対のURIを取得*/,@AuthenticationPrincipal LoginUserDetails userDetails){
		Customer createdCustomer = customerService.create(customer,userDetails.getUser());
		//URIを作成する。{id}は後に呼ばれている　BuildAndExpandの引数に置換される。
		URI location = uriBuilder.path("api/customers/{id}").buildAndExpand(createdCustomer.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		System.out.println("CREATED has been called.");
		
		//レスポンスヘッダを返却したい場合は、Response Entityオブジェクトを返却する
		return new ResponseEntity<>(createdCustomer,headers,HttpStatus.CREATED);
	}
	
	//顧客更新
	@RequestMapping(value="{id}", method=RequestMethod.PUT) //
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer,@AuthenticationPrincipal LoginUserDetails userDetails ){
		customer.setId(id);
		return customerService.update(customer,userDetails.getUser());
	}
	
	//顧客一件削除
	@RequestMapping(value="{id}", method=RequestMethod.DELETE) //
	@ResponseStatus(HttpStatus.NO_CONTENT) //
	void deleteCustomer(@PathVariable Integer id){
		customerService.delete(id);
	}
	
	

}
