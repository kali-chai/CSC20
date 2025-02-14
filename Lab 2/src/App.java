public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello, World!");
		C[] elements = { new A(), new B(), new C(), new D() };
		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
			elements[i].method1();
			System.out.println();
			elements[i].method2();
			System.out.println();
			System.out.println();
		}
		Arya[] thrones = { new Oberyn(), new Arya(), new Brienne(), new Tyrion() };
		for (int i = 0; i < thrones.length; i++) {
			thrones[i].a();
			System.out.println();
			System.out.println(thrones[i]);
			thrones[i].b();
			System.out.println();
			System.out.println();
		}
	}
}

class A extends B {
	public void method2() {
		System.out.print("a 2  ");
		method1();
	}
}

class B extends C {
	public String toString() {
		return "b";
	}

	public void method2() {
		System.out.print("b 2  ");
		super.method2();
	}
}

class C {
	public String toString() {
		return "c";
	}

	public void method1() {
		System.out.print("c 1  ");
	}

	public void method2() {
		System.out.print("c 2  ");
	}
}

class D extends B {
	public void method1() {
		System.out.print("d 1  ");
		method2();
	}
}

class Employee {
	public int getHours() {
		return __baseHours; // 40 hours/week
	}

	public double getSalary() {
		return __baseSalary; // $40,000.00
	}

	public int getVacationDays() {
		return __baseVacationDays; // 10 days
	}

	public String getVacationForm() {
		return __baseVacationForm; // yellow
	}

	// These are so that test cases can change the base values
	// and make sure that subclasses also change their values.
	// (Your code that you submit is NOT supposed to directly use, call,
	// or modify the values below! They are here only to help our site
	// successfully test your code. Please ignore them.)

	private static int __baseHours = 40;
	private static double __baseSalary = 40000.0;
	private static int __baseVacationDays = 10;
	private static String __baseVacationForm = "yellow";

	public static final void setBaseHours(int hours) {
		__baseHours = hours;
	}

	public static final void setBaseSalary(double salary) {
		__baseSalary = salary;
	}

	public static final void setBaseVacationDays(int days) {
		__baseVacationDays = days;
	}

	public static final void setBaseVacationForm(String form) {
		__baseVacationForm = form;
	}
}

// A class to represent lawyers.
class Lawyer extends Employee {
	public Lawyer() {
		super();
	}

	// overrides getVacationDays from Employee class
	public int getVacationDays() {
		return super.getVacationDays() + 5;
	}

	// overrides getVacationDays from Employee class
	public String getVacationForm() {
		return lawyerVacationForm;
	}

	// this is the Lawyer's added behavior
	public String sue() {
		return "I'll see you in court!";
	}

	// these are so that test cases can change the Lawyer values
	// and make sure that subclasses also change
	private static String lawyerVacationForm = "pink";

	public static final void setLawyerVacationForm(String form) {
		lawyerVacationForm = form;
	}
}

class Custodian extends Employee {
	public Custodian() {
		super();
	}

	public int getHours() {
		return super.getHours() * 2;
	}

	public double getSalary() {
		return super.getSalary() - 10000;
	}

	public int getVacationDays() {
		return super.getVacationDays() / 2;
	}

	public String getVacationForm() {
		return super.getVacationForm();
	}

	public String clean() {
		return "Workin' for the man.";
	}
}

class StanfordLawyer extends Lawyer {
	public StanfordLawyer() {
		super();
	}

	public String sue() {
		return "I will sue you for everything you have!";
	}

	public double getSalary() {
		return super.getSalary() * 1.2;
	}

	public int getVacationDays() {
		return super.getVacationDays() + 3;
	}

	public String getVacationForm() {
		return String.format("%1$s%1$s%1$s%1$s", super.getVacationForm());
	}
}

class Brienne extends Oberyn {
	public void a() {
		System.out.print("Brienne-a   ");
	}
}

class Arya {
	public void a() {
		System.out.print("Arya-a   ");
	}

	public void b() {
		a();
		System.out.print("Arya-b   ");
	}

	public String toString() {
		return "Arya";
	}
}

class Tyrion extends Arya {
	public void a() {
		super.a();
		System.out.print("Tyrion-a   ");
	}
}

class Oberyn extends Arya {
	public void b() {
		System.out.print("Oberyn-b   ");
		super.b();
	}

	public String toString() {
		return "Oberyn";
	}
}