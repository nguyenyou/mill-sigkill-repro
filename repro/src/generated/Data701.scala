package generated

final case class Data701(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data701 = copy(name = name.toUpperCase)
  def scale(k: Double): Data701 = copy(value = value * k)
  def addTag(t: String): Data701 = copy(tags = t :: tags)
  def put(k: String, v: String): Data701 = copy(meta = meta.updated(k, v))
  def merge(other: Data701): Data701 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data701 {
  given Ordering[Data701] = Ordering.by(_.id)
  def empty: Data701 = Data701(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data701 =
    Data701(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data701] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
