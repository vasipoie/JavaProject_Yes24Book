package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import oracle.net.ns.SessionAtts;
import print.Print;
import service.YesBookService;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;
import vo.BookVo;

public class YesBookCon extends Print{
	static public Map<String, Object> sessionStorage = new HashMap<>();

	YesBookService bookService = YesBookService.getInstance();
	static JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public static void main(String[] args) {
		/*
		 * 1. 전체 테이블 조회	READ -2,4
		 * 2. 상세 페이지 조회	READ
		 * 3. 게시판 글 신규 등록	CREATE
		 * 4. 게시판 글 수정	UPDATE
		 * 5. 게시판 글 삭제	DELETE
		 * 
		 * 1.
		 * 게시번호 	제목	작성자	작성시간	내용(10자만 출력)
		 * 3		게시글3		테스트1	2023-11-01	오늘 날씨는 ....
		 * 2		게시글2		테스트1 2023-11-01	오늘 날씨는 ....
		 * 1		게시글1		테스트1	2023-10-31	오늘 날씨는 ....
		 * 
		 * 
		 */
		
		new YesBookCon().start();
	}

	 void start() {
		View view = View.HOME;
		while(true){
			switch(view) {
			case HOME:
				view = home();
				break;
			case ADMIN:
				view = admin();
				break;
			case MEMBER:
				view = member();
				break;
			case BOOK_ADD:
				view = member();
				break;
			case BOOK_UPDATE:
				view = member();
				break;
			case BOOK_DEL:
				view = bookDel();
				break;
			case BOOK_LIST:
				view = bookList();
				break;
			case BOOK_DETAIL:
				view = bookDetail();
				break;
			}
		}
	}

	 private View bookDel() {
		 List<BookVo> list = bookService.bookList();
		 printList(list);
		 printDelete();
		 int select = ScanUtil.nextInt("메뉴를 선택하세요\s");
			switch (select) {
			case 1:
				int delNo = ScanUtil.nextInt("삭제할 번호를 선택하세요\s");
				bookService.bookDel(delNo);
				//테이블에 delyn만들고 y로 업데이트, 쿼리는 is null
				return View.BOOK_DEL;	//삭제
			case 2:
				int pageNo = (int) sessionStorage.get("pageNo")+1;
				sessionStorage.put("pageNo", pageNo);
				return View.BOOK_DEL;
			case 3:
				pageNo = (int) sessionStorage.get("pageNo")-1;
				sessionStorage.put("pageNo", pageNo);
				return View.BOOK_DEL;
			case 4:
				return View.HOME;
			default:
				return View.BOOK_DEL;
			}
	}

	private View bookDetail() {
		//session은 맵. 메소드끼리 옮기기 어려운 데이터는 sessionStorage에 넣는다
		 int bookNo = (int) sessionStorage.get("bookNo");
		 BookVo book = bookService.bookDetail(bookNo);
		 printDetail(book);
		 int select = ScanUtil.nextInt("메뉴를 선택하세요"); 
		 switch (select) {
			case 1:
				return View.BOOK_LIST;
			default:
				return View.BOOK_DETAIL;
		 }
	}

	private View bookList() {
		 List<BookVo> list = bookService.bookList();
		 printList(list);
		 printListMenu();
		 int select = ScanUtil.nextInt("메뉴를 선택하세요"); 
		 switch (select) {
			case 1:
				int bookNo = ScanUtil.nextInt("책 번호를 선택하세요"); 
				//검증 필요. 번호 잘못입력했다 추가
				sessionStorage.put("bookNo", bookNo);
				return View.BOOK_DETAIL;
			case 2:
				return View.HOME;
			default:
				return View.BOOK_LIST;
			}
	}

	private View member() {
		 printMember();
		 int select = ScanUtil.nextInt("");
			switch (select) {
			case 1:
				return View.BOOK_LIST;
			case 2:
				return View.HOME;
			default:
				return View.MEMBER;
			}
	}

	private View admin() {
		 printAdmin();
			int select = ScanUtil.nextInt("메뉴를 선택하세요\s");
			switch (select) {
			case 1:
				return View.BOOK_ADD;
			case 2:
				return View.BOOK_UPDATE;
			case 3:
				return View.BOOK_DEL;
			case 4:
				return View.HOME;
			default:
				return View.ADMIN;
			}
	}

	View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요\s");
		switch (select) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.MEMBER;
		default:
			return View.HOME;
		}
	}
	
}
