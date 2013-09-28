/**
 *
 */
package model

/**
 * @author goblinbenches
 *
 */
class Cell {

	var state: String = "inactive"
	
	def activate{
	  state = "active"
	}
	
	def is_predicted : Boolean = state == "predicted"
	
	
}