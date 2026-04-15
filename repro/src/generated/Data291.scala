package generated

final case class Data291(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data291 = copy(name = name.toUpperCase)
  def scale(k: Double): Data291 = copy(value = value * k)
  def addTag(t: String): Data291 = copy(tags = t :: tags)
  def put(k: String, v: String): Data291 = copy(meta = meta.updated(k, v))
  def merge(other: Data291): Data291 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data291 {
  given Ordering[Data291] = Ordering.by(_.id)
  def empty: Data291 = Data291(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data291 =
    Data291(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data291] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
