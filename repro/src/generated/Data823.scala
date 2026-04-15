package generated

final case class Data823(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data823 = copy(name = name.toUpperCase)
  def scale(k: Double): Data823 = copy(value = value * k)
  def addTag(t: String): Data823 = copy(tags = t :: tags)
  def put(k: String, v: String): Data823 = copy(meta = meta.updated(k, v))
  def merge(other: Data823): Data823 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data823 {
  given Ordering[Data823] = Ordering.by(_.id)
  def empty: Data823 = Data823(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data823 =
    Data823(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data823] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
