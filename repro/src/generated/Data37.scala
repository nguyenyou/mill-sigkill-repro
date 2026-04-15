package generated

final case class Data37(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data37 = copy(name = name.toUpperCase)
  def scale(k: Double): Data37 = copy(value = value * k)
  def addTag(t: String): Data37 = copy(tags = t :: tags)
  def put(k: String, v: String): Data37 = copy(meta = meta.updated(k, v))
  def merge(other: Data37): Data37 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data37 {
  given Ordering[Data37] = Ordering.by(_.id)
  def empty: Data37 = Data37(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data37 =
    Data37(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data37] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
