package generated

final case class Data608(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data608 = copy(name = name.toUpperCase)
  def scale(k: Double): Data608 = copy(value = value * k)
  def addTag(t: String): Data608 = copy(tags = t :: tags)
  def put(k: String, v: String): Data608 = copy(meta = meta.updated(k, v))
  def merge(other: Data608): Data608 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data608 {
  given Ordering[Data608] = Ordering.by(_.id)
  def empty: Data608 = Data608(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data608 =
    Data608(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data608] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
