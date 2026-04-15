package generated

final case class Data43(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data43 = copy(name = name.toUpperCase)
  def scale(k: Double): Data43 = copy(value = value * k)
  def addTag(t: String): Data43 = copy(tags = t :: tags)
  def put(k: String, v: String): Data43 = copy(meta = meta.updated(k, v))
  def merge(other: Data43): Data43 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data43 {
  given Ordering[Data43] = Ordering.by(_.id)
  def empty: Data43 = Data43(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data43 =
    Data43(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data43] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
