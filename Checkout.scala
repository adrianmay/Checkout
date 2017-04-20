object Checkout {

	// Prices all in pounds in this program

	type Pounds = Double
	type Item = String
	type Shopping = List[Item]

	val na:String = "Apple"
	val no:String = "Orange"

	//Prices of apples and oranges:
	val pa:Pounds = 0.60
	val po:Pounds = 0.25

	def price(i : Item) : Pounds = i match {
		case `na` => pa
		case `no` => po
		case _ => 0
	}

	//Shopping list evaluator:
	def priceOfShopping(l : Shopping): Pounds = priceOfShopping_(l.sorted)
	def priceOfShopping_(l : Shopping): Pounds = 
		l match {
			case `no` :: `no` :: `no` :: rest => 2*price(no) + priceOfShopping_(rest)
			case `na` :: `na` :: rest => price(na) + priceOfShopping_(rest)
			case i :: rest => price(i) + priceOfShopping_(rest)
			case _ => 0
		}

	// 2 apples for price of 1
	// 3 oranges for price of 2

	//Test cases:
	val cases : List[(Pounds, Shopping)] = List(
		(0,       Nil),
		(pa,      List(na)),
		(pa,      List(na, na)),
		(po,      List(no)),
		(2*po,    List(no, no)),
		(2*po,    List(no, no, no)),
		(3*po,    List(no, no, no, no)),
		(4*po,    List(no, no, no, no, no)),
		(4*po,    List(no, no, no, no, no, no)),
		(4*po+pa, List(no, no, na, na, no, no, no, no)),
		(4*po+pa, List(no, na, no, no, no, no, no)),
		(pa+po,   List(na, no)),
		(pa+po,   List(na, na, no)),
		(2*pa,    List(na, na, na)),
		(2*pa,    List(na, na, na, na)),
		(pa+po,   List(na, no, na)),
		(2*pa+po, List(na, no, na, na, na)),
		(2*pa+po, List(na, na, no, na, na)),

		(pa+po,   List(na, no, na, "Slartibartfast")),
		(pa+po,   List(na, no, na, ""))
	)

	def main(args : Array[String]) : Unit = {
		val resall = for { (p,l) <- cases } yield {
			val pp = priceOfShopping(l)
			(p==pp, l, p, pp)
		}
		println(resall.filter {!_._1})
	}
}

