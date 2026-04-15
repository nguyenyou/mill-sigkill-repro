package generated

final case class Data166(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data166 = copy(name = name.toUpperCase)
  def scale(k: Double): Data166 = copy(value = value * k)
  def addTag(t: String): Data166 = copy(tags = t :: tags)
  def put(k: String, v: String): Data166 = copy(meta = meta.updated(k, v))
  def merge(other: Data166): Data166 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data166 {
  given Ordering[Data166] = Ordering.by(_.id)
  def empty: Data166 = Data166(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data166 =
    Data166(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data166] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
