/**
 *
 */
package model

/**
 * @author goblinbenches
 *
 */
class Synapse(var permanence: Double, val threshold: Double, val pos: Int) {
  
   def update(input_vector: Array[Int]){
	  val bit = input_vector(pos)
	  if( bit==1 && permanence < threshold){
	    permanence += .1
	    if( permanence > 1) permanence = 1
	  }
	  else if( bit==0 && permanence > threshold){
	    permanence -= .1
	    if( permanence < 0) permanence = 0
	  }
   }
  
	def potential(input_vector: Array[Int]) : Int  = {
	  if( permanence >= threshold && input_vector(pos) == 1){
	    return 1
	  }
	  return 0
	}
	
}