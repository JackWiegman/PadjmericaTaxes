import java.util.Scanner;

public class TaxPrep {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int salary;
		int age;
		int kids;

		System.out.println("What is your salary: ");
		salary = scan.nextInt();
		System.out.println("How old are you: ");
		age = scan.nextInt();
		System.out.println("How many kids do you have: ");
		kids = scan.nextInt();

		double salaryTaxed;
		double otherBrackets;
		double currentBracket;
		if (salary < 10000) {
			salaryTaxed = 0;
		} 
		else if (salary < 25000) {
			salaryTaxed = salary * 0.1;
		}
		else if (salary < 75000) {
			otherBrackets = 15000 * 0.1;
			currentBracket = (salary - 25000)  * 0.2;
			salaryTaxed = otherBrackets + currentBracket;
		}
		else if (salary < 250000) {
			otherBrackets = (15000 * 0.1) + (50000 * 0.2);
			currentBracket = (salary - 75000) * 0.3;
			salaryTaxed = otherBrackets + currentBracket;
		}
		else {
			otherBrackets = (15000 * 0.1) + (50000 * 0.2) + (175000 * 0.3);
			currentBracket = (salary - 250000) * 0.5;
			salaryTaxed = otherBrackets + currentBracket;
		}


		int kidsDiscount = 0;
		if (kids >= 1) {
			kidsDiscount = 1000;
		}
		if (kids >= 3) {
			for (int i = 3; i <= kids; i++) {
				kidsDiscount += 500;
			}
		}

		double taxBeforeAge = salaryTaxed - kidsDiscount;
		double totalTax;

		if (age <= 15) {
			totalTax = taxBeforeAge * 0.5;
		}
		else if (age <= 21) {
			totalTax = taxBeforeAge * 0.75;
		}
		else if (age <= 63) {
			totalTax = taxBeforeAge;
		}
		else if (age <= 72) {
			totalTax = taxBeforeAge * 0.66;
		}
		else if (age <= 80) {
			totalTax = taxBeforeAge * 0.33;
		}
		else {
			totalTax = 0;
		}

		double finalTax;
		if (salary >= 10000 && salary < 25000) {
			if (totalTax < 500) {
				finalTax = 500;
			} else {
				finalTax = totalTax;
			}
		}
		else if (salary < 75000) {
			if (totalTax < 5000) {
				finalTax = 5000;
			} else {
				finalTax = totalTax;
			}
		}
		else if (salary < 250000) {
			if (totalTax < 10000) {
				finalTax = 10000;
			} else {
				finalTax = totalTax;
			}
		}
		else {
			if (totalTax < 25000) {
				finalTax = 25000;
			} else {
				finalTax = totalTax;
			}
		}

		System.out.println("You need to pay $" + finalTax + " in taxes.");

	}

}