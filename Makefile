T=Checkout

all:	$T.class
	scala $T

$T.class: $T.scala
	scalac $T.scala

