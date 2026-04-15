package generated

final case class Data395(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data395 = copy(name = name.toUpperCase)
  def scale(k: Double): Data395 = copy(value = value * k)
  def addTag(t: String): Data395 = copy(tags = t :: tags)
  def put(k: String, v: String): Data395 = copy(meta = meta.updated(k, v))
  def merge(other: Data395): Data395 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data395 {
  given Ordering[Data395] = Ordering.by(_.id)
  def empty: Data395 = Data395(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data395 =
    Data395(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data395] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
