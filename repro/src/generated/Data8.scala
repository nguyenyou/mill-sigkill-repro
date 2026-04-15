package generated

final case class Data8(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data8 = copy(name = name.toUpperCase)
  def scale(k: Double): Data8 = copy(value = value * k)
  def addTag(t: String): Data8 = copy(tags = t :: tags)
  def put(k: String, v: String): Data8 = copy(meta = meta.updated(k, v))
  def merge(other: Data8): Data8 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data8 {
  given Ordering[Data8] = Ordering.by(_.id)
  def empty: Data8 = Data8(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data8 =
    Data8(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data8] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
