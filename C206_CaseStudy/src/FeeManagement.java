import java.time.*;

public class FeeManagement {

	private double feeAmount;
	private String feeType;
	private LocalDate feeDueDate;
	private String studentId;
	
	public FeeManagement(double feeAmt, String feeType, LocalDate feeDD, String studentId) {
		feeAmount = feeAmt;
		this.feeType = feeType;
		feeDueDate = feeDD;
		this.studentId = studentId;
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

	public LocalDate getFeeDueDate() {
		return feeDueDate;
	}

	public void setFeeDueDate(LocalDate feeDueDate) {
		this.feeDueDate = feeDueDate;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
}
