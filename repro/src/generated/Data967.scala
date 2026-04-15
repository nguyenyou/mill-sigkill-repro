package generated

final case class Data967(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data967 = copy(name = name.toUpperCase)
  def scale(k: Double): Data967 = copy(value = value * k)
  def addTag(t: String): Data967 = copy(tags = t :: tags)
  def put(k: String, v: String): Data967 = copy(meta = meta.updated(k, v))
  def merge(other: Data967): Data967 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data967 {
  given Ordering[Data967] = Ordering.by(_.id)
  def empty: Data967 = Data967(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data967 =
    Data967(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data967] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
