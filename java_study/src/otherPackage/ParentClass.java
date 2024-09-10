package otherPackage;

public class ParentClass {
	public String publicField;
	
	protected String protectedField;
	
	// === default ===
	public ParentClass() {
		this.protectedField = "안녕하세요";
	}
	
	protected void exampleMethod() {
		System.out.println("상속받은 클래스에서 호출 가능");
	}

}
