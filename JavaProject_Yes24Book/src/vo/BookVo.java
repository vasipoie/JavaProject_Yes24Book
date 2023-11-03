package vo;

import lombok.Data;

@Data
public class BookVo {
	
	  int book_no;
	  String book_nm;
	  String book_wit;
	  String book_pubsh;
	  int book_fp;
	  int book_sp;
	  int book_dc;
	  String book_sm;
	  String book_rev;
	
	  /*
	   * select * from 으로 데이터 가져오고
	   * 데이터 타입을 regdate2로 바꿔주면
	   * date 쓸 수 있음
	   * 
	   * Date regdate;
	   * String regdate2;
	   * 
	   * public Date getRegdate(){
	   * 	SimpleDate
	   * 	return regdate;
	   * }
	   * 
	   * public void setRegdate(Date regdate){
	   * 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   * 	this.regdate2 = sdf.format(regdate);
	   * 	this.regdate = regdate;
	   */
	
}
