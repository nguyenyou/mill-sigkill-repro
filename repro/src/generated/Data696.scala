package generated

final case class Data696(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data696 = copy(name = name.toUpperCase)
  def scale(k: Double): Data696 = copy(value = value * k)
  def addTag(t: String): Data696 = copy(tags = t :: tags)
  def put(k: String, v: String): Data696 = copy(meta = meta.updated(k, v))
  def merge(other: Data696): Data696 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data696 {
  given Ordering[Data696] = Ordering.by(_.id)
  def empty: Data696 = Data696(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data696 =
    Data696(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data696] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
