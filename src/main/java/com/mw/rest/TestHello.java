package com.mw.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Scope("request")
@Path("/hello")
public class TestHello {
	Map<Object,Object> userMap = new HashMap<Object, Object>();
    @GET
//    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    // @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public User getUser(@PathParam("name") String userName, @PathParam("age") Integer age) {
        User user = new User ();
        user.setId(new Random().nextInt());
        user.setName(userName);
        user.setAge(age);
        System.out.println(user);
        return user;
//       return  "jersey demo " + userName + age;
    }
    
    /** 
     * 增加 
     * @param user 
     */  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Map<String, Object> createStudent(User user)
    {
        System.out.print("POST方法调用!");
        userMap.put(user.getId(), user );
        for (Map.Entry entry : userMap.entrySet()){
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("status",Boolean.TRUE);
        map1.put("mes","成功");
        return map1;
    } 

  /** 
     * 删除 
     * @param id 
     */  
    @DELETE  
    @Path("{id}")  
    public void deleteStudent(@PathParam("id")String id){  
        userMap.remove(id);  
    }  

    /** 
     * 修改 
     * @param user 
     */  
    @PUT  
    @Consumes(MediaType.APPLICATION_XML)  
    public void updateStudent(User user){  
        userMap.put(user.getId(), user );  
    }  
}
