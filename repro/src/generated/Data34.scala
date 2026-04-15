package generated

final case class Data34(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data34 = copy(name = name.toUpperCase)
  def scale(k: Double): Data34 = copy(value = value * k)
  def addTag(t: String): Data34 = copy(tags = t :: tags)
  def put(k: String, v: String): Data34 = copy(meta = meta.updated(k, v))
  def merge(other: Data34): Data34 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data34 {
  given Ordering[Data34] = Ordering.by(_.id)
  def empty: Data34 = Data34(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data34 =
    Data34(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data34] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
