/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package KotlinPoker

data class Card(val suit: String, val rank : String){
    override fun toString() = "${rank}${suit}"

    fun hasSameSuit(other : Card) = suit == other.suit

    fun hasSameRank(other : Card) = rank == other.rank
}