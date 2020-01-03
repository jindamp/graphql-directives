//package com.example.graphql.resolvers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
//import com.example.graphql.models.User;
//import com.example.graphql.repo.UserRepo;
//
//public class UserMutationResolver implements GraphQLMutationResolver{
//	
//	@Autowired
//    private UserRepo userRepo;
//    public User createVehicle(final int id, final String username, final String email, final String mobile, int age) {
//    	
//    	User u = new User();
//    	u.setUsername(username);
//    	u.setEmail(email);
//    	u.setMobile(mobile);
//    	u.setAge(age);
//    	
//        return userRepo.save(u);
//    }
//
//}
