package generated

final case class Data449(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data449 = copy(name = name.toUpperCase)
  def scale(k: Double): Data449 = copy(value = value * k)
  def addTag(t: String): Data449 = copy(tags = t :: tags)
  def put(k: String, v: String): Data449 = copy(meta = meta.updated(k, v))
  def merge(other: Data449): Data449 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data449 {
  given Ordering[Data449] = Ordering.by(_.id)
  def empty: Data449 = Data449(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data449 =
    Data449(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data449] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
