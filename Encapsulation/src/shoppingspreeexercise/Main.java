package shoppingspreeexercise;
/*
Create two classes: class Person and class Product. Each person should have a name, money and a bag of products. Each
product should have name and cost. Name cannot be an empty string. Be careful about white space in name. Money and cost
cannot be a negative number.

Person
-	name: String
-	money:  double
-	products:  List<Product>
+ 	Person (String ,  double)
-	setName (String) : void
-	setMoney (double) : void
+	buyProduct (Product) : void
+	getName(): String


Product
-	name: String
-	cost: double
+ 	Product (String,  double)
-	setCost (double): void
-	setName (String): void
+	getName(): String
+	getCost (): double

Create a program in which each command corresponds to a person buying a product. If the person can afford a product add
it to his bag. If a person doesn’t have enough money, print an appropriate message: "{Person name} can't afford {Product
name}"
On the first two lines you are given all people and all products. After all purchases print every person in the order of
appearance and all products that he has bought also in order of appearance. If nothing is bought, print the name of the
person followed by "Nothing bought".
Read commands till you find line with "END" command. In case of invalid input (negative money exception message: "Money
cannot be negative") or empty name: (empty name exception message "Name cannot be empty") break the program with an
appropriate message. See the examples below:
 */
public class Main {
    public static void main(String[] args) {

    }
}
