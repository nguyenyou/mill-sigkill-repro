package generated

final case class Data385(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data385 = copy(name = name.toUpperCase)
  def scale(k: Double): Data385 = copy(value = value * k)
  def addTag(t: String): Data385 = copy(tags = t :: tags)
  def put(k: String, v: String): Data385 = copy(meta = meta.updated(k, v))
  def merge(other: Data385): Data385 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data385 {
  given Ordering[Data385] = Ordering.by(_.id)
  def empty: Data385 = Data385(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data385 =
    Data385(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data385] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
