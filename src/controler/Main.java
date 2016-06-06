package controler;
import java.util.ArrayList;

import dao.UserDao;
import dto.User;
public class Main {
	public static void main(String[] args) {
		User u = new User();
		u.setId(2);
		u.setUsername("lim chhunly");
		u.setPassword("123456");
		try {
			
			ArrayList<Object> users =  new UserDao().selectRecord();
			for(Object u1 : users){
				User uu = (User)u1;
				System.out.println(uu.getId()+"  "+uu.getUsername()+"   "+uu.getPassword());
				System.out.println("==========================");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
