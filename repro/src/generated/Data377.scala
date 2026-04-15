package generated

final case class Data377(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data377 = copy(name = name.toUpperCase)
  def scale(k: Double): Data377 = copy(value = value * k)
  def addTag(t: String): Data377 = copy(tags = t :: tags)
  def put(k: String, v: String): Data377 = copy(meta = meta.updated(k, v))
  def merge(other: Data377): Data377 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data377 {
  given Ordering[Data377] = Ordering.by(_.id)
  def empty: Data377 = Data377(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data377 =
    Data377(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data377] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
