package generated

final case class Data847(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data847 = copy(name = name.toUpperCase)
  def scale(k: Double): Data847 = copy(value = value * k)
  def addTag(t: String): Data847 = copy(tags = t :: tags)
  def put(k: String, v: String): Data847 = copy(meta = meta.updated(k, v))
  def merge(other: Data847): Data847 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data847 {
  given Ordering[Data847] = Ordering.by(_.id)
  def empty: Data847 = Data847(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data847 =
    Data847(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data847] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
