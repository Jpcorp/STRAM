package com.yousoft.stram.service.mvc.rest.controller;

//import javax.ws.rs.core.MediaType;

import com.yousoft.stram.domain.User;
import com.yousoft.stram.domain.application.UserList;
import com.yousoft.stram.service.mvc.rest.controller.response.UserAutenticateResponse;
import com.yousoft.stram.service.utils.ApplicationUtils;
import java.io.IOException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * NOtas: Cuando se usa spring 4, se puede Utilizar @RestController y no es 
 * necesario (@Controller + @ResponseBody)
 * @author jguinart
 */
@RestController
@RequestMapping("/users")
public class UserRestController {
    
    @RequestMapping(method = RequestMethod.GET,  value = "/all", produces = ApplicationUtils.PRODUCES_JSON)
    public UserList getAllUsers() {
        
        UserList users = new UserList();
        
        User one = new User("1", "admin", "admin");
        User two = new User("2", "ju.guinart@live.cl", "admin");
        
        users.getUsers().add(one);
        users.getUsers().add(two);
    
        return users;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = ApplicationUtils.PRODUCES_JSON)
    public User getUserById(@PathVariable("id") String id) {
        // mimics a call to a business service
        return new User(id, "admin", "admin");
    }
    
   /** @RequestMapping(method = RequestMethod.POST, value = "/autenticate", produces = ApplicationUtils.PRODUCES_JSON)
    public JSONResponse<UserAutenticateResponse> validate(@RequestBody UserAuteticateRequest request) throws IOException{		
		UserAutenticateResponse userAutenticateResponse = new UserAutenticateResponse();
		sicccoResponse.setId(1);
		
		
		JsonResponseBuilder<SiccoResponse> builder = new JsonResponseBuilder<SiccoResponse>();
		builder.addData(sicccoResponse);
		builder.addStatus(new ServiceStatus(200, "OK"));

		return builder.buildJsonResponse();
	}**/
}
