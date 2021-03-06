/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package KotlinPoker

data class Card(val suit: Suit, val rank : Rank){
    override fun toString() = "${rank.value}${suit.value}"

    fun hasSameSuit(other : Card) = suit == other.suit

    fun hasSameRank(other : Card) = rank == other.rank

}

data class Cards(val cards: List<Card>){
    fun getHand() : String = when  {
        this.isLinerRank() && this.isFlush() -> "StraightFlush"
        this.isLinerRank() -> "Straight"
        this.isPair() -> "Pair"
        this.isFlush() -> "Flush"
        else -> "HighCard"
    }

    fun isPair()  : Boolean = cards[0].hasSameRank(cards[1])
    fun isFlush() : Boolean = cards[0].hasSameSuit(cards[1])

    fun isLinerRank() : Boolean = when {
        cards[0].rank == Rank.ACE && cards[1].rank == Rank.KING -> true
        cards[0].rank == Rank.KING && cards[1].rank == Rank.ACE -> true
        else -> Math.abs(cards[0].rank.value - cards[1].rank.value) == 1
    }
}

enum class Rank(val value : Int){
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);
}
enum class Suit(val value : String){
    CLUB("♣"),
    SPADE("♠"),
    HEART("♥"),
    DIA("◆")
}




