package com.demo.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.project.dto.CustomerDTO;
import com.demo.project.entity.Customer;
import com.demo.project.repo.CustomerRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepo custRepo;

    public String getAllCustomers(Long leadId) {
        HashMap<String, CustomerDTO> presentMap = new HashMap<>();
        HashMap<String, Object> nullMap = new HashMap<>();
        HashMap<String, Object> finalResponse = new HashMap<>();

        Optional<Customer> customerResult = custRepo.findById(leadId);
            

       
        if(customerResult.isPresent()){
            Customer customer = customerResult.get();

            CustomerDTO cust = new CustomerDTO();

            if (customer.getLeadId() == null) nullMap.put("leadId", null);
            if (customer.getName() == null) nullMap.put("name", null);
            if (customer.getGender() == null) nullMap.put("gender", null);
            if (customer.getAge() == null) nullMap.put("age", null); // Assuming 0 means missing
            if (customer.getAddress() == null) nullMap.put("address", null);
            
            cust.setLeadId(customer.getLeadId());
            cust.setName(customer.getName());
            cust.setGender(customer.getGender());
            cust.setAge(customer.getAge());
            cust.setAddress(customer.getAddress());

            presentMap.put("presentValues", cust);

            finalResponse.put("presentResponse", presentMap);
            finalResponse.put("nullResponse", nullMap);
            // Gson gson = new Gson();
            Gson gson = new GsonBuilder().serializeNulls().create();
            return gson.toJson(finalResponse);
        
        }else{
            throw new RuntimeException("Customer not found!");
        }
      
    }
    
}
