package generated

final case class Data682(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data682 = copy(name = name.toUpperCase)
  def scale(k: Double): Data682 = copy(value = value * k)
  def addTag(t: String): Data682 = copy(tags = t :: tags)
  def put(k: String, v: String): Data682 = copy(meta = meta.updated(k, v))
  def merge(other: Data682): Data682 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data682 {
  given Ordering[Data682] = Ordering.by(_.id)
  def empty: Data682 = Data682(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data682 =
    Data682(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data682] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
