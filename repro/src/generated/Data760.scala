package generated

final case class Data760(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data760 = copy(name = name.toUpperCase)
  def scale(k: Double): Data760 = copy(value = value * k)
  def addTag(t: String): Data760 = copy(tags = t :: tags)
  def put(k: String, v: String): Data760 = copy(meta = meta.updated(k, v))
  def merge(other: Data760): Data760 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data760 {
  given Ordering[Data760] = Ordering.by(_.id)
  def empty: Data760 = Data760(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data760 =
    Data760(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data760] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
