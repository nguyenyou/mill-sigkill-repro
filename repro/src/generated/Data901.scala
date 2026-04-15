package generated

final case class Data901(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data901 = copy(name = name.toUpperCase)
  def scale(k: Double): Data901 = copy(value = value * k)
  def addTag(t: String): Data901 = copy(tags = t :: tags)
  def put(k: String, v: String): Data901 = copy(meta = meta.updated(k, v))
  def merge(other: Data901): Data901 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data901 {
  given Ordering[Data901] = Ordering.by(_.id)
  def empty: Data901 = Data901(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data901 =
    Data901(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data901] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
