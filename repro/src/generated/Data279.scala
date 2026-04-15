package generated

final case class Data279(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data279 = copy(name = name.toUpperCase)
  def scale(k: Double): Data279 = copy(value = value * k)
  def addTag(t: String): Data279 = copy(tags = t :: tags)
  def put(k: String, v: String): Data279 = copy(meta = meta.updated(k, v))
  def merge(other: Data279): Data279 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data279 {
  given Ordering[Data279] = Ordering.by(_.id)
  def empty: Data279 = Data279(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data279 =
    Data279(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data279] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
