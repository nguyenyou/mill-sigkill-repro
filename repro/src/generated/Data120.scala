package generated

final case class Data120(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data120 = copy(name = name.toUpperCase)
  def scale(k: Double): Data120 = copy(value = value * k)
  def addTag(t: String): Data120 = copy(tags = t :: tags)
  def put(k: String, v: String): Data120 = copy(meta = meta.updated(k, v))
  def merge(other: Data120): Data120 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data120 {
  given Ordering[Data120] = Ordering.by(_.id)
  def empty: Data120 = Data120(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data120 =
    Data120(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data120] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
