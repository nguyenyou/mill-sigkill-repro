package generated

final case class Data671(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data671 = copy(name = name.toUpperCase)
  def scale(k: Double): Data671 = copy(value = value * k)
  def addTag(t: String): Data671 = copy(tags = t :: tags)
  def put(k: String, v: String): Data671 = copy(meta = meta.updated(k, v))
  def merge(other: Data671): Data671 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data671 {
  given Ordering[Data671] = Ordering.by(_.id)
  def empty: Data671 = Data671(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data671 =
    Data671(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data671] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
