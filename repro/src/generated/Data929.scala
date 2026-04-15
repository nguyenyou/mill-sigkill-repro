package generated

final case class Data929(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data929 = copy(name = name.toUpperCase)
  def scale(k: Double): Data929 = copy(value = value * k)
  def addTag(t: String): Data929 = copy(tags = t :: tags)
  def put(k: String, v: String): Data929 = copy(meta = meta.updated(k, v))
  def merge(other: Data929): Data929 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data929 {
  given Ordering[Data929] = Ordering.by(_.id)
  def empty: Data929 = Data929(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data929 =
    Data929(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data929] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
