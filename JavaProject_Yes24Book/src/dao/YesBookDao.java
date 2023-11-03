package dao;

import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.BookVo;

public class YesBookDao {
	 static YesBookDao singleTon = null;
	
	 YesBookDao(){};
	
	public static YesBookDao getInstance() {
		if(singleTon == null) {
			singleTon = new YesBookDao();
		}
		return singleTon;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<BookVo> bookList() {
		String sql = "select book_no, book_nm, book_wit, book_pubsh, \r\n" + 
					"book_fp, book_fp*((100-book_dc)/100) book_sp, book_dc, \r\n "
					+ "book_sm, book_rev\r\n" + 
					"from book";
		List<Map<String, Object>> l = jdbc.selectList(sql);
		return ConvertUtils.convertToList(l, BookVo.class);
	}

	public BookVo bookDetail(int bookNo) {
		String sql = "select book_no, book_nm, book_wit, book_pubsh, \r\n" + 
				"book_fp, book_fp*((100-book_dc)/100) book_sp, book_dc, book_sm, book_rev\r\n" + 
				"from book\r\n" + 
				"where book_no="+bookNo;
		Map<String, Object> map = jdbc.selectOne(sql);
		return ConvertUtils.convertToVo(map, BookVo.class);
	}

	public Object bookDel(int delNo) {
		String sql = "UPDATE book\r\n" + 
				"set delyn = 'y'\r\n" + 
				"where book_no ="+delNo;
		Map<String,Object> map = jdbc.selectOne(sql);
		return ConvertUtils.convertToVo(map, BookVo.class);
	}
	
	
	
	
	
}

