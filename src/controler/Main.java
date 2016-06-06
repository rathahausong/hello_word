package controler;
import dao.UserDao;
import dto.User;
public class Main {
	public static void main(String[] args) {
		User u = new User();
		u.setId(1);
		u.setUsername("sim ratha");
		u.setPassword("123456");
		try {
			if(new UserDao().insertRow(u)){
				System.out.println("insert is complet !");
			}else{
				System.out.println("can not insert !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
