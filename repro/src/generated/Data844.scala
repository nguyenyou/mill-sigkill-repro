package generated

final case class Data844(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data844 = copy(name = name.toUpperCase)
  def scale(k: Double): Data844 = copy(value = value * k)
  def addTag(t: String): Data844 = copy(tags = t :: tags)
  def put(k: String, v: String): Data844 = copy(meta = meta.updated(k, v))
  def merge(other: Data844): Data844 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data844 {
  given Ordering[Data844] = Ordering.by(_.id)
  def empty: Data844 = Data844(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data844 =
    Data844(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data844] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
