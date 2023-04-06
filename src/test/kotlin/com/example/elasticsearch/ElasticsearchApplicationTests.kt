package com.example.elasticsearch

import org.apache.coyote.Request
import org.junit.jupiter.api.Test
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

//@SpringBootTest
class ElasticsearchApplicationTests {

	@Test
	fun contextLoads() {
		CarFactory.makeCar()
		CarFactory.makeCar()
		println("size : ${CarFactory.cars.size}")
		
		println("toString() : $CarFactory")
	}
}

interface Vehicle {
	fun move()
}

class Car: Vehicle {
	override fun move() {
		println("car move")
	}
}

object CarFactory {
	val cars = mutableListOf<Car>()
	
	fun makeCar(): Car {
		println("make car")
		return Car().also(cars::add)
	}
}

@ExperimentalContracts
class Service {
	
	fun process(request: Request?) {
		validate(request)
		println(request.isProcessing) // Compiles fine now
	}
}

@ExperimentalContracts
private fun validate(request: Request?) {
	contract {
		returns() implies (request != null)
	}
	if (request == null) {
		throw IllegalArgumentException("Undefined request")
	}
	if (request.isProcessing) {
		throw IllegalArgumentException("No argument is provided")
	}
}