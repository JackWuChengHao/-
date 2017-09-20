package home.iter;


public enum Season {
	
	SPRING(1,"春季"),
	SUMMER(2,"夏季"),
	AUTOMN(3,"秋季"),
	WINTOR(4,"冬季");
	
	private Integer val;
	private String text;
	
	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	Season(Integer value,String text){
		this.val = value;
		this.text = text;
	}
}
