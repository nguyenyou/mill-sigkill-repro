package generated

final case class Data320(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data320 = copy(name = name.toUpperCase)
  def scale(k: Double): Data320 = copy(value = value * k)
  def addTag(t: String): Data320 = copy(tags = t :: tags)
  def put(k: String, v: String): Data320 = copy(meta = meta.updated(k, v))
  def merge(other: Data320): Data320 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data320 {
  given Ordering[Data320] = Ordering.by(_.id)
  def empty: Data320 = Data320(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data320 =
    Data320(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data320] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
