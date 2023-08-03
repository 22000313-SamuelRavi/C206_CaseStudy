import java.util.Date;


public class FeeManagement {

	private double feeAmount;
	private String feeType;
	private Date feeDueDate;
	
	public FeeManagement(double feeAmt, String feeType, Date feeDD) {
		feeAmount = feeAmt;
		this.feeType = feeType;
		feeDueDate = feeDD;
	}

	public double getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(double feeAmount) {
		this.feeAmount = feeAmount;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Date getFeeDueDate() {
		return feeDueDate;
	}

	public void setFeeDueDate(Date feeDueDate) {
		this.feeDueDate = feeDueDate;
	}
	
}
