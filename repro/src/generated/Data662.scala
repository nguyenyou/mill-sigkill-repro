package generated

final case class Data662(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data662 = copy(name = name.toUpperCase)
  def scale(k: Double): Data662 = copy(value = value * k)
  def addTag(t: String): Data662 = copy(tags = t :: tags)
  def put(k: String, v: String): Data662 = copy(meta = meta.updated(k, v))
  def merge(other: Data662): Data662 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data662 {
  given Ordering[Data662] = Ordering.by(_.id)
  def empty: Data662 = Data662(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data662 =
    Data662(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data662] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
