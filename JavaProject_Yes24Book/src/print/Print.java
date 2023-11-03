package print;

import java.util.List;

import vo.BookVo;

public class Print {
	
		public void printVar() {
			System.out.println("-----------------------------------------------");
		}
		
		//줄맞춤용도
		public void printLn(int num) {
			for(int i=0; i<num; i++)
				System.out.println();
		}

		public void printHome() {
			printVar();
			System.out.println("1. 관리자");
			System.out.println("2. 회원");
			printLn(5);
			printVar();
		}
		
		//1.관리자 -
		public void printAdmin() {
			printVar();
			System.out.println("1. 신규 책 등록");
			System.out.println("2. 책 수정");
			System.out.println("3. 책 삭제");
			System.out.println("4. 로그아웃");
			printLn(3);	//줄맞춤을 다른거랑 같게
			printVar();
		}
		
		//2.멤버 -
		public void printMember() {
			printVar();
			System.out.println("1. 전체 책 리스트");
			System.out.println("2. 홈");
			printLn(5);
			printVar();
		}
		
		//1.관리자 - 1.전체 책 목록 조회
		//바로 출력할거니까 파라미터로 list라는 ArrayList 넣기
		//list출력은 향상된 for문
		public void printList(List<BookVo> list) {
			printVar();
			System.out.println("No\t책제목\t저자\t출판사\t정가\t판매가\t할인율\tSummary\t리뷰");
			for (BookVo book : list) {
				//1. toString으로 	2.get으로
				System.out.printf("%d \t %s\t %s \t %s \t %d \t %d \t %d \t %s\t%s\n",
						book.getBook_no(),book.getBook_nm(),book.getBook_wit(),book.getBook_pubsh(),
						book.getBook_fp(),book.getBook_sp(),book.getBook_dc(),book.getBook_sm(),
						book.getBook_rev());
//				System.out.println(book);
			}
			printLn(1);
			printVar();
		}
		
		
		public void printListMenu() {
			System.out.println("1. 상세페이지");
			System.out.println("2. 홈");
			printLn(5);
			printVar();
		}
	
		
		public void printDetail(BookVo book) {
			printVar();
			System.out.println("No\t책제목\t저자\t출판사\t정가\t판매가\t할인율\tSummary\t리뷰");
			System.out.printf("%d \t %s\t %s \t %s \t %d \t %d \t %d \t %s\t%s\n",
					book.getBook_no(),book.getBook_nm(),book.getBook_wit(),book.getBook_pubsh(),
					book.getBook_fp(),book.getBook_sp(),book.getBook_dc(),book.getBook_sm(),
					book.getBook_rev());
			printLn(6);
			printVar();
			System.out.println("1. 전체 책 리스트");
			
			printVar();
		}
		
		public void printDelete() {
			printVar();
			System.out.println("1. 삭제");
			System.out.println("2. 다음페이지");
			System.out.println("3. 이전페이지");
			System.out.println("4. 홈");
			printLn(5);
			printVar();
		}
	
	
	
	
}
