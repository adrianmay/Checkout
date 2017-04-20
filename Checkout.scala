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
	val cases : List[(Pence, Shopping)] = List(
		(0,       Nil),
		(pa,      List("Apple")),
		(2*pa,    List("Apple", "Apple")),
		(po,      List("Orange")),
		(2*po,    List("Orange", "Orange")),
		(pa+po,   List("Apple", "Orange")),
		(2*pa+po, List("Apple", "Orange", "Apple")),
		(2*pa+po, List("Apple", "Orange", "Apple", "Slartibartfast")),
		(2*pa+po, List("Apple", "Orange", "Apple", ""))
	)

	def main(args : Array[String]) : Unit = {
		val res = for { (p,l) <- cases } yield p==priceOfShopping(l)
		println(res)
	}
}
