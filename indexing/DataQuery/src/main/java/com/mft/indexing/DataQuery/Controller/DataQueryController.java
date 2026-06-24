package com.mft.indexing.DataQuery.Controller;

import com.mft.indexing.DataQuery.dto.EmployeeResponseDto;
import com.mft.indexing.DataQuery.service.DataQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data-query")
public class DataQueryController {
    @Autowired
    public DataQueryServiceImpl dataQueryService;
    @GetMapping("/test")
    public String test() {
        return "Data Query Service is working!";
    }
    @GetMapping("/findEmployeeByEmail")
    public String findEmployeeByEmail(@RequestParam("email") String email) {
long startTime = System.currentTimeMillis();
        EmployeeResponseDto employeeResponseDto = dataQueryService.getByEmail(email);
        long endTime = System.currentTimeMillis();;
        System.out.println(" the total time taken is " + (endTime - startTime) + " milliseconds.");
        return "Finding employee by email: " + email;
    }

    @GetMapping("/findAll")
    public List<EmployeeResponseDto> findAllEmails(){
      List<EmployeeResponseDto>employeeResponseDtos = dataQueryService.findAllEmails();
        return employeeResponseDtos;
    }


}
