package generated

final case class Data724(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data724 = copy(name = name.toUpperCase)
  def scale(k: Double): Data724 = copy(value = value * k)
  def addTag(t: String): Data724 = copy(tags = t :: tags)
  def put(k: String, v: String): Data724 = copy(meta = meta.updated(k, v))
  def merge(other: Data724): Data724 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data724 {
  given Ordering[Data724] = Ordering.by(_.id)
  def empty: Data724 = Data724(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data724 =
    Data724(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data724] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
