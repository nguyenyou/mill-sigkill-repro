package generated

final case class Data892(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data892 = copy(name = name.toUpperCase)
  def scale(k: Double): Data892 = copy(value = value * k)
  def addTag(t: String): Data892 = copy(tags = t :: tags)
  def put(k: String, v: String): Data892 = copy(meta = meta.updated(k, v))
  def merge(other: Data892): Data892 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data892 {
  given Ordering[Data892] = Ordering.by(_.id)
  def empty: Data892 = Data892(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data892 =
    Data892(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data892] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
