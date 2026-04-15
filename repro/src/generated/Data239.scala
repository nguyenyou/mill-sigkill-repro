package generated

final case class Data239(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data239 = copy(name = name.toUpperCase)
  def scale(k: Double): Data239 = copy(value = value * k)
  def addTag(t: String): Data239 = copy(tags = t :: tags)
  def put(k: String, v: String): Data239 = copy(meta = meta.updated(k, v))
  def merge(other: Data239): Data239 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data239 {
  given Ordering[Data239] = Ordering.by(_.id)
  def empty: Data239 = Data239(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data239 =
    Data239(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data239] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
