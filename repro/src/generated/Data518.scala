package generated

final case class Data518(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data518 = copy(name = name.toUpperCase)
  def scale(k: Double): Data518 = copy(value = value * k)
  def addTag(t: String): Data518 = copy(tags = t :: tags)
  def put(k: String, v: String): Data518 = copy(meta = meta.updated(k, v))
  def merge(other: Data518): Data518 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data518 {
  given Ordering[Data518] = Ordering.by(_.id)
  def empty: Data518 = Data518(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data518 =
    Data518(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data518] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
