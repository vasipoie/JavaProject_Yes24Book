package service;

import java.util.List;

import dao.YesBookDao;
import util.JDBCUtil;
import vo.BookVo;

public class YesBookService {
	 static YesBookService singleTon = null;
	
	 YesBookService(){};
	
	public static YesBookService getInstance() {
		if(singleTon == null) {
			singleTon = new YesBookService();
		}
		return singleTon;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	YesBookDao bookDao = YesBookDao.getInstance();

	//List<Vo이름>
	public List<BookVo> bookList() {
		return bookDao.bookList();
	}

	public BookVo bookDetail(int bookNo) {
		return bookDao.bookDetail(bookNo);
	}

	public Object bookDel(int delNo) {
		return bookDao.bookDel(delNo);
	}
	
	
	
	
	
	
}
