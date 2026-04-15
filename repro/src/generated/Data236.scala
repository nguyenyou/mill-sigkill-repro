package generated

final case class Data236(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data236 = copy(name = name.toUpperCase)
  def scale(k: Double): Data236 = copy(value = value * k)
  def addTag(t: String): Data236 = copy(tags = t :: tags)
  def put(k: String, v: String): Data236 = copy(meta = meta.updated(k, v))
  def merge(other: Data236): Data236 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data236 {
  given Ordering[Data236] = Ordering.by(_.id)
  def empty: Data236 = Data236(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data236 =
    Data236(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data236] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
