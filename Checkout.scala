object Checkout {

	// Prices all in pence in this program

	type Pounds = Double
	type Item = String
	type Shopping = List[Item]

	//Prices of apples and oranges:
	val pa:Pounds = 0.60
	val po:Pounds = 0.25

	def price(i : Item) : Pounds = i match {
		case "Apple" => pa
		case "Orange" => po
		case _ => 0
	}

	//Shopping list evaluator:
	def priceOfShopping(l : Shopping): Pounds = 
		l.map(price).foldLeft(0.0) {_+_}

	// 2 apples for price of 1

	//Test cases:
	val cases : List[(Pounds, Shopping)] = List(
		(0,       Nil),
		(pa,      List("Apple")),
		(pa,      List("Apple", "Apple")),
		(po,      List("Orange")),
		(123,     List("Orange")), //Deliberate failure
		(2*po,    List("Orange", "Orange")),
		(pa+po,   List("Apple", "Orange")),
		(pa+po,   List("Apple", "Apple", "Orange")),
		(2*pa,    List("Apple", "Apple", "Apple")),
		(2*pa,    List("Apple", "Apple", "Apple", "Apple")),
		(pa+po,   List("Apple", "Orange", "Apple")),
		(2*pa+po, List("Apple", "Orange", "Apple", "Apple", "Apple")),
		(2*pa+po, List("Apple", "Apple", "Orange", "Apple", "Apple")),

		(pa+po,   List("Apple", "Orange", "Apple", "Slartibartfast")),
		(pa+po,   List("Apple", "Orange", "Apple", ""))
	)

	def main(args : Array[String]) : Unit = {
		val resall = for { (p,l) <- cases } yield {
			val pp = priceOfShopping(l)
			(p==pp, l, p, pp)
		}
		println(resall.filter {!_._1})
	}
}
