package generated

final case class Data531(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data531 = copy(name = name.toUpperCase)
  def scale(k: Double): Data531 = copy(value = value * k)
  def addTag(t: String): Data531 = copy(tags = t :: tags)
  def put(k: String, v: String): Data531 = copy(meta = meta.updated(k, v))
  def merge(other: Data531): Data531 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data531 {
  given Ordering[Data531] = Ordering.by(_.id)
  def empty: Data531 = Data531(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data531 =
    Data531(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data531] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
