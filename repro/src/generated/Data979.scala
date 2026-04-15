package generated

final case class Data979(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data979 = copy(name = name.toUpperCase)
  def scale(k: Double): Data979 = copy(value = value * k)
  def addTag(t: String): Data979 = copy(tags = t :: tags)
  def put(k: String, v: String): Data979 = copy(meta = meta.updated(k, v))
  def merge(other: Data979): Data979 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data979 {
  given Ordering[Data979] = Ordering.by(_.id)
  def empty: Data979 = Data979(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data979 =
    Data979(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data979] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
