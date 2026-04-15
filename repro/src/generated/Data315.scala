package generated

final case class Data315(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data315 = copy(name = name.toUpperCase)
  def scale(k: Double): Data315 = copy(value = value * k)
  def addTag(t: String): Data315 = copy(tags = t :: tags)
  def put(k: String, v: String): Data315 = copy(meta = meta.updated(k, v))
  def merge(other: Data315): Data315 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data315 {
  given Ordering[Data315] = Ordering.by(_.id)
  def empty: Data315 = Data315(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data315 =
    Data315(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data315] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
