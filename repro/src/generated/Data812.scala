package generated

final case class Data812(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data812 = copy(name = name.toUpperCase)
  def scale(k: Double): Data812 = copy(value = value * k)
  def addTag(t: String): Data812 = copy(tags = t :: tags)
  def put(k: String, v: String): Data812 = copy(meta = meta.updated(k, v))
  def merge(other: Data812): Data812 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data812 {
  given Ordering[Data812] = Ordering.by(_.id)
  def empty: Data812 = Data812(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data812 =
    Data812(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data812] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
