object Checkout {

	// Prices all in pence in this program

	type Pence = Int
	type Item = String
	type Shopping = List[Item]

	//Prices of apples and oranges:
	val pa:Pence = 60
	val po:Pence = 25

	//Shopping list evaluator:
	def priceOfShopping(shopping : Shopping): Int = 0

	//Test cases:
	val cases : List[(Pence, Shopping)] = Nil

	def main(args : Array[String]) : Unit = {
		println("Hello, world")
	}
}
