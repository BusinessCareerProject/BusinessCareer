package test;

import static org.junit.Assert.*;

import org.junit.Test;



public class testPG {


	@Test
	public void aaa() {


		System.out.println("ああああああああああ");



		int i = 1;


		if  (i == 1) {

		}

		bbb(i);


	}


	private void bbb(Integer i) {

		if (i == 1) {

		}





	}


	@Test
	public void ccc() {
		Integer i1 = new Integer("1");
		Integer i2 = i1;
		Integer i3 = new Integer("1");

		if ( i1 == i2) {
		    System.out.println("== の比較で i1 と i2 は等しい");
		} else {
		    System.out.println("== の比較で i1 と i2 は等しくない");
		}

		if (i1 == i3) {
		    System.out.println("== の比較で i1 と i3 は等しい");
		} else {
		    System.out.println("== の比較で i1 と i3 は等しくない");
		}


		if (i1.equals(i3) == true) {
		    System.out.println("== の比較で i1 と i3 は等しい");
		} else {
		    System.out.println("== の比較で i1 と i3 は等しくない");
		}


		String a = "aaa";
		String b = "bbb";

		if (a == b) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}


	}


//	@Test
//	public void userSelectTest() {
//		jp.co.tad.container.User dao = new jp.co.tad.container.User(MyBatisConnectionFactory.getSqlSessionFactory());
//		List<User> list = dao.selectAll();
//		for (User u : list) {
//			System.out.println(u.getUserId() + ":" + u.getUserName() + ":" + u.getLoginTime());
//		}
//	}
//
//	@Test
//	public void userDeleteTest() {
//		UserDAO dao = new UserDAO(MyBatisConnectionFactory.getSqlSessionFactory());
//		System.out.println("削除件数" + dao.deleteAll());
//	}
//
//	@Test
//	public void existsUser() {
//		UserDAO dao = new UserDAO(MyBatisConnectionFactory.getSqlSessionFactory());
//		int cnt = dao.existsUser("1", "aaa");
//
//		if (cnt == 1) {
//			logger.info("OK");
//			assertTrue(true);
//		} else {
//			logger.info("NG");
//			assertTrue(false);
//		}
//	}

//	@Inject
//    SqlSession session;
//
//	@Test
//	public void aaaa() {
//
//		SqlSessionProducer sp = new SqlSessionProducer();
//		sp.initialize();
//
//		try (SqlSession session = sp.openSession()) {
//			SqlUserMapper mapper = session.getMapper(SqlUserMapper.class);
//
//			List<UserEntity> list = mapper.selectAll();
//
//			for (UserEntity u : list) {
//				System.out.println(u.getUserId() + ":" + u.getUserName() + ":" + u.getLoginTime());
//			}
//		}
//	}
}
