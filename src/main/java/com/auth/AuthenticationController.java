package com.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Feedback;
import com.entity.Plant;
import com.entity.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;


    // Admin Controller

    @PostMapping("/admin/register")
    public String adminregister(@RequestBody RegisterRequest request){
        AuthenticationResponse token =  service.adminregister(request);
        String createdmessage ="";
        if(token!=null){
             createdmessage = "Admin Created";
        }else{
             createdmessage = "SomeThing Went Wrong";

        }
        return createdmessage;
    }

    @PostMapping("/admin/authenticate")
    public ResponseEntity<AuthenticationResponse> adminAuthenticate(@RequestBody AuthenticationRequest adminrequest){
        return ResponseEntity.ok(service.adminAuthenticate(adminrequest));
    }
    
    @GetMapping("/admin/getadmin/{email}")
    public ResponseEntity<Optional<User>> getadminById(@PathVariable String email){
    	return ResponseEntity.ok(service.getadminById(email));
    }
    
    //user controller
    @PostMapping("/user/register")
    public String userregister(@RequestBody RegisterRequest request){
        AuthenticationResponse token =  service.userregister(request);
        String createdmessage ="";
        if(token!=null){
             createdmessage = "User Created";
        }else{
             createdmessage = "SomeThing Went Wrong";

        }
        return createdmessage;
    }
    
    @PostMapping("/user/authenticate")
    public ResponseEntity<AuthenticationResponse> userAuthenticate(@RequestBody AuthenticationRequest userrequest){
        return ResponseEntity.ok(service.userauthenticate(userrequest));
    }
    
    @GetMapping("/user/getuser/{email}")
    public ResponseEntity<Optional<User>> getuserById(@PathVariable String email){
    	return ResponseEntity.ok(service.getuserById(email));
    }
    
    //plant controller
    @PostMapping("/plant/add")
    public String addPlant(@RequestBody PlantAdd request){
        return service.AddPlant(request);
    }
    @GetMapping("/plant/getplant/{plantId}")
    public ResponseEntity<Optional<Plant>> getplantById(@PathVariable long plantId){
    	return ResponseEntity.ok(service.getPlantById(plantId));
    }
    @GetMapping("/plant/getall")
    public ResponseEntity<List<Plant>> getAllplant(){
    	return ResponseEntity.ok(service.getAllPlants());
    }
    @DeleteMapping("/plant/delete/{plantId}")
    public String deleteplantById(@PathVariable long plantId){
    	service.deletePlant(plantId);
    	return "Plant Deleted";
    }
    @PutMapping("/plant/update/{plantId}")
    public ResponseEntity<String> updateplantById(@PathVariable long plantId,@RequestBody PlantAdd request){
    	return ResponseEntity.ok(service.updatePlant(plantId,request));
    }
    
    //FeedBack Controller
    @PostMapping("/feedback/add")
    public String addFeedback(@RequestBody Feedback request){
        return service.AddFeedback(request);
    }
}