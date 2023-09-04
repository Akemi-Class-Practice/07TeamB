package Beeeee.com.ex.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Beeeee.com.ex.model.dao.AdminDao;
import Beeeee.com.ex.model.entity.AdminEntity;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	//createAdminメソッドは、管理者アカウントを作成するためのメソッドで、引数としてadminName,adminEmail,adminPasswordを受け取ります。
	public boolean createAdmin(String adminName,String adminEmail,String adminPassword) {
		//現在の日時を取得し、registerDateに保存します。
		LocalDateTime adminRegisterDate = LocalDateTime.now();
		//AdminDaoインタフェースのfindByAdminEmailメソッドを使用して、指定されたEmailを持つAdminEntityを検索し、結果をadminEntityに格納します。
		AdminEntity adminEntity = adminDao.findByAdminEmail(adminEmail);
		//AdminEntityが見つからなかった場合
		if (adminEntity == null) {
			adminDao.save(new AdminEntity(adminName,adminEmail,adminPassword,adminRegisterDate));
			return true;
		}else {
			return false;
		}
	}
	
	public AdminEntity loginAdmin(String adminEmail,String adminPassword) {
		//引数として受け取ったEmailとパスワードを使用して
		//AdminDaoインタフェースのfinByAdminEmailAndPasswordメソッドを呼び出して、該当するAdminEntityを検索します。
		AdminEntity adminEntity = adminDao.findByAdminEmailAndAdminPassword(adminEmail, adminPassword);
		/*検索結果として取得したAdminEntityがNULLであるかどうかを確認し、
	　　　　nullである場合はログイン失敗したことを示すためにNULLを返します。*/
		if (adminEntity == null) {
			return null;
		}else {
			//検索結果として取得したAdminEntityがNULLでない場合、ログイン成功
			return adminEntity;
		}
	}

}
