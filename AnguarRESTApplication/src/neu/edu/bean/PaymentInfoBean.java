package neu.edu.bean;
// Generated Apr 27, 2017 7:35:39 PM by Hibernate Tools 5.2.1.Final

/**
 * PaymentInfo generated by hbm2java
 */
public class PaymentInfoBean implements java.io.Serializable {

	private int userId;
	private Integer cardNumber;
	private Integer cardYear;
	private Integer cardMonth;
	private Integer cardCvv;

	public PaymentInfoBean() {
	}

	

	public PaymentInfoBean(int userId, Integer cardNumber, Integer cardYear, Integer cardMonth, Integer cardCvv) {
		this.cardYear = cardYear;
		this.cardMonth = cardMonth;
		this.cardCvv = cardCvv;
		this.userId = userId;
		this.cardNumber = cardNumber;
	}

	

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public Integer getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}



	public Integer getCardYear() {
		return this.cardYear;
	}

	public void setCardYear(Integer cardYear) {
		this.cardYear = cardYear;
	}

	public Integer getCardMonth() {
		return this.cardMonth;
	}

	public void setCardMonth(Integer cardMonth) {
		this.cardMonth = cardMonth;
	}

	public Integer getCardCvv() {
		return this.cardCvv;
	}

	public void setCardCvv(Integer cardCvv) {
		this.cardCvv = cardCvv;
	}

}
