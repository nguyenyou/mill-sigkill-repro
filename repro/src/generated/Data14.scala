package generated

final case class Data14(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data14 = copy(name = name.toUpperCase)
  def scale(k: Double): Data14 = copy(value = value * k)
  def addTag(t: String): Data14 = copy(tags = t :: tags)
  def put(k: String, v: String): Data14 = copy(meta = meta.updated(k, v))
  def merge(other: Data14): Data14 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data14 {
  given Ordering[Data14] = Ordering.by(_.id)
  def empty: Data14 = Data14(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data14 =
    Data14(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data14] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
