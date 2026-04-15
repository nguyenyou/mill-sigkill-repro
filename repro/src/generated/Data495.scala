package generated

final case class Data495(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data495 = copy(name = name.toUpperCase)
  def scale(k: Double): Data495 = copy(value = value * k)
  def addTag(t: String): Data495 = copy(tags = t :: tags)
  def put(k: String, v: String): Data495 = copy(meta = meta.updated(k, v))
  def merge(other: Data495): Data495 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data495 {
  given Ordering[Data495] = Ordering.by(_.id)
  def empty: Data495 = Data495(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data495 =
    Data495(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data495] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
