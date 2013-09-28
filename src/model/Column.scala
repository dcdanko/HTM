/**
 *
 */
package model
import scala.util.Random

/**
 * @author goblinbenches
 *
 */
class Column(val height: Int, val num_synapses: Int, val permanence_threshold: Float, val vec_len: Int) {

	val cells = for{ a <- 0 until height} yield new Cell
	
	val synapses = for{ a <- 0 until num_synapses} yield new Synapse(Random.nextFloat(), 
																		permanence_threshold,
																		Random.nextInt(vec_len))
	
	def overlap(input_vector: Array[Int]) : Int = {
	  var total_overlap = 0: Int
	  for(synapse <- synapses) total_overlap += synapse.potential(input_vector)
	  return total_overlap
	}
	
	def activate(input_vector: Array[Int]){
	  for{ cell <- cells if cell.is_predicted} cell.activate 
	  for{ synapse <- synapses } synapse.update( input_vector )
	}

}