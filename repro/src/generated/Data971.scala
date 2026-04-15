package generated

final case class Data971(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data971 = copy(name = name.toUpperCase)
  def scale(k: Double): Data971 = copy(value = value * k)
  def addTag(t: String): Data971 = copy(tags = t :: tags)
  def put(k: String, v: String): Data971 = copy(meta = meta.updated(k, v))
  def merge(other: Data971): Data971 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data971 {
  given Ordering[Data971] = Ordering.by(_.id)
  def empty: Data971 = Data971(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data971 =
    Data971(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data971] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
