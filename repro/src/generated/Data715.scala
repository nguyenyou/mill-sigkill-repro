package generated

final case class Data715(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data715 = copy(name = name.toUpperCase)
  def scale(k: Double): Data715 = copy(value = value * k)
  def addTag(t: String): Data715 = copy(tags = t :: tags)
  def put(k: String, v: String): Data715 = copy(meta = meta.updated(k, v))
  def merge(other: Data715): Data715 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data715 {
  given Ordering[Data715] = Ordering.by(_.id)
  def empty: Data715 = Data715(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data715 =
    Data715(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data715] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
