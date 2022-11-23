package ie.ul.frankscafe.Services

interface Visitable {
    fun accept(visitor: Visitor) : Int
}