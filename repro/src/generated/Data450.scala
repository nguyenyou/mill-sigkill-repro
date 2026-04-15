package generated

final case class Data450(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data450 = copy(name = name.toUpperCase)
  def scale(k: Double): Data450 = copy(value = value * k)
  def addTag(t: String): Data450 = copy(tags = t :: tags)
  def put(k: String, v: String): Data450 = copy(meta = meta.updated(k, v))
  def merge(other: Data450): Data450 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data450 {
  given Ordering[Data450] = Ordering.by(_.id)
  def empty: Data450 = Data450(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data450 =
    Data450(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data450] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
