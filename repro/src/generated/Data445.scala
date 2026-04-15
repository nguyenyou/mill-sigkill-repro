package generated

final case class Data445(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data445 = copy(name = name.toUpperCase)
  def scale(k: Double): Data445 = copy(value = value * k)
  def addTag(t: String): Data445 = copy(tags = t :: tags)
  def put(k: String, v: String): Data445 = copy(meta = meta.updated(k, v))
  def merge(other: Data445): Data445 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data445 {
  given Ordering[Data445] = Ordering.by(_.id)
  def empty: Data445 = Data445(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data445 =
    Data445(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data445] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
